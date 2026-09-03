package Batalha;

import Entidade.Entidade;
import Habilidade.Habilidade;
import Relatorio.RelatorioBatalha;
import Relatorio.RelatorioEfeito;

import java.util.List;

public class Batalha {

    public RelatorioBatalha ataqueComum(Entidade atacante, Entidade alvo){
        if (!atacante.estaVivo() || !alvo.estaVivo()){
            throw new RuntimeException("As duas entidades precisam estar vivas para batalhar");
        }

        List<RelatorioEfeito> efeitos = atacante.aplicarEfeitos();

        int danoFinal = alvo.receberDano(atacante.atacar());


        return new RelatorioBatalha(atacante, alvo, danoFinal, null, efeitos);
    }



    public RelatorioBatalha ataqueComHabilidade(Entidade atacante, Entidade alvo, Habilidade habilidade){

        if (!atacante.estaVivo() || !alvo.estaVivo()){
            throw new RuntimeException("As duas entidades precisam estar vivas para batalhar");
        }

        List<RelatorioEfeito> efeitos = atacante.aplicarEfeitos();

        int danoFinal = alvo.receberDano(atacante.usarHabilidade(habilidade));

        if (habilidade.getEfeito() != null){
            alvo.adicionarEfeito(habilidade.getEfeito().returnEfeitoAtivo(atacante, alvo));
        }

        return new RelatorioBatalha(atacante, alvo, danoFinal, habilidade, efeitos);

    }
}
