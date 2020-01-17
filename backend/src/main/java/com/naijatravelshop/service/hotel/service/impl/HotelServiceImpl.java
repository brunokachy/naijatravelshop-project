package com.naijatravelshop.service.hotel.service.impl;

import com.naijatravelshop.client.hotel.pojo.response.search_hotel.Hotel;
import com.naijatravelshop.client.hotel.pojo.response.search_hotel.RoomType;
import com.naijatravelshop.client.hotel.service.GOTWClientService;
import com.naijatravelshop.persistence.model.crm.Customer;
import com.naijatravelshop.persistence.model.crm.ServiceRequest;
import com.naijatravelshop.persistence.model.crm.ServiceRequestActorHistory;
import com.naijatravelshop.persistence.model.crm.ServiceRequestLog;
import com.naijatravelshop.persistence.model.enums.EntityStatus;
import com.naijatravelshop.persistence.model.enums.Gender;
import com.naijatravelshop.persistence.model.enums.Priority;
import com.naijatravelshop.persistence.model.enums.ProcessStatus;
import com.naijatravelshop.persistence.model.enums.ReservationType;
import com.naijatravelshop.persistence.model.enums.ServiceTaskSubject;
import com.naijatravelshop.persistence.model.enums.ServiceTaskType;
import com.naijatravelshop.persistence.model.enums.SupplierGroupType;
import com.naijatravelshop.persistence.model.hotel.HotelBookingDetail;
import com.naijatravelshop.persistence.model.hotel.HotelCity;
import com.naijatravelshop.persistence.model.hotel.RoomOffer;
import com.naijatravelshop.persistence.model.portal.Country;
import com.naijatravelshop.persistence.model.portal.PortalUser;
import com.naijatravelshop.persistence.model.portal.Reservation;
import com.naijatravelshop.persistence.model.portal.ReservationOwner;
import com.naijatravelshop.persistence.model.portal.Setting;
import com.naijatravelshop.persistence.model.portal.Traveller;
import com.naijatravelshop.persistence.repository.crm.CustomerRepository;
import com.naijatravelshop.persistence.repository.crm.ServiceRequestActorHistoryRepository;
import com.naijatravelshop.persistence.repository.crm.ServiceRequestLogRepository;
import com.naijatravelshop.persistence.repository.crm.ServiceRequestRepository;
import com.naijatravelshop.persistence.repository.flight.AirportRepository;
import com.naijatravelshop.persistence.repository.flight.FlightCityRepository;
import com.naijatravelshop.persistence.repository.flight.FlightRouteRepository;
import com.naijatravelshop.persistence.repository.visa.VisaRequestRepository;
import com.naijatravelshop.persistence.repository.hotel.HotelBookingDetailRepository;
import com.naijatravelshop.persistence.repository.hotel.HotelCityRepository;
import com.naijatravelshop.persistence.repository.hotel.RoomOfferRepository;
import com.naijatravelshop.persistence.repository.payment.PaymentHistoryRepository;
import com.naijatravelshop.persistence.repository.portal.AddressRepository;
import com.naijatravelshop.persistence.repository.portal.CountryRepository;
import com.naijatravelshop.persistence.repository.portal.PortalUserRepository;
import com.naijatravelshop.persistence.repository.portal.ReservationOwnerRepository;
import com.naijatravelshop.persistence.repository.portal.ReservationRepository;
import com.naijatravelshop.persistence.repository.portal.SettingRepository;
import com.naijatravelshop.persistence.repository.portal.TravellerRepository;
import com.naijatravelshop.service.email.EmailService;
import com.naijatravelshop.service.flight.pojo.request.TravellerDTO;
import com.naijatravelshop.service.flight.pojo.response.ReservationResponseDTO;
import com.naijatravelshop.service.hotel.pojo.request.BookHotelDTO;
import com.naijatravelshop.service.hotel.pojo.request.HotelCityDTO;
import com.naijatravelshop.service.hotel.pojo.request.RoomDTO;
import com.naijatravelshop.service.hotel.pojo.request.SearchHotelDTO;
import com.naijatravelshop.service.hotel.pojo.response.HotelListReponse;
import com.naijatravelshop.service.hotel.pojo.response.HotelResponse;
import com.naijatravelshop.service.hotel.pojo.response.RoomResponse;
import com.naijatravelshop.service.hotel.service.HotelService;
import com.naijatravelshop.service.portal.pojo.response.HotelReservationResponse;
import com.naijatravelshop.web.constants.ProjectConstant;
import com.naijatravelshop.web.exceptions.BadRequestException;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Bruno on
 * 12/08/2019
 */
@Service
public class HotelServiceImpl implements HotelService {
    private HotelCityRepository hotelCityRepository;
    private GOTWClientService gotwClientService;
    private SettingRepository settingRepository;
    private AddressRepository addressRepository;
    private PaymentHistoryRepository paymentHistoryRepository;
    private ReservationOwnerRepository reservationOwnerRepository;
    private ReservationRepository reservationRepository;
    private TravellerRepository travellerRepository;
    private CountryRepository countryRepository;
    private PortalUserRepository portalUserRepository;
    private HotelBookingDetailRepository hotelBookingDetailRepository;
    private FlightRouteRepository flightRouteRepository;
    private VisaRequestRepository visaRequestRepository;
    private CustomerRepository customerRepository;
    private ServiceRequestRepository serviceRequestRepository;
    private ServiceRequestActorHistoryRepository serviceRequestActorHistoryRepository;
    private ServiceRequestLogRepository serviceRequestLogRepository;
    private AirportRepository airportRepository;
    private FlightCityRepository flightCityRepository;
    private RoomOfferRepository roomOfferRepository;
    private EmailService emailService;

    private static final Logger log = LoggerFactory.getLogger(HotelServiceImpl.class);

    public HotelServiceImpl(HotelCityRepository hotelCityRepository,
                            GOTWClientService gotwClientService,
                            SettingRepository settingRepository,
                            AddressRepository addressRepository,
                            PaymentHistoryRepository paymentHistoryRepository,
                            ReservationOwnerRepository reservationOwnerRepository,
                            ReservationRepository reservationRepository,
                            TravellerRepository travellerRepository,
                            CountryRepository countryRepository,
                            PortalUserRepository portalUserRepository,
                            HotelBookingDetailRepository hotelBookingDetailRepository,
                            FlightRouteRepository flightRouteRepository,
                            VisaRequestRepository visaRequestRepository,
                            CustomerRepository customerRepository,
                            ServiceRequestRepository serviceRequestRepository,
                            ServiceRequestActorHistoryRepository serviceRequestActorHistoryRepository,
                            ServiceRequestLogRepository serviceRequestLogRepository,
                            AirportRepository airportRepository,
                            FlightCityRepository flightCityRepository,
                            RoomOfferRepository roomOfferRepository,
                            EmailService emailService) {
        this.hotelCityRepository = hotelCityRepository;
        this.gotwClientService = gotwClientService;
        this.settingRepository = settingRepository;
        this.addressRepository = addressRepository;
        this.paymentHistoryRepository = paymentHistoryRepository;
        this.reservationOwnerRepository = reservationOwnerRepository;
        this.reservationRepository = reservationRepository;
        this.travellerRepository = travellerRepository;
        this.countryRepository = countryRepository;
        this.portalUserRepository = portalUserRepository;
        this.hotelBookingDetailRepository = hotelBookingDetailRepository;
        this.flightRouteRepository = flightRouteRepository;
        this.visaRequestRepository = visaRequestRepository;
        this.customerRepository = customerRepository;
        this.serviceRequestRepository = serviceRequestRepository;
        this.serviceRequestLogRepository = serviceRequestLogRepository;
        this.serviceRequestActorHistoryRepository = serviceRequestActorHistoryRepository;
        this.airportRepository = airportRepository;
        this.flightCityRepository = flightCityRepository;
        this.emailService = emailService;
        this.roomOfferRepository = roomOfferRepository;
    }

    @Cacheable(value = "hotelCityCache", unless = "#result == null")
    @Override
    public List<HotelCityDTO> getAllHotelCity() {
        List<HotelCityDTO> hotelCityDTOS = new ArrayList<>();
        hotelCityRepository.findAll().forEach(hotelCity -> {
            HotelCityDTO hotelCityDTO = HotelCityDTO
                    .builder()
                    .code(hotelCity.getCode())
                    .countryCode(hotelCity.getCountryCode())
                    .countryName(hotelCity.getCountryName())
                    .name(hotelCity.getName())
                    .displayName(hotelCity.getName() + ", " + hotelCity.getCountryName())
                    .build();
            hotelCityDTOS.add(hotelCityDTO);
        });
        return hotelCityDTOS;
    }

    @Override
    public HotelListReponse searchHotel(SearchHotelDTO searchHotelDTO) {
        List<Hotel> resultHotels = gotwClientService.searchHotel(searchHotelDTO);
        Optional<Setting> optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.CURRENCY_EXCHANGE_RATE);
        Double exchangeRate = Double.valueOf(optionalSetting.get().getValue());

        List<HotelResponse> hotels = new ArrayList<>();
        List<Double> minHotelPrices = new ArrayList<>();
        List<Double> maxHotelPrices = new ArrayList<>();

        for (int i = 0, resultHotelsSize = resultHotels.size(); i < resultHotelsSize; i++) {
            Hotel hotel = resultHotels.get(i);
            List<String> facilities = new ArrayList<>();
            List<String> images = new ArrayList<>();
            List<RoomResponse> rooms = new ArrayList<>();
            List<Double> roomPrices = new ArrayList<>();

            if (hotel.getAmenitie().getLanguage() != null) {
                facilities = hotel.getAmenitie().getLanguage().stream().collect(Collectors.toList());
            }
            if (hotel.getLeisure().getLanguage() != null) {
                hotel.getLeisure().getLanguage().stream().forEachOrdered(facilities::add);
            }
            if (hotel.getBusiness().getLanguage() != null) {
                hotel.getBusiness().getLanguage().stream().forEachOrdered(facilities::add);
            }
            if (hotel.getImages() != null) {
                images = hotel.getImages().getHotelImages().getImage().stream().map(image -> image.getUrl()).collect(Collectors.toList());
            }

            for (RoomType roomType : hotel.getRooms().get(0).getRoomType()) {
                Double roomPrice = Double.valueOf(roomType.getRateBasis().get(0).getTotal()) * exchangeRate;
                roomPrices.add(roomPrice);
                RoomResponse roomResponse = RoomResponse
                        .builder()
                        .name(roomType.getName())
                        .roomPrice(roomPrice)
                        .build();
                rooms.add(roomResponse);
            }
            Collections.sort(rooms);

            minHotelPrices.add(Collections.min(roomPrices));
            maxHotelPrices.add(Collections.max(roomPrices));
            HotelResponse hotelResponse = HotelResponse.builder()
                    .address(hotel.getAddress())
                    .cityCode(hotel.getCityCode())
                    .cityName(hotel.getCityName())
                    .countryCode(hotel.getCountryCode())
                    .countryName(hotel.getCountryName())
                    .facilities(facilities)
                    .fullDescription(hotel.getDescription1().getLanguage())
                    .hotelId(hotel.getHotelid())
                    .hotelName(hotel.getHotelName())
                    .images(images)
                    .lat(hotel.getGeoPoint().getLat())
                    .lng(hotel.getGeoPoint().getLng())
                    .minimumPrice(Collections.min(roomPrices))
                    .maximumPrice(Collections.max(roomPrices))
                    .rating(hotel.getRating().substring(hotel.getRating().length() - 1))
                    .rooms(rooms)
                    .smallDescription(hotel.getDescription2().getLanguage())
                    .thumbImageURL(hotel.getImages() != null ? hotel.getImages().getHotelImages().getThumb() : "")
                    .build();

            hotels.add(hotelResponse);
        }

        HotelListReponse hotelResponse = HotelListReponse
                .builder()
                .hotelList(hotels)
                .maximumPrice(Collections.max(maxHotelPrices))
                .minimumPrice(Collections.min(minHotelPrices))
                .totalResult(hotels.size())
                .build();
        return hotelResponse;
    }

    @Override
    @Transactional
    public ReservationResponseDTO createReservation(BookHotelDTO bookHotelDTO) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ReservationOwner owner = new ReservationOwner();
            Optional<Country> optionalCountry = countryRepository.findFirstByName(bookHotelDTO.getCustomerAccount().getCountryName());
            Optional<HotelCity> optionalHotelCity = hotelCityRepository.findFirstByCode(bookHotelDTO.getCityCode());

            owner.setFirstName(bookHotelDTO.getCustomerAccount().getFirstName());
            owner.setLastName(bookHotelDTO.getCustomerAccount().getLastName());
            owner.setEmail(bookHotelDTO.getCustomerAccount().getEmail());
            owner.setPhoneNumber(bookHotelDTO.getCustomerAccount().getPhoneNumber());
            owner.setNationality(optionalCountry.orElse(null));
            owner.setTitle(bookHotelDTO.getCustomerAccount().getTitle());
            reservationOwnerRepository.save(owner);

            HotelBookingDetail hotelBookingDetail = new HotelBookingDetail();
            hotelBookingDetail.setCheckoutDate(new Timestamp(simpleDateFormat.parse(bookHotelDTO.getCheckOutDate()).getTime()));
            hotelBookingDetail.setNumberOfChildren(bookHotelDTO.getChildCount());
            hotelBookingDetail.setNumberOfAdult(bookHotelDTO.getAdultCount());
            hotelBookingDetail.setNightlyRateTotalInKobo(bookHotelDTO.getRoomPrice() * 100L);
            hotelBookingDetail.setCheckinDate(new Timestamp(simpleDateFormat.parse(bookHotelDTO.getCheckInDate()).getTime()));
            hotelBookingDetail.setCity(optionalHotelCity.orElse(null));
            hotelBookingDetail.setCityName(bookHotelDTO.getCityName());
            hotelBookingDetail.setCountryCode(bookHotelDTO.getCountryCode());
            hotelBookingDetail.setCountryName(bookHotelDTO.getCountryName());
            hotelBookingDetail.setHotelDescription(bookHotelDTO.getHotelDescription());
            hotelBookingDetail.setHotelId(bookHotelDTO.getHotelId());
            hotelBookingDetail.setHotelName(bookHotelDTO.getHotelName());
            hotelBookingDetail.setNumberOfNightsStay(bookHotelDTO.getNights());
            hotelBookingDetail.setNumberOfRoom(bookHotelDTO.getRoomCount());
            hotelBookingDetail.setRoomType(bookHotelDTO.getRoomName());
            hotelBookingDetail.setStatus(EntityStatus.ACTIVE);

            hotelBookingDetailRepository.save(hotelBookingDetail);

            Reservation reservation = new Reservation();
            reservation.setSellingPrice(bookHotelDTO.getRoomPrice() * 100L);
            reservation.setActualAmountInKobo(bookHotelDTO.getRoomPrice() * 100L);
            reservation.setBookingNumber(RandomStringUtils.randomAlphabetic(6).toUpperCase());
            reservation.setReservationOwner(owner);
            reservation.setStatus(EntityStatus.ACTIVE);
            reservation.setTransactionFeeInKobo(0L);
            reservation.setSupplierGroupType(SupplierGroupType.DOTW);
            reservation.setMargin(0L);
            reservation.setReservationStatus(ProcessStatus.PENDING);
            reservation.setReservationType(ReservationType.HOTEL);
            reservation.setHotelBookingDetail(hotelBookingDetail);
            if (bookHotelDTO.getPortalUsername() != null) {
                Optional<PortalUser> optionalPortalUser = portalUserRepository.findFirstByEmailAndStatus(bookHotelDTO.getPortalUsername(), EntityStatus.ACTIVE);
                reservation.setProcessedBy(optionalPortalUser.get());
            }
            reservationRepository.save(reservation);

            for (RoomDTO roomDTO : bookHotelDTO.getGuestInformation()) {
                RoomOffer roomOffer = new RoomOffer();
                roomOffer.setHotelBookingDetail(hotelBookingDetail);
                roomOffer.setNumberOfAdults(roomDTO.getNumberOfAdults());
                roomOffer.setNumberOfChildren(roomDTO.getNumberOfChildren());

                roomOfferRepository.save(roomOffer);

                for (TravellerDTO traveller : roomDTO.getAdultList()) {
                    Traveller t = new Traveller();
                    t.setAge(traveller.getAge());
                    t.setFirstName(traveller.getFirstName());
                    t.setLastName(traveller.getLastName());
                    t.setTitle(traveller.getTitle());
                    t.setRoomOffer(roomOffer);
                    t.setReservation(reservation);
                    t.setNationality(traveller.getCountryName());

                    if (traveller.getTitle().equalsIgnoreCase("MISS")
                            || traveller.getTitle().equalsIgnoreCase("MRS")) {
                        t.setGender(Gender.FEMALE);
                    } else {
                        t.setGender(Gender.MALE);
                    }
                    travellerRepository.save(t);
                }
                for (TravellerDTO traveller : roomDTO.getChildrenList()) {
                    Traveller t = new Traveller();
                    t.setAge(traveller.getAge());
                    t.setFirstName(traveller.getFirstName());
                    t.setLastName(traveller.getLastName());
                    t.setTitle(traveller.getTitle());
                    t.setRoomOffer(roomOffer);
                    t.setReservation(reservation);
                    t.setNationality(traveller.getCountryName());

                    if (traveller.getTitle().equalsIgnoreCase("MISS")) {
                        t.setGender(Gender.FEMALE);
                    } else {
                        t.setGender(Gender.MALE);
                    }
                    travellerRepository.save(t);
                }
            }

            try {
                createHotelServiceRequest(reservation, owner, bookHotelDTO);
                HotelReservationResponse hotelReservationResponse = prepareEmailMessage(reservation, bookHotelDTO.getGuestInformation());
                sendHotelBookingEmail(hotelReservationResponse);
            } catch (Exception e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }

            ReservationResponseDTO responseDTO = new ReservationResponseDTO();
            responseDTO.setBookingNumber(reservation.getBookingNumber());
            responseDTO.setReservationId(reservation.getId());

            return responseDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException(e.getMessage());
        }
    }

    @Transactional
    public void createHotelServiceRequest(Reservation reservation, ReservationOwner reservationOwner, BookHotelDTO bookHotelDTO) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByEmail(reservationOwner.getEmail());
        Customer customer;
        if (optionalCustomer.isPresent()) {
            customer = optionalCustomer.get();
        } else {
            customer = new Customer();
            customer.setEmail(reservationOwner.getEmail());
            customer.setFirstName(reservationOwner.getFirstName());
            customer.setLastName(reservationOwner.getLastName());
            customer.setPhoneNumber(reservationOwner.getPhoneNumber());
            customer.setStatus(EntityStatus.ACTIVE);
            customer.setDateOfBirth(reservationOwner.getDateOfBirth());
            customer.setTitle(reservationOwner.getTitle());
            customerRepository.save(customer);
        }

        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setAssignedTo(reservation.getProcessedBy());
        serviceRequest.setCustomer(customer);
        serviceRequest.setPriority(Priority.MEDIUM);
        serviceRequest.setReservation(reservation);
        serviceRequest.setRequestId(RandomStringUtils.randomAlphabetic(6));
        serviceRequest.setServiceType(ReservationType.HOTEL);
        serviceRequest.setStatus(EntityStatus.ACTIVE);
        serviceRequestRepository.save(serviceRequest);

        if (reservation.getProcessedBy() != null) {
            ServiceRequestActorHistory actorHistory = new ServiceRequestActorHistory();
            actorHistory.setActor(reservation.getProcessedBy());
            actorHistory.setServiceRequest(serviceRequest);
            actorHistory.setStatus(EntityStatus.ACTIVE);
            serviceRequestActorHistoryRepository.save(actorHistory);

            ServiceRequestLog serviceRequestLog = new ServiceRequestLog();
            serviceRequestLog.setActor(actorHistory);
            serviceRequestLog.setDescription(ServiceTaskType.NEW_TASK.getValue());
            serviceRequestLog.setSubject(ServiceTaskSubject.HOTEL_ENQUIRY);
            serviceRequestLog.setTaskType(ServiceTaskType.NEW_TASK);
            serviceRequestLog.setStatus(EntityStatus.ACTIVE);
            serviceRequestLogRepository.save(serviceRequestLog);
        }
    }

    private void sendHotelBookingEmail(HotelReservationResponse hotelReservation) {
        log.info("Sending mail.....");
        Map<String, Object> hotelBookingEmail = new HashMap<>();
        hotelBookingEmail.put("recieverName", hotelReservation.getReservationOwner().getTitle() + " " + hotelReservation.getReservationOwner().getLastName());
        hotelBookingEmail.put("reservationDate", hotelReservation.getBookingDate());
        hotelBookingEmail.put("bookingNumber", hotelReservation.getBookingNumber());
        hotelBookingEmail.put("amount", hotelReservation.getSellingPrice().toString().substring(0, hotelReservation.getSellingPrice().toString().length() - 2) + "." + hotelReservation.getSellingPrice().toString().substring(hotelReservation.getSellingPrice().toString().length() - 2));
        hotelBookingEmail.put("contactName", hotelReservation.getReservationOwner().getTitle() + " " + hotelReservation.getReservationOwner().getFirstName() + " " + hotelReservation.getReservationOwner().getLastName());
        hotelBookingEmail.put("contactEmail", hotelReservation.getReservationOwner().getEmail());
        hotelBookingEmail.put("contactPhone", hotelReservation.getReservationOwner().getPhoneNumber());
        hotelBookingEmail.put("rooms", hotelReservation.getRooms());
        hotelBookingEmail.put("hotelName", hotelReservation.getHotelName());
        hotelBookingEmail.put("roomType", hotelReservation.getRoomType());
        hotelBookingEmail.put("location", hotelReservation.getCityName() + ", " + hotelReservation.getCountryName());
        hotelBookingEmail.put("checkInDate", hotelReservation.getCheckInDate());
        hotelBookingEmail.put("checkOutDate", hotelReservation.getCheckOutDate());
        hotelBookingEmail.put("nights", hotelReservation.getNights());
        hotelBookingEmail.put("noOfRooms", hotelReservation.getNumberOfRooms());
        hotelBookingEmail.put("noOfGuests", hotelReservation.getNumberOfAdult() + hotelReservation.getNumberOfChildren());

        emailService.sendHtmlEmail(hotelReservation.getReservationOwner().getEmail(), "Hotel Booking Notification", "hotel-booking-confirmation-template", hotelBookingEmail, "travel@naijatravelshop.com");
    }

    private HotelReservationResponse prepareEmailMessage(Reservation reservation, List<RoomDTO> roomDTOs) {
        HotelBookingDetail hotelBookingDetail = reservation.getHotelBookingDetail();

        TravellerDTO reservationOwner = new TravellerDTO();
        reservationOwner.setEmail(reservation.getReservationOwner().getEmail());
        reservationOwner.setFirstName(reservation.getReservationOwner().getFirstName());
        reservationOwner.setLastName(reservation.getReservationOwner().getLastName());
        reservationOwner.setPhoneNumber(reservation.getReservationOwner().getPhoneNumber());
        reservationOwner.setTitle(reservation.getReservationOwner().getTitle());

        HotelReservationResponse response = HotelReservationResponse.builder()
                .bookingDate(reservation.getDateCreated())
                .bookingNumber(reservation.getBookingNumber())
                .checkInDate(hotelBookingDetail.getCheckinDate())
                .checkOutDate(hotelBookingDetail.getCheckoutDate())
                .cityName(hotelBookingDetail.getCityName())
                .countryName(hotelBookingDetail.getCountryName())
                .hotelName(hotelBookingDetail.getHotelName())
                .numberOfAdult(hotelBookingDetail.getNumberOfAdult())
                .numberOfChildren(hotelBookingDetail.getNumberOfChildren())
                .numberOfRooms(hotelBookingDetail.getNumberOfRoom())
                .nights(hotelBookingDetail.getNumberOfNightsStay())
                .reservationOwner(reservationOwner)
                .rooms(roomDTOs)
                .roomType(hotelBookingDetail.getRoomType())
                .sellingPrice(reservation.getSellingPrice())
                .build();

        return response;
    }
}
