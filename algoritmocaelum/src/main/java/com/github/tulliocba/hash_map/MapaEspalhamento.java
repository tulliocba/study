package com.github.tulliocba.hash_map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MapaEspalhamento {
    private List<List<Associacao>> tabela = new ArrayList<List<Associacao>>();

    public MapaEspalhamento() {
        for (int i = 0; i < 100; i++) {
            this.tabela.add(new LinkedList<Associacao>());
        }
    }

    private int calculaIndiceDaTabela(String placa) {
        return Math.abs(placa.hashCode()) % this.tabela.size();
    }

    public boolean contemChave(String placa) {
        int indice = calculaIndiceDaTabela(placa);
        List<Associacao> lista = this.tabela.get(indice);
        for (int i = 0; i < lista.size(); i++) {
            Associacao associacao = lista.get(i);
            if (associacao.getPlaca().equals(placa)) {
                return true;
            }
        }
        return false;
    }

    public void remove(String placa) {
        int indice = calculaIndiceDaTabela(placa);
        final List<Associacao> lista = this.tabela.get(indice);
        for (int i = 0; i < lista.size(); i++) {
            Associacao associacao = lista.get(i);
            if (associacao.getPlaca().equals(placa)) {
                lista.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("A chave não existe");
    }

    public void adiciona(String placa, Carro carro) {
        if (this.contemChave(placa)){
            remove(placa);
        }

        final int indice = calculaIndiceDaTabela(placa);
        final List<Associacao> lista = this.tabela.get(indice);
        lista.add(new Associacao(placa, carro));
    }

    public Carro pega(String placa) {
        final int indice = calculaIndiceDaTabela(placa);
        final List<Associacao> lista = this.tabela.get(indice);
        for (int i = 0; i < lista.size(); i++) {
            final Associacao associacao = lista.get(i);
            if (associacao.getPlaca().equals(placa)){
                return associacao.getCarro();
            }
        }
        throw new IllegalArgumentException("A chave não existe");
    }
}
