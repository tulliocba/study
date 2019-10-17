package com.github.tulliocba.linked_list;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ListaLigadaTest {

    @Test
    public void adicionar_no_comeco_da_lista_test() {
        ListaLigada lista = new ListaLigada();
        String joao = "João";
        lista.adicionaNoComeco(joao);
        String pedro = "Pedro";
        lista.adiciona(pedro);
        String carlos = "Carlos";
        lista.adiciona(carlos);
        assertThat(lista.pega(0)).isEqualTo(joao);
        assertThat(lista.tamanho()).isEqualTo(3);
    }

    @Test
    public void adicionar_no_final_da_lista_test() {
        ListaLigada lista = new ListaLigada();
        String joao = "João";
        lista.adiciona(joao);
        String carlos = "Carlos";
        lista.adiciona(carlos);
        assertThat(lista.pega(1)).isEqualTo(carlos);
        assertThat(lista.pega(1)).isNotEqualTo(joao);
        assertThat(lista.tamanho()).isEqualTo(2);
    }

    @Test
    public void adicionar_elemento_em_qualquer_ponto_da_lista_test() {
        ListaLigada lista = new ListaLigada();
        String joao = "João";
        lista.adiciona(joao);
        String carlos = "Carlos";
        lista.adiciona(carlos);
        String jose = "José";
        lista.adiciona(1, jose);
        assertThat(lista.tamanho()).isEqualTo(3);
        assertThat(lista.pega(0)).isEqualTo(joao);
        assertThat(lista.pega(1)).isNotEqualTo(carlos);
        assertThat(lista.pega(1)).isEqualTo(jose);
    }

    @Test
    public void pegar_elemento_da_lista_por_posicao_test() {
        ListaLigada lista = new ListaLigada();
        String abel = "Abel";
        lista.adiciona(abel);
        String manoel = "Manoel";
        lista.adiciona(manoel);
        assertThat(lista.pega(1)).isEqualTo(manoel);
    }

    @Test
    public void remover_elemento_do_comeco_da_lista_test() {
        ListaLigada lista = new ListaLigada();
        String pedro = "Pedro";
        lista.adiciona(pedro);
        String carlos = "Carlos";
        lista.adiciona(carlos);
        lista.removeDoComeco();
        assertThat(lista.tamanho()).isEqualTo(1);
        assertThat(lista.pega(0)).isEqualTo(carlos);
        lista.removeDoComeco();
        assertThat(lista.tamanho()).isEqualTo(0);
    }

    @Test
    public void remover_elemento_do_fim_da_lista_test() {
        ListaLigada lista = new ListaLigada();
        String carlos = "Carlos";
        lista.adiciona(carlos);
        String pedro = "Pedro";
        lista.adiciona(pedro);
        lista.removeDoFim();
        assertThat(lista.tamanho()).isEqualTo(1);
        assertThat(lista.pega(0)).isEqualTo(carlos);
        lista.removeDoFim();
        assertThat(lista.tamanho()).isEqualTo(0);
    }

    @Test
    public void remover_elemento_por_posicao() {
        ListaLigada lista = new ListaLigada();
        String carlos = "Carlos";
        lista.adiciona(carlos);
        String manoel = "Manoel";
        lista.adiciona(manoel);
        String joel = "Joel";
        lista.adiciona(joel);
        lista.remove(0);
        assertThat(lista.tamanho()).isEqualTo(2);
        assertThat(lista.pega(0)).isEqualTo(manoel);
    }

    @Test
    public void verificar_se_lista_contem_elemento_test() {
        ListaLigada lista = new ListaLigada();
        String carlos = "Carlos";
        lista.adiciona(carlos);
        String joel = "Joel";
        lista.adiciona(joel);
        String pedro = "Pedro";
        lista.adiciona(pedro);
        assertThat(lista.contem(pedro)).isTrue();
    }
}
