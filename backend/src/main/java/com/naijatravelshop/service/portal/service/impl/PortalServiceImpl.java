package com.naijatravelshop.service.portal.service.impl;

import com.naijatravelshop.persistence.model.crm.Customer;
import com.naijatravelshop.persistence.model.enums.EntityStatus;
import com.naijatravelshop.persistence.model.enums.ProcessStatus;
import com.naijatravelshop.persistence.model.enums.ReservationType;
import com.naijatravelshop.persistence.model.enums.RoleType;
import com.naijatravelshop.persistence.model.flight.FlightBookingDetail;
import com.naijatravelshop.persistence.model.flight.FlightRoute;
import com.naijatravelshop.persistence.model.hotel.HotelBookingDetail;
import com.naijatravelshop.persistence.model.hotel.RoomOffer;
import com.naijatravelshop.persistence.model.payment.PaymentHistory;
import com.naijatravelshop.persistence.model.portal.Country;
import com.naijatravelshop.persistence.model.portal.PortalUser;
import com.naijatravelshop.persistence.model.portal.PortalUserRoleMap;
import com.naijatravelshop.persistence.model.portal.Reservation;
import com.naijatravelshop.persistence.model.portal.ReservationOwner;
import com.naijatravelshop.persistence.model.portal.Role;
import com.naijatravelshop.persistence.model.portal.Setting;
import com.naijatravelshop.persistence.model.portal.Traveller;
import com.naijatravelshop.persistence.model.visa.VisaRequest;
import com.naijatravelshop.persistence.repository.crm.CustomerRepository;
import com.naijatravelshop.persistence.repository.flight.FlightBookingDetailRepository;
import com.naijatravelshop.persistence.repository.flight.FlightRouteRepository;
import com.naijatravelshop.persistence.repository.hotel.RoomOfferRepository;
import com.naijatravelshop.persistence.repository.payment.PaymentHistoryRepository;
import com.naijatravelshop.persistence.repository.portal.CountryRepository;
import com.naijatravelshop.persistence.repository.portal.PortalUserRepository;
import com.naijatravelshop.persistence.repository.portal.PortalUserRoleMapRepository;
import com.naijatravelshop.persistence.repository.portal.ReservationOwnerRepository;
import com.naijatravelshop.persistence.repository.portal.ReservationRepository;
import com.naijatravelshop.persistence.repository.portal.RoleRepository;
import com.naijatravelshop.persistence.repository.portal.SettingRepository;
import com.naijatravelshop.persistence.repository.portal.TravellerRepository;
import com.naijatravelshop.persistence.repository.visa.VisaRequestRepository;
import com.naijatravelshop.service.email.EmailService;
import com.naijatravelshop.service.flight.pojo.request.FlightSegmentsDTO;
import com.naijatravelshop.service.flight.pojo.request.TravellerDTO;
import com.naijatravelshop.service.hotel.pojo.request.RoomDTO;
import com.naijatravelshop.service.portal.pojo.request.BookingSearchDTO;
import com.naijatravelshop.service.portal.pojo.request.PasswordDTO;
import com.naijatravelshop.service.portal.pojo.request.UserDTO;
import com.naijatravelshop.service.portal.pojo.response.AffiliateAccountDetail;
import com.naijatravelshop.service.portal.pojo.response.DOTWDetail;
import com.naijatravelshop.service.portal.pojo.response.FlightReservationResponse;
import com.naijatravelshop.service.portal.pojo.response.FlutterwaveDetail;
import com.naijatravelshop.service.portal.pojo.response.HotelReservationResponse;
import com.naijatravelshop.service.portal.pojo.response.PortalSettingResponse;
import com.naijatravelshop.service.portal.pojo.response.RecentBookingResponse;
import com.naijatravelshop.service.portal.pojo.response.UserResponse;
import com.naijatravelshop.service.portal.pojo.response.VisaResponse;
import com.naijatravelshop.service.portal.service.PortalService;
import com.naijatravelshop.service.visa.pojo.response.VisaCountryDTO;
import com.naijatravelshop.web.constants.ProjectConstant;
import com.naijatravelshop.web.exceptions.BadRequestException;
import com.naijatravelshop.web.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Bruno on
 * 17/05/2019
 */
@Service
public class PortalServiceImpl implements PortalService {

    private PortalUserRepository portalUserRepository;
    private PortalUserRoleMapRepository portalUserRoleMapRepository;
    private RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private EmailService emailService;
    private SettingRepository settingRepository;
    private ReservationRepository reservationRepository;
    private FlightBookingDetailRepository flightBookingDetailRepository;
    private PaymentHistoryRepository paymentHistoryRepository;
    private ReservationOwnerRepository reservationOwnerRepository;
    private FlightRouteRepository flightRouteRepository;
    private TravellerRepository travellerRepository;
    private VisaRequestRepository visaRequestRepository;
    private RoomOfferRepository roomOfferRepository;
    private CustomerRepository customerRepository;
    private CountryRepository countryRepository;

    private static final Logger log = LoggerFactory.getLogger(PortalServiceImpl.class);

    public PortalServiceImpl(PortalUserRepository portalUserRepository,
                             PasswordEncoder passwordEncoder,
                             PortalUserRoleMapRepository portalUserRoleMapRepository,
                             RoleRepository roleRepository,
                             EmailService emailService,
                             SettingRepository settingRepository,
                             ReservationRepository reservationRepository,
                             FlightBookingDetailRepository flightBookingDetailRepository,
                             PaymentHistoryRepository paymentHistoryRepository,
                             ReservationOwnerRepository reservationOwnerRepository,
                             FlightRouteRepository flightRouteRepository,
                             TravellerRepository travellerRepository,
                             VisaRequestRepository visaRequestRepository,
                             RoomOfferRepository roomOfferRepository,
                             CustomerRepository customerRepository, CountryRepository countryRepository) {
        this.portalUserRepository = portalUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.portalUserRoleMapRepository = portalUserRoleMapRepository;
        this.roleRepository = roleRepository;
        this.emailService = emailService;
        this.settingRepository = settingRepository;
        this.reservationRepository = reservationRepository;
        this.flightBookingDetailRepository = flightBookingDetailRepository;
        this.paymentHistoryRepository = paymentHistoryRepository;
        this.reservationOwnerRepository = reservationOwnerRepository;
        this.flightRouteRepository = flightRouteRepository;
        this.travellerRepository = travellerRepository;
        this.visaRequestRepository = visaRequestRepository;
        this.roomOfferRepository = roomOfferRepository;
        this.customerRepository = customerRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    @Transactional
    public UserResponse createUserAccount(UserDTO userDTO) {
        Optional<PortalUser> optionalPortalUser = portalUserRepository.findFirstByEmailAndStatus(userDTO.getEmail(), EntityStatus.ACTIVE);
        if (optionalPortalUser.isPresent()) {
            throw new BadRequestException("User account already exists");
        }
        Timestamp currentTime = new Timestamp(new Date().getTime());
        PortalUser user = new PortalUser();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        if (!StringUtils.isEmpty(userDTO.getPassword())) {
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }
        user.setPasswordReset(false);
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setDateCreated(currentTime);
        user.setStatus(EntityStatus.ACTIVE);
        user.setLastUpdated(currentTime);
        user.setLastPasswordUpdate(currentTime);
        portalUserRepository.save(user);

        userDTO.getRoles().stream().map(role -> roleRepository.findFirstByDisplayName(role)).forEachOrdered(optionalRole -> {
            PortalUserRoleMap portalUserRoleMap = new PortalUserRoleMap();
            portalUserRoleMap.setPortalUser(user);
            portalUserRoleMap.setRole(optionalRole.get());
            portalUserRoleMap.setStatus(EntityStatus.ACTIVE);
            portalUserRoleMapRepository.save(portalUserRoleMap);
        });

        Map<String, Object> newAccount = new HashMap<>();
        newAccount.put("recieverName", user.getFirstName());
        emailService.sendHtmlEmail(user.getEmail(), "Naija Travel Shop: New User Account!", "account-creation-template", newAccount, "travel@naijatravelshop.com");

        return buildUserResponse(user, userDTO);
    }

    @Override
    public UserResponse updateUserAccount(UserDTO userDTO) {
        PortalUser user = doesUserExist(userDTO);
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setLastUpdated(new Timestamp(new Date().getTime()));
        portalUserRepository.save(user);

        return buildUserResponse(user, userDTO);
    }

    @Override
    public UserResponse deactivateUserAccount(UserDTO userDTO) {
        PortalUser user = doesUserExist(userDTO);
        user.setStatus(EntityStatus.DEACTIVATED);
        user.setLastUpdated(new Timestamp(new Date().getTime()));
        portalUserRepository.save(user);

        UserResponse userResponse = buildUserResponse(user, userDTO);
        userResponse.setActive(false);

        return userResponse;
    }

    @Override
    public UserResponse reactivateUserAccount(UserDTO userDTO) {
        PortalUser user = doesUserExist(userDTO);
        user.setStatus(EntityStatus.ACTIVE);
        user.setLastUpdated(new Timestamp(new Date().getTime()));
        portalUserRepository.save(user);

        UserResponse userResponse = buildUserResponse(user, userDTO);
        userResponse.setActive(true);

        return userResponse;
    }

    @Override
    public UserResponse resetPassword(UserDTO userDTO) {
        Optional<PortalUser> optionalPortalUser = Optional.empty();

        if (userDTO.getId() != null) {
            optionalPortalUser = portalUserRepository.findById(userDTO.getId());
        }

        if (!optionalPortalUser.isPresent()) {
            optionalPortalUser = portalUserRepository.findFirstByEmailAndStatus(userDTO.getEmail(), EntityStatus.ACTIVE);
            if (!optionalPortalUser.isPresent()) {
                throw new NotFoundException("User does not exist");
            }
        }
        String newPassword = randomAlphaNumeric(8);
        PortalUser user = optionalPortalUser.get();
        user.setPassword(passwordEncoder.encode(newPassword));
        user.setLastUpdated(new Timestamp(new Date().getTime()));
        user.setLastPasswordUpdate(new Timestamp(new Date().getTime()));
        portalUserRepository.save(user);
        log.info(newPassword);

        Map<String, Object> newAccount = new HashMap<>();
        newAccount.put("recieverName", user.getFirstName());
        newAccount.put("password", newPassword);
        emailService.sendHtmlEmail(user.getEmail(), "Naija Travel Shop: Password Reset!", "password-reset-template", newAccount, "travel@naijatravelshop.com");

        return buildUserResponse(user, userDTO);
    }

    @Override
    public UserResponse changePassword(PasswordDTO passwordDTO) {
        Optional<PortalUser> optionalPortalUser = portalUserRepository.findById(passwordDTO.getUserId());

        if (!optionalPortalUser.isPresent()) {
            throw new NotFoundException("User does not exist");
        }
        Timestamp currentTime = new Timestamp(new Date().getTime());
        PortalUser user = optionalPortalUser.get();
        CharSequence passwordCharSequence = new StringBuffer(passwordDTO.getOldPassword());
        if (passwordEncoder.matches(passwordCharSequence, user.getPassword())) {
            user.setPassword(passwordEncoder.encode(passwordDTO.getNewPassword()));
            user.setLastUpdated(currentTime);
            user.setLastPasswordUpdate(currentTime);
            portalUserRepository.save(user);

            return buildUserResponse(user, null);
        } else {
            throw new BadRequestException("Password is incorrect");
        }
    }

    @Override
    public UserResponse login(UserDTO userDTO) {
        Optional<PortalUser> optionalPortalUser;

        optionalPortalUser = portalUserRepository.findFirstByEmailAndStatus(userDTO.getEmail(), EntityStatus.ACTIVE);
        if (!optionalPortalUser.isPresent()) {
            throw new NotFoundException("User with this email does not exist");
        }
        List<PortalUserRoleMap> roleMaps = portalUserRoleMapRepository.getAllByStatusAndPortalUserEquals(EntityStatus.ACTIVE, optionalPortalUser.get());
        List<String> roles = new ArrayList<>();
        for (PortalUserRoleMap portalUserRoleMap : roleMaps) {
            Optional<Role> role = roleRepository.findById(portalUserRoleMap.getRole().getId());
            if (role.isPresent()) {
                roles.add(role.get().getDisplayName());
            }
        }
        PortalUser user = optionalPortalUser.get();
        CharSequence passwordCharSequence = new StringBuffer(userDTO.getPassword());

        if (passwordEncoder.matches(passwordCharSequence, user.getPassword())) {
            UserResponse userResponse = buildUserResponse(user, userDTO);
            userResponse.setRoles(roles);
            userResponse.setPasswordReset(user.isPasswordReset());

            return userResponse;
        } else {
            throw new NotFoundException("User with this password does not exist");
        }
    }

    @Override
    public AffiliateAccountDetail getAffiliateAccountDetail() {
        Optional<Setting> secretKey = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_SECRET_KEY);
        Optional<Setting> publicKey = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_PUBLIC_KEY);
        Optional<Setting> affiliateCode = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_CODE);

        AffiliateAccountDetail affiliateAccountDetail = new AffiliateAccountDetail();
        affiliateAccountDetail.setAffiliateCode(affiliateCode.get().getValue());
        affiliateAccountDetail.setPublicKey(publicKey.get().getValue());
        affiliateAccountDetail.setSecretKey(secretKey.get().getValue());

        return affiliateAccountDetail;
    }

    @Override
    public String getApiBaseUrl() {
        Optional<Setting> baseUrl = settingRepository.findFirstByNameEquals(ProjectConstant.API_BASE_URL);
        return baseUrl.get().getValue();
    }

    @Override
    public List<RecentBookingResponse> getRecentBooking() {
        List<RecentBookingResponse> recentBookingResponseList = new ArrayList<>();

        Page<Reservation> page = reservationRepository.findAll(PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "dateCreated")));
        page.get().forEach(reservation -> {
            RecentBookingResponse recentBookingResponse = new RecentBookingResponse();
            recentBookingResponse.setAmount(reservation.getSellingPrice().doubleValue());
            recentBookingResponse.setBookingDate(reservation.getDateCreated());
            recentBookingResponse.setBookingType(reservation.getReservationType().getValue());
            if (reservation.getReservationType().equals(ReservationType.FLIGHT) && reservation.getFlightBookingDetail() != null) {
                Optional<FlightBookingDetail> optFlightBookingDetail = flightBookingDetailRepository.findById(reservation.getFlightBookingDetail().getId());
                optFlightBookingDetail.ifPresent(flightBookingDetail -> recentBookingResponse.setDescription(reservation.getFlightBookingDetail().getFlightSummary()));
            }
            recentBookingResponse.setBookingNumber(reservation.getBookingNumber());
            recentBookingResponseList.add(recentBookingResponse);
        });

        return recentBookingResponseList;
    }

    @Override
    public List<RecentBookingResponse> getFlightBookingBySearchTerm(BookingSearchDTO bookingSearchDTO) {
        List<RecentBookingResponse> bookingList = new ArrayList<>();

        if (StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
            Page<Reservation> page = reservationRepository.findAll(PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "dateCreated")));
            bookingList = flightReservationToRecentBookingResponse(page.getContent());
        } else {
            Timestamp startDateTimeStamp = null;
            Timestamp endDateTimeStamp = null;
            try {
                startDateTimeStamp = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(bookingSearchDTO.getStartDate()).getTime());
                endDateTimeStamp = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(bookingSearchDTO.getEndDate()).getTime());
            } catch (ParseException e) {

            }

            if (!StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && !StringUtils.isEmpty(bookingSearchDTO.getStartDate())
                    && !StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                bookingList = getRecentFlightBookingResponses(bookingSearchDTO.getBookingNo(), bookingList);
            }

            if (StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && !StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && !StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                List<Reservation> reservations =
                        reservationRepository.getAllByReservationStatusEqualsAndDateCreatedBetween(ProcessStatus.valueOf(bookingSearchDTO.getBookingStatus()),
                                startDateTimeStamp, endDateTimeStamp);
                bookingList = flightReservationToRecentBookingResponse(reservations);
            }

            if (StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && !StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                List<Reservation> reservations =
                        reservationRepository.getAllByReservationStatusEquals(ProcessStatus.valueOf(bookingSearchDTO.getBookingStatus()));
                bookingList = flightReservationToRecentBookingResponse(reservations);
            }

            if (!StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                bookingList = getRecentFlightBookingResponses(bookingSearchDTO.getBookingNo(), bookingList);
            }

            if (!StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && !StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                bookingList = getRecentFlightBookingResponses(bookingSearchDTO.getBookingNo(), bookingList);
            }

            if (!StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && !StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                bookingList = getRecentFlightBookingResponses(bookingSearchDTO.getBookingNo(), bookingList);
            }

            if (StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && !StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                List<Reservation> reservations =
                        reservationRepository.getAllByDateCreatedBetween(startDateTimeStamp,
                                endDateTimeStamp);
                bookingList = flightReservationToRecentBookingResponse(reservations);
            }
        }
        return bookingList;

    }

    @Override
    public List<RecentBookingResponse> getHotelBookingBySearchTerm(BookingSearchDTO bookingSearchDTO) {
        List<RecentBookingResponse> bookingList = new ArrayList<>();

        if (StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
            Page<Reservation> page = reservationRepository.findAll(PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "dateCreated")));
            bookingList = hotelReservationToRecentBookingResponse(page.getContent());
        } else {
            Timestamp startDateTimeStamp = null;
            Timestamp endDateTimeStamp = null;
            try {
                startDateTimeStamp = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(bookingSearchDTO.getStartDate()).getTime());
                endDateTimeStamp = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(bookingSearchDTO.getEndDate()).getTime());
            } catch (ParseException e) {

            }

            if (!StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && !StringUtils.isEmpty(bookingSearchDTO.getStartDate())
                    && !StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                bookingList = getRecentHotelBookingResponses(bookingSearchDTO.getBookingNo(), bookingList);
            }

            if (StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && !StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && !StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                List<Reservation> reservations =
                        reservationRepository.getAllByReservationStatusEqualsAndDateCreatedBetween(ProcessStatus.valueOf(bookingSearchDTO.getBookingStatus()),
                                startDateTimeStamp, endDateTimeStamp);
                bookingList = hotelReservationToRecentBookingResponse(reservations);
            }

            if (StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && !StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                List<Reservation> reservations =
                        reservationRepository.getAllByReservationStatusEquals(ProcessStatus.valueOf(bookingSearchDTO.getBookingStatus()));
                bookingList = hotelReservationToRecentBookingResponse(reservations);
            }

            if (!StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                bookingList = getRecentHotelBookingResponses(bookingSearchDTO.getBookingNo(), bookingList);
            }

            if (!StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && !StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                bookingList = getRecentHotelBookingResponses(bookingSearchDTO.getBookingNo(), bookingList);
            }

            if (!StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && !StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                bookingList = getRecentHotelBookingResponses(bookingSearchDTO.getBookingNo(), bookingList);
            }

            if (StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && !StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                List<Reservation> reservations =
                        reservationRepository.getAllByDateCreatedBetween(startDateTimeStamp,
                                endDateTimeStamp);
                bookingList = hotelReservationToRecentBookingResponse(reservations);
            }
        }
        return bookingList;
    }

    @Override
    public RecentBookingResponse changeBookingStatus(BookingSearchDTO bookingSearchDTO) {
        Optional<Reservation> optionalReservation = reservationRepository.findFirstByBookingNumberEquals(bookingSearchDTO.getBookingNo());

        if (!optionalReservation.isPresent()) {
            throw new BadRequestException("Reservation does not exist");
        }
        Reservation reservation = optionalReservation.get();
        reservation.setReservationStatus(ProcessStatus.valueOf(bookingSearchDTO.getBookingStatus()));
        reservation.setLastUpdated(new Timestamp(new Date().getTime()));
        if (bookingSearchDTO.getBookingStatus().equalsIgnoreCase("PROCESSED")) {
            reservation.setDateProcessed(new Timestamp(new Date().getTime()));
        }
        reservationRepository.save(reservation);
        RecentBookingResponse recentBookingResponse = new RecentBookingResponse();
        recentBookingResponse.setBookingStatus(reservation.getReservationStatus().getValue());
        recentBookingResponse.setBookingNumber(reservation.getBookingNumber());
        return recentBookingResponse;
    }

    @Override
    public VisaResponse changeVisaRequestStatus(BookingSearchDTO bookingSearchDTO) {
        Optional<VisaRequest> optionalVisaRequest = visaRequestRepository.findById(Long.valueOf(bookingSearchDTO.getBookingNo()));
        if (!optionalVisaRequest.isPresent()) {
            throw new BadRequestException("Reservation does not exist");
        }
        VisaRequest visaRequest = optionalVisaRequest.get();
        visaRequest.setLastUpdated(new Timestamp(new Date().getTime()));
        visaRequest.setProcessed(Boolean.valueOf(bookingSearchDTO.getBookingStatus()));
        visaRequestRepository.save(visaRequest);

        return VisaResponse.builder()
                .processed(Boolean.valueOf(bookingSearchDTO.getBookingStatus()))
                .id(Long.valueOf(bookingSearchDTO.getBookingNo()))
                .build();
    }

    @Override
    public List<UserResponse> getPortalUsers() {
        Optional<Role> role = roleRepository.findFirstByNameEquals(RoleType.PORTAL_USER);
        List<PortalUserRoleMap> portalUserRoleMaps = portalUserRoleMapRepository.getAllByRoleEquals(role.get());

        List<UserResponse> userResponses = new ArrayList<>();
        portalUserRoleMaps.forEach(portalUser -> {
            UserResponse userResponse = new UserResponse();
            userResponse.setPhoneNumber(portalUser.getPortalUser().getPhoneNumber());
            userResponse.setId(portalUser.getPortalUser().getId());
            userResponse.setFirstName(portalUser.getPortalUser().getFirstName());
            userResponse.setLastName(portalUser.getPortalUser().getLastName());
            userResponse.setEmail(portalUser.getPortalUser().getEmail());
            switch (portalUser.getStatus()) {
                case ACTIVE:
                    userResponse.setActive(true);
                    break;
                default:
                    userResponse.setActive(false);
                    break;
            }
            List<PortalUserRoleMap> roleMaps = portalUserRoleMapRepository.getAllByStatusAndPortalUserEquals(EntityStatus.ACTIVE, portalUser.getPortalUser());
            List<String> roles = roleMaps.stream().map(roleMap -> roleMap.getRole().getDisplayName()).collect(Collectors.toList());
            userResponse.setRoles(roles);
            userResponses.add(userResponse);
        });
        return userResponses;
    }

    @Override
    public PortalSettingResponse getPortalSettings() {
        PortalSettingResponse portalSettingResponse = new PortalSettingResponse();
        Optional<Setting> optionalSetting;

        FlutterwaveDetail flutterwaveDetail = new FlutterwaveDetail();
        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.FLW_PAYMENT_VERIFY_ENDPOINT);
        flutterwaveDetail.setVerifyEndpoint(optionalSetting.orElse(new Setting()).getValue());

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.FLW_SECRET_KEY);
        flutterwaveDetail.setSecretKey(optionalSetting.orElse(new Setting()).getValue());

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.FLW_PUBLIC_KEY);
        flutterwaveDetail.setPublicKey(optionalSetting.orElse(new Setting()).getValue());

        DOTWDetail dotwDetail = new DOTWDetail();
        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.DOTW_LOGIN_PASSWORD);
        dotwDetail.setPassword(optionalSetting.orElse(new Setting()).getValue());

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.DOTW_COMPANY_CODE);
        dotwDetail.setCompanyCode(optionalSetting.orElse(new Setting()).getValue());

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.DOTW_LOGIN_ID);
        dotwDetail.setId(optionalSetting.orElse(new Setting()).getValue());

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.DOTW_CUSTOMER_NAME);
        dotwDetail.setCustomerName(optionalSetting.orElse(new Setting()).getValue());

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.DOTW_HOST_URL);
        dotwDetail.setHostUrl(optionalSetting.orElse(new Setting()).getValue());

        AffiliateAccountDetail affiliateAccountDetail = new AffiliateAccountDetail();
        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_CODE);
        affiliateAccountDetail.setAffiliateCode(optionalSetting.orElse(new Setting()).getValue());

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_PUBLIC_KEY);
        affiliateAccountDetail.setPublicKey(optionalSetting.orElse(new Setting()).getValue());

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_SECRET_KEY);
        affiliateAccountDetail.setSecretKey(optionalSetting.orElse(new Setting()).getValue());

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.API_BASE_URL);
        affiliateAccountDetail.setBaseUrl(optionalSetting.orElse(new Setting()).getValue());

        portalSettingResponse.setAffiliateAccountDetail(affiliateAccountDetail);
        portalSettingResponse.setDotwDetail(dotwDetail);
        portalSettingResponse.setFlutterwaveDetail(flutterwaveDetail);
        portalSettingResponse.setExchangeRate(settingRepository.findFirstByNameEquals(ProjectConstant.CURRENCY_EXCHANGE_RATE).get().getValue());

        return portalSettingResponse;
    }

    @Override
    public String updateExchangeRateSetting(String currency) {
        Optional<Setting> optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.CURRENCY_EXCHANGE_RATE);
        optionalSetting.ifPresent(setting -> {
            setting.setValue(currency);
            settingRepository.save(setting);
        });
        return currency;
    }


    @Override
    @Transactional
    public FlutterwaveDetail updateFlutterwaveSetting(FlutterwaveDetail flutterwaveDetail) {
        Optional<Setting> optionalSetting;

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.FLW_PAYMENT_VERIFY_ENDPOINT);
        optionalSetting.ifPresent(setting -> {
            setting.setValue(flutterwaveDetail.getVerifyEndpoint());
            settingRepository.save(setting);
        });

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.FLW_PUBLIC_KEY);
        optionalSetting.ifPresent(setting -> {
            setting.setValue(flutterwaveDetail.getPublicKey());
            settingRepository.save(setting);
        });

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.FLW_SECRET_KEY);
        optionalSetting.ifPresent(setting -> {
            setting.setValue(flutterwaveDetail.getSecretKey());
            settingRepository.save(setting);
        });

        return flutterwaveDetail;
    }

    @Override
    @Transactional
    public AffiliateAccountDetail updateTravelbetaAffiliateSetting(AffiliateAccountDetail affiliateAccountDetail) {
        Optional<Setting> optionalSetting;

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_SECRET_KEY);
        optionalSetting.ifPresent(setting -> {
            setting.setValue(affiliateAccountDetail.getSecretKey());
            settingRepository.save(setting);
        });

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_CODE);
        optionalSetting.ifPresent(setting -> {
            setting.setValue(affiliateAccountDetail.getAffiliateCode());
            settingRepository.save(setting);
        });

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_PUBLIC_KEY);
        optionalSetting.ifPresent(setting -> {
            setting.setValue(affiliateAccountDetail.getPublicKey());
            settingRepository.save(setting);
        });

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.API_BASE_URL);
        optionalSetting.ifPresent(setting -> {
            setting.setValue(affiliateAccountDetail.getBaseUrl());
            settingRepository.save(setting);
        });

        return affiliateAccountDetail;
    }

    @Override
    @Transactional
    public DOTWDetail updateDOTWSetting(DOTWDetail dotwDetail) {
        Optional<Setting> optionalSetting;

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.DOTW_HOST_URL);
        optionalSetting.ifPresent(setting -> {
            setting.setValue(dotwDetail.getHostUrl());
            settingRepository.save(setting);
        });

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.DOTW_CUSTOMER_NAME);
        optionalSetting.ifPresent(setting -> {
            setting.setValue(dotwDetail.getCustomerName());
            settingRepository.save(setting);
        });

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.DOTW_LOGIN_ID);
        optionalSetting.ifPresent(setting -> {
            setting.setValue(dotwDetail.getId());
            settingRepository.save(setting);
        });

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.DOTW_LOGIN_PASSWORD);
        optionalSetting.ifPresent(setting -> {
            setting.setValue(dotwDetail.getPassword());
            settingRepository.save(setting);
        });

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.DOTW_COMPANY_CODE);
        optionalSetting.ifPresent(setting -> {
            setting.setValue(dotwDetail.getCompanyCode());
            settingRepository.save(setting);
        });

        return dotwDetail;
    }

    @Override
    public List<String> getAllRoles() {
        List<Role> allRoles = (List<Role>) roleRepository.findAll();
        return allRoles.stream().map(Role::getDisplayName).collect(Collectors.toList());
    }

    @Override
    public void updateUserRoles(UserDTO userDTO) {
        Optional<PortalUser> optionalPortalUser = portalUserRepository.findFirstByEmailAndStatus(userDTO.getEmail(), EntityStatus.ACTIVE);
        if (!optionalPortalUser.isPresent()) {
            throw new BadRequestException("Could not fetch user");
        }
        List<PortalUserRoleMap> portalUserRoleMaps = portalUserRoleMapRepository.getAllByStatusAndPortalUserEquals(EntityStatus.ACTIVE, optionalPortalUser.get());
        portalUserRoleMaps.stream().filter(portalUserRoleMap -> !portalUserRoleMap.getRole().getDisplayName().equals(RoleType.PORTAL_USER.getValue())).forEachOrdered(portalUserRoleMap -> portalUserRoleMapRepository.delete(portalUserRoleMap));
        userDTO.getRoles().stream().map(role -> roleRepository.findFirstByDisplayName(role)).forEachOrdered(optionalRole -> {
            PortalUserRoleMap portalUserRoleMap = new PortalUserRoleMap();
            portalUserRoleMap.setPortalUser(optionalPortalUser.get());
            portalUserRoleMap.setRole(optionalRole.get());
            portalUserRoleMap.setStatus(EntityStatus.ACTIVE);
            portalUserRoleMapRepository.save(portalUserRoleMap);
        });
    }

    @Override
    public void subscribeEmail(UserDTO userDTO) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByEmail(userDTO.getEmail());
        Customer customer;
        if (optionalCustomer.isPresent()) {
            customer = optionalCustomer.get();
            if (customer.isSubscribed()) {
                throw new BadRequestException("You are already subscribed");
            }
            customer.setEmail(userDTO.getEmail());
            customer.setStatus(EntityStatus.ACTIVE);
            customer.setSubscribed(true);
            customerRepository.save(customer);
        } else {
            customer = new Customer();
            customer.setEmail(userDTO.getEmail());
            customer.setStatus(EntityStatus.ACTIVE);
            customer.setSubscribed(true);
            customerRepository.save(customer);
        }

        Map<String, Object> emailSubscriptionObjectMap = new HashMap<>();
        emailSubscriptionObjectMap.put("message", "Thank you for subscribing to our newsletters, promos, and broadcasts.");

        emailService.sendHtmlEmail(userDTO.getEmail(), "Naija Travel Shop: Email Subscription!", "email-subscription-template", emailSubscriptionObjectMap, "travel@naijatravelshop.com");
    }

    @Override
    public void unSubscribeEmail(UserDTO userDTO) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByEmail(userDTO.getEmail());

        optionalCustomer.ifPresent(customer -> {
            customer.setSubscribed(false);
            customerRepository.save(customer);

            Map<String, Object> emailSubscriptionObjectMap = new HashMap<>();
            emailSubscriptionObjectMap.put("message", "You have been unsubscribed from our newsletters, promos, and broadcasts.");

            emailService.sendHtmlEmail(userDTO.getEmail(), "Naija Travel Shop: Email Unsubscription!", "email-subscription-template", emailSubscriptionObjectMap, "travel@naijatravelshop.com");
        });

        throw new BadRequestException("Your subscription does not exist");
    }

    @Override
    public List<UserResponse> getAllSubscribedEmails() {
        List<UserResponse> userResponses = new ArrayList<>();

        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        for (int i = 0, customersSize = customers.size(); i < customersSize; i++) {
            Customer customer = customers.get(i);
            UserResponse userResponse = new UserResponse();
            userResponse.setEmail(customer.getEmail());
            userResponse.setPhoneNumber(customer.getStatus().getValue());
            userResponse.setSubscribed(customer.isSubscribed());
            userResponses.add(userResponse);
        }
        return userResponses;
    }

    @Override
    public List<VisaCountryDTO> getNAEUCountries() {
        List<Country> NAEUCountries = new ArrayList<>();
        NAEUCountries.addAll(countryRepository.getCountriesByContinent("NA"));
        NAEUCountries.addAll(countryRepository.getCountriesByContinent("EU"));
        NAEUCountries.add(countryRepository.findFirstByName("Australia").get());

        List<VisaCountryDTO> visaCountryDTOS = NAEUCountries.stream().map(country -> VisaCountryDTO
                .builder()
                .id(country.getId())
                .name(country.getName())
                .build()).collect(Collectors.toList());
        visaCountryDTOS.sort(Comparator.comparing(VisaCountryDTO::getName));
        return visaCountryDTOS;
    }

    @Override
    public FlightReservationResponse getFlightBookingDetails(String bookingNumber) {
        Optional<Reservation> optionalReservation = reservationRepository.findFirstByBookingNumberEquals(bookingNumber);
        FlightReservationResponse response = new FlightReservationResponse();

        if (!optionalReservation.isPresent()) {
            throw new BadRequestException("Reservation does not exist");
        }

        try {
            Reservation reservation = optionalReservation.get();
            if (reservation.getFlightBookingDetail() != null) {
                Optional<FlightBookingDetail> flightBookingDetail = flightBookingDetailRepository.findById(reservation.getFlightBookingDetail().getId());
                response.setHotelServiceRequested(flightBookingDetail.get().getHotelServiceRequested());
                response.setNumberOfAdult(flightBookingDetail.get().getNumberOfAdult());
                response.setNumberOfChildren(flightBookingDetail.get().getNumberOfChildren());
                response.setNumberOfInfant(flightBookingDetail.get().getNumberOfInfant());
                response.setVisaServiceRequested(flightBookingDetail.get().getVisaServiceRequested());

                List<FlightRoute> flightRoutes = flightRouteRepository.findAllByFlightBookingDetail(flightBookingDetail.get());
                List<FlightSegmentsDTO> flightSegmentsDTOS = new ArrayList<>();
                for (int i = 0, flightRoutesSize = flightRoutes.size(); i < flightRoutesSize; i++) {
                    FlightRoute flightRoute = flightRoutes.get(i);
                    FlightSegmentsDTO flightSegmentsDTO = new FlightSegmentsDTO();
                    flightSegmentsDTO.setAirlineCode(flightRoute.getMarketingAirlineCode());
                    flightSegmentsDTO.setAirlineName(flightRoute.getAirlineName());
                    flightSegmentsDTO.setArrivalAirportCode(flightRoute.getDestinationAirport());
                    flightSegmentsDTO.setArrivalAirportName(flightRoute.getDestinationCityName());
                    flightSegmentsDTO.setArrivalTime(flightRoute.getArrivalTime().toString());
                    flightSegmentsDTO.setBookingClass(flightRoute.getBookingClass());
                    flightSegmentsDTO.setDepartureAirportCode(flightRoute.getDepartureCityName());
                    flightSegmentsDTO.setDepartureAirportName(flightRoute.getDepartureAirport());
                    flightSegmentsDTO.setDepartureTime(flightRoute.getDepartureTime().toString());
                    flightSegmentsDTO.setFlightNumber(flightRoute.getFlightNumber());
                    flightSegmentsDTO.setJourneyDuration(flightRoute.getFlightDuration());
                    flightSegmentsDTOS.add(flightSegmentsDTO);
                }
                response.setFlightRoutes(flightSegmentsDTOS);
            }
            Optional<PaymentHistory> optionalPaymentHistory = paymentHistoryRepository.findPaymentHistoryByReservation(reservation);

            response.setBookingDate(reservation.getDateCreated());
            response.setBookingNumber(bookingNumber);
            response.setDateProcessed(reservation.getDateProcessed());
            response.setReservationStatus(reservation.getReservationStatus().getValue());
            response.setSellingPrice(reservation.getSellingPrice());
            response.setReservationOwner(reservationOwnerToTravellerDTO(reservation));

            optionalPaymentHistory.ifPresent(paymentHistory -> {
                response.setPaymentDate(paymentHistory.getPaymentDate());
                response.setPaymentReference(paymentHistory.getPaymentReference());
                response.setTransactionId(paymentHistory.getTransactionId());
                response.setPaymentStatus(paymentHistory.getPaymentStatus().getValue());
                response.setPaymentChannel(paymentHistory.getPaymentChannel().getValue());
            });

            List<Traveller> travellers = travellerRepository.getAllByReservation(reservation);
            List<TravellerDTO> travellerDTOList = new ArrayList<>();
            for (int i = 0, travellersSize = travellers.size(); i < travellersSize; i++) {
                Traveller traveller = travellers.get(i);
                TravellerDTO travellerDTO = new TravellerDTO();
                travellerDTO.setTitle(traveller.getTitle());
                travellerDTO.setLastName(traveller.getLastName());
                travellerDTO.setFirstName(traveller.getFirstName());
                travellerDTO.setDateOfBirth(traveller.getDateOfBirth().toString());
                travellerDTOList.add(travellerDTO);
            }
            response.setTravellers(travellerDTOList);

        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException("Error Fetching Flight Booking Details: " + e.getMessage());
        }
        return response;
    }

    @Override
    public HotelReservationResponse getHotelBookingDetails(String bookingNumber) {
        Optional<Reservation> optionalReservation = reservationRepository.findFirstByBookingNumberEquals(bookingNumber);
        if (!optionalReservation.isPresent()) {
            throw new BadRequestException("Reservation does not exist");
        }
        try {
            Reservation reservation = optionalReservation.get();
            HotelBookingDetail hotelBookingDetail = reservation.getHotelBookingDetail();
            Optional<PaymentHistory> paymentHistory = paymentHistoryRepository.findPaymentHistoryByReservation(reservation);
            List<RoomOffer> roomOffers = roomOfferRepository.getAllByHotelBookingDetail(hotelBookingDetail);
            List<RoomDTO> roomDTOS = new ArrayList<>();

            roomOffers.stream().map(roomOffer -> travellerRepository.getAllByRoomOffer(roomOffer)).forEachOrdered(travellers -> {
                List<TravellerDTO> adultList = new ArrayList<>();
                List<TravellerDTO> childrenList = new ArrayList<>();
                for (int i = 0, travellersSize = travellers.size(); i < travellersSize; i++) {
                    Traveller traveller = travellers.get(i);
                    TravellerDTO travellerDTO = new TravellerDTO();
                    travellerDTO.setFirstName(traveller.getFirstName());
                    travellerDTO.setLastName(traveller.getLastName());
                    travellerDTO.setTitle(traveller.getTitle());
                    travellerDTO.setAge(traveller.getAge());
                    travellerDTO.setCountryName(traveller.getNationality());

                    if (traveller.getAge() > 12) {
                        adultList.add(travellerDTO);
                    } else {
                        childrenList.add(travellerDTO);
                    }
                }
                RoomDTO roomDTO = RoomDTO.builder()
                        .adultList(adultList)
                        .childrenList(childrenList)
                        .numberOfAdults(adultList.size())
                        .numberOfChildren(childrenList.size())
                        .build();
                roomDTOS.add(roomDTO);
            });

            HotelReservationResponse response = HotelReservationResponse.builder()
                    .bookingDate(reservation.getDateCreated())
                    .bookingNumber(bookingNumber)
                    .checkInDate(hotelBookingDetail.getCheckinDate())
                    .checkOutDate(hotelBookingDetail.getCheckoutDate())
                    .cityName(hotelBookingDetail.getCityName())
                    .countryName(hotelBookingDetail.getCountryName())
                    .dateProcessed(reservation.getDateProcessed())
                    .hotelDescription(hotelBookingDetail.getHotelDescription())
                    .hotelId(hotelBookingDetail.getHotelId())
                    .hotelName(hotelBookingDetail.getHotelName())
                    .hotelServiceRequested(false)
                    .numberOfAdult(hotelBookingDetail.getNumberOfAdult())
                    .numberOfChildren(hotelBookingDetail.getNumberOfChildren())
                    .numberOfRooms(hotelBookingDetail.getNumberOfRoom())
                    .nights(hotelBookingDetail.getNumberOfNightsStay())
                    .paymentChannel(paymentHistory.isPresent() ? paymentHistory.get().getPaymentChannel().getValue() : "")
                    .paymentDate(paymentHistory.isPresent() ? paymentHistory.get().getPaymentDate() : null)
                    .paymentReference(paymentHistory.isPresent() ? paymentHistory.get().getPaymentReference() : "")
                    .paymentStatus(paymentHistory.isPresent() ? paymentHistory.get().getPaymentStatus().getValue() : "")
                    .reservationOwner(reservationOwnerToTravellerDTO(reservation))
                    .reservationStatus(reservation.getReservationStatus().getValue())
                    .rooms(roomDTOS)
                    .roomType(hotelBookingDetail.getRoomType())
                    .sellingPrice(reservation.getSellingPrice())
                    .transactionId(paymentHistory.isPresent() ? paymentHistory.get().getTransactionId() : "")
                    .visaServiceRequested(false)
                    .build();

            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException(e.getMessage());
        }
    }

    private TravellerDTO reservationOwnerToTravellerDTO(Reservation reservation) {
        Optional<ReservationOwner> optionalReservationOwner = reservationOwnerRepository.findById(reservation.getReservationOwner().getId());

        TravellerDTO reservationOwner = new TravellerDTO();
        reservationOwner.setEmail(optionalReservationOwner.get().getEmail());
        reservationOwner.setFirstName(optionalReservationOwner.get().getFirstName());
        reservationOwner.setLastName(optionalReservationOwner.get().getLastName());
        reservationOwner.setPhoneNumber(optionalReservationOwner.get().getPhoneNumber());
        reservationOwner.setTitle(optionalReservationOwner.get().getTitle());

        return reservationOwner;
    }

    @Override
    public List<VisaResponse> getRecentVisaRequest(BookingSearchDTO bookingSearchDTO) {
        List<VisaResponse> visaResponseList = new ArrayList<>();
        Page<VisaRequest> page = visaRequestRepository
                .findAll(PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "dateCreated")));
        page.get().forEach(visa -> {
            visaResponseObjectBuilder2(visaResponseList, visa);
        });

        return visaResponseList;
    }

    @Override
    public List<VisaResponse> getVisaRequestsBySearchTerm(BookingSearchDTO bookingSearchDTO) {
        List<VisaResponse> visaResponseList = new ArrayList<>();

        if (StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
            Page<VisaRequest> page = visaRequestRepository.findAll(PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "dateCreated")));
            for (VisaRequest visa : page.getContent()) {
                visaResponseObjectBuilder2(visaResponseList, visa);
            }
        } else {
            Timestamp startDateTimeStamp = null;
            Timestamp endDateTimeStamp = null;
            try {
                startDateTimeStamp = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(bookingSearchDTO.getStartDate()).getTime());
                endDateTimeStamp = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(bookingSearchDTO.getEndDate()).getTime());
            } catch (ParseException e) {

            }

            if (!StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && !StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                List<VisaRequest> visaRequests =
                        visaRequestRepository.getAllByStatusEqualsAndDateCreatedBetween(Boolean.valueOf(bookingSearchDTO.getBookingStatus()),
                                startDateTimeStamp, endDateTimeStamp);
                visaResponseObjectBuilder(visaResponseList, visaRequests);
            }

            if (StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && !StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                List<VisaRequest> visaRequests =
                        visaRequestRepository.getAllByProcessed(Boolean.valueOf(bookingSearchDTO.getBookingStatus()));
                visaResponseObjectBuilder(visaResponseList, visaRequests);
            }

            if (StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                visaResponseList = getRecentVisaRequest(bookingSearchDTO);
            }

            if (!StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                List<VisaRequest> visaRequests =
                        visaRequestRepository.getAllByDateCreatedBetween(startDateTimeStamp,
                                endDateTimeStamp);
                visaResponseObjectBuilder(visaResponseList, visaRequests);
            }
        }

        return visaResponseList;
    }

    private void visaResponseObjectBuilder2(List<VisaResponse> visaResponseList, VisaRequest visa) {
        VisaResponse visaResponse = VisaResponse.builder()
                .additionalInfo(visa.getAdditionalInfo())
                .applicationCapacity(visa.getApplicationCapacity())
                .arrestedBefore(visa.getArrestedBefore())
                .deportedBefore(visa.getDeportedBefore())
                .destinationCountry((visa.getDestinationCountry() != null) ? visa.getDestinationCountry().getCountryName() : "")
                .duplicateAccountFunction(visa.getDuplicateAccountFunction())
                .email(visa.getEmail())
                .employerName(visa.getEmployerName())
                .employmentResumptionDate(visa.getEmploymentResumptionDate())
                .employmentStatus(visa.getEmploymentStatus())
                .firstName(visa.getFirstName())
                .hasCashFlow(visa.getHasCashFlow())
                .id(visa.getId())
                .infoAttestation(visa.getInfoAttestation())
                .involvedInTerrorism(visa.getInvolvedInTerrorism())
                .isAccountBalanceLow(visa.getIsAccountBalanceLow())
                .isBusinessRegistered(visa.getIsBusinessRegistered())
                .lastName(visa.getLastName())
                .middleName(visa.getMiddleName())
                .monthlyTurnover(visa.getMonthlyTurnover())
                .nameOfBusiness(visa.getNameOfBusiness())
                .nationality((visa.getNationality() != null) ? visa.getNationality().getName() : "")
                .natureOfBusiness(visa.getNatureOfBusiness())
                .needInvitationLetter(visa.getNeedInvitationLetter())
                .noOfStaff(visa.getNoOfStaff())
                .otherPurposes(visa.getOtherPurposes())
                .overStayedTopCountryBefore(visa.getOverStayedTopCountryBefore())
                .passportExpiryDate(visa.getPassportExpiryDate())
                .passportIssueDate(visa.getPassportIssueDate())
                .passportNumber(visa.getPassportNumber())
                .phoneNumber(visa.getPhoneNumber())
                .placeToStay(visa.getPlaceToStay())
                .planToReturn(visa.getPlanToReturn())
                .positionInCompany(visa.getPositionInCompany())
                .processed(visa.isProcessed())
                .provideFundSource(visa.getProvideFundSource())
                .reasonRejectionChanged(visa.getReasonRejectionChanged())
                .rejectedPreviously(visa.getRejectedPreviously())
                .rejectionReason(visa.getRejectionReason())
                .requestById(visa.getRequestById())
                .requireInsurance(visa.getRequireInsurance())
                .residentCountry((visa.getResidentCountry() != null) ? visa.getResidentCountry().getName() : "")
                .returnDate(visa.getReturnDate())
                .salaryRange(visa.getSalaryRange())
                .specialCircumstance(visa.getSpecialCircumstance())
                .timesAppliedPreviously(visa.getTimesAppliedPreviously())
                .topCountryOverstayed(visa.getTopCountryOverstayed())
                .topCountryVisited(visa.getTopCountryVisited())
                .travelDate(visa.getTravelDate())
                .travelPurpose(visa.getTravelPurpose())
                .visaAttestation(visa.getVisaAttestation())
                .visitedPreviously(visa.getVisitedPreviously())
                .visitedTopCountryBefore(visa.getVisitedTopCountryBefore())
                .willInviteeHostYou(visa.getWillInviteeHostYou())
                .build();
        visaResponseList.add(visaResponse);
    }

    private void visaResponseObjectBuilder(List<VisaResponse> visaResponseList, List<VisaRequest> visaRequests) {
        for (int i = 0, visaRequestsSize = visaRequests.size(); i < visaRequestsSize; i++) {
            VisaRequest visa = visaRequests.get(i);
            visaResponseObjectBuilder2(visaResponseList, visa);
        }
    }

    private List<RecentBookingResponse> getRecentFlightBookingResponses(String bookingNo, List<RecentBookingResponse> bookingList) {
        Optional<Reservation> optionalReservation =
                reservationRepository.findFirstByBookingNumberEqualsAndReservationTypeEquals(bookingNo, ReservationType.FLIGHT);
        return getRecentBookingResponses(bookingList, optionalReservation);
    }

    private List<RecentBookingResponse> getRecentHotelBookingResponses(String bookingNo, List<RecentBookingResponse> bookingList) {
        Optional<Reservation> optionalReservation =
                reservationRepository.findFirstByBookingNumberEqualsAndReservationTypeEquals(bookingNo, ReservationType.HOTEL);
        return getRecentBookingResponses(bookingList, optionalReservation);
    }

    private List<RecentBookingResponse> getRecentBookingResponses(List<RecentBookingResponse> bookingList, Optional<Reservation> optionalReservation) {
        optionalReservation.ifPresent(reservation -> {
            RecentBookingResponse recentBookingResponse = new RecentBookingResponse();
            recentBookingResponse.setAmount(optionalReservation.get().getSellingPrice().doubleValue());
            recentBookingResponse.setBookingDate(optionalReservation.get().getDateCreated());
            recentBookingResponse.setBookingStatus(optionalReservation.get().getReservationStatus().getValue());
            recentBookingResponse.setBookingNumber(optionalReservation.get().getBookingNumber());
            recentBookingResponse.setOwnerEmail(optionalReservation.get().getReservationOwner().getEmail());
            bookingList.add(recentBookingResponse);
        });
        return bookingList;
    }

    private List<RecentBookingResponse> flightReservationToRecentBookingResponse(List<Reservation> reservationList) {
        List<RecentBookingResponse> bookingList = new ArrayList<>();
        for (int i = 0, reservationListSize = reservationList.size(); i < reservationListSize; i++) {
            Reservation reservation = reservationList.get(i);
            if (reservation.getReservationType().equals(ReservationType.FLIGHT)) {
                RecentBookingResponse recentBookingResponse = new RecentBookingResponse();
                recentBookingResponse.setAmount(reservation.getSellingPrice().doubleValue());
                recentBookingResponse.setBookingDate(reservation.getDateCreated());
                recentBookingResponse.setBookingStatus(reservation.getReservationStatus().getValue());
                recentBookingResponse.setBookingNumber(reservation.getBookingNumber());
                recentBookingResponse.setOwnerEmail(reservation.getReservationOwner().getEmail());
                bookingList.add(recentBookingResponse);
            }
        }
        return bookingList;
    }

    private List<RecentBookingResponse> hotelReservationToRecentBookingResponse(List<Reservation> reservationList) {
        List<RecentBookingResponse> bookingList = new ArrayList<>();
        for (int i = 0, reservationListSize = reservationList.size(); i < reservationListSize; i++) {
            Reservation reservation = reservationList.get(i);
            if (reservation.getReservationType().equals(ReservationType.HOTEL)) {
                RecentBookingResponse recentBookingResponse = new RecentBookingResponse();
                recentBookingResponse.setAmount(reservation.getSellingPrice().doubleValue());
                recentBookingResponse.setBookingDate(reservation.getDateCreated());
                recentBookingResponse.setBookingStatus(reservation.getReservationStatus().getValue());
                recentBookingResponse.setBookingNumber(reservation.getBookingNumber());
                recentBookingResponse.setOwnerEmail(reservation.getReservationOwner().getEmail());
                bookingList.add(recentBookingResponse);
            }
        }
        return bookingList;
    }

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    private PortalUser doesUserExist(UserDTO userDTO) {
        Optional<PortalUser> optionalPortalUser = portalUserRepository.findById(userDTO.getId());

        if (!optionalPortalUser.isPresent()) {
            throw new NotFoundException("User does not exist");
        }

        return optionalPortalUser.get();
    }

    private UserResponse buildUserResponse(PortalUser user, UserDTO userDTO) {
        UserResponse userResponse = new UserResponse();
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setId(user.getId());
        userResponse.setPhoneNumber(user.getPhoneNumber());
        userResponse.setRoles(userDTO != null ? userDTO.getRoles() : null);

        return userResponse;
    }

}
