package com.naijatravelshop.client.hotel.service.impl;

import com.naijatravelshop.client.hotel.pojo.request.search_hotel.BookingDetails;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.Child;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.Children;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.ConditionA;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.ConditionC;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.Customer;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.FieldValues;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.Fields;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.Filters;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.Request;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.Return;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.Room;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.Rooms;
import com.naijatravelshop.client.hotel.pojo.response.search_hotel.Hotel;
import com.naijatravelshop.client.hotel.pojo.response.search_hotel.Result;
import com.naijatravelshop.client.hotel.service.GOTWClientService;
import com.naijatravelshop.persistence.model.portal.Setting;
import com.naijatravelshop.persistence.repository.portal.SettingRepository;
import com.naijatravelshop.service.hotel.pojo.request.RoomDTO;
import com.naijatravelshop.service.hotel.pojo.request.SearchHotelDTO;
import com.naijatravelshop.web.constants.ProjectConstant;
import com.naijatravelshop.web.exceptions.BadRequestException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Bruno on
 * 12/08/2019
 */
@Service
public class GOTWClientServiceImpl<T> implements GOTWClientService {

    private SettingRepository settingRepository;

    public GOTWClientServiceImpl(SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }

    @Value("${dotw.request.command}")
    private String searchHotelCommand;
    @Value("${dotw.source}")
    private String source;
    @Value("${dotw.product}")
    private String product;
    @Value("${dotw.currency.code}")
    private String currency;

    @Override
    public List<Hotel> searchHotel(SearchHotelDTO searchHotelDTO) {
        Optional<Setting> code = settingRepository.findFirstByNameEquals(ProjectConstant.DOTW_COMPANY_CODE);
        Optional<Setting> id = settingRepository.findFirstByNameEquals(ProjectConstant.DOTW_LOGIN_ID);
        Optional<Setting> password = settingRepository.findFirstByNameEquals(ProjectConstant.DOTW_LOGIN_PASSWORD);

        Result result = searchHotelForPrice(searchHotelDTO, code.get().getValue(), id.get().getValue(), password.get().getValue());
        if (result.getHotels() == null) {
            throw new BadRequestException("Error in retrieving hotel data");
        }
        Result hotelDetailResult = searchHotelForDetails(searchHotelDTO, result, code.get().getValue(), id.get().getValue(), password.get().getValue());
        if (hotelDetailResult.getHotels() == null) {
            throw new BadRequestException("Error in retrieving hotel data");
        }

        List<Hotel> hotels = new ArrayList<>();
        for (int i = 0; i < result.getHotels().size(); i++) {
            for (int j = 0; j < hotelDetailResult.getHotels().size(); j++) {
                Hotel hotel = result.getHotels().get(i);
                Hotel hotel1 = hotelDetailResult.getHotels().get(j);
                if (hotel.getHotelid().equals(hotel1.getHotelid())) {
                    hotel.setDescription1(hotel1.getDescription1());
                    hotel.setDescription2(hotel1.getDescription2());
                    hotel.setHotelName(hotel1.getHotelName());
                    hotel.setAddress(hotel1.getAddress());
                    hotel.setCityName(hotel1.getCityName());
                    hotel.setCityCode(hotel1.getCityCode());
                    hotel.setCountryCode(hotel1.getCountryCode());
                    hotel.setCountryName(hotel1.getCountryName());
                    hotel.setAmenitie(hotel1.getAmenitie());
                    hotel.setLeisure(hotel1.getLeisure());
                    hotel.setBusiness(hotel1.getBusiness());
                    hotel.setRating(hotel1.getRating());
                    hotel.setImages(hotel1.getImages());
                    hotel.setGeoPoint(hotel1.getGeoPoint());
                    hotels.add(hotel);
                }
            }
        }
        return hotels;
    }

    private Result searchHotelForPrice(SearchHotelDTO searchHotelDTO, String id, String username, String password) {
        Filters filters = new Filters();
        filters.setCity(searchHotelDTO.getCityCode());
        filters.setXmlnsa("http://us.dotwconnect.com/xsd/atomicCondition");
        filters.setXmlnsc("http://us.dotwconnect.com/xsd/complexCondition");
        filters.setNoPrice("false");

        Return aReturn = new Return();
        aReturn.setFilters(filters);

        Request request = new Request();
        request.set_command(searchHotelCommand);
        request.setBookingDetails(prepareBookingDetails(searchHotelDTO));
        request.setReturns(aReturn);

        Customer customer = new Customer();
        customer.setId(id);
        customer.setPassword(password);
        customer.setProduct(product);
        customer.setSource(source);
        customer.setUsername(username);
        customer.setRequest(request);
        return request(customer);
    }

    @Cacheable(value = "hotelDetailsCache", key = "#searchHotelDTO.cityCode")
    public Result searchHotelForDetails(SearchHotelDTO searchHotelDTO, Result searchHotelForPriceResult, String id, String username, String password) {
        List<String> fieldList = new ArrayList<>();
        fieldList.add("description1");
        fieldList.add("description2");
        fieldList.add("hotelName");
        fieldList.add("address");
        fieldList.add("cityName");
        fieldList.add("cityCode");
        fieldList.add("countryName");
        fieldList.add("countryCode");
        fieldList.add("amenitie");
        fieldList.add("leisure");
        fieldList.add("business");
        fieldList.add("rating");
        fieldList.add("images");
        fieldList.add("geoPoint");

        List<String> hotelIds = new ArrayList<>();
        for (int i = 0; i < searchHotelForPriceResult.getHotels().size(); i++) {
            hotelIds.add(searchHotelForPriceResult.getHotels().get(i).getHotelid());
        }

        FieldValues fieldValues = new FieldValues();
        fieldValues.setFieldValue(hotelIds);

        ConditionA conditionA = new ConditionA();
        conditionA.setFieldValues(fieldValues);
        conditionA.setFieldTest("in");
        conditionA.setFieldName("hotelId");

        ConditionC conditionC = new ConditionC();
        conditionC.setConditionA(conditionA);

        Fields fields = new Fields();
        fields.setField(fieldList);

        Filters filters = new Filters();
        filters.setCity(searchHotelDTO.getCityCode());
        filters.setXmlnsa("http://us.dotwconnect.com/xsd/atomicCondition");
        filters.setXmlnsc("http://us.dotwconnect.com/xsd/complexCondition");
        filters.setNoPrice("true");
        filters.setConditionC(conditionC);

        Return aReturn = new Return();
        aReturn.setFilters(filters);
        aReturn.setFields(fields);

        Request request = new Request();
        request.set_command(searchHotelCommand);
        request.setBookingDetails(prepareBookingDetails(searchHotelDTO));
        request.setReturns(aReturn);

        Customer customer = new Customer();
        customer.setId(id);
        customer.setPassword(password);
        customer.setProduct(product);
        customer.setSource(source);
        customer.setUsername(username);
        customer.setRequest(request);
        return request(customer);
    }

    private String changeObjectToXML(Customer customer) {
        String xml = "";
        try {
            JAXBContext context = JAXBContext.newInstance(customer.getClass());
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter writer = new StringWriter();
            m.marshal(customer, writer);
            xml = writer.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
            Logger.getLogger(GOTWClientServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        xml = xml.replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim();
        return xml;
    }

    private Result changeStringToObject(String responseBody) {
        Result result = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Result.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(responseBody.replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim());
            result = (Result) jaxbUnmarshaller.unmarshal(reader);
        } catch (JAXBException ex) {
            Logger.getLogger(GOTWClientServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    private Result request(Customer customer) {
        try {
            Optional<Setting> optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.DOTW_HOST_URL);
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(optionalSetting.get().getValue());
            // add header
            post.setHeader("Accept-Encoding", "application/gzip");
            post.setHeader("Content-Type", "text/xml");
            post.setEntity(new StringEntity(changeObjectToXML(customer)));

            org.apache.http.HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            return changeStringToObject(result.toString());
        } catch (IOException ex) {
            Logger.getLogger(GOTWClientServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private BookingDetails prepareBookingDetails(SearchHotelDTO searchHotelDTO) {
        List<Room> roomList = new ArrayList<>();
        for (int i = 0; i < searchHotelDTO.getRoomDetailList().size(); i++) {
            RoomDTO roomDTO = searchHotelDTO.getRoomDetailList().get(i);
            List<Child> childList = new ArrayList<>();
            for (int j = 0; j < roomDTO.getChildrenAgeList().size(); j++) {
                Child child = new Child();
                child.setChild(roomDTO.getChildrenAgeList().get(j).toString());
                child.set_runno(String.valueOf(j));
                childList.add(child);
            }
            Children children = new Children();
            children.set_no(String.valueOf(roomDTO.getNumberOfChildren()));
            children.setChild(childList);

            Room room = new Room();
            room.set_runno(String.valueOf(i));
            room.setAdultsCode(String.valueOf(roomDTO.getNumberOfAdults()));
            room.setChildren(children);
            room.setRateBasis("-1");
            roomList.add(room);
        }
        Rooms rooms = new Rooms();
        rooms.set_no(String.valueOf(searchHotelDTO.getNumberOfRooms()));
        rooms.setRoom(roomList);

        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setFromDate(searchHotelDTO.getCheckInDate());
        bookingDetails.setCurrency(currency);
        bookingDetails.setRooms(rooms);
        bookingDetails.setToDate(searchHotelDTO.getCheckOutDate());

        return bookingDetails;
    }
}
