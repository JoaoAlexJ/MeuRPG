package Item;

public abstract class Item {

    private String nome;
    private Raridade raridade;
    private double preco;

    public Item(String nome, Raridade raridade, int preco) {
        this.nome = nome;
        this.raridade = raridade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Raridade getRaridade() {
        return raridade;
    }

    public double getPreco() {
        return preco;
    }

    //--------------------//


    public void setPreco(double preco) {
        if (preco < 0)throw new IllegalArgumentException("Preço inválido");

        this.preco = preco;
    }
}
