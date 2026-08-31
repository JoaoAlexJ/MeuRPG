package Entidade.Personagem.Jogador;

import Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Item> items;

    public Inventario() {
        this.items = new ArrayList<>();
    }

    public void adicionarItem(Item item){

        if (item == null)throw new IllegalArgumentException("Item inválido");

        items.add(item);
    }

    public Item removerItem(Item item){

        if (items.contains(item)){
            items.remove(item);
            return item;
        }

        else return null;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}
