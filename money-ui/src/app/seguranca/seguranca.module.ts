import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LoginFormComponent} from './login-form/login-form.component';
import {SegurancaRoutingModule} from "./seguranca-routing.module";
import {FormsModule} from "@angular/forms";
import {ButtonModule, InputTextModule} from "primeng/primeng";
import {AuthConfig, AuthHttp} from "angular2-jwt";
import {Http, RequestOptions} from "@angular/http";
import {MoneyHttp} from "./money-http";
import {AuthService} from "./auth.service";
import {AuthGuard} from "./auth.guard";
import {LogoutService} from "./logout.service";

export function authHttpServiceFactory(authService: AuthService, http: Http, options: RequestOptions) {
  let config = new AuthConfig({
    globalHeaders: [
      {
        'Content-Type': 'application/json'
      }
    ]
  });
  return new MoneyHttp(authService, config, http, options);
}

@NgModule({
  imports: [
    CommonModule,
    SegurancaRoutingModule,
    FormsModule,
    InputTextModule,
    ButtonModule
  ],
  declarations: [
    LoginFormComponent
  ],
  providers: [
    {
      provide: AuthHttp,
      useFactory: authHttpServiceFactory,
      deps: [AuthService, Http, RequestOptions]
    },
    AuthGuard,
    LogoutService
  ]
})
export class SegurancaModule {
}
