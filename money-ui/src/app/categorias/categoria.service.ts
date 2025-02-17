import {Injectable} from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {environment} from "../../environments/environment";

@Injectable()
export class CategoriaService {

  categoriasUrl: string;

  constructor(private http: AuthHttp) {
    this.categoriasUrl = `${environment.apiUrl}/categories`;
  }

  listarTodas(): Promise<any> {
    return this.http.get(`${this.categoriasUrl}`)
    .toPromise().then((response) => response.json());
  }

}
