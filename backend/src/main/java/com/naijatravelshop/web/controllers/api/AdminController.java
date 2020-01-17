package com.naijatravelshop.web.controllers.api;

import com.naijatravelshop.service.portal.pojo.request.BookingSearchDTO;
import com.naijatravelshop.service.portal.pojo.request.PasswordDTO;
import com.naijatravelshop.service.portal.pojo.request.UserDTO;
import com.naijatravelshop.service.portal.pojo.response.*;
import com.naijatravelshop.service.portal.service.PortalService;
import com.naijatravelshop.web.pojo.ApiResponse;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Bruno on
 * 08/05/2019
 */
@RestController
@RequestMapping(value = "naijatravelshop/api/admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    private PortalService portalService;

    public AdminController(PortalService portalService) {
        this.portalService = portalService;
    }

    @ApiOperation(value = "Create Portal User Account")
    @PostMapping(value = {"/create_account"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<UserResponse>> createAccount(@RequestBody UserDTO user) {
        log.info("CREATE ACCOUNT: {}", user.toString());
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        UserResponse userResponse = portalService.createUserAccount(user);
        apiResponse.setMessage("User Account Created successfully");
        apiResponse.setData(userResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Update Portal User Account")
    @PostMapping(value = {"/update_account"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<UserResponse>> updateAccount(@RequestBody UserDTO user) {
        log.info("UPDATE ACCOUNT: {}", user.toString());
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        UserResponse userResponse = portalService.updateUserAccount(user);
        apiResponse.setMessage("User Account Updated successfully");
        apiResponse.setData(userResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Deactivate Portal User Account")
    @PostMapping(value = {"/deactivate_account"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<UserResponse>> deactivateUserAccount(@RequestBody UserDTO user) {
        log.info("DEACTIVATE USER ACCOUNT: {}", user.toString());
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        UserResponse userResponse = portalService.deactivateUserAccount(user);
        apiResponse.setMessage("User Account Deactivated successfully");
        apiResponse.setData(userResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Re-activate Portal User Account")
    @PostMapping(value = {"/reactivate_account"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<UserResponse>> reactivateUserAccount(@RequestBody UserDTO user) {
        log.info("REACTIVATE USER ACCOUNT: {}", user.toString());
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        UserResponse userResponse = portalService.reactivateUserAccount(user);
        apiResponse.setMessage("User Account Re-activated successfully");
        apiResponse.setData(userResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Reset Portal User Password")
    @PostMapping(value = {"/reset_user_password"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<UserResponse>> resetPassword(@RequestBody UserDTO user) {
        log.info("RESET USER PASSWORD: {}", user.toString());
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        UserResponse userResponse = portalService.resetPassword(user);
        apiResponse.setMessage("User Account Password Reset successful");
        apiResponse.setData(userResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Portal User Login")
    @PostMapping(value = {"/login"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<UserResponse>> login(@RequestBody UserDTO user) {
        log.info("PORTAL USER LOGIN: {}", user.toString());
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        UserResponse userResponse = portalService.login(user);
        apiResponse.setMessage("User Account Authentication successful");
        apiResponse.setData(userResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Change Portal User Password")
    @PostMapping(value = {"/change_password"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<UserResponse>> changePassword(@RequestBody PasswordDTO passwordDTO) {
        log.info("PORTAL USER CHANGE PASSWORD: {}", passwordDTO.toString());
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        UserResponse userResponse = portalService.changePassword(passwordDTO);
        apiResponse.setMessage("User Account Password changed successful");
        apiResponse.setData(userResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Fetch Affiliate Account")
    @GetMapping(value = {"/get_affiliate_account_details"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<AffiliateAccountDetail>> getAffiliateAccountDetails() {
        ApiResponse<AffiliateAccountDetail> apiResponse = new ApiResponse<>();
        AffiliateAccountDetail affiliateAccountDetail = portalService.getAffiliateAccountDetail();
        apiResponse.setMessage("Affiliate Account Details retrieved successfully");
        apiResponse.setData(affiliateAccountDetail);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Fetch Base URL")
    @GetMapping(value = {"/get_base_url"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<String>> getBaseUrl() {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        String baseUrl = portalService.getApiBaseUrl();
        apiResponse.setMessage("Base URL retrieved successfully");
        apiResponse.setData(baseUrl);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Fetch recent bookings")
    @GetMapping(value = {"/get_recent_booking"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<RecentBookingResponse>>> getRecentBooking() {
        ApiResponse<List<RecentBookingResponse>> apiResponse = new ApiResponse<>();
        List<RecentBookingResponse> recentBookings = portalService.getRecentBooking();
        apiResponse.setMessage("Recent booking retrieved successfully");
        apiResponse.setData(recentBookings);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Fetch flight bookings by search term")
    @PostMapping(value = {"/get_flight_bookings_by_search_term"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<RecentBookingResponse>>> getFlightBookingBySearchTerm(@RequestBody BookingSearchDTO bookingSearchDTO) {
        ApiResponse<List<RecentBookingResponse>> apiResponse = new ApiResponse<>();
        List<RecentBookingResponse> recentBookings = portalService.getFlightBookingBySearchTerm(bookingSearchDTO);
        apiResponse.setMessage("Bookings retrieved successfully");
        apiResponse.setData(recentBookings);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Fetch hotel bookings by search term")
    @PostMapping(value = {"/get_hotel_bookings_by_search_term"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<RecentBookingResponse>>> getHotelBookingBySearchTerm(@RequestBody BookingSearchDTO bookingSearchDTO) {
        ApiResponse<List<RecentBookingResponse>> apiResponse = new ApiResponse<>();
        List<RecentBookingResponse> recentBookings = portalService.getHotelBookingBySearchTerm(bookingSearchDTO);
        apiResponse.setMessage("Bookings retrieved successfully");
        apiResponse.setData(recentBookings);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Change Booking Status")
    @PostMapping(value = {"/change_booking_status"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<RecentBookingResponse>> changeBookingStatus(@RequestBody BookingSearchDTO bookingSearchDTO) {
        ApiResponse<RecentBookingResponse> apiResponse = new ApiResponse<>();
        RecentBookingResponse changeBookingStatus = portalService.changeBookingStatus(bookingSearchDTO);
        apiResponse.setMessage("Reservation status of booking (" + bookingSearchDTO.getBookingNo() + ") changed successfully");
        apiResponse.setData(changeBookingStatus);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Get Flight Reservation Details")
    @PostMapping(value = {"/get_flight_reservation_details"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<FlightReservationResponse>> getFlightReservationDetails(@RequestBody BookingSearchDTO bookingSearchDTO) {
        ApiResponse<FlightReservationResponse> apiResponse = new ApiResponse<>();
        FlightReservationResponse flightReservationResponse = portalService.getFlightBookingDetails(bookingSearchDTO.getBookingNo());
        apiResponse.setMessage("Reservation details retrieved successfully");
        apiResponse.setData(flightReservationResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Fetch visa requests by search term")
    @PostMapping(value = {"/get_visa_requests_by_search_term"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<VisaResponse>>> getVisaRequestBySearchTerm(@RequestBody BookingSearchDTO bookingSearchDTO) {
        ApiResponse<List<VisaResponse>> apiResponse = new ApiResponse<>();
        List<VisaResponse> visaRequests = portalService.getVisaRequestsBySearchTerm(bookingSearchDTO);
        apiResponse.setMessage("Visa Requests retrieved successfully");
        apiResponse.setData(visaRequests);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Change Visa Request Status")
    @PostMapping(value = {"/change_visa_request_status"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<VisaResponse>> changeVisaRequestStatus(@RequestBody BookingSearchDTO bookingSearchDTO) {
        ApiResponse<VisaResponse> apiResponse = new ApiResponse<>();
        VisaResponse changeVisaRequestStatus = portalService.changeVisaRequestStatus(bookingSearchDTO);
        apiResponse.setMessage("Visa request status changed successfully");
        apiResponse.setData(changeVisaRequestStatus);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Fetch Portal Users")
    @GetMapping(value = {"/get_portal_users"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<UserResponse>>> getPortalUsers() {
        ApiResponse<List<UserResponse>> apiResponse = new ApiResponse<>();
        List<UserResponse> userResponses = portalService.getPortalUsers();
        apiResponse.setMessage("Portal users retrieved successfully");
        apiResponse.setData(userResponses);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Get Hotel Reservation Details")
    @PostMapping(value = {"/get_hotel_reservation_details"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<HotelReservationResponse>> getHotelReservationDetails(@RequestBody BookingSearchDTO bookingSearchDTO) {
        ApiResponse<HotelReservationResponse> apiResponse = new ApiResponse<>();
        HotelReservationResponse hotelReservationResponse = portalService.getHotelBookingDetails(bookingSearchDTO.getBookingNo());
        apiResponse.setMessage("Reservation details retrieved successfully");
        apiResponse.setData(hotelReservationResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Get Portal Settings")
    @PostMapping(value = {"/get_portal_settings"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<PortalSettingResponse>> getPortalSettings() {
        ApiResponse<PortalSettingResponse> apiResponse = new ApiResponse<>();
        PortalSettingResponse portalSettingResponse = portalService.getPortalSettings();
        apiResponse.setMessage("Settings details retrieved successfully");
        apiResponse.setData(portalSettingResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Update Exchange Rate Setting")
    @PostMapping(value = {"/update_exchange_rate_setting"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<String>> updateExchangeRateSetting(@RequestBody String currency) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        String updateExchangeRateSettingResponse = portalService.updateExchangeRateSetting(currency);
        apiResponse.setMessage("Exchange Rate Sget_portal_usersetting updated successfully");
        apiResponse.setData(updateExchangeRateSettingResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Update Travelbeta Affiliate Setting")
    @PostMapping(value = {"/update_travelbeta_affiliate_setting"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<AffiliateAccountDetail>> updateTravelbetaAffiliateSetting(@RequestBody AffiliateAccountDetail affiliateAccountDetail) {
        ApiResponse<AffiliateAccountDetail> apiResponse = new ApiResponse<>();
        AffiliateAccountDetail updateTravelbetaAffiliateSetting = portalService.updateTravelbetaAffiliateSetting(affiliateAccountDetail);
        apiResponse.setMessage("Travelbeta Affiliate Setting updated successfully");
        apiResponse.setData(updateTravelbetaAffiliateSetting);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Update Flutterwave Setting")
    @PostMapping(value = {"/update_flutterwave_setting"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<FlutterwaveDetail>> updateFlutterwaveSetting(@RequestBody FlutterwaveDetail flutterwaveDetail) {
        ApiResponse<FlutterwaveDetail> apiResponse = new ApiResponse<>();
        FlutterwaveDetail updateFlutterwaveSetting = portalService.updateFlutterwaveSetting(flutterwaveDetail);
        apiResponse.setMessage("Flutterwave Setting updated successfully");
        apiResponse.setData(updateFlutterwaveSetting);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Update DOTW Setting")
    @PostMapping(value = {"/update_dotw_setting"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<DOTWDetail>> updateDOTWSetting(@RequestBody DOTWDetail dotwDetail) {
        ApiResponse<DOTWDetail> apiResponse = new ApiResponse<>();
        DOTWDetail updateDOTWSetting = portalService.updateDOTWSetting(dotwDetail);
        apiResponse.setMessage("DOTW Setting updated successfully");
        apiResponse.setData(updateDOTWSetting);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Get all roles")
    @PostMapping(value = {"/get_all_roles"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<String>>> getAllRoles() {
        ApiResponse<List<String>> apiResponse = new ApiResponse<>();
        List<String> roles = portalService.getAllRoles();
        apiResponse.setMessage("All roles successfully retrieved");
        apiResponse.setData(roles);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Update portal user roles")
    @PostMapping(value = {"/update_user_roles"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<String>> updateUserRoles(@RequestBody UserDTO user) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        portalService.updateUserRoles(user);
        apiResponse.setMessage("Roles for user " + user.getEmail() + " updated successfully");
        apiResponse.setData("");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Unsubscribe email")
    @PostMapping(value = {"/unsubscribe_email"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<String>> unSubscribeEmail(@RequestBody UserDTO user) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        portalService.unSubscribeEmail(user);
        apiResponse.setMessage("Email unsubscription successful");
        apiResponse.setData("");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Subscribe email")
    @PostMapping(value = {"/subscribe_email"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<String>> subscribeEmail(@RequestBody UserDTO user) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        portalService.subscribeEmail(user);
        apiResponse.setMessage("Email subscription successful");
        apiResponse.setData("");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Get Subscribed email")
    @PostMapping(value = {"/get_subscribed_email"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<UserResponse>>> subscribeEmail() {
        ApiResponse<List<UserResponse>> apiResponse = new ApiResponse<>();
        List<UserResponse> allSubscribedEmails = portalService.getAllSubscribedEmails();
        apiResponse.setMessage("All Email subscription fetched successfully");
        apiResponse.setData(allSubscribedEmails);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
