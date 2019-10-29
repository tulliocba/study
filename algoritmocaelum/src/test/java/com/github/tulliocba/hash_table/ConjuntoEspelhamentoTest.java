package com.github.tulliocba.hash_table;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConjuntoEspelhamentoTest {
    @Test
    public void adiciona_no_conjunto() {
        ConjuntoEspelhamento conjunto = new ConjuntoEspelhamento();
        conjunto.adiciona("teste");
        conjunto.adiciona("teste");
        assertThat(conjunto.tamanho()).isEqualTo(1);
    }

    @Test
    public void remove_do_conjunto() {
        ConjuntoEspelhamento conjunto = new ConjuntoEspelhamento();
        for (int i = 0; i < 50; i++) conjunto.adiciona("teste"+i);
        assertThat(conjunto.tamanho()).isEqualTo(50);

        for (int i = 0; i < 30; i++) conjunto.remove("teste"+i);
        assertThat(conjunto.tamanho()).isEqualTo(20);
    }
}
