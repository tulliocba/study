package com.github.tulliocba.hash_table;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class ConjuntoEspelhamento {
    private ArrayList<LinkedList<String>> tabela = new ArrayList<LinkedList<String>>();
    private int tamanho = 0;
    private static final int TAMANHO_MINIMO = 10;

    public ConjuntoEspelhamento() {
        for (int i = 0; i < 26; i++) tabela.add(new LinkedList<String>());
    }

    private int calculaIndiceDaTabela(String palavra) {
        int codigoEspelhamento = Math.abs(this.calculaCodigoDeEspelhamento(palavra));
        return codigoEspelhamento % this.tabela.size();
    }

    private void redimencionarTabela(int novaCapacidade) {
        List<String> palavras = this.pegaTodas();
        this.tabela.clear();

        for (int i = 0; i < novaCapacidade; i++) {
            this.tabela.add(new LinkedList<String>());
        }

        for (String palavra : palavras) {
            this.adiciona(palavra);
        }
    }

    private void verificarCarga() {
        int capacidade = this.tabela.size();
        double carga = (double) this.tamanho / capacidade;
        if (capacidade > TAMANHO_MINIMO) {
            if (carga > 0.75) {
                this.redimencionarTabela(capacidade * 2);
            } else if (carga < 0.25) {
                this.redimencionarTabela(Math.max(capacidade / 2, TAMANHO_MINIMO));
            }
        }
    }

    private int calculaCodigoDeEspelhamento(String palavra) {
        int codigo = 1;
        for (int i = 0; i < palavra.length(); i++) {
            codigo = 31 * codigo + palavra.charAt(i);
        }
        return codigo;
    }

    private boolean contem(String palavra) {
        int indice = calculaIndiceDaTabela(palavra);
        LinkedList<String> lista = this.tabela.get(indice);
        return lista.contains(palavra);
    }

    public void adiciona(String palavra) {
        if (!contem(palavra)) {
            this.verificarCarga();
            int indice = calculaIndiceDaTabela(palavra);
            if(this.pegaTodas().isEmpty()) this.tamanho = 0;
            this.tabela.get(indice).add(palavra);
            this.tamanho++;
        }
    }

    public void remove(String palavra) {
        if (this.contem(palavra)) {
            this.verificarCarga();
            int indice = calculaIndiceDaTabela(palavra);
            LinkedList<String> lista = this.tabela.get(indice);
            lista.remove(palavra);
            this.tamanho--;
        }
    }

    public List<String> pegaTodas() {
        List<String> palavras = new LinkedList<>();
        for (List<String> lista : this.tabela) {
            palavras.addAll(lista);
        }
        return palavras;
    }

    public int tamanho() {
        return this.tamanho;
    }
}
