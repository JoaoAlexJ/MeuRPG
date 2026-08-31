package Entidade;

public enum Classe {

    MAGO{
        @Override
        public void bonusClasse(Entidade entidade) {

            entidade.setPoderMagico(entidade.getPoderMagico() + 15);
            entidade.setInteligencia(entidade.getInteligencia() + 8);

            entidade.setManaMaxima(entidade.getManaMaxima() + 100);
            entidade.setManaAtual(entidade.getManaAtual() + 100);


        }
    },
    GUERREIRO{
        @Override
        public void bonusClasse(Entidade entidade) {

            entidade.setArmadura(entidade.getArmadura() + 7);

            entidade.setVidaMaxima(entidade.getVidaMaxima() + 100);
            entidade.setVidaAtual(entidade.getVidaAtual() + 100);

            entidade.setForca(entidade.getForca() + 15);


        }
    },
    ASSASINO{
        @Override
        public void bonusClasse(Entidade entidade) {

            entidade.setVelocidade(entidade.getVelocidade() + 8);
            entidade.setForca(entidade.getForca() + 15);
            entidade.setInteligencia(entidade.getInteligencia() + 5 );

        }
    },
    ARQUEIRO{
        @Override
        public void bonusClasse(Entidade entidade) {

            entidade.setInteligencia(entidade.getInteligencia() + 15 );
            entidade.setPoderMagico(entidade.getPoderMagico() + 8 );
            entidade.setForca(entidade.getForca() + 15);

        }
    };


    public abstract void bonusClasse(Entidade entidade);



}
