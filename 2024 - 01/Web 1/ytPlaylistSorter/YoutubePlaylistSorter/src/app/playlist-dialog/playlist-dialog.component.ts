import { Component, Inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import {MatListModule} from '@angular/material/list';
import { YoutubeService } from '../services/youtube.service';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';

@Component({
  selector: 'app-playlist-dialog',
  standalone: true,
  imports: [
    MatDialogModule,
    MatButtonModule,
    MatIconModule,
    MatListModule,
    CommonModule,
    MatProgressSpinnerModule
  ],
  templateUrl: './playlist-dialog.component.html',
  styleUrl: './playlist-dialog.component.css'
})
export class PlaylistDialogComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public id: {id: string}, private ytService: YoutubeService) { }

  playlist: any = {};
  playlistItems: any[] = [];
  isLoading: boolean = false;

  ngOnInit(): void {
    this.isLoading = true;
    this.getPlaylist();
    this.getPlaylistItems();
  }

  async getPlaylist() {
    this.playlist = await this.ytService.getPlaylist(this.id.id);
  }

  async getPlaylistItems() {
    try {
      this.isLoading = true;
      this.playlistItems = await this.ytService.getPlaylistItems(this.id.id);
      console.log('Playlist items:', this.playlistItems);
    } finally {
      this.isLoading = false;
    }
  }

  async reorganizeAndUpdatePlaylist() {
    try {
      this.isLoading = true;
      document.getElementById('reorganize-button')?.setAttribute('disabled', 'true');
      const playlistItems = await this.ytService.getPlaylistItems(this.id.id);
      const organizedVideos = this.reorganizePlaylist(playlistItems);
      console.log('Organized videos:', organizedVideos);

      return await this.ytService.reorderPlaylistItems(this.id.id, organizedVideos);
    } catch (error) {
      console.error('Failed to reorganize playlist:', error);
      throw error;
    } finally {
      this.isLoading = false;
      document.getElementById('reorganize-button')?.removeAttribute('disabled');
      this.getPlaylistItems();
    }
  }

  reorganizePlaylist(videos: any[]): any[] {

    const sortedAlphabetically = videos.sort((a, b) => {
      const titleA = a.snippet.title.toLowerCase();
      const titleB = b.snippet.title.toLowerCase();
      return titleA.localeCompare(titleB);
    });

    const artistsMap: { [key: string]: any[] } = {};
    
    sortedAlphabetically.forEach(video => {
      const artist = video.snippet.videoOwnerChannelTitle;
      if (artistsMap.hasOwnProperty(artist)) {
        artistsMap[artist].push(video);
      } else {
        artistsMap[artist] = [video];
      }
    });

    const artistKeys = Object.keys(artistsMap).sort((a, b) => {
      const artistA = a.toLowerCase();
      const artistB = b.toLowerCase();
      return artistA.localeCompare(artistB);
    });

    const organizedVideos: any[] = [];
    artistKeys.forEach(artist => {
      console.log('Artist:', artist);
      organizedVideos.push(...artistsMap[artist]);
    })

    for (let i = 0; i < organizedVideos.length; i++) {
      organizedVideos[i].snippet.position = i;
    }

    return organizedVideos;
  }

  updatePlaylistTitle(title: string): void {
    this.ytService.updatePlaylistTitle(this.id.id, title);
  }

}
