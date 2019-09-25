import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs/Observable';
import {AuthService} from "./auth.service";
import {ToastyService} from "ng2-toasty";

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(
    private auth: AuthService,
    private router: Router,
    private toastyService: ToastyService
  ) {
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

    if (this.auth.isAccessTokenInvalido()) {

      return this.auth.obterNovoAccessToken().then(() => {
        if(this.auth.isAccessTokenInvalido()){
          this.toastyService.warning('O usuário deve estar logado!');
          this.router.navigate(['/login']);
          return false;
        }

        return true;
      });

    } else if (next.data.roles && !this.auth.temQualquerPermissao(next.data.roles)) {
      this.router.navigate(['/nao-autorizado']);
      return false;
    }

    return true;
  }
}
