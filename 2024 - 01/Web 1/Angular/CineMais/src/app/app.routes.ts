import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { MovieListComponent } from './pages/movie-list/movie-list.component';	
import { AboutComponent } from './pages/about/about.component';

export const routes: Routes = [
    {
        path: '',
        component: LoginComponent,
        title: 'CineMais - Login'
    },
    {
        path: 'register',
        component: RegisterComponent,
        title: 'CineMais - Cadastro de Filmes'
    },
    {
        path: 'register/:id',
        component: RegisterComponent
    },
    {
        path: 'movie-list',
        component: MovieListComponent,
        title: 'CineMais - Sua Lista'
    },
    {
        path: 'about',
        component: AboutComponent,
        title: 'CineMais - Sobre Nós'
    }
];
