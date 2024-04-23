import { Component, OnInit, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule, FormControl } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MovieService } from '../../services/movie-service.service';

import { ActivatedRoute, Router } from '@angular/router';


interface Genre {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    MatIconModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatSelectModule,
    CommonModule
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})

export class RegisterComponent implements OnInit {

  selectedMovie: any | null = null;
  selectedMovieId: number = 0;
  submitBtn: string = 'Cadastrar';

  genres: Genre[] = [
    {value: 'action', viewValue: 'Ação'},
    {value: 'comedy', viewValue: 'Comédia'},
    {value: 'drama', viewValue: 'Drama'},
    {value: 'children', viewValue: 'Infantil'},
    {value: 'romance', viewValue: 'Romance'},
    {value: 'thriller', viewValue: 'Suspense'},
    {value: 'horror', viewValue: 'Terror'},
  ];

  movieForm: FormGroup = this.fb.group({
    title: ['', [Validators.required]],
    director: ['',[Validators.required]],
    genre: ['', [Validators.required]],
    year: ['', [Validators.required, Validators.min(1895)]],
    sinopsis: ['', [Validators.required, Validators.minLength(10)]],
    poster: ['', [Validators.required]]
  });


  get titleControl() {
    return this.movieForm.get('title') as FormControl;
  }

  get directorControl() {
    return this.movieForm.get('director') as FormControl;
  }

  get genreControl() {
    return this.movieForm.get('genre') as FormControl;
  }

  get yearControl() {
    return this.movieForm.get('year') as FormControl;
  }

  get sinopsisControl() {
    return this.movieForm.get('sinopsis') as FormControl;
  }

  get posterControl() {
    return this.movieForm.get('poster') as FormControl;
  }

  constructor(private fb: FormBuilder, private activatedRoute: ActivatedRoute, private movieService: MovieService, private router: Router) {}

  moviesList: any[] = [];

  ngOnInit(): void {
    const moviesListJson = localStorage.getItem('movies');
    this.moviesList = moviesListJson ? JSON.parse(moviesListJson) : [];

    const movieId = this.activatedRoute.snapshot.paramMap.get('id');
    if (movieId) {
      this.movieService.selectedMovie$.subscribe(movie => {
        this.selectedMovie = movie;
        if (movie) {
          this.submitBtn = 'Editar';
          const movieNoId = {...movie};
          this.selectedMovieId = movie.id;
          delete movieNoId.id;
          this.movieForm.setValue(movieNoId);
        }
      });
    }
  }

  onSubmit() {
    if (this.submitBtn === 'Editar') {
      this.EditMovie(this.selectedMovieId);
    } else {
      this.AddMovie();
    }
    
    this.movieForm.reset();
  }

  AddMovie() {
    let movieId = Math.floor(Math.random() * 1000);
    
    let newMovie = {
      id: movieId,
      ...this.movieForm.value
    };

    let indexExist = this.moviesList.findIndex((movie) => movie.id === movieId);
    
    while(indexExist !== -1) {
      movieId = Math.floor(Math.random() * 1000);
      indexExist = this.moviesList.findIndex((movie) => movie.id === movieId);
    }

    this.moviesList.push(newMovie);
    localStorage.setItem('movies', JSON.stringify(this.moviesList));
  }

  EditMovie(movieId: number) {
    const movieIndex = this.moviesList.findIndex((movie) => movie.id === movieId);
    this.moviesList[movieIndex] = {
      id: movieId,
      ...this.movieForm.value
    };
    localStorage.setItem('movies', JSON.stringify(this.moviesList));
    this.submitBtn = 'Cadastrar';
    this.router.navigate(['/register']);
  }
}
