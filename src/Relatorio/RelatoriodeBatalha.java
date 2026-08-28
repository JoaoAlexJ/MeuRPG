package Relatorio;

import Entidade.Entidade;
import Habilidade.Habilidade;

public class RelatoriodeBatalha {

    private Entidade atacante;
    private Entidade alvo;
    private int dano;
    private Habilidade habilidade;

    public RelatoriodeBatalha(Entidade atacante, Entidade alvo, int dano, Habilidade habilidade) {
        this.atacante = atacante;
        this.alvo = alvo;
        this.dano = dano;
        this.habilidade = habilidade;
    }

    public Entidade getAtacante() {
        return atacante;
    }

    public Entidade getAlvo() {
        return alvo;
    }

    public int getDano() {
        return dano;
    }

    public Habilidade getHabilidade() {
        return habilidade;
    }
}
