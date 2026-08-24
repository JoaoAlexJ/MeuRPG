public enum Raca {

    HUMANO{
        @Override
        public void bonusAtributo(Entidade entidade) {

           //Humano escala todos os atributos menos pdm, porem, em pouco quantidade

            entidade.setForca(+10);
            entidade.setMana(+100);
            entidade.setArmadura(+10);
            entidade.setVida(+100);
            entidade.setInteligencia(+30);
            entidade.setVelocidade(+10);
        }
    },
    ELFO{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setPoderMagico(+30);
            entidade.setMana(+250);
            entidade.setInteligencia(+20);


        }
    },
    ANAO{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setInteligencia(+30);
            entidade.setArmadura(+20);
            entidade.setForca(+15);

        }
    },
    FADA{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setMana(+100);
            entidade.setPoderMagico(+40);

        }
    },
    ORC{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setVida(+200);
            entidade.setArmadura(+30);
            entidade.setForca(+20);

        }
    },
    MARINHO{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setVelocidade(+20);
            entidade.setMana(+220);
            entidade.setInteligencia(+40);
            entidade.setPoderMagico(+25);

        }
    },
    GOBLIM{
        @Override
        public void bonusAtributo(Entidade entidade) {

            entidade.setVelocidade(+15);
            entidade.setForca(+15);
            entidade.setPoderMagico(+15);

        }
    };

    public abstract void bonusAtributo(Entidade entidade);



}
