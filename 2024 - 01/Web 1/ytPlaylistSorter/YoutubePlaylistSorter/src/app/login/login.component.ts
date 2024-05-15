import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SocialAuthService, GoogleSigninButtonModule } from '@abacritt/angularx-social-login';
import { YoutubeService } from '../services/youtube.service';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    CommonModule,
    GoogleSigninButtonModule,
    DashboardComponent,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  constructor(private authService: SocialAuthService, private ytService: YoutubeService) {}

  public isLogged = false;

  ngOnInit() {
    this.authService.authState.subscribe((user) => {
      console.log(user);
      this.ytService.user = user;
      this.ytService.isLogged = (user != null);
      this.isLogged = this.ytService.isLogged;
    });
  }

  public logOut(): void {
    this.authService.signOut();
    this.ytService.isLogged = false;
    this.isLogged = false;
  }

}
