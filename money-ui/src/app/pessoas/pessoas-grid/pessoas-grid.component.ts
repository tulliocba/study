import { Component, OnInit, Input, Output, EventEmitter, ViewChild } from '@angular/core';
import { PessoaFiltro } from '../pessoas.service';

@Component({
  selector: 'app-pessoas-grid',
  templateUrl: './pessoas-grid.component.html',
  styleUrls: ['./pessoas-grid.component.css']
})
export class PessoasGridComponent {

  @Input() pessoas: any[] = [];
  @Input() filter: PessoaFiltro;
  @Input() lazy = false;
  @Input() totalRecords: number;
  @Output() onLazyLoad = new EventEmitter();
  @Output() excluirEvent = new EventEmitter();
  @Output() ativarInativarEvento = new EventEmitter();
  @ViewChild('tabela') tabela;

  //repassar o evento para o componente pai.
  lazyLoad(event: any) {
    this.onLazyLoad.emit(event);
  }

  excluir(pessoa: any) {
    this.excluirEvent.emit({pessoa: pessoa, tabela: this.tabela});
  }

  ativarInativar(pessoa: any) {
    this.ativarInativarEvento.emit({pessoa: pessoa, tabela: this.tabela});
  }

}
