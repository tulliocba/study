package com.github.tulliocba.queue;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FilaTest {
    @Test
    public void insere_elemento_na_fila_test() {
        Fila fila = new Fila();
        fila.insere(new Aluno("Aluno 1"));
        assertThat(fila.vazia()).isFalse();
    }

    @Test
    public void remove_elemento_da_fila_test() {
        Fila fila = new Fila();
        fila.insere(new Aluno("Aluno 01"));
        fila.remove();
        assertThat(fila.vazia()).isTrue();
    }

    @Test
    public void checa_se_fila_esta_vazia_test() {
        Fila fila = new Fila();
        fila.insere(new Aluno("Teste"));
        assertThat(fila.vazia()).isFalse();
        fila.remove();
        assertThat(fila.vazia()).isTrue();
    }
}
