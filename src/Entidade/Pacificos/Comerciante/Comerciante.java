package Entidade.Pacificos.Comerciante;

import Entidade.Personagem.Raca;
import Item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Comerciante implements Vendedor, Comprador {

    private String nome;
    private List<Item> items = new ArrayList<>();
    private double dinheiro;
    private Raca raca;

    public Comerciante(String nome, List<Item> items, Raca raca) {

        this.nome = Objects.requireNonNull(nome);
        this.items = Objects.requireNonNull(items);
        this.dinheiro = 1500;
        this.raca = Objects.requireNonNull(raca);
        calcularLucroVendedor();
    }


    @Override
    public void comprar(Item item, double valor) {

        if (item.getPreco() != valor)throw new IllegalArgumentException("Valor inválido para item");

        pagar(valor);
        this.items.add(item);
    }


    @Override
    public Item vender(Item item, double valor) {

        if (!items.contains(item))throw new IllegalArgumentException("O comerciante não possui esse item");

        if (valor != item.getPreco())throw new IllegalArgumentException("Valor inválido para o item");

        receberDinheiro(valor);
        items.remove(item);
        return item;
    }



    @Override
    public void receberDinheiro(double valor){
        if (valor < 0)throw new IllegalArgumentException("Valor inválido");

        this.dinheiro += valor;
    }



    public double pagar(double valor){
        if (valor > this.dinheiro)throw new IllegalArgumentException("Saldo insuficiente");
        if (valor <= 0)throw new IllegalArgumentException("valor inválido");


        this.dinheiro -= valor;
        return valor;
    }

    private void calcularLucroVendedor(){
        if (!items.isEmpty()) {
            for (Item item : items) {
                item.setPreco(item.getPreco() + item.getPreco() * 0.75);
            }
        }
    }


    //------------------//

    public String getNome() {
        return nome;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public Raca getRaca() {
        return raca;
    }

}
