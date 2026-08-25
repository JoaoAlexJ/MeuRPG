package Entidade;

import Entidade.Jogador.Raca;

import java.util.ArrayList;
import java.util.List;

public class Npc extends Entidade {

    private Raca raca;
    List<String> falas;

    public Npc(String nome, int nivel, int mana, int vida, int forca,
               int inteligencia, int poderMagico, int velocidade, int armadura, Raca raca, List<String> falas) {

        super(nome, nivel, mana, vida, forca, inteligencia, poderMagico, velocidade, armadura);


        this.raca = raca;
        this.falas = falas;

    }


    public void adicionarFala(String fala){
        if (fala == null || fala.isBlank()) throw new IllegalArgumentException("Fala inválida");

        falas.add(fala);
    }

    public String retornarFala(int posicao){
        if (posicao < 0) throw new IllegalArgumentException("Indice inválido");

        return falas.get(posicao);
    }

    //---------------------//


    public Raca getRaca() {
        return raca;
    }

    public List<String> getFalas() {
        return new ArrayList<>(falas);
    }
}
