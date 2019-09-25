import {CurrencyMaskModule} from 'ng2-currency-mask';
import {DropdownModule} from 'primeng/components/dropdown/dropdown';
import {InputTextareaModule} from 'primeng/components/inputtextarea/inputtextarea';
import {TooltipModule} from 'primeng/components/tooltip/tooltip';
import {DataTableModule} from 'primeng/components/datatable/datatable';
import {ButtonModule} from 'primeng/components/button/button';
import {InputTextModule} from 'primeng/components/inputtext/inputtext';
import {CalendarModule} from 'primeng/components/calendar/calendar';
import {FormsModule} from '@angular/forms';
import {LancamentoGridComponent} from './lancamento-grid/lancamento-grid.component';
import {LancamentosPesquisaComponent} from './lancamentos-pesquisa/lancamentos-pesquisa.component';
import {LancamentoCadastroComponent} from './lancamento-cadastro/lancamento-cadastro.component';
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SelectButtonModule} from 'primeng/components/selectbutton/selectbutton';
import {SharedModule} from './../shared/shared.module';
import {LancamentosRoutingModule} from "./lancamentos-routing.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    InputTextModule,
    ButtonModule,
    DataTableModule,
    TooltipModule,
    InputTextareaModule,
    CalendarModule,
    SelectButtonModule,
    DropdownModule,
    CurrencyMaskModule,
    SharedModule,
    LancamentosRoutingModule
  ],
  declarations: [
    LancamentoCadastroComponent,
    LancamentosPesquisaComponent,
    LancamentoGridComponent
  ],
  exports: []
})
export class LancamentosModule { }
