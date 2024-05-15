import { Injectable } from '@angular/core';
import { SocialAuthService, GoogleLoginProvider } from '@abacritt/angularx-social-login';
import { SocialUser } from '@abacritt/angularx-social-login';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class YoutubeService {

  public accessToken = '';
  public isLogged = false;
  public user: SocialUser | null = null;

  constructor(private authService: SocialAuthService) { }

  public loggedIn(): void {
    this.isLogged = true;
  }

  // GET'S

  getAccessToken(): Observable<string> {
    const tokenSubject = new Subject<string>();

    this.authService.getAccessToken(GoogleLoginProvider.PROVIDER_ID).then(accessToken => {
      tokenSubject.next(accessToken);
      this.accessToken = accessToken;
      this.loggedIn();
      tokenSubject.complete();
    }).catch(error => {
      console.error('Failed to get access token:', error);
      tokenSubject.error(error);
    });

    return tokenSubject.asObservable();
  }

  async getPlaylists(): Promise<any[]> {
    if (!this.accessToken) {
      this.getAccessToken();
      return [];
    }

    const url = 'https://www.googleapis.com/youtube/v3/playlists?part=snippet&mine=true&maxResults=50';
    let playlists: any[] = [];
    let nextPageToken = '';

    do {
      const response = await fetch(url + (nextPageToken ? `&pageToken=${nextPageToken}` : ''), {
        headers: {
          'Authorization': `Bearer ${this.accessToken}`
        }
      });
      if (!response.ok) {
        throw new Error(`Failed to get playlists: ${response.status}`);
      }
      const data = await response.json();
      nextPageToken = data.nextPageToken || '';
      playlists = playlists.concat(data.items || []);
    } while (nextPageToken);

    return Promise.resolve(playlists);
  }

  async getPlaylist(id: string): Promise<any> {
    if (!this.accessToken) {
      this.getAccessToken();
      return Promise.resolve({});
    }

    const url = `https://www.googleapis.com/youtube/v3/playlists?part=snippet&id=${id}`;

    return await fetch(url, {
      headers: {
        'Authorization': `Bearer ${this.accessToken}`
      }
    }).then(response => {
      if (!response.ok) {
        throw new Error(`Failed to get playlist: ${response.status}`);
      }
      return response.json();
    }).then(data => {
      return data.items[0];
    }).catch(error => {
      console.error(error);
      return {};
    });
  }

  async getPlaylistItems(id: string): Promise<any[]> {
    if (!this.accessToken) {
      this.getAccessToken();
      return [];
    }

    const url = `https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=${id}&maxResults=50`;
    let playlistItems: any[] = [];
    let nextPageToken = '';

    do {
      const response = await fetch(url + (nextPageToken ? `&pageToken=${nextPageToken}` : ''), {
        headers: {
          'Authorization': `Bearer ${this.accessToken}`
        }
      });
      if (!response.ok) {
        throw new Error(`Failed to get playlist items: ${response.status}`);
      }
      const data = await response.json();
      nextPageToken = data.nextPageToken || '';
      playlistItems = playlistItems.concat(data.items || []);
    } while (nextPageToken);

    return Promise.resolve(playlistItems);
  }

  // POST'S

  createPlaylist(): void {
    if (!this.accessToken) {
      this.getAccessToken();
      return;
    }

    const url = 'https://www.googleapis.com/youtube/v3/playlists?part=snippet&key=AIzaSyDPNdrnWYSssAgIhUUz6jiikQZUbWHdqok';

    fetch(url, {
      method: 'POST',
      headers: {
        'Authorization': `Bearer ${this.accessToken}`,
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        'snippet': {
          'title': 'New Playlist',
        }
      })
    }).then(response => {
      if (!response.ok) {
        throw new Error(`Failed to create playlist: ${response.status}`);
      }
      return response.json();
    }).then(data => {
      const playlistId = data.id;
      console.log(`Playlist created with ID: ${playlistId}`);
    }).catch(error => {
      console.error(error);
    }
    )
  }

  // PUT'S

  async reorderPlaylistItems(playlistId: string, videos: any[]) {
    if (!this.accessToken) {
      this.getAccessToken();
      return;
    }

    const updatePromises = videos.map(async (video) => {
      try {
        await this.updatePlaylistItem(playlistId, video);
      } catch (error) {
        console.error('Failed to update playlist item:', error);
      } finally {
        await new Promise(resolve => setTimeout(resolve, 1500));
      }
    })

    await Promise.all(updatePromises);
    console.log('Playlist reorganization completed (with sequential updates and delays).');
  }

  async updatePlaylistItem(playlistId: string, video: any, retryCount = 0): Promise<boolean> {
    const url = `https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&key=AIzaSyDPNdrnWYSssAgIhUUz6jiikQZUbWHdqok`;
  
    const body = JSON.stringify({
      id: video.id,
      snippet: {
        playlistId: playlistId,
        resourceId: {
          kind: 'youtube#video',
          videoId: video.snippet.resourceId.videoId
        },
        position: video.snippet.position
      }
    });
  
    const options = {
      method: 'PUT',
      headers: {
        Authorization: `Bearer ${this.accessToken}`,
        'Content-Type': 'application/json'
      },
      body: body
    };
  
    try {
      const response = await fetch(url, options);
      if (!response.ok) {
        const errorText = await response.text();
        if (response.status === 409 && errorText.includes('SERVICE_UNAVAILABLE') && retryCount < 10000) {
          console.warn(`Retrying update for video ${video.snippet.title} due to service unavailable (attempt ${retryCount + 1})`);
          await new Promise(resolve => setTimeout(resolve, this.calculateBackoffDelay(retryCount)));
          return this.updatePlaylistItem(playlistId, video, retryCount + 1); // Retry with backoff
        } else {
          throw new Error(`Error updating playlist item: ${video.status} - ${errorText}`); // Include response status and error text
        }
      }
      console.log('Playlist item updated:', video.snippet.title);
      return true; // Indicate successful update
    } catch (error) {
      console.error('Error updating playlist item:', video.snippet.title, error);
      return false; // Indicate failed update
    }
  }

  calculateBackoffDelay(retryCount: number): number {
    return Math.pow(2, retryCount) * 1000;
  }

  updatePlaylistTitle(id: string, title: string): void {
    if (!this.accessToken) {
      this.getAccessToken();
      return;
    }

    const url = `https://www.googleapis.com/youtube/v3/playlists?part=snippet&key=AIzaSyDPNdrnWYSssAgIhUUz6jiikQZUbWHdqok`;

    fetch(url, {
      method: 'PUT',
      headers: {
        'Authorization': `Bearer ${this.accessToken}`,
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        'id': id,
        'snippet': {
          'title': title
        }
      })
    }).then(response => {
      if (!response.ok) {
        throw new Error(`Failed to update playlist title: ${response.status}`);
      }
      return response.json();
    }).then(data => {
      console.log('Playlist title updated:', data);
    }).catch(error => {
      console.error('Error updating playlist title:', error);
    });
  }

  updatePlaylistDescription(id: string, description: string): void {
    if (!this.accessToken) {
      this.getAccessToken();
      return;
    }

    const url = `https://www.googleapis.com/youtube/v3/playlists?part=snippet&key=AIzaSyDPNdrnWYSssAgIhUUz6jiikQZUbWHdqok`;

    fetch(url, {
      method: 'PUT',
      headers: {
        'Authorization': `Bearer ${this.accessToken}`,
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        'id': id,
        'snippet': {
          'description': description
        }
      })
    }).then(response => {
      if (!response.ok) {
        throw new Error(`Failed to update playlist description: ${response.status}`);
      }
      return response.json();
    }).then(data => {
      console.log('Playlist description updated:', data);
    }).catch(error => {
      console.error('Error updating playlist description:', error);
    });
  }

  updatePlaylistPrivacy(id: string, privacy: boolean): void {
    if (!this.accessToken) {
      this.getAccessToken();
      return;
    }

    const url = `https://www.googleapis.com/youtube/v3/playlists?part=status&key=AIzaSyDPNdrnWYSssAgIhUUz6jiikQZUbWHdqok`;

    fetch(url, {
      method: 'PUT',
      headers: {
        'Authorization': `Bearer ${this.accessToken}`,
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        'id': id,
        'status': {
          'privacyStatus': privacy ? 'private' : 'public'
        }
      })
    }).then(response => {
      if (!response.ok) {
        throw new Error(`Failed to update playlist privacy: ${response.status}`);
      }
      return response.json();
    }).then(data => {
      console.log('Playlist privacy updated:', data);
    }).catch(error => {
      console.error('Error updating playlist privacy:', error);
    });
  }

  // DELETE'S

  deletePlaylist(id: string): void {
    if (!this.accessToken) {
      this.getAccessToken();
      return;
    }

    const url = `https://www.googleapis.com/youtube/v3/playlists?id=${id}&key=AIzaSyDPNdrnWYSssAgIhUUz6jiikQZUbWHdqok`;

    fetch(url, {
      method: 'DELETE',
      headers: {
        'Authorization': `Bearer ${this.accessToken}`
      }
    }).then(response => {
      if (!response.ok) {
        throw new Error(`Failed to delete playlist: ${response.status}`);
      }
      console.log('Playlist deleted');
    }
    ).catch(error => {
      console.error('Error deleting playlist:', error);
    });
  }

}
