package com.naijatravelshop.service.flight.service.impl;

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
import com.naijatravelshop.persistence.model.flight.Airport;
import com.naijatravelshop.persistence.model.flight.FlightBookingDetail;
import com.naijatravelshop.persistence.model.flight.FlightCity;
import com.naijatravelshop.persistence.model.flight.FlightRoute;
import com.naijatravelshop.persistence.model.portal.Address;
import com.naijatravelshop.persistence.model.portal.Country;
import com.naijatravelshop.persistence.model.portal.PortalUser;
import com.naijatravelshop.persistence.model.portal.Reservation;
import com.naijatravelshop.persistence.model.portal.ReservationOwner;
import com.naijatravelshop.persistence.model.portal.Traveller;
import com.naijatravelshop.persistence.repository.crm.CustomerRepository;
import com.naijatravelshop.persistence.repository.crm.ServiceRequestActorHistoryRepository;
import com.naijatravelshop.persistence.repository.crm.ServiceRequestLogRepository;
import com.naijatravelshop.persistence.repository.crm.ServiceRequestRepository;
import com.naijatravelshop.persistence.repository.flight.AirportRepository;
import com.naijatravelshop.persistence.repository.flight.FlightBookingDetailRepository;
import com.naijatravelshop.persistence.repository.flight.FlightCityRepository;
import com.naijatravelshop.persistence.repository.flight.FlightRouteRepository;
import com.naijatravelshop.persistence.repository.payment.PaymentHistoryRepository;
import com.naijatravelshop.persistence.repository.portal.AddressRepository;
import com.naijatravelshop.persistence.repository.portal.CountryRepository;
import com.naijatravelshop.persistence.repository.portal.PortalUserRepository;
import com.naijatravelshop.persistence.repository.portal.ReservationOwnerRepository;
import com.naijatravelshop.persistence.repository.portal.ReservationRepository;
import com.naijatravelshop.persistence.repository.portal.TravellerRepository;
import com.naijatravelshop.persistence.repository.visa.VisaRequestRepository;
import com.naijatravelshop.service.email.EmailService;
import com.naijatravelshop.service.flight.pojo.request.FlightSegmentsDTO;
import com.naijatravelshop.service.flight.pojo.request.OriginDestinationOptionsDTO;
import com.naijatravelshop.service.flight.pojo.request.ReservationRequestDTO;
import com.naijatravelshop.service.flight.pojo.request.TravellerDTO;
import com.naijatravelshop.service.flight.pojo.response.AirportDTO;
import com.naijatravelshop.service.flight.pojo.response.ReservationResponseDTO;
import com.naijatravelshop.service.flight.service.FlightService;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Bruno on
 * 21/05/2019
 */
@Service
public class FlightServiceImpl implements FlightService {
    private AddressRepository addressRepository;
    private PaymentHistoryRepository paymentHistoryRepository;
    private ReservationOwnerRepository reservationOwnerRepository;
    private ReservationRepository reservationRepository;
    private TravellerRepository travellerRepository;
    private CountryRepository countryRepository;
    private PortalUserRepository portalUserRepository;
    private FlightBookingDetailRepository flightBookingDetailRepository;
    private FlightRouteRepository flightRouteRepository;
    private VisaRequestRepository visaRequestRepository;
    private CustomerRepository customerRepository;
    private ServiceRequestRepository serviceRequestRepository;
    private ServiceRequestActorHistoryRepository serviceRequestActorHistoryRepository;
    private ServiceRequestLogRepository serviceRequestLogRepository;
    private AirportRepository airportRepository;
    private FlightCityRepository flightCityRepository;
    private EmailService emailService;

    private static final Logger log = LoggerFactory.getLogger(FlightServiceImpl.class);

    public FlightServiceImpl(AddressRepository addressRepository,
                             PaymentHistoryRepository paymentHistoryRepository,
                             ReservationOwnerRepository reservationOwnerRepository,
                             ReservationRepository reservationRepository,
                             TravellerRepository travellerRepository,
                             CountryRepository countryRepository,
                             PortalUserRepository portalUserRepository,
                             FlightBookingDetailRepository flightBookingDetailRepository,
                             FlightRouteRepository flightRouteRepository,
                             VisaRequestRepository visaRequestRepository,
                             CustomerRepository customerRepository,
                             ServiceRequestRepository serviceRequestRepository,
                             ServiceRequestActorHistoryRepository serviceRequestActorHistoryRepository,
                             ServiceRequestLogRepository serviceRequestLogRepository,
                             AirportRepository airportRepository,
                             FlightCityRepository flightCityRepository,
                             EmailService emailService) {
        this.addressRepository = addressRepository;
        this.paymentHistoryRepository = paymentHistoryRepository;
        this.reservationOwnerRepository = reservationOwnerRepository;
        this.reservationRepository = reservationRepository;
        this.travellerRepository = travellerRepository;
        this.countryRepository = countryRepository;
        this.portalUserRepository = portalUserRepository;
        this.flightBookingDetailRepository = flightBookingDetailRepository;
        this.flightRouteRepository = flightRouteRepository;
        this.visaRequestRepository = visaRequestRepository;
        this.customerRepository = customerRepository;
        this.serviceRequestRepository = serviceRequestRepository;
        this.serviceRequestLogRepository = serviceRequestLogRepository;
        this.serviceRequestActorHistoryRepository = serviceRequestActorHistoryRepository;
        this.airportRepository = airportRepository;
        this.flightCityRepository = flightCityRepository;
        this.emailService = emailService;
    }

    @Override
    @Transactional
    public ReservationResponseDTO createReservation(ReservationRequestDTO requestDTO) {
        try {
            Optional<Country> optionalCountry = countryRepository.findFirstByCode(requestDTO.getReservationOwner().getCountryCode());

            Address address = new Address();
            address.setName(requestDTO.getReservationOwner().getAddress());
            address.setCity(requestDTO.getReservationOwner().getCity());
            if (optionalCountry.isPresent()) {
                address.setCountry(optionalCountry.get());
            }
            addressRepository.save(address);

            ReservationOwner owner = new ReservationOwner();
            Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(requestDTO.getReservationOwner().getDateOfBirth());
            owner.setFirstName(requestDTO.getReservationOwner().getFirstName());
            owner.setLastName(requestDTO.getReservationOwner().getLastName());
            owner.setAddress(address);
            owner.setDateOfBirth(new Timestamp(dob.getTime()));
            owner.setEmail(requestDTO.getReservationOwner().getEmail());
            owner.setPhoneNumber(requestDTO.getReservationOwner().getPhoneNumber());
            if (optionalCountry.isPresent()) {
                owner.setNationality(optionalCountry.get());
            }

            if (requestDTO.getReservationOwner().getTitleCode() == 1) {
                owner.setTitle("MISS");
            }
            if (requestDTO.getReservationOwner().getTitleCode() == 3) {
                owner.setTitle("MRS");
            }

            if (requestDTO.getReservationOwner().getTitleCode() == 0) {
                owner.setTitle("MR");
            }
            reservationOwnerRepository.save(owner);

            FlightBookingDetail flightBookingDetail = new FlightBookingDetail();
            flightBookingDetail.setBookingDate(new Timestamp(new Date().getTime()));
            flightBookingDetail.setNumberOfAdult(requestDTO.getFlightSearch().getTravellerDetail().getAdults());
            flightBookingDetail.setNumberOfChildren(requestDTO.getFlightSearch().getTravellerDetail().getChildren());
            flightBookingDetail.setNumberOfInfant(requestDTO.getFlightSearch().getTravellerDetail().getInfants());
            flightBookingDetail.setFlightSummary(requestDTO.getFlightSummary());
            flightBookingDetail.setPnr(requestDTO.getBookingNumber());
            flightBookingDetailRepository.save(flightBookingDetail);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            List<FlightRoute> flightRouteList = new ArrayList<>();
            for (OriginDestinationOptionsDTO originDestinationOptionsDTO : requestDTO.getFlightDetails().getOriginDestinationOptions()) {
                for (FlightSegmentsDTO flightSegmentsDTO : originDestinationOptionsDTO.getFlightSegments()) {
                    FlightRoute flightRoute = new FlightRoute();
                    flightRoute.setArrivalTime(new Timestamp(simpleDateFormat.parse(flightSegmentsDTO.getArrivalTime()).getTime()));
                    flightRoute.setDepartureAirport(flightSegmentsDTO.getDepartureAirportName());
                    flightRoute.setDepartureCityName(flightSegmentsDTO.getDepartureAirportName().split("-")[0]);
                    flightRoute.setDepartureTime(new Timestamp(simpleDateFormat.parse(flightSegmentsDTO.getDepartureTime()).getTime()));
                    flightRoute.setDestinationAirport(flightSegmentsDTO.getArrivalAirportName());
                    flightRoute.setDestinationCityName(flightSegmentsDTO.getArrivalAirportName().split("-")[0]);
                    flightRoute.setFlightDuration(flightSegmentsDTO.getJourneyDuration());
                    flightRoute.setFlightBookingDetail(flightBookingDetail);
                    flightRoute.setFlightNumber(flightSegmentsDTO.getFlightNumber());
                    flightRoute.setMarketingAirlineCode(flightSegmentsDTO.getAirlineCode());
                    flightRoute.setMarketingAirlineName(flightSegmentsDTO.getAirlineName());
                    flightRoute.setOperatingAirlineCode(flightSegmentsDTO.getAirlineCode());
                    flightRoute.setAirlineName(flightSegmentsDTO.getAirlineName());
                    flightRoute.setBookingClass(flightSegmentsDTO.getBookingClass());

                    flightRouteList.add(flightRoute);
                    flightRouteRepository.save(flightRoute);
                }
            }

            Reservation reservation = new Reservation();
            reservation.setSellingPrice(requestDTO.getAmount().longValue());
            reservation.setBookingNumber(requestDTO.getBookingNumber());
            reservation.setReservationOwner(owner);
            reservation.setStatus(EntityStatus.ACTIVE);
            reservation.setTransactionFeeInKobo(0L);
            reservation.setSupplierGroupType(SupplierGroupType.AMADEUS);
            reservation.setMargin(0L);
            reservation.setReservationStatus(ProcessStatus.PENDING);
            reservation.setReservationType(ReservationType.FLIGHT);
            reservation.setFlightBookingDetail(flightBookingDetail);
            if (requestDTO.getPortalUsername() != null) {
                Optional<PortalUser> optionalPortalUser = portalUserRepository.findFirstByEmailAndStatus(requestDTO.getPortalUsername(), EntityStatus.ACTIVE);
                reservation.setProcessedBy(optionalPortalUser.get());
            }
            reservationRepository.save(reservation);

            List<Traveller> travellerList = new ArrayList<>();
            for (TravellerDTO traveller : requestDTO.getTravellers()) {
                Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(traveller.getDateOfBirth());

                Traveller t = new Traveller();
                t.setDateOfBirth(new Timestamp(dateOfBirth.getTime()));
                t.setFirstName(traveller.getFirstName());
                t.setLastName(traveller.getLastName());

                if (traveller.getTitleCode() == 1) {
                    t.setTitle("MISS");
                    t.setGender(Gender.FEMALE);
                }
                if (traveller.getTitleCode() == 3) {
                    t.setTitle("MRS");
                    t.setGender(Gender.FEMALE);
                }

                if (traveller.getTitleCode() == 0) {
                    t.setTitle("MR");
                    t.setGender(Gender.MALE);
                }

                if (traveller.getTitleCode() == 2) {
                    t.setTitle("MASTER");
                    t.setGender(Gender.MALE);
                }
                travellerList.add(t);
                t.setReservation(reservation);
                travellerRepository.save(t);
            }

            try {
                createFlightServiceRequest(reservation, owner, requestDTO);
                sendFlightBookingEmail(owner, reservation, travellerList, flightRouteList);
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

    @Cacheable(value = "airports", unless = "#result == null")
    @Override
    public List<AirportDTO> getAllAirports() {
        List<AirportDTO> airportDTOS = new ArrayList<>();
        List<Airport> airportList = airportRepository.getAirportByPopularityIndexGreaterThan(0);
        log.info("number of airports {}", airportList.size());
        airportList.forEach(airport -> {
            Optional<FlightCity> flightCity = flightCityRepository.findById(airport.getFlightCity());
            Optional<Country> country = countryRepository.findById(flightCity.get().getCountry());
            AirportDTO airportDTO = AirportDTO
                    .builder()
                    .city(flightCity.get().getName())
                    .country(country.get().getName())
                    .gmt(airport.getGmt())
                    .iataCode(airport.getIataCode())
                    .icaoCode(airport.getIcaoCode())
                    .latitude(airport.getLatitude())
                    .longitude(airport.getLongitude())
                    .name(airport.getName())
                    .displayName(airport.getName() + " (" + airport.getIataCode() + "), " + flightCity.get().getName()+", "+ country.get().getName())
                    .timezone(airport.getTimezone())
                    .build();

            airportDTOS.add(airportDTO);
        });
        return airportDTOS;
    }

    @Transactional
    public void createFlightServiceRequest(Reservation reservation, ReservationOwner reservationOwner, ReservationRequestDTO requestDTO) {
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
        serviceRequest.setDescription(requestDTO.getFlightSummary());
        serviceRequest.setPriority(Priority.MEDIUM);
        serviceRequest.setReservation(reservation);
        serviceRequest.setRequestId(RandomStringUtils.randomAlphabetic(6));
        serviceRequest.setServiceType(ReservationType.FLIGHT);
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
            serviceRequestLog.setSubject(ServiceTaskSubject.FLIGHT_ENQUIRY);
            serviceRequestLog.setTaskType(ServiceTaskType.NEW_TASK);
            serviceRequestLog.setStatus(EntityStatus.ACTIVE);
            serviceRequestLogRepository.save(serviceRequestLog);
        }
    }

    private void sendFlightBookingEmail(ReservationOwner owner, Reservation reservation, List<Traveller> travellers,
                                        List<FlightRoute> itinerary) {
        log.info("Sending mail.....");
        Map<String, Object> flightBookingEmail = new HashMap<>();
        flightBookingEmail.put("recieverName", owner.getTitle() + " " + owner.getLastName());
        flightBookingEmail.put("reservationDate", reservation.getDateCreated());
        flightBookingEmail.put("bookingNumber", reservation.getBookingNumber());
        flightBookingEmail.put("amount", reservation.getSellingPrice().toString().substring(0, reservation.getSellingPrice().toString().length() - 2) + "." + reservation.getSellingPrice().toString().substring(reservation.getSellingPrice().toString().length() - 2));
        flightBookingEmail.put("supplierReference", " BOOKING NOT YET CREATED");
        flightBookingEmail.put("contactName", owner.getTitle() + " " + owner.getFirstName() + " " + owner.getLastName());
        flightBookingEmail.put("contactEmail", owner.getEmail());
        flightBookingEmail.put("contactPhone", owner.getPhoneNumber());
        flightBookingEmail.put("itinerary", itinerary);
        flightBookingEmail.put("travellers", travellers);

        emailService.sendHtmlEmail(owner.getEmail(), "Flight Booking Notification", "flight-booking-confirmation-template", flightBookingEmail, "travel@naijatravelshop.com");
    }

}

