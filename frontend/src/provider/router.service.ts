import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { User } from '../model/User';

@Injectable()
export class AuthGuard implements CanActivate {
    constructor(private router: Router) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

        const url: string = state.url;
        if (url === '/flight_search_result') {
            return this.canViewFlightSearchResultPage(url);
        }

        if (url === '/hotel_search_result') {
            return this.canViewHotelSearchResultPage(url);
        }

        if (url === '/flight_detail') {
            return this.canViewFlightDetailPage(url);
        }

        if (url === '/flight_payment') {
            return this.canViewFlightPaymentPage(url);
        }

        if (url === '/hotel_payment') {
            return this.canViewHotelPaymentPage(url);
        }

        if (url === '/hotel_search_result') {
            return this.canViewHotelSearchResultPage(url);
        }

        if (url === '/app-hotel-rooms') {
            return this.canViewHotelRoomPage(url);
        }

        if (url === '/hotel_details') {
            return this.canViewHotelDetailsPage(url);
        }

        if (url === '/payment_response') {
            return this.canViewPaymentResponsePage(url);
        }

        if (url === '/dashboard') {
            return this.IsUserLoggedIn();
        }

        if (url === '/profile') {
            return this.IsUserLoggedIn();
        }

        if (url === '/reservation') {
            return this.IsUserLoggedIn();
        }

        if (url === '/crm') {
            return this.isUserPortalUser();
        }

        if (url === '/user_management') {
            return this.IsUserSuperAdmin();
        }

        if (url === '/settings') {
            return this.IsUserSuperAdmin();
        }
    }

    canViewFlightSearchResultPage(url: string): boolean {
        const canView = sessionStorage.getItem('viewFlightSearchResult');
        if (canView === 'true') { return true; }
        this.router.navigate(['/home']);
        return false;
    }

    canViewFlightDetailPage(url: string): boolean {
        const canView = sessionStorage.getItem('viewFlightDetail');
        if (canView === 'true') { return true; }
        // Navigate to the home page with extras
        this.router.navigate(['/home']);
        return false;
    }

    canViewFlightPaymentPage(url: string): boolean {
        const canView = sessionStorage.getItem('viewFlightPayment');
        if (canView === 'true') { return true; }
        this.router.navigate(['/home']);
        return false;
    }

    canViewHotelPaymentPage(url: string): boolean {
        const canView = sessionStorage.getItem('viewHotelPayment');
        if (canView === 'true') { return true; }
        this.router.navigate(['/home']);
        return false;
    }

    canViewHotelSearchResultPage(url: string): boolean {
        const canView = sessionStorage.getItem('viewHotelSearchResult');
        if (canView === 'true') { return true; }
        this.router.navigate(['/home']);
        return false;
    }

    canViewHotelRoomPage(url: string): boolean {
        const canView = sessionStorage.getItem('viewHotelRooms');
        if (canView === 'true') { return true; }
        this.router.navigate(['/home']);
        return false;
    }

    canViewHotelDetailsPage(url: string): boolean {
        const canView = sessionStorage.getItem('viewHotelDetails');
        if (canView === 'true') { return true; }
        this.router.navigate(['/home']);
        return false;
    }

    canViewPaymentResponsePage(url: string): boolean {
        const canView = sessionStorage.getItem('viewPaymentResponse');
        if (canView === 'true') { return true; }
        this.router.navigate(['/home']);
        return false;
    }

    IsUserLoggedIn(): boolean {
        const user = localStorage.getItem('user');
        if (user != null) { return true; }
        this.router.navigate(['/home']);
        return false;
    }

    isUserPortalUser(): boolean {
        if (this.IsUserLoggedIn) {
            const user: User = JSON.parse(localStorage.getItem('user'));
            if (user != null) {
                if (user.roles.includes('PORTAL USER') || user.roles.includes('SUPER ADMIN')) {
                    return true;
                }
            }
            this.router.navigate(['/dashboard']);
            return false;
        }
    }

    IsUserSuperAdmin(): boolean {
        if (this.IsUserLoggedIn) {
            const user: User = JSON.parse(localStorage.getItem('user'));
            if (user != null) {
                if (user.roles.includes('SUPER ADMIN')) {
                    return true;
                }
            }
            this.router.navigate(['/dashboard']);
            return false;
        }
    }
}
