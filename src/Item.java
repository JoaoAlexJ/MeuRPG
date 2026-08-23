public abstract class Item {

    private String nome;
    private Raridade raridade;
    private int preco;

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

    public int getPreco() {
        return preco;
    }
}
