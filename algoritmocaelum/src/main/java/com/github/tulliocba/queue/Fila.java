package com.github.tulliocba.queue;

import java.util.LinkedList;
import java.util.List;

public class Fila {
    List<Aluno> alunos = new LinkedList<>();

    public void insere(Aluno aluno) {
        this.alunos.add(aluno);
    }
    public void remove() {
        this.alunos.remove(0);
    }

    public boolean vazia() {
        return this.alunos.size() == 0;
    }
}
