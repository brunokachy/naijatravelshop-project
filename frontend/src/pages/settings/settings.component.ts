import { Component } from '@angular/core';
import { User } from '../../model/User';
import { LocalAPIService } from '../../provider/local.api.service';
import { AlertComponent } from 'ngx-bootstrap';
import { FlwAccountDetails } from '../../model/FlwAccountDetail';
import { AfilliateDetails } from '../../model/AffiliateDetails';
import { DOTWDetails } from '../../model/DOTWDetails';
import { InitModel } from '../../model/InitModel';
import { Country } from '../../model/Country';

@Component({
    moduleId: module.id,
    selector: 'settings',
    templateUrl: 'settings.component.html',
    styleUrls: []
})
export class SettingsComponent {
    constructor(private localAPIService: LocalAPIService) {
        this.user = JSON.parse(localStorage.getItem('user'));
        this.isSuperAdmin = JSON.parse(localStorage.getItem('isSuperAdmin'));
        this.getPortalSettings();
        this.initModel = JSON.parse(localStorage.getItem('initModel'));
        this.loadVisaCountries();
    }

    user: User;
    isSuperAdmin = false;
    flwAccountDetails: FlwAccountDetails = new FlwAccountDetails();
    afilliateDetails: AfilliateDetails = new AfilliateDetails();
    dotwDetails: DOTWDetails = new DOTWDetails();
    exchangeRate: number;
    initModel: InitModel = new InitModel();
    visaCountries: Country[] = [];
    visaCountry: Country = new Country();

    alerts: any[] = [];

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

    loadVisaCountries() {
        this.localAPIService.getRequest(this.localAPIService.GET_VISA_COUNTRY).subscribe(
            data => {
                this.visaCountries = data.data;
            },
            error => {
                console.log(error);
            });
    }

    createVisaCountry() {
        this.localAPIService.postRequest(this.visaCountry.name, this.localAPIService.CREATE_VISA_COUNTRY).subscribe(
            data => {
                this.loadVisaCountries();
                this.visaCountry = new Country();
                this.add('success', data.message);
            },
            error => {
                console.log(error);
                this.add('danger', error.error.message);
            });
    }

    activateVisaCountry(country: Country) {
        country.status = 'ACTIVE';
        this.updateVisaCountry(country);
    }

    deactivateVisaCountry(country: Country) {
        country.status = 'DEACTIVATED';
        this.updateVisaCountry(country);
    }

    updateVisaCountry(country: Country) {
        this.localAPIService.postRequest(country, this.localAPIService.UPDATE_VISA_COUNTRY).subscribe(
            data => {
                this.loadVisaCountries();
                this.add('success', data.message);
            },
            error => {
                console.log(error);
                this.add('danger', error.error.message);
            });
    }


    getPortalSettings() {
        this.localAPIService.postRequest({}, this.localAPIService.GET_PORTAL_SETTINGS).subscribe(
            data => {
                this.user = data.data;
                this.flwAccountDetails = data.data.flutterwaveDetail;
                this.exchangeRate = data.data.exchangeRate;
                this.dotwDetails = data.data.dotwDetail;
                this.afilliateDetails = data.data.affiliateAccountDetail;

            },
            error => {
                console.log(error);
            });
    }

    updateFlutterwaveCredential() {
        this.localAPIService.postRequest(this.flwAccountDetails, this.localAPIService.UPDATE_FLUTTERWAVE_SETTING).subscribe(
            data => {
                this.initModel.flwAccountDetails = this.flwAccountDetails;
                localStorage.setItem('initModel', JSON.stringify(this.initModel));
                this.add('success', data.message);
            },
            error => {
                console.log(error);
                this.add('danger', error.error.message);
            });
    }

    updateTravelbetaCredential() {
        this.localAPIService.postRequest(this.afilliateDetails, this.localAPIService.UPDATE_TRAVELBETA_AFFILIATE_SETTING).subscribe(
            data => {
                this.initModel.affilateDetail = this.afilliateDetails;
                this.initModel.apiURL = this.afilliateDetails.baseUrl;
                localStorage.setItem('initModel', JSON.stringify(this.initModel));
                this.add('success', data.message);
            },
            error => {
                console.log(error);
                this.add('danger', error.error.message);
            });
    }

    updateDOTWCredential() {
        this.localAPIService.postRequest(this.dotwDetails, this.localAPIService.UPDATE_DOTW_SETTING).subscribe(
            data => {
                this.add('success', data.message);
            },
            error => {
                console.log(error);
                this.add('danger', error.error.message);
            });
    }

    updateExchangeRate() {
        this.localAPIService.postRequest(this.exchangeRate, this.localAPIService.UPDATE_EXCHANGE_RATE_SETTING).subscribe(
            data => {
                this.add('success', data.message);
            },
            error => {
                console.log(error);
                this.add('danger', error.error.message);
            });
    }
}
