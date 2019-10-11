package com.github.tulliocba.data;

import com.github.tulliocba.object.Aluno;

import java.util.Arrays;

public class Vector {
    private Aluno[] alunos = new Aluno[100];
    private int totalDeAlunos = 0;

    public void adiciona(Aluno aluno) {
        alunos[totalDeAlunos] = aluno;
        totalDeAlunos++;
    }

    public void adiciona(int posicao, Aluno aluno) {
        if (!posicaoValida(posicao)) {
            throw new IllegalArgumentException("Posição Inválida!");
        }

        for (int i = this.totalDeAlunos - 1; i >= posicao; i -= 1) {
            this.alunos[i + 1] = this.alunos[i];
        }
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao <= this.totalDeAlunos;
    }

    public Aluno pega(int posicao) {
        if (!posicaoOcupada(posicao))
            throw new IllegalArgumentException("Posição inválida!");
        return alunos[posicao];
    }

    public void remove(int posicao) {

    }

    public boolean contem(Aluno aluno) {
        for (int i = 0; i < this.totalDeAlunos; i++) {
            if (aluno.equals(alunos[i])) return true;
        }
        return false;
    }

    public int tamanho() {
        return totalDeAlunos;
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.totalDeAlunos;
    }


    @Override
    public String toString() {
        if (totalDeAlunos == 0)
            return "[]";

        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < this.totalDeAlunos - 1; i++) {
            builder.append(alunos[i]);
            builder.append(", ");
        }
        builder.append(this.alunos[this.totalDeAlunos - 1]);
        builder.append("]");
        return builder.toString();
    }
}
