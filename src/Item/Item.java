package Item;

import Efeito.Efeito;

public abstract class Item {

    private String nome;
    private Raridade raridade;
    private double preco;
    private Efeito efeito;


    public Item(String nome, Raridade raridade, int preco, Efeito efeito) {
        this.nome = nome;
        this.raridade = raridade;
        this.preco = preco;
        this.efeito = efeito;
    }

    public Item(String nome, Raridade raridade, double preco) {
        this.nome = nome;
        this.raridade = raridade;
        this.preco = preco;
    }


    //-----------------------//


    public String getNome() {
        return nome;
    }

    public Raridade getRaridade() {
        return raridade;
    }

    public double getPreco() {
        return preco;
    }

    public Efeito getEfeito() {
        return efeito;
    }

    //--------------------//


    public void setPreco(double preco) {
        if (preco < 0)throw new IllegalArgumentException("Preço inválido");

        this.preco = preco;
    }
}
