import { RouterModule } from '@angular/router';
import { NgModule, LOCALE_ID } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ToastyModule } from 'ng2-toasty';
import { ConfirmDialogModule } from 'primeng/components/confirmdialog/confirmdialog';
import { ConfirmationService } from 'primeng/components/common/api';

import { ErrorHandlerService } from './error-handler.service';
import { NavbarComponent } from './navbar/navbar.component';
import { LancamentoService } from 'app/lancamentos/lancamento.service';
import { PessoasService } from 'app/pessoas/pessoas.service';
import { PaginaNaoEncontradaComponent } from './pagina-nao-encontrada.component';
import {Title} from "@angular/platform-browser";
import {AuthService} from "../seguranca/auth.service";
import {JwtHelper} from "angular2-jwt";
import {NaoAutorizadoComponent} from "./nao-autorizado.component";

@NgModule({
  imports: [
    CommonModule,
    ToastyModule.forRoot(),
    ConfirmDialogModule,
    RouterModule
  ],
  declarations: [
    NavbarComponent,
    PaginaNaoEncontradaComponent,
    NaoAutorizadoComponent
  ],
  exports: [
    NavbarComponent,
    ToastyModule,
    ConfirmDialogModule
  ],
  providers: [
    ErrorHandlerService,
    LancamentoService,
    PessoasService,
    ConfirmationService,
    Title,
    AuthService,
    JwtHelper,
    {provide: LOCALE_ID, useValue: 'pt-BR'}

  ]
})
export class CoreModule { }
