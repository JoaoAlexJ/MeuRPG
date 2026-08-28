package Batalha;

import Efeito.EfeitoAtivo;
import Entidade.Entidade;
import Habilidade.Habilidade;
import Relatorio.RelatoriodeBatalha;

public class Batalha {

    public RelatoriodeBatalha ataqueComum(Entidade atacante, Entidade alvo){
        if (!atacante.estaVivo() || !alvo.estaVivo()){
            throw new RuntimeException("As duas entidades precisam estar vivas para batalhar");
        }

        alvo.aplicarEfeitos();

        int danoFinal = alvo.receberDano(atacante.atacar());


        return new RelatoriodeBatalha(atacante, alvo, danoFinal, null);
    }



    public RelatoriodeBatalha ataqueComHabilidade(Entidade atacante, Entidade alvo, Habilidade habilidade){

        if (!atacante.estaVivo() || !alvo.estaVivo()){
            throw new RuntimeException("As duas entidades precisam estar vivas para batalhar");
        }

        alvo.aplicarEfeitos();

        int danoFinal = alvo.receberDano(atacante.usarHabilidade(habilidade));

        if (habilidade.getEfeito() != null){
            alvo.adicionarEfeito(habilidade.getEfeito().returnEfeitoAtivo(atacante, alvo));
        }

        return new RelatoriodeBatalha(atacante, alvo, danoFinal, habilidade);

    }
}
