import {Expense} from './../core/model';
import {Injectable} from '@angular/core';
import {URLSearchParams} from '@angular/http';

import * as moment from 'moment';

import 'rxjs/add/operator/toPromise';
import {AuthHttp} from "angular2-jwt";
import {environment} from "../../environments/environment";

export class LancamentoFiltro {
  description: string;
  invoiceExpirationFrom: Date;
  invoiceExpirationTo: Date;
  page = 0;
  size = 3;
}

@Injectable()
export class LancamentoService {
  lancamentosUrl: string;

  constructor(private http: AuthHttp) {
    this.lancamentosUrl = `${environment.apiUrl}/expenses`;
  }

  pesquisar(filter: LancamentoFiltro): Promise<any> {
    const params = new URLSearchParams();

    params.set('page', filter.page.toString());
    params.set('size', filter.size.toString());

    if (filter.description) {
      params.set('description', filter.description);
    }

    if (filter.invoiceExpirationFrom) {
      params.set('invoiceExpirationFrom', moment(filter.invoiceExpirationFrom).format('YYYY-MM-DD'));
    }

    if (filter.invoiceExpirationTo) {
      params.set('invoiceExpirationTo', moment(filter.invoiceExpirationTo).format('YYYY-MM-DD'));
    }

    return this.http.get(`${this.lancamentosUrl}/search?digest`, {search: params})
      .toPromise().then(response => {
        return {lancamentos: response.json().content, totalElements: response.json().totalElements}
      });
  }

  excluir(id: number): Promise<void> {
    return this.http.delete(`${this.lancamentosUrl}/${id}`)
      .toPromise().then(() => null);
  }

  adicionar(lancamento: Expense): Promise<Expense> {
    return this.http.post(`${this.lancamentosUrl}`, JSON.stringify(lancamento)).toPromise()
      .then(response => response.json());
  }

  atualizar(lancamento: Expense): Promise<Expense> {

    return this.http.put(`${this.lancamentosUrl}/${lancamento.id}`, JSON.stringify(lancamento))
      .toPromise()
      .then(response => {
        const lancamentoAlterado = response.json() as Expense;

        this.converterStringsParaDatas([lancamentoAlterado]);

        return lancamentoAlterado;
      });
  }

  buscarPorCodigo(codigo: number): Promise<Expense> {
    return this.http.get(`${this.lancamentosUrl}/${codigo}`)
      .toPromise()
      .then(response => {
        const lancamento = response.json() as Expense;

        this.converterStringsParaDatas([lancamento]);

        return lancamento;
      });
  }

  private converterStringsParaDatas(lancamentos: Expense[]) {
    for (const lancamento of lancamentos) {
      lancamento.invoiceExpirationDate = moment(lancamento.invoiceExpirationDate,
        'YYYY-MM-DD').toDate();

      if (lancamento.payableDate) {
        lancamento.payableDate = moment(lancamento.payableDate,
          'YYYY-MM-DD').toDate();
      }
    }
  }

}
