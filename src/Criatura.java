public abstract class Criatura extends Alvos{

    private Raca raca;

    public Criatura(String nome, int nivel, int mana, int vida, int forca, int inteligencia, int poderMagico, int velocidade, int armadura, Raca raca) {
        super(nome, nivel, mana, vida, forca, inteligencia, poderMagico, velocidade, armadura);

        this.raca = raca;
    }



    public Raca getRaca() {
        return raca;
    }
}
