package Batalha;

import Entidade.Entidade;
import Habilidade.Habilidade;
import Relatorio.RelatorioBatalha;

import java.util.List;
import java.util.Random;

public class IAinimiga {

    public RelatorioBatalha agir(Batalha batalha, Entidade inimigo, Entidade alvo){

        Random random = new Random();

        List<Habilidade> habilidadesInimigo = inimigo.getHabilidadesEquipadas().stream()
                .filter(h -> h.getCustoMana() <= inimigo.getManaAtual())
                .toList();

        if (habilidadesInimigo.isEmpty()){

            return batalha.ataqueComum(inimigo, alvo);
        }


        Habilidade habilidade = habilidadesInimigo.get(random.nextInt(habilidadesInimigo.size()));


        if (random.nextInt(2) == 0){

            return batalha.ataqueComum(inimigo, alvo);
        }

        return batalha.ataqueComHabilidade(inimigo, alvo, habilidade);

    }
}
