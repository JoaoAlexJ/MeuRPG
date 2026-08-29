package Efeito;

import Entidade.Entidade;

public class Veneno extends EfeitoAtivo {

    private final static int DURACAO = 2;


    public Veneno(Entidade origem, Entidade alvo) {
        super(DURACAO, origem, alvo);
    }

    @Override
    public int execultar() {

        int dano = (int) (getOrigem().getInteligencia() * 0.80 + getOrigem().getPoderMagico() * 0.20);
        getAlvo().receberDanoVerdadeiro(dano);
        diminuirDuracao();

        return dano;
    }


}
