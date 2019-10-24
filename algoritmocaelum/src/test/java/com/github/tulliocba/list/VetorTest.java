package com.github.tulliocba.list;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VetorTest {
    private Vetor lista;

    @Before
    public void setUp() throws Exception {
        lista = new Vetor();
    }

    @Test
    public void adicionar_no_fim_da_lista() {
        Aluno a1 = new Aluno("João");
        Aluno a2 = new Aluno("Jose");
        this.lista.adiciona(a1);
        this.lista.adiciona(a2);

        assertThat(lista.pega(0)).isEqualTo(a1);
        assertThat(lista.pega(1)).isEqualTo(a2);
    }

    @Test
    public void checar_tamanho_da_lista() {
        int tamanhoDaLista = 20;
        for (int i = 0; i < 20; i++) {
            this.lista.adiciona(new Aluno(String.valueOf(i)));
        }
        assertThat(this.lista.tamanho()).isEqualTo(tamanhoDaLista);
    }

    @Test
    public void checar_se_lista_possui_objeto() {
        Aluno aluno = new Aluno("João");
        this.lista.adiciona(aluno);

        assertThat(this.lista.contem(aluno)).isTrue();
    }

    @Test
    public void obter_objeto_por_posicao() {
        Aluno joao = new Aluno("João");
        this.lista.adiciona(joao);
        Aluno pedro = new Aluno("Pedro");
        this.lista.adiciona(pedro);
        Aluno carlos = new Aluno("Carlos");
        this.lista.adiciona(carlos);
        Aluno jose = new Aluno("Jose");
        this.lista.adiciona(0, jose);

        assertThat(this.lista.pega(0)).isEqualTo(jose);
        assertThat(this.lista.pega(0)).isNotEqualTo(joao);
    }

    @Test
    public void remover_objeto_por_posicao() {
        Aluno joao = new Aluno("João");
        this.lista.adiciona(joao);
        Aluno pedro = new Aluno("Pedro");
        this.lista.adiciona(pedro);
        Aluno marcos = new Aluno("Marcos");
        this.lista.adiciona(marcos);

        this.lista.remove(1);

        assertThat(this.lista.pega(1)).isEqualTo(marcos);
        assertThat(this.lista.tamanho()).isEqualTo(2);
    }
}
