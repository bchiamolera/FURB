import { SocialAuthService, SocialUser } from '@abacritt/angularx-social-login';
import { Component, OnInit, inject } from '@angular/core';
import { Router } from '@angular/router';
import { YouTubeService } from '../../services/you-tube.service';


@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit {

  user: SocialUser = new SocialUser();
  loggedIn: boolean = false;
  router = inject(Router);

  constructor(private authService: SocialAuthService, private youtubeService: YouTubeService) { }

  ngOnInit() {
    this.authService.authState.subscribe((user) => {
      this.user = user;
      this.loggedIn = (user != null);
    });

    console.log(this.user);
  }

  getUser() {
    console.log(this.user)  ;
  }
  signOut(): void {
    this.authService.signOut();
  }

  createPlaylist() {
    this.youtubeService.createPlaylist('Teste').then(data => {
      console.log(data);
    });
  }

}
