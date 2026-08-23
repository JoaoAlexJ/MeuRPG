import java.util.List;

public abstract class Alvos extends Entidade{

    public Alvos(String nome, int nivel, int mana, int vida, int forca, int inteligencia, int poderMagico, int velocidade, int armadura) {
        super(nome, nivel, mana, vida, forca, inteligencia, poderMagico, velocidade, armadura);
    }

    public abstract int reconpensa();


}
