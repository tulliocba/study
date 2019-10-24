package com.github.tulliocba.stack;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PilhaTest {

    @Test
    public void adiciona_elemento_na_pilha_test() {
        Pilha pilha = new Pilha();

        pilha.insere(new Peca("Peça 01"));

        assertThat(pilha.vazia()).isFalse();
    }

    @Test
    public void remove_elemento_da_pilha_test() {
        Pilha pilha = new Pilha();

        pilha.insere(new Peca("Peca 01"));
        assertThat(pilha.vazia()).isFalse();

        pilha.remove();
        assertThat(pilha.vazia()).isTrue();
    }

    @Test
    public void checa_se_a_pilha_esta_vazia_test() {
        Pilha pilha = new Pilha();
        pilha.insere(new Peca("Peca 01"));
        assertThat(pilha.vazia()).isFalse();
        pilha.remove();
        assertThat(pilha.vazia()).isTrue();
    }
}
