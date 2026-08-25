package Entidade;

import Entidade.Jogador.Raca;
import Habilidade.Habilidade;

import java.util.ArrayList;
import java.util.List;

public class Npc extends Entidade {

    private Raca raca;
    List<String> falas;
    private Classe classe;

    public Npc(String nome, int nivel, int mana, int vida, int forca,
               int inteligencia, int poderMagico, int velocidade, int armadura, Raca raca, List<String> falas) {

        super(nome, nivel, mana, vida, forca, inteligencia, poderMagico, velocidade, armadura);


        this.raca = raca;
        this.falas = falas;
        this.raca.bonusAtributo(this);

    }

    public Npc(String nome, int nivel, int mana, int vida, int forca,
               int inteligencia, int poderMagico, int velocidade, int armadura, Raca raca, List<String> falas, Classe classe) {

        super(nome, nivel, mana, vida, forca, inteligencia, poderMagico, velocidade, armadura);


        this.raca = raca;
        this.classe = classe;
        this.falas = falas;

        this.raca.bonusAtributo(this);

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

    public Classe getClasse() {
        return classe;
    }

    @Override
    public boolean podeAddHabilidade(Habilidade habilidade) {
        if (habilidade.getRequisitoClasse() == null && habilidade.getRequisitoMonstro() == null){
            return true;
        }else if (habilidade.getRequisitoClasse() == this.classe && habilidade.getRequisitoMonstro() == null){
            return true;
        }

        else return false;
    }
}
