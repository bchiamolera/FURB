import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private selectedMovieSource = new BehaviorSubject<any | null>(null);
  selectedMovie$ = this.selectedMovieSource.asObservable();

  setSelectedMovie(movie: any) {
    this.selectedMovieSource.next(movie);
  }
}
