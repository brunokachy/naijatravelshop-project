import { Component } from '@angular/core';
import { User } from '../model/User';
import { InitAPIService } from '../provider/init.api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'naijatravelshop-app';
  user: User;
  isLogin = false;
  interval: any;
  firstname: string;
  phoneNumber: string;

  constructor(private initService: InitAPIService, private router: Router) {
    this.initService.makeInitCall();
    console.log(window.location.origin);

    setInterval(() => {
      this.checkUserLogin();
    }, 1000);
  }

  checkUserLogin() {
    if (JSON.parse(localStorage.getItem('user')) == null) {
      this.user = null;
      this.isLogin = false;
    }
    if (JSON.parse(localStorage.getItem('user')) != null) {
      this.user = JSON.parse(localStorage.getItem('user'));
      this.firstname = this.user.firstName;
      this.isLogin = true;
    }
  }

  signOut() {
    localStorage.removeItem('user');
    localStorage.removeItem('isSuperAdmin');
    localStorage.removeItem('isPortalUser');
    localStorage.removeItem('isGuest');
    window.location.reload();
  }

}
