package com.github.tulliocba.linked_list;

class ListaLigada {
    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos;

    public void adiciona(Object elemento) {
        if (this.totalDeElementos == 0) {
            this.adicionaNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento);
            this.ultima.setProximo(nova);
            nova.setAnterior(this.ultima);
            this.ultima = nova;
            this.totalDeElementos++;
        }
    }

    public void adiciona(int posicao, Object elemento) {
        if (posicao == 0) {
            this.adicionaNoComeco(elemento);
        } else if (posicao == this.totalDeElementos) {
            this.adiciona(elemento);
        } else {
            Celula anterior = pegaCelula(posicao - 1);
            Celula proximo = anterior.getProximo();
            Celula nova = new Celula(anterior.getProximo(), elemento);
            nova.setAnterior(anterior);
            anterior.setProximo(nova);
            proximo.setAnterior(nova);
            this.totalDeElementos++;
        }
    }

    public Object pega(int posicao) {
        return this.pegaCelula(posicao).getElemento();
    }

    public void remove(int posicao) {
        if (!this.posicaoOcupada(posicao)) throw new IllegalArgumentException("Posição não Existe");

        if (posicao == 0) {
            this.removeDoComeco();
        } else if (posicao == this.totalDeElementos - 1) {
            this.removeDoFim();
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula atual = anterior.getProximo();
            Celula proximo = atual.getProximo();
            anterior.setProximo(proximo);
            proximo.setAnterior(anterior);
            this.totalDeElementos--;
        }
    }

    public int tamanho() {
        return totalDeElementos;
    }

    public boolean contem(Object elemento) {
        Celula atual = primeira;
        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    public void adicionaNoComeco(Object elemento) {
        if (this.totalDeElementos == 0) {
            Celula nova = new Celula(elemento);
            this.primeira = nova;
            this.ultima = nova;
        } else {
            Celula nova = new Celula(this.primeira, elemento);// linko a primeira celula como próxima da nova celula
            this.primeira.setAnterior(nova);//linko a nova celula como anterior da primeira
            //ou seja, troco as posições
            this.primeira = nova; // Na lista ligada eu defino a primeira como a nova celula e mantenho a ultima.
        }
        this.totalDeElementos++;
    }

    public void removeDoComeco() {
        if (!this.posicaoOcupada(0)) throw new IllegalArgumentException("Posição não existe");

        this.primeira = this.primeira.getProximo();
        this.totalDeElementos--;
        if (this.totalDeElementos == 0) {
            this.ultima = null;
        }
    }

    public void removeDoFim() {
        if (!this.posicaoOcupada(totalDeElementos - 1)) throw new IllegalArgumentException("Posição não existe.");

        if (this.totalDeElementos == 1) {
            this.removeDoComeco();
        } else {
            Celula pnultima = this.ultima.getAnterior();
            pnultima.setProximo(null);
            this.ultima = pnultima;
            totalDeElementos--;
        }
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.totalDeElementos;
    }

    private Celula pegaCelula(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe.");
        }
        Celula atual = primeira;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    @Override
    public String toString() {
        if (this.totalDeElementos == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Celula atual = primeira;

        for (int i = 0; i < this.totalDeElementos - 1; i++) {
            sb.append(atual.getElemento());
            sb.append(", ");
            atual = atual.getProximo();
        }

        sb.append(atual.getElemento());
        sb.append("]");
        return sb.toString();
    }
}

