package Entidade;

public enum Classe {

    MAGO{
        @Override
        public void bonusClasse(Entidade entidade) {

            entidade.setPoderMagico(entidade.getPoderMagico() + 15);
            entidade.setInteligencia(entidade.getInteligencia() + 10);
            entidade.setMana(entidade.getMana() + 100);


        }
    },
    GUERREIRO{
        @Override
        public void bonusClasse(Entidade entidade) {

            entidade.setArmadura(entidade.getArmadura() + 10);
            entidade.setVida(entidade.getVida() + 100);
            entidade.setForca(entidade.getForca() + 15);


        }
    },
    ASSASINO{
        @Override
        public void bonusClasse(Entidade entidade) {

            entidade.setVelocidade(entidade.getVelocidade() + 15);
            entidade.setForca(entidade.getForca() + 15);
            entidade.setInteligencia(entidade.getInteligencia() + 10 );

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
