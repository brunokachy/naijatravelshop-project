import { Component } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { AlertComponent } from 'ngx-bootstrap';
import { Router } from '@angular/router';
import { User } from '../../model/User';
import { LocalAPIService } from '../../provider/local.api.service';

@Component({
    moduleId: module.id,
    selector: 'login_register',
    templateUrl: 'login-register.component.html',
    styleUrls: []
})
export class LoginRegisterComponent {
    constructor(private router: Router, private localAPIService: LocalAPIService, private spinnerService: NgxSpinnerService) {

    }
    user = new User();
    newPassword: string;
    alerts: any[] = [];
    forgotPassword = false;
    showPassword = false;

    add(type, message): void {
        this.alerts.push({
            type,
            msg: message,
            timeout: 5000
        });
    }

    onClosed(dismissedAlert: AlertComponent): void {
        this.alerts = this.alerts.filter(alert => alert !== dismissedAlert);
    }

    resetPassword() {
        this.forgotPassword = true;
    }

    showPasswordFunction() {
        if (this.showPassword) {
            this.showPassword = false;
        } else {
            this.showPassword = true;
        }
    }

    signin() {
        this.forgotPassword = false;
    }

    login() {
        this.spinnerService.show();

        if (this.forgotPassword) {
            this.localAPIService.postRequest(this.user, this.localAPIService.RESET_PASSWORD).subscribe(
                data => {
                    this.add('success', 'Check your email for your default password.');
                    this.user = new User();
                    this.spinnerService.hide();
                },
                error => {
                    console.log(error);
                    this.add('danger', error.error.message);
                    this.spinnerService.hide();
                });
        }

        if (!this.forgotPassword) {
            this.localAPIService.postRequest(this.user, this.localAPIService.LOGIN).subscribe(
                data => {
                    this.spinnerService.hide();
                    localStorage.setItem('user', JSON.stringify(data.data));

                    const user: User = JSON.parse(localStorage.getItem('user'));

                    if (user.roles.includes('SUPER ADMIN')) {
                        localStorage.setItem('isSuperAdmin', 'true');
                    } else {
                        localStorage.setItem('isSuperAdmin', 'false');
                    }

                    if (user.roles.includes('PORTAL USER')) {
                        localStorage.setItem('isPortalUser', 'true');
                    } else {
                        localStorage.setItem('isPortalUser', 'false');
                    }

                    if (user.roles.includes('GUEST')) {
                        localStorage.setItem('isGuest', 'true');
                    } else {
                        localStorage.setItem('isGuest', 'false');
                    }
                    this.router.navigate(['/reservation']);

                    // window.location.reload();
                },
                error => {
                    console.log(error);
                    this.add('danger', error.error.message);
                    this.spinnerService.hide();
                });
        }

    }


}
