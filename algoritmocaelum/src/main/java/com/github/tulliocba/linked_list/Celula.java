package com.github.tulliocba.linked_list;

import lombok.Getter;
import lombok.Setter;


class Celula {
    @Getter @Setter
    private Celula proximo;
    @Getter @Setter
    private Celula anterior;
    @Getter
    private Object elemento;


    public Celula(Celula proximo, Object elemento) {
        this.proximo = proximo;
        this.elemento = elemento;
    }

    public Celula(Object elemento) {
        this.elemento = elemento;
    }
}
