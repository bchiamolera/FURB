import { GoogleSigninButtonModule, SocialAuthService, SocialLoginModule, SocialUser } from '@abacritt/angularx-social-login';
import { CommonModule } from '@angular/common';
import { Component, OnInit, inject } from '@angular/core';
import { Router } from '@angular/router';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { YouTubeService } from '../../services/you-tube.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, SocialLoginModule, GoogleSigninButtonModule, MatButtonModule, MatIconModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  
  user: SocialUser = new SocialUser();
  loggedIn: boolean = false;
  router = inject(Router);

  private accessToken = '';

  constructor(private authService: SocialAuthService, private ytService: YouTubeService) { }

  ngOnInit() {
    this.authService.authState.subscribe((user) => {
      this.user = user;
      this.loggedIn = (user != null);
      sessionStorage.setItem('user', JSON.stringify(user));
      this.ytService.getAccessToken();
    });
  }

  logOut() {
    this.authService.signOut();
    sessionStorage.clear();
  }

  
}