package com.naijatravelshop.service.portal.service;

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
import com.naijatravelshop.service.visa.pojo.response.VisaCountryDTO;

import java.util.List;

public interface PortalService {

    UserResponse createUserAccount(UserDTO userDTO);

    UserResponse updateUserAccount(UserDTO userDTO);

    UserResponse deactivateUserAccount(UserDTO userDTO);

    UserResponse reactivateUserAccount(UserDTO userDTO);

    UserResponse resetPassword(UserDTO userDTO);

    UserResponse changePassword(PasswordDTO passwordDTO);

    UserResponse login(UserDTO userDTO);

    AffiliateAccountDetail getAffiliateAccountDetail();

    String getApiBaseUrl();

    List<RecentBookingResponse> getRecentBooking();

    List<RecentBookingResponse> getFlightBookingBySearchTerm(BookingSearchDTO bookingSearchDTO);

    List<RecentBookingResponse> getHotelBookingBySearchTerm(BookingSearchDTO bookingSearchDTO);

    RecentBookingResponse changeBookingStatus(BookingSearchDTO bookingSearchDTO);

    FlightReservationResponse getFlightBookingDetails(String bookingNumber);

    HotelReservationResponse getHotelBookingDetails(String bookingNumber);

    List<VisaResponse> getRecentVisaRequest(BookingSearchDTO bookingSearchDTO);

    List<VisaResponse> getVisaRequestsBySearchTerm(BookingSearchDTO bookingSearchDTO);

    VisaResponse changeVisaRequestStatus(BookingSearchDTO bookingSearchDTO);

    List<UserResponse> getPortalUsers();

    PortalSettingResponse getPortalSettings();

    String updateExchangeRateSetting(String currency);

    FlutterwaveDetail updateFlutterwaveSetting(FlutterwaveDetail flutterwaveDetail);

    AffiliateAccountDetail updateTravelbetaAffiliateSetting(AffiliateAccountDetail affiliateAccountDetail);

    DOTWDetail updateDOTWSetting(DOTWDetail dotwDetail);

    List<String> getAllRoles();

    void updateUserRoles(UserDTO userDTO);

    void subscribeEmail(UserDTO userDTO);

    void unSubscribeEmail(UserDTO userDTO);

    List<UserResponse> getAllSubscribedEmails();

    List<VisaCountryDTO> getNAEUCountries();

}
