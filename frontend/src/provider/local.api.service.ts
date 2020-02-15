import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class LocalAPIService {
    constructor(private httpClient: HttpClient) { }

    private naijaTravelShopAPIBaseURL = window.location.origin + '/naijatravelshop/api/';
   // private naijaTravelShopAPIBaseURL = 'http://localhost:8080/naijatravelshop/api/';

    public CONFIRM_REGISTRATION = this.naijaTravelShopAPIBaseURL + 'confirm_registration';
    public CREATE_ACCOUNT = this.naijaTravelShopAPIBaseURL + 'admin/create_account';
    public LOGIN = this.naijaTravelShopAPIBaseURL + 'admin/login';
    public BOOK = this.naijaTravelShopAPIBaseURL + 'flight/create_reservation';
    public PAYMENT_VERIFICATION = this.naijaTravelShopAPIBaseURL + 'payment/flw_payment_verification';
    public GET_RECENT_BOOKINGS = this.naijaTravelShopAPIBaseURL + 'admin/get_recent_booking';
    public UPDATE_PROFILE = this.naijaTravelShopAPIBaseURL + 'admin/update_account';
    public CHANGE_PASSWORD = this.naijaTravelShopAPIBaseURL + 'admin/change_password';
    public RESET_PASSWORD = this.naijaTravelShopAPIBaseURL + 'admin/reset_user_password';
    public GET_AFFILIATE_ACCOUNT = this.naijaTravelShopAPIBaseURL + 'admin/get_affiliate_account_details';
    public GET_PORTAL_USERS = this.naijaTravelShopAPIBaseURL + 'admin/get_portal_users';
    public ACTIVATE_USER = this.naijaTravelShopAPIBaseURL + 'admin/reactivate_account';
    public DEACTIVATE_USER = this.naijaTravelShopAPIBaseURL + 'admin/deactivate_account';
    public VISA_REQUEST = this.naijaTravelShopAPIBaseURL + 'visa/create_visa_request';
    public GET_FLIGHT_BOOKINGS_BY_SEARCH_TERM = this.naijaTravelShopAPIBaseURL + 'admin/get_flight_bookings_by_search_term';
    public GET_HOTEL_BOOKINGS_BY_SEARCH_TERM = this.naijaTravelShopAPIBaseURL + 'admin/get_hotel_bookings_by_search_term';
    public GET_VISA_REQUEST_BY_SEARCH_TERM = this.naijaTravelShopAPIBaseURL + 'admin/get_visa_requests_by_search_term';
    public CHANGE_BOOKING_STATUS = this.naijaTravelShopAPIBaseURL + 'admin/change_booking_status';
    public CHANGE_VISA_REQUEST_STATUS = this.naijaTravelShopAPIBaseURL + 'admin/change_visa_request_status';
    public GET_FLIGHT_RESERVATION_DETAILS = this.naijaTravelShopAPIBaseURL + 'admin/get_flight_reservation_details';
    public GET_HOTEL_RESERVATION_DETAILS = this.naijaTravelShopAPIBaseURL + 'admin/get_hotel_reservation_details';
    public GET_PORTAL_SETTINGS = this.naijaTravelShopAPIBaseURL + 'admin/get_portal_settings';
    public UPDATE_DOTW_SETTING = this.naijaTravelShopAPIBaseURL + 'admin/update_dotw_setting';
    public UPDATE_FLUTTERWAVE_SETTING = this.naijaTravelShopAPIBaseURL + 'admin/update_flutterwave_setting';
    public UPDATE_TRAVELBETA_AFFILIATE_SETTING = this.naijaTravelShopAPIBaseURL + 'admin/update_travelbeta_affiliate_setting';
    public UPDATE_EXCHANGE_RATE_SETTING = this.naijaTravelShopAPIBaseURL + 'admin/update_exchange_rate_setting';
    public GET_ALL_ROLES = this.naijaTravelShopAPIBaseURL + 'admin/get_all_roles';
    public UPDATE_USER_ROLES = this.naijaTravelShopAPIBaseURL + 'admin/update_user_roles';
    public SUBSCRIBE_EMAIL = this.naijaTravelShopAPIBaseURL + 'admin/subscribe_email';
    public UN_SUBSCRIBE_EMAIL = this.naijaTravelShopAPIBaseURL + 'admin/unsubscribe_email';
    public GET_SUBSCRIBED_EMAIL = this.naijaTravelShopAPIBaseURL + 'admin/get_subscribed_email';
    public BANK_PAYMENT = this.naijaTravelShopAPIBaseURL + 'payment/bank_payment';
    public SEARCH_HOTELS = this.naijaTravelShopAPIBaseURL + 'hotel/search_hotels';
    public BOOKING_HOTEL = this.naijaTravelShopAPIBaseURL + 'hotel/create_reservation';
    public GET_ACTIVE_VISA_COUNTRY = this.naijaTravelShopAPIBaseURL + 'visa/get_all_active_visa_country';
    public GET_VISA_COUNTRY = this.naijaTravelShopAPIBaseURL + 'visa/get_all_visa_country';
    public CREATE_VISA_COUNTRY = this.naijaTravelShopAPIBaseURL + 'visa/create_visa_country';
    public UPDATE_VISA_COUNTRY = this.naijaTravelShopAPIBaseURL + 'visa/update_visa_country';
    public GET_NA_EU_COUNTRY = this.naijaTravelShopAPIBaseURL + 'visa/get_na_eu_country';

    postRequest(requestData: any, url: string): Observable<any> {
        return this.httpClient
            .post(url, requestData, this.header());
    }

    getRequest(url: string): Observable<any> {
        return this.httpClient.get(url);
    }

    private header(): any {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
            })
        };
        return httpOptions;
    }
}
