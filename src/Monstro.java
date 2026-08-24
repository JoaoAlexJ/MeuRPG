public abstract class Monstro extends Alvos{

    public Monstro(String nome, int nivel, int mana, int vida, int forca, int inteligencia, int poderMagico, int velocidade, int armadura) {
        super(nome, nivel, mana, vida, forca, inteligencia, poderMagico, velocidade, armadura);
    }

    public abstract void bonusMonstro();
}
