import { Injectable } from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {AuthService} from "./auth.service";
import {environment} from "../../environments/environment";

@Injectable()
export class LogoutService {

  tokensRevokeURL: string;

  constructor(
    private http: AuthHttp,
    private auth: AuthService
  ) {
    this.tokensRevokeURL = `${environment.apiUrl}/tokens/revoke`;
  }


  logout() {
   return this.http.delete(this.tokensRevokeURL, {withCredentials: true}).toPromise()
      .then(() => {
        this.auth.limparAccessToken();
      });
  }


}
