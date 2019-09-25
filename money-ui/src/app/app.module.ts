import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {AppComponent} from './app.component';

import {CoreModule} from './core/core.module';
import {PessoasModule} from './pessoas/pessoas.module';
import {LancamentosModule} from './lancamentos/lancamentos.module';
import {CategoriaService} from './categorias/categoria.service';
import {AppRoutingModel} from "./app-routing.model";
import {SegurancaModule} from "./seguranca/seguranca.module";


@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    LancamentosModule,
    PessoasModule,
    SegurancaModule,
    CoreModule,
    HttpModule,
    AppRoutingModel
  ],
  providers: [CategoriaService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
