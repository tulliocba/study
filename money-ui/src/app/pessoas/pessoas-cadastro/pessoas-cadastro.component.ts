import {ToastyService} from 'ng2-toasty';
import {ErrorHandlerService} from './../../core/error-handler.service';
import {PessoasService} from 'app/pessoas/pessoas.service';
import {Component, OnInit} from '@angular/core';
import {Addres, Person} from 'app/core/model';
import {NgForm} from '@angular/forms';
import {ActivatedRoute, Router} from "@angular/router";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-pessoas-cadastro',
  templateUrl: './pessoas-cadastro.component.html',
  styleUrls: ['./pessoas-cadastro.component.css']
})
export class PessoasCadastroComponent implements OnInit {

  pessoa = new Person(true);

  constructor(private pessoasService: PessoasService,
              private errorHandlerService: ErrorHandlerService,
              private toastyService: ToastyService,
              private activatedRoute: ActivatedRoute,
              private title: Title,
              private router: Router) { }

  ngOnInit() {
    let id = this.activatedRoute.snapshot.params['id'];
    this.title.setTitle('Nova Pessoa')
    if(id) {
      this.carregarPessoa(id);
    }
  }

  salvar(form: NgForm) {
    if(this.isEditanto()){
      this.atualizarPessoa(form);
    } else {
      this.adicionarPessoa(form);
    }
  }

  private adicionarPessoa(form: NgForm) {
    this.removerMascaraCEP(this.pessoa);
    this.pessoasService.adicionar(this.pessoa).then((pessoa) => {
      this.toastyService.success('Pessoa adicionada com sucesso!');
      this.router.navigate(['/pessoas', pessoa.id]);
    }).catch(error => this.errorHandlerService.handle(error));
  }

  private removerMascaraCEP(pessoa: Person): void {
    let zipcode = pessoa.address.zipcode.replace('-', '');
    pessoa.address.zipcode = zipcode;
  }

  private carregarPessoa(id: number) {
    this.pessoasService.pesquisarPessoaPor(id).then(pessoa => {
      if(!pessoa.address){
        pessoa.address = new Addres();
      }
      this.pessoa = pessoa;
      this.atualizarTitleEdicao();
    }).catch(error => this.errorHandlerService.handle(error));
  }

  isEditanto() {
    return Boolean(this.pessoa.id);
  }

  private atualizarTitleEdicao() {
    this.title.setTitle(`Editando Pessoa ${this.pessoa.name}`);
  }

  private atualizarPessoa(form: NgForm) {
    this.removerMascaraCEP(this.pessoa);
    this.pessoasService.atualizarPessoa(this.pessoa).then(pessoa => {
      this.toastyService.success('Pessoas atualizada com sucesso!');
      this.router.navigate(['/pessoas']);
    }).catch(error => this.errorHandlerService.handle(error));
  }

  novo(form: NgForm){
    form.reset();
    this.pessoa = new Person(true);
    this.router.navigate(['/pessoas', 'novo'])

  }
}
