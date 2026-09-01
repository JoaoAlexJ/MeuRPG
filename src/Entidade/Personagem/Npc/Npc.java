package Entidade.Personagem.Npc;

import Entidade.Personagem.Classe;
import Entidade.Personagem.Personagem;
import Entidade.Personagem.Raca;
import Habilidade.Habilidade;

import java.util.ArrayList;
import java.util.List;

public class Npc extends Personagem {

    private List<String> falas;

    public Npc(String nome, int nivel, int manaMaxima, int vidaMaxima, int forca, int inteligencia, int poderMagico, int velocidade,
               int armadura, Raca raca, List<String> falas, Classe classe) {
        super(nome, nivel, manaMaxima, vidaMaxima, forca, inteligencia, poderMagico, velocidade, armadura, raca, classe);

        this.falas = falas;
    }

    public Npc(String nome, int nivel, int manaMaxima, int vidaMaxima, int forca, int inteligencia, int poderMagico, int velocidade,
               int armadura, Raca raca, List<String> falas) {
        super(nome, nivel, manaMaxima, vidaMaxima, forca, inteligencia, poderMagico, velocidade, armadura, raca);

        this.falas = falas;
    }


    public void adicionarFala(String fala){
        if (fala == null || fala.isBlank()) throw new IllegalArgumentException("Fala inválida");

        falas.add(fala);
    }

    public String retornarFala(int posicao){
        if (posicao < 0 || posicao >= falas.size()) throw new IllegalArgumentException("Indice inválido");

        return falas.get(posicao);
    }

    //---------------------//




    public List<String> getFalas() {
        return new ArrayList<>(falas);
    }

    @Override
    public boolean podeAddHabilidade(Habilidade habilidade) {
        if (habilidade.getRequisitoClasse() == null && habilidade.getRequisitoMonstro() == null){
            return true;
        }else if (habilidade.getRequisitoClasse() == getClasse() && habilidade.getRequisitoMonstro() == null){
            return true;
        }

        else return false;
    }
}
