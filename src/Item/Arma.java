package Item;

import Efeito.Efeito;
import Entidade.Personagem.Classe;

public abstract class Arma extends Item implements BonusRaridade {

    private final SlotArma SLOT_ARMA = SlotArma.ARMA;
    private int dano;

    private int bonus;

    public Arma(String nome, Raridade raridade, int preco, Efeito efeito, int dano, int bonus) {
        super(nome, raridade, preco, efeito);

        this.dano = dano;
        this.bonus = bonus;
    }

    public Arma(String nome, Raridade raridade, double preco, int dano, int bonus) {
        super(nome, raridade, preco);

        this.dano = dano;
        this.bonus = bonus;
    }


    public int getDano() {
        return dano;
    }



    public SlotArma getSLOT() {
        return SLOT_ARMA;
    }

    public int getBonus() {
        return bonus;
    }

    //------------------//


    public void setDano(int dano) {
        this.dano = dano;
    }

    //------------------//
    @Override
    public void aplicarBonusRaridade() {
        this.dano += getRaridade().getBuff();
    }

    public abstract int calcularBonusClasse(Classe classe);
}
