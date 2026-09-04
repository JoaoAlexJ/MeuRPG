package Item;

import Efeito.Efeito;
import Entidade.Personagem.Classe;

public class EspadaPesada extends Arma{


    public EspadaPesada(String nome, Raridade raridade, int preco, Efeito efeito, int dano, int bonus) {
        super(nome, raridade, preco, efeito, dano, bonus);
    }

    public EspadaPesada(String nome, Raridade raridade, double preco, int dano, int bonus) {
        super(nome, raridade, preco, dano, bonus);
    }

    @Override
    public int calcularBonusClasse(Classe classe) {
        if (classe.equals(Classe.GUERREIRO)){
            setDano((int) (getDano() + getBonus() * 0.05));
            return getBonus();
        }


        return 0;
    }
}
