package Entidade.Pacificos;

import Entidade.Personagem.Jogador.Jogador;
import Entidade.Personagem.Raca;
import Entidade.Vendedor;
import Item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Comerciante implements Vendedor {

    private String nome;
    private List<Item> itens = new ArrayList<>();
    private double dinheiro;
    private Raca raca;

    public Comerciante(String nome, List<Item> itens, Raca raca) {

        this.nome = Objects.requireNonNull(nome);
        this.itens = Objects.requireNonNull(itens);
        this.dinheiro = 1500;
        this.raca = Objects.requireNonNull(raca);
        calcularLucroVendedor();
    }

    @Override
    public Item vender(Item item, double valor){

        if (itens.contains(item) && valor == item.getPreco()){

            this.dinheiro += valor;
            itens.remove(item);
            return item;

        }else {

            System.err.println("Erro na venda");
            return null;
        }
    }

    public void comprarItem(Jogador jogador, Item item){

        if (this.dinheiro >= item.getPreco()){

            itens.add(jogador.vender(item, gastarDinheiro(item.getPreco())));

        }

    }

    public double gastarDinheiro(double valor){
        if (valor > this.dinheiro)throw new IllegalArgumentException("Saldo insuficiente");
        if (valor <= 0)throw new IllegalArgumentException("valor inválido");


        this.dinheiro -= valor;
        return valor;
    }

    private void calcularLucroVendedor(){
        if (!itens.isEmpty()) {
            for (Item item : itens) {
                item.setPreco(item.getPreco() + item.getPreco() * 0.75);
            }
        }
    }


    //------------------//

    public String getNome() {
        return nome;
    }

    public List<Item> getItens() {
        return new ArrayList<>(itens);
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public Raca getRaca() {
        return raca;
    }
}
