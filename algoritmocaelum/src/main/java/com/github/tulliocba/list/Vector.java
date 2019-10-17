package com.github.tulliocba.list;

public class Vector {
    private Aluno[] alunos = new Aluno[100];
    private int totalDeAlunos = 0;

    public void adiciona(Aluno aluno) {
        this.garantaEspaco();
        alunos[totalDeAlunos] = aluno;
        totalDeAlunos++;
    }

    public void adiciona(int posicao, Aluno aluno) {
        this.garantaEspaco();
        if (!posicaoValida(posicao)) {
            throw new IllegalArgumentException("Posição Inválida!");
        }
        for (int i = this.totalDeAlunos - 1; i >= posicao; i--) {
            this.alunos[i + 1] = this.alunos[i];
        }
        this.alunos[posicao] = aluno;
        this.totalDeAlunos++;
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
        if (!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posiçao Inválida!");
        }

        for (int i = posicao; i < this.totalDeAlunos - 1; i++) {
            this.alunos[i] = this.alunos[i + 1];
        }
        this.totalDeAlunos--;
        this.alunos[totalDeAlunos] = null;
    }

    private void garantaEspaco() {
        if(this.totalDeAlunos == this.alunos.length) {
            Aluno[] novoArray = new Aluno[this.alunos.length * 2];
            for (int i = 0; i < this.alunos.length; i++) {
                novoArray[i] = this.alunos[i];
            }
            this.alunos = novoArray;
        }
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
