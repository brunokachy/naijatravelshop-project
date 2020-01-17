import { Component } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { AlertComponent } from 'ngx-bootstrap';
import { Router } from '@angular/router';
import { User } from '../../model/user';
import { LocalAPIService } from '../../provider/local.api.service';

@Component({
    moduleId: module.id,
    selector: 'register',
    templateUrl: 'register.component.html',
    styleUrls: ['register.component.scss']
})
export class RegisterComponent {

    constructor(private router: Router, private localAPIService: LocalAPIService, private spinnerService: NgxSpinnerService) {

    }

    user = new User();
    cPassword = '';
    alerts: any[] = [];
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

    showPasswordFunction() {
        if (this.showPassword) {
            this.showPassword = false;
        } else {
            this.showPassword = true;
        }
    }

    signup() {
        this.spinnerService.show();
        const roles: string[] = [];
        roles.push('GUEST');
        this.user.roles = roles;
        this.localAPIService.postRequest(this.user, this.localAPIService.CREATE_ACCOUNT).subscribe(
            data => {
                this.add('success', 'User accounted created successfully.');
                this.localAPIService.postRequest(this.user, this.localAPIService.LOGIN).subscribe(
                    data => {
                        this.spinnerService.hide();
                        localStorage.setItem('user', JSON.stringify(data.data));
                        this.router.navigate(['/reservation']);
                        const user: User = JSON.parse(sessionStorage.getItem('user'));
                        if (user.roles.includes('SUPER ADMIN')) {
                            localStorage.setItem('isSuperAdmin', 'true');
                        } else {
                            localStorage.setItem('isSuperAdmin', 'false');
                        }
                        // window.location.reload();
                    },
                    error => {
                        console.log(error);
                        this.add('danger', error.error.message);
                        this.spinnerService.hide();
                    });
            },
            error => {
                console.log(error);
                this.add('danger', error.error.message);
                this.spinnerService.hide();
            });
    }


}
