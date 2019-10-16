package com.github.tulliocba.list;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
class Aluno {
    private String nome;

    Aluno(String nome) {
        this.nome = nome;
    }
    Aluno() {}
}
