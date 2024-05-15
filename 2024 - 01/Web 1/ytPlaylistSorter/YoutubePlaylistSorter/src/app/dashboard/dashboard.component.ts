import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { YoutubeService } from '../services/youtube.service';
import { GoogleLoginProvider, SocialAuthService } from '@abacritt/angularx-social-login';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import {MatListModule} from '@angular/material/list';
import {MatCardModule} from '@angular/material/card';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { PlaylistDialogComponent } from '../playlist-dialog/playlist-dialog.component';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    CommonModule,
    MatButtonModule,
    MatIconModule,
    MatListModule,
    MatCardModule,
    MatDialogModule,
    MatProgressSpinnerModule
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit {

  constructor(public dialog: MatDialog, private authService: SocialAuthService, private ytService: YoutubeService) { }

  playlists: any[] = [];
  playlistItems: any[] = [];
  accessToken: string = '';
  isLoading: boolean = true;

  ngOnInit(): void {
    this.ytService.getAccessToken().subscribe(() => {
      setTimeout(() => {
        this.getPlaylists()
      }, 1000);
    })
  }

  openDialog(playlistId: string) {
    const dialogRef = this.dialog.open(PlaylistDialogComponent, {
      width: '800px',
      data: { id: playlistId }
    });

    dialogRef.afterClosed().subscribe(() => {
      this.getPlaylists();
    });
  }

  refreshToken(): void {
    this.authService.refreshAuthToken(GoogleLoginProvider.PROVIDER_ID);
  }

  async getPlaylists() {
    this.isLoading = true;
    try {
      this.playlists = await this.ytService.getPlaylists();
      console.log('Playlists:', this.playlists);
    } finally {
      this.isLoading = false;
    }
  }

  async createPlaylist(): Promise<any> {
    try {
      document.getElementById('create-playlist-button')?.setAttribute('disabled', 'true');
      this.ytService.createPlaylist();
    } catch (error) {
      console.error('Failed to create playlist:', error);
      throw error;
    } finally {
      setTimeout(() => {
        this.getPlaylists();
        document.getElementById('create-playlist-button')?.removeAttribute('disabled');
      }, 1000);
    }

    setTimeout(() => {
      this.getPlaylists();
    }, 1000);
  }

  deletePlaylist(id: string): void {
    this.ytService.deletePlaylist(id);
    this.playlists.splice(this.playlists.findIndex(playlist => playlist.id === id), 1);
  }
}