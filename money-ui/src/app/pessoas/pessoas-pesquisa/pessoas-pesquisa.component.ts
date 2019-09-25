import { ErrorHandlerService } from './../../core/error-handler.service';
import { ToastyService } from 'ng2-toasty';
import { PessoaFiltro, PessoasService } from './../pessoas.service';
import { Component, OnInit } from '@angular/core';
import { LazyLoadEvent, ConfirmationService } from 'primeng/components/common/api';
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-pessoas-pesquisa',
  templateUrl: './pessoas-pesquisa.component.html',
  styleUrls: ['./pessoas-pesquisa.component.css']
})
export class PessoasPesquisaComponent implements OnInit{

  pessoas = [];
  filter: PessoaFiltro = new PessoaFiltro();
  totalRecords = 0;

  constructor(private pessoasService: PessoasService,
              private confirmationService: ConfirmationService,
              private toastyService: ToastyService,
              private errorHandlerService: ErrorHandlerService,
              private title: Title) {

  }

  ngOnInit(): void {
    this.title.setTitle('Pesquisa de Pessoas');
  }

  lazyLoad(event: LazyLoadEvent) {
    const page = event.first / event.rows;
    this.pesquisar(page);
  }

  pesquisar(page = 0) {
    this.filter.page = page;
    this.pessoasService.pesquisar(this.filter)
    .then(response => {
      this.pessoas = response.pessoas;
      this.totalRecords = response.totalElements;
    }).catch((erro) => {
      this.errorHandlerService.handle(erro);
    });

  }

  excluir(eventoExclusao: any) {
    this.confirmationService.confirm({
      message: 'Tem certeza que deseja excluir essa pessoa?',
      accept: () => {
        this.pessoasService.excluir(eventoExclusao.pessoa.id)
        .then(() => {
          this.pesquisar(eventoExclusao.tabela.first / eventoExclusao.tabela.rows);
          this.toastyService.success('Pessoa excluída com sucesso.');
        }).catch((erro) => {
          this.errorHandlerService.handle(erro);
        });
      }
    });
  }

  ativatInativar(eventoAlteracao: any) {
    this.pessoasService.ativarInativar(eventoAlteracao.pessoa)
    .then(() => {
      this.pesquisar(eventoAlteracao.tabela.first / eventoAlteracao.tabela.rows);
      this.toastyService.success('Pessoa alterada com sucesso!.');
    }).catch((erro) => {
      this.errorHandlerService.handle(erro);
    });
  }


}
