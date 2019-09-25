import { ToastyService } from 'ng2-toasty';
import { LancamentoService } from 'app/lancamentos/lancamento.service';
import { Expense } from './../../core/model';
import { ErrorHandlerService } from './../../core/error-handler.service';
import { CategoriaService } from './../../categorias/categoria.service';
import { Component, OnInit } from '@angular/core';
import { PessoasService } from 'app/pessoas/pessoas.service';
import {FormControl, NgForm} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-lancamento-cadastro',
  templateUrl: './lancamento-cadastro.component.html',
  styleUrls: ['./lancamento-cadastro.component.css']
})
export class LancamentoCadastroComponent implements OnInit {

  tipos = [ {label: 'Receita', value: 'REVENUE'},
            {label: 'Despesa', value: 'EXPENSE'}];

  categorias = [];

  pessoas = [];

  lancamento = new Expense();

  constructor(private categoriaService: CategoriaService,
              private pessoasService: PessoasService,
              private errorHandlerService: ErrorHandlerService,
              private lancamentoService: LancamentoService,
              private toastyService: ToastyService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private title: Title) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params['id'];
    this.title.setTitle("Novo Lançamento")

    if (id) {
      this.carregarLancamento(id);
    }

    this.carregarCategorias();
    this.carregarPessoas();
  }

  atualizarTitle(){
    this.title.setTitle(`Edição de Lançamento: ${this.lancamento.description}`);
  }

  isEditando(): boolean {
    return Boolean(this.lancamento.id);
  }

  carregarLancamento(id: number) {
    this.lancamentoService.buscarPorCodigo(id).then(lancamento => {
      this.lancamento = lancamento;
      this.atualizarTitle();
    }).catch(error => this.errorHandlerService.handle(error));
  }

  carregarCategorias() {
    return this.categoriaService.listarTodas().then( categorias => {
      this.categorias = categorias.map(categoria => {
        return { label: categoria.name, value: categoria.id };
      });
    }).catch(error => this.errorHandlerService.handle(error));
  }

  carregarPessoas() {
    return this.pessoasService.listarTodas().then( pessoas => {
      this.pessoas = pessoas.map(pessoa => {
        return { label: pessoa.name, value: pessoa.id};
      });
    }).catch(error => this.errorHandlerService.handle(error));
  }

  salvar(form: NgForm) {
    if (this.isEditando()) {
      this.atualizarLancamento(form);
    } else {
      this.adicionarLancamento(form);
    }
  }

  atualizarLancamento(form: NgForm) {
    this.lancamentoService.atualizar(this.lancamento).then(lancamento => {
      this.lancamento = lancamento;
      this.atualizarTitle();
      this.toastyService.success('Lancamento atualizado com sucesso!');
      this.router.navigate(['/lancamentos']);
    }).catch(error => this.errorHandlerService.handle(error));
  }

  adicionarLancamento (form: NgForm) {
    this.lancamentoService.adicionar(this.lancamento).then((lancamentoAdicionado) => {
      this.toastyService.success('Lançamento adicionado com sucesso!');
      this.router.navigate(['/lancamentos', lancamentoAdicionado.id]);
    }).catch(error => this.errorHandlerService.handle(error));
  }

  novo(form: NgForm) {
    form.reset();
    this.lancamento = new Expense();
    this.router.navigate(['/lancamentos/novo']);
  }
}
