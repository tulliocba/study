package com.github.tulliocba.hash_map;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MapaEspalhamentoTest {
    @Test
    public void adiciona_no_mapa_test() {
        MapaEspalhamento mapa = new MapaEspalhamento();
        mapa.adiciona("1234", new Carro("carro1"));
        assertThat(mapa.contemChave("1234")).isTrue();
    }

    @Test
    public void remove_do_mapa_test() {
        MapaEspalhamento mapa = new MapaEspalhamento();
        mapa.adiciona("1234", new Carro("carro1"));
        mapa.adiciona("12345", new Carro("carro2"));
        mapa.remove("1234");
        assertThat(mapa.contemChave("1234")).isFalse();
        assertThat(mapa.contemChave("12345")).isTrue();
    }

    @Test
    public void recupera_do_mapa_test() {
        final MapaEspalhamento mapa = new MapaEspalhamento();
        final Carro carro1 = new Carro("carro1");
        mapa.adiciona("123", carro1);
        final Carro carro2 = new Carro("carro2");
        mapa.adiciona("1234", carro2);
        assertThat(mapa.pega("123")).isEqualTo(carro1);
    }
}
