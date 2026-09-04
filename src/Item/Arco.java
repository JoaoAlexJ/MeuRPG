package Item;

import Efeito.Efeito;
import Entidade.Personagem.Classe;

public class Arco extends Arma {


    public Arco(String nome, Raridade raridade, int preco, Efeito efeito, int dano, int bonus) {
        super(nome, raridade, preco, efeito, dano, bonus);
    }

    public Arco(String nome, Raridade raridade, double preco, int dano, int bonus) {
        super(nome, raridade, preco, dano, bonus);
    }

    @Override
    public int calcularBonusClasse(Classe classe) {
        if (classe.equals(Classe.ARQUEIRO)){
            setDano((int)(getDano() + getBonus() * 0.05));
            return getBonus();
        }

        return 0;
    }
}
