package Efeito;

import Entidade.Entidade;

public class Veneno extends Efeito{

    public Veneno(int duracao, int dano) {
        super(duracao, dano);
    }

    @Override
    public void execultar() {

        int dano = (int) (getOrigem().getInteligencia() * 0.80 + getOrigem().getPoderMagico() * 0.20);
        diminuirDuracao();
        getAlvo().receberDanoVerdadeiro(dano);

    }


}
