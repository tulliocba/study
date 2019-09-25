import {URLSearchParams} from '@angular/http';
import {Injectable} from '@angular/core';
import {Person} from 'app/core/model';
import {AuthHttp} from "angular2-jwt";
import {environment} from "../../environments/environment";

export class PessoaFiltro {
  name: string;
  page = 0;
  size = 2;
}

@Injectable()
export class PessoasService {

  pessoasUrl: string;

  constructor(private http: AuthHttp) {
    this.pessoasUrl = `${environment.apiUrl}/people`;
  }

  pesquisar(filter: PessoaFiltro): Promise<any> {
    const params = new URLSearchParams();

    params.set('page', filter.page.toString());
    params.set('size', filter.size.toString());

    if (filter.name) {
      params.set('name', filter.name);
    }

    return this.http
      .get(`${this.pessoasUrl}/search?`, {search: params})
      .toPromise()
      .then(response => {
        return {
          pessoas: response.json().content,
          totalElements: response.json().totalElements
        }
      });
  }

  listarTodas(): Promise<any> {
    return this.http.get(`${this.pessoasUrl}/search`)
      .toPromise().then(response => response.json().content);
  }

  excluir(id: number): Promise<void> {
    return this.http.delete(`${this.pessoasUrl}/${id}`)
      .toPromise().then(() => null);
  }

  ativarInativar(pessoa: any): Promise<void> {
    return this.http.put(`${this.pessoasUrl}/${pessoa.id}/enabled`, !pessoa.enabled).toPromise()
      .then(() => null);
  }

  adicionar(pessoa: Person): Promise<Person> {
    return this.http.post(`${this.pessoasUrl}`, JSON.stringify(pessoa)).toPromise()
      .then(response => response.json());
  }

  pesquisarPessoaPor(id: number): Promise<Person> {
    return this.http.get(`${this.pessoasUrl}/${id}`).toPromise()
      .then(pessoa => pessoa.json());
  }

  atualizarPessoa(pessoa: Person): Promise<Person> {
    return this.http.put(`${this.pessoasUrl}/${pessoa.id}`, JSON.stringify(pessoa)).toPromise()
      .then(person => person.json());
  }
}
