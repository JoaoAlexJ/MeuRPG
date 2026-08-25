package Entidade.Jogador;

import Entidade.Entidade;

public enum Raca {

    HUMANO{
        @Override
        public void bonusAtributo(Entidade entidade) {

           //Humano escala todos os atributos menos pdm, porem, em pouco quantidade

            entidade.setForca(entidade.getForca() +10);
            entidade.setMana(entidade.getMana() +100);
            entidade.setArmadura(entidade.getArmadura() +10);
            entidade.setVida(entidade.getVida() +100);
            entidade.setInteligencia(entidade.getInteligencia() + 30);
            entidade.setVelocidade(entidade.getVelocidade() + 10);
        }
    },
    ELFO{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setPoderMagico(entidade.getPoderMagico() + 30);
            entidade.setMana(entidade.getMana() + 250);
            entidade.setInteligencia(entidade.getInteligencia() +20);


        }
    },
    ANAO{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setInteligencia(entidade.getInteligencia() +30);
            entidade.setArmadura(entidade.getArmadura() +20);
            entidade.setForca(entidade.getForca() +15);

        }
    },
    FADA{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setMana(entidade.getMana() +100);
            entidade.setPoderMagico(entidade.getPoderMagico() +40);

        }
    },
    ORC{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setVida(entidade.getVida() +200);
            entidade.setArmadura(entidade.getArmadura() +30);
            entidade.setForca(entidade.getForca() +20);

        }
    },
    MARINHO{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setMana(entidade.getMana() +220);
            entidade.setInteligencia(entidade.getInteligencia() +40);
            entidade.setPoderMagico(entidade.getPoderMagico() +25);

        }
    },

    //-----------------//

    GOBLIM{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setVelocidade(entidade.getVelocidade() +15);
            entidade.setForca(entidade.getForca() +15);
            entidade.setPoderMagico(entidade.getPoderMagico() + 15);

        }
    },

    DRAGAO{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setArmadura(entidade.getArmadura() + 25);
            entidade.setPoderMagico(entidade.getPoderMagico() + 45);
            entidade.setForca(entidade.getForca() + 25);
            entidade.setVida(entidade.getVida() + 300);


        }
    },

    ARACNIDEO{
        @Override
        public void bonusAtributo(Entidade entidade) {
            entidade.setInteligencia(entidade.getInteligencia() + 25);
            entidade.setPoderMagico(entidade.getPoderMagico() + 15);
            entidade.setVelocidade(entidade.getVelocidade() + 5);


        }
    },

    GOLEM{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setArmadura(entidade.getArmadura() + 25);
            entidade.setVida(entidade.getVida() + 350);
            entidade.setPoderMagico(entidade.getPoderMagico() + 20);


        }
    };

    public abstract void bonusAtributo(Entidade entidade);



}
