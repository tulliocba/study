package com.github.tulliocba.object;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class Aluno {
    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }
    public Aluno() {
    }
}
