package Entidade.Jogador;

import Entidade.Entidade;

public enum Raca {

    HUMANO{
        @Override
        public void bonusAtributo(Entidade entidade) {

           //Humano escala todos os atributos menos pdm, porem, em pouco quantidade

            entidade.setForca(entidade.getForca() +10);

            entidade.setManaMaxima(entidade.getManaMaxima() +100);
            entidade.setManaAtual(entidade.getManaAtual() +100);

            entidade.setArmadura(entidade.getArmadura() +10);

            entidade.setVidaMaxima(entidade.getVidaMaxima() +100);
            entidade.setVidaAtual(entidade.getVidaAtual() +100);

            entidade.setInteligencia(entidade.getInteligencia() + 30);
            entidade.setVelocidade(entidade.getVelocidade() + 10);
        }
    },
    ELFO{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setPoderMagico(entidade.getPoderMagico() + 30);

            entidade.setManaMaxima(entidade.getManaMaxima() + 250);
            entidade.setManaAtual(entidade.getManaAtual() + 250);

            entidade.setInteligencia(entidade.getInteligencia() +20);


        }
    },
    ANAO{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setInteligencia(entidade.getInteligencia() +20);
            entidade.setArmadura(entidade.getArmadura() +20);
            entidade.setForca(entidade.getForca() +15);

        }
    },
    FADA{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setManaMaxima(entidade.getManaMaxima() +100);
            entidade.setManaAtual(entidade.getManaAtual() +100);

            entidade.setPoderMagico(entidade.getPoderMagico() +40);

        }
    },
    ORC{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setVidaMaxima(entidade.getVidaMaxima() +200);
            entidade.setVidaAtual(entidade.getVidaAtual() +200);

            entidade.setArmadura(entidade.getArmadura() +20);
            entidade.setForca(entidade.getForca() +15);

        }
    },
    MARINHO{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setManaMaxima(entidade.getManaMaxima() +150);
            entidade.setManaAtual(entidade.getManaAtual() +150);

            entidade.setInteligencia(entidade.getInteligencia() +15);
            entidade.setPoderMagico(entidade.getPoderMagico() + 20);

        }
    },


    GOBLIM{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setVelocidade(entidade.getVelocidade() +5);
            entidade.setForca(entidade.getForca() +5);
            entidade.setPoderMagico(entidade.getPoderMagico() + 5);

        }
    };

    //-----------------//

    public abstract void bonusAtributo(Entidade entidade);



}
