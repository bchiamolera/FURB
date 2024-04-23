import { Component, OnInit, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { MovieService } from '../../services/movie-service.service';

import { Router } from '@angular/router';


interface Movie {
  id: number;
  title: string;
  director: string;
  genre: string;
  year: number;
  sinopsis: string;
  poster: string;
};

@Component({
  selector: 'app-movie-list',
  standalone: true,
  imports: [
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    CommonModule
  ],
  templateUrl: './movie-list.component.html',
  styleUrl: './movie-list.component.css'
})
export class MovieListComponent implements OnInit {

  moviesList: Movie[] = [];

  constructor(private movieService: MovieService, private router: Router){
  }

  ngOnInit(): void {
    const moviesListJson = localStorage.getItem('movies');
    this.moviesList = moviesListJson ? JSON.parse(moviesListJson) : [];
  }

  handleImageError(event: any) {
    return event.target.src = 'https://via.placeholder.com/200x300';
  }

  Delete(movie: Movie) {
    this.moviesList = this.moviesList.filter((m) => m.id !== movie.id);
    localStorage.setItem('movies', JSON.stringify(this.moviesList));
  }

  Edit(movie: Movie) {
    this.movieService.setSelectedMovie(movie);
    this.router.navigate(['register', movie.id]);
  }

  getGenre(genre: string) {
    switch (genre) {
      case 'action':
        return 'Ação';
      case 'comedy':
        return 'Comédia';
      case 'drama':
        return 'Drama';
      case 'horror':
        return 'Terror';
      case 'romance':
        return 'Romance';
      case 'thriller':
        return 'Suspense';
      case 'children':
        return 'Infantil';
    };
    return "";
  }

}
