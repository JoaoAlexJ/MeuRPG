package Relatorio;

import Entidade.Entidade;
import Habilidade.Habilidade;

import java.util.List;

public record RelatorioBatalha(Entidade atacante, Entidade alvo, int dano, Habilidade habilidade, List<RelatorioEfeito> efeitos ) {
}
