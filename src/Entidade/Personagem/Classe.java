package Entidade.Personagem;

import Entidade.Entidade;
import Habilidade.Habilidade;

public enum Classe {

    MAGO{
        @Override
        public void bonusClasse(Entidade entidade) {

            entidade.setPoderMagico(entidade.getPoderMagico() + 15);
            entidade.setInteligencia(entidade.getInteligencia() + 8);

            entidade.setManaMaxima(entidade.getManaMaxima() + 100);
            entidade.setManaAtual(entidade.getManaAtual() + 100);


        }

        @Override
        public int calcularDanoHabilidade(Habilidade habilidade, Entidade entidade) {
            return (int) (habilidade.getDano() + entidade.getPoderMagico() * 0.85 + entidade.getInteligencia());
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

        @Override
        public int calcularDanoHabilidade(Habilidade habilidade, Entidade entidade) {
            return (int) (habilidade.getDano() + entidade.getForca() + entidade.getArmadura() * 0.38);

        }
    },
    ASSASINO{
        @Override
        public void bonusClasse(Entidade entidade) {

            entidade.setVelocidade(entidade.getVelocidade() + 8);
            entidade.setForca(entidade.getForca() + 15);
            entidade.setInteligencia(entidade.getInteligencia() + 5 );

        }

        @Override
        public int calcularDanoHabilidade(Habilidade habilidade, Entidade entidade) {
            return (int) (habilidade.getDano() + entidade.getForca() * 0.85 + entidade.getVelocidade() * 0.05);
        }
    },
    ARQUEIRO{
        @Override
        public void bonusClasse(Entidade entidade) {

            entidade.setInteligencia(entidade.getInteligencia() + 15 );
            entidade.setPoderMagico(entidade.getPoderMagico() + 8 );
            entidade.setForca(entidade.getForca() + 15);

        }

        @Override
        public int calcularDanoHabilidade(Habilidade habilidade, Entidade entidade) {
            return (int) (habilidade.getDano() + entidade.getForca() * 0.40 + entidade.getInteligencia() * 0.40 + entidade.getVelocidade() * 0.10);

        }
    };


    public abstract void bonusClasse(Entidade entidade);
    public abstract int calcularDanoHabilidade(Habilidade habilidade, Entidade entidade);


}
