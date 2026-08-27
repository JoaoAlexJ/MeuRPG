package Efeito;

import Entidade.Entidade;

public class Veneno extends Efeito{

    public Veneno(int duracao, Entidade origem, Entidade alvo) {
        super(duracao, origem, alvo);
    }

    @Override
    public void execultar() {

        int dano = (int) (getOrigem().getInteligencia() * 0.80 + getOrigem().getPoderMagico() * 0.20);
        getAlvo().receberDanoVerdadeiro(dano);
        diminuirDuracao();

    }


}
