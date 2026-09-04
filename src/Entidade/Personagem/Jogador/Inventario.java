package Entidade.Personagem.Jogador;

import Item.Item;
import Item.SlotArma;
import Item.SlotAcessorio;
import Item.SlotArmadura;
import Item.Arma;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class Inventario {

    private EnumMap<SlotArma, Arma> arma;
    private EnumMap<SlotArmadura, Arma> armadura;
    private EnumMap<SlotAcessorio, Arma> acessorios;
    private List<Item> items;

    public Inventario() {
        this.items = new ArrayList<>();
    }

    public void adicionarListItems(List<Item> itemsAdd){

        if (itemsAdd.isEmpty())throw new IllegalArgumentException("Lista vazia");

        for (Item item : itemsAdd){
            adicionarItem(item);
        }
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
