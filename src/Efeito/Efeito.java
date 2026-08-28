package Efeito;

import Entidade.Entidade;

public enum Efeito {

    VENENO{
        @Override
        public EfeitoAtivo returnEfeitoAtivo(Entidade origem, Entidade alvo) {
            return new Veneno(origem, alvo);
        }
    };

    public abstract EfeitoAtivo returnEfeitoAtivo(Entidade atacante, Entidade alvo);
}
