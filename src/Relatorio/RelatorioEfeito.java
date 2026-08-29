package Relatorio;

import Entidade.Entidade;

public record RelatorioEfeito(String nomeEfeito, Entidade origem, Entidade alvo, int dano ) {

}
