import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SocialAuthService, GoogleLoginProvider  } from "@abacritt/angularx-social-login";


@Injectable({
  providedIn: 'root'
})
export class YouTubeService {

  constructor(private authService: SocialAuthService) { }

  public accessToken = '';

  public getAccessToken(): void {
    this.authService.getAccessToken(GoogleLoginProvider.PROVIDER_ID).then(accessToken => {
      this.accessToken = accessToken
    });
  }

    // Get playlists from YouTube API
    public getPlaylists() {
    }

    // Get playlist items from YouTube API
    public getPlaylistItems() {
    }
  
    // Update playlist from Youtube
    public updatePlaylist() {
    }
  

    async createPlaylist(nome: string) {
    }
  
    // Delete playlist from Youtube
    public deletePlaylist() {
    }
    
}
