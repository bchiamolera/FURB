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
      const url = `https://youtube.googleapis.com/youtube/v3/playlists?part=snippet%2Cstatus`;
      const body = {
        "snippet": {
          "title": nome,
          "description": "A private playlist created with the YouTube API"
        },
        "status": {
          "privacyStatus": "private"
        }
      }
      const response = await fetch(url, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${this.accessToken}`
        },
        body: JSON.stringify(body)
      });
      const data = await response.json();
      return data;
    }
  
    // Delete playlist from Youtube
    public deletePlaylist() {
    }
    
}
