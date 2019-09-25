import {Injectable} from '@angular/core';
import {Headers, Http} from "@angular/http";
import {JwtHelper} from "angular2-jwt";
import {environment} from "../../environments/environment";

@Injectable()
export class AuthService {

  oAuthTokenUrl: string;

  headers = new Headers({'Content-Type': 'application/x-www-form-urlencoded', 'Authorization': 'Basic YW5ndWxhcjpQQHNzdzByZA=='});

  jwtPayload: any;

  constructor(
    private http: Http,
    private jwtHelper: JwtHelper
  ) {
    this.carregarToken();
    this.oAuthTokenUrl = `${environment.apiUrl}/oauth/token`;
  }

  private armazenarToken(token: string) {
    this.jwtPayload = this.jwtHelper.decodeToken(token);
    localStorage.setItem('token', token);
  }

  private carregarToken() {
    let token = localStorage.getItem('token');

    if (token) {
      this.armazenarToken(token);
    }
  }

  limparAccessToken() {
    localStorage.removeItem('token');
    this.jwtPayload = null;
  }

  temPermissao(permissao: string): boolean {
    return this.jwtPayload && this.jwtPayload.authorities.includes(permissao);
  }

  isAccessTokenInvalido() {
    const token = localStorage.getItem('token');
    return !token || this.jwtHelper.isTokenExpired(token);
  }

  temQualquerPermissao(roles: string []) {
    for(const role of roles){
      if(this.temPermissao(role)){
        return true;
      }
    }
  }


  obterNovoAccessToken(): Promise<void> {
    return this.http.post(this.oAuthTokenUrl, 'grant_type=refresh_token', {headers: this.headers, withCredentials: true}).toPromise()
      .then(response => {
        this.armazenarToken(response.json().access_token);
        return Promise.resolve(null);
      }).catch(response => {
        console.error('Erro ao renovar o token!');
        Promise.resolve(null);
      })
  }


  login(usuario: string, senha: string): Promise<void> {
    const body = `username=${usuario}&password=${senha}&grant_type=password`;
    return this.http.post(this.oAuthTokenUrl, body, {headers: this.headers, withCredentials: true}).toPromise()
      .then(response => {
        this.armazenarToken(response.json().access_token);
        console.log(response);
      })
      .catch(response => {
        if (response.status === 400) {
          if (response.json().error === 'invalid_grant') {
            return Promise.reject('Usuário ou Senha inválido!');
          }
        }

        return Promise.reject(response);
      });
  }

}
