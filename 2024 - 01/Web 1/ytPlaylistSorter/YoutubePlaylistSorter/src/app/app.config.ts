import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

import { GoogleInitOptions, SocialAuthServiceConfig } from '@abacritt/angularx-social-login';
import { GoogleLoginProvider } from '@abacritt/angularx-social-login';

export const appConfig: ApplicationConfig = {
  providers: [
    {
      provide: 'SocialAuthServiceConfig',
      useValue: {
        autoLogin: false,
        scopes: 'https://www.googleapis.com/auth/youtube',
        providers: [
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider(
              '434308392701-13dm6ijpc5sjraj3pljpsdcu3kjb2g5n.apps.googleusercontent.com',
              { scopes: 'https://www.googleapis.com/auth/youtube' } as GoogleInitOptions
            )
          }
        ],
        onError: (err: string) => {
          console.error(err);
        }
      } as SocialAuthServiceConfig
    },
    provideRouter(routes), provideAnimationsAsync()
  ]
};

