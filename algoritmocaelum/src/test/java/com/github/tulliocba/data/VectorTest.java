package com.github.tulliocba.data;

import com.github.tulliocba.object.Aluno;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VectorTest {
    private Vector lista;

    @Before
    public void setUp() throws Exception {
        lista = new Vector();
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
        this.lista.adiciona(1, carlos);

        assertThat(this.lista.pega(1)).isEqualTo(carlos);
        assertThat(this.lista.pega(1)).isNotEqualTo(pedro);
    }
}
