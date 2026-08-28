package Efeito;

import Entidade.Entidade;

public class Veneno extends EfeitoAtivo {

    private final static int DURACAO = 2;


    public Veneno(Efeito efeito, Entidade origem, Entidade alvo) {
        super(efeito, DURACAO, origem, alvo);
    }

    @Override
    public void execultar() {

        int dano = (int) (getOrigem().getInteligencia() * 0.80 + getOrigem().getPoderMagico() * 0.20);
        getAlvo().receberDanoVerdadeiro(dano);
        diminuirDuracao();

    }


}
