import { ErrorHandlerService } from './../../core/error-handler.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { LancamentoService, LancamentoFiltro } from '../lancamento.service';
import { LazyLoadEvent, ConfirmationService } from 'primeng/components/common/api';
import { ToastyService } from 'ng2-toasty';
import {Title} from "@angular/platform-browser";
import {AuthService} from "../../seguranca/auth.service";

@Component({
  selector: 'app-lancamentos-pesquisa',
  templateUrl: './lancamentos-pesquisa.component.html',
  styleUrls: ['./lancamentos-pesquisa.component.css']
})
export class LancamentosPesquisaComponent implements OnInit {

  filter: LancamentoFiltro = new LancamentoFiltro();
  totalElements = 0;
  lancamentos = [];

  constructor(
    private lancamentoService: LancamentoService,
    private toastyService: ToastyService,
    private confirmationService: ConfirmationService,
    private errorHandlerService: ErrorHandlerService,
    private title: Title,
    private auth: AuthService) {

  }

  ngOnInit() {
    this.title.setTitle("Pesquisa de lançamento");
  }

  lazyLoad(event: LazyLoadEvent) {
    const pagina = event.first / event.rows;
    this.pesquisar(pagina);
  }

  pesquisar(page = 0) {
    this.filter.page = page;
    this.lancamentoService.pesquisar(this.filter)
    .then(result => {
      this.lancamentos = result.lancamentos;
      this.totalElements = result.totalElements;
    }).catch(erro => {
      this.errorHandlerService.handle(erro);
    });
  }

  excluir(eventExlusao: any) {
    this.confirmationService.confirm({
      message: 'Tem certeza que deseja excluir?',
      accept: () => {
        this.lancamentoService.excluir(eventExlusao.lancamento.id)
        .then(() => {
          this.pesquisar(eventExlusao.tabela.first / eventExlusao.tabela.rows);
          this.toastyService.success('Lançamento excluído com sucesso.');
        }).catch((erro) => {
          this.errorHandlerService.handle(erro);
        });
      }
    });
  }
}
