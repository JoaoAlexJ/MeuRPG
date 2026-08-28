package Efeito;

import Entidade.Entidade;

public enum Efeito {

    VENENO{
        @Override
        public EfeitoAtivo returnEfeitoAtivo(Efeito efeito, Entidade origem, Entidade alvo) {
            return new Veneno(efeito, origem, alvo);
        }
    };

    public abstract EfeitoAtivo returnEfeitoAtivo(Efeito efeito, Entidade atacante, Entidade alvo);
}
