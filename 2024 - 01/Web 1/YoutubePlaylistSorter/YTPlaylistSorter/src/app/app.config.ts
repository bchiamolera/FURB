import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { GoogleInitOptions, GoogleLoginProvider, SocialAuthServiceConfig } from '@abacritt/angularx-social-login';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

const googleLoginOptions: GoogleInitOptions = {
  oneTapEnabled: false,
  scopes: 'profile email openid https://www.googleapis.com/auth/youtube https://www.googleapis.com/auth/youtube.readonly',
};

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes), provideClientHydration(),
      {
    provide: 'SocialAuthServiceConfig',
    useValue: {
      autoLogin: false,
      providers: [
        {
          id: GoogleLoginProvider.PROVIDER_ID,
          provider: new GoogleLoginProvider(
            '434308392701-13dm6ijpc5sjraj3pljpsdcu3kjb2g5n.apps.googleusercontent.com',
            googleLoginOptions
          )
        },
      ],
      OnError: (err: void): void => {
        console.log(err);
      }
    } as SocialAuthServiceConfig
  }, provideAnimationsAsync()
  ]
};
