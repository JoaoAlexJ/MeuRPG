package Entidade.Alvos;

public enum TipoMonstro {

    DRAGAO{
        @Override
        public void bonusMonstro(Monstro monstro) {
            monstro.setForca(monstro.getForca() + 20);
            monstro.setPoderMagico(monstro.getPoderMagico() + 25);
            monstro.setArmadura(monstro.getArmadura() + 15);

            monstro.setVidaMaxima(monstro.getVidaMaxima() + 250);
            monstro.setVidaAtual(monstro.getVidaAtual() + 250);
        }
    },
    GOLEM{
        @Override
        public void bonusMonstro(Monstro monstro) {
            monstro.setArmadura(monstro.getArmadura() + 25);
            monstro.setPoderMagico(monstro.getPoderMagico() + 15);

            monstro.setVidaMaxima(monstro.getVidaMaxima() + 350);
            monstro.setVidaAtual(monstro.getVidaAtual() + 350);
        }
    },
    ARACNIDEO{
        @Override
        public void bonusMonstro(Monstro monstro) {
            monstro.setInteligencia(monstro.getInteligencia() + 15);
            monstro.setManaMaxima(monstro.getManaMaxima() + 100);
            monstro.setManaAtual(monstro.getManaAtual() + 100);
            monstro.setPoderMagico(monstro.getPoderMagico() + 25);

        }
    };

    public abstract void bonusMonstro(Monstro monstro);
}
