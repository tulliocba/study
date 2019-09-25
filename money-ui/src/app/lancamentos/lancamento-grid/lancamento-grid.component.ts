import { LancamentoFiltro } from './../lancamento.service';
import { Component, OnInit, Input, Output, ViewChild } from '@angular/core';
import { EventEmitter } from '@angular/core';
import {AuthService} from "../../seguranca/auth.service";

@Component({
  selector: 'app-lancamento-grid',
  templateUrl: './lancamento-grid.component.html',
  styleUrls: ['./lancamento-grid.component.css']
})
export class LancamentoGridComponent {

  @Input() lancamentos: any[] = [];
  @Input() filter: LancamentoFiltro = new LancamentoFiltro();
  @Input() lazy = false;
  @Input() totalRecords: number;
  @Output() onLazyLoad = new EventEmitter();
  @Output() excluirEvent = new EventEmitter();
  @ViewChild('tabela') tabela;

  lazyLoad( event: any ) {
    this.onLazyLoad.emit(event);
  }

  excluir(lanc: any) {
    this.excluirEvent.emit({lancamento: lanc, tabela: this.tabela});
  }

  constructor(private auth: AuthService){

  }

}
