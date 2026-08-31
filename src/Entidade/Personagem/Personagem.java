package Entidade.Personagem;

import Entidade.Entidade;
import Habilidade.Habilidade;

public abstract class Personagem extends Entidade {

    private Raca raca;
    private Classe classe;

    public Personagem(String nome, int nivel, int manaMaxima, int vidaMaxima, int forca, int inteligencia,
                      int poderMagico, int velocidade, int armadura, Raca raca, Classe classe) {

        super(nome, nivel, manaMaxima, vidaMaxima, forca, inteligencia, poderMagico, velocidade, armadura);


        this.raca = raca;
        this.classe = classe;

        this.raca.bonusAtributo(this);
        this.classe.bonusClasse(this);
    }

    public Personagem(String nome, int nivel, int manaMaxima, int vidaMaxima, int forca, int inteligencia, int poderMagico, int velocidade, int armadura, Raca raca) {
        super(nome, nivel, manaMaxima, vidaMaxima, forca, inteligencia, poderMagico, velocidade, armadura);

        this.raca = raca;
        this.raca.bonusAtributo(this);
    }

    public Raca getRaca() {
        return raca;
    }

    public Classe getClasse() {
        return classe;
    }

    @Override
    public int usarHabilidade(Habilidade habilidade){

        if (getClasse() != null){

            return getClasse().calcularDanoHabilidade(habilidade, this);
        }

        return (int) (habilidade.getDano() + getForca() * 0.20);
    }
}
