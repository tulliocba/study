package com.github.tulliocba.stack;

import lombok.Data;

@Data
class Peca {
    private String nome;

    public Peca(String nome) {
        this.nome = nome;
    }
}
