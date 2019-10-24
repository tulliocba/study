package com.github.tulliocba.stack;

import java.util.LinkedList;
import java.util.List;

class Pilha {
    private List<Peca> pecas = new LinkedList<>();

    public void insere(Peca peca) {
        this.pecas.add(peca);
    }

    public void remove(){
        this.pecas.remove(this.pecas.size() -1);
    }

    public boolean vazia() {
    return this.pecas.size() == 0;
    }
}
