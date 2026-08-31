package Entidade.Alvos;

import Entidade.Entidade;
import Item.DropItem;
import Item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Alvos extends Entidade {

    private List<DropItem> items;

    public Alvos(String nome, int nivel, int mana, int vida, int forca, int inteligencia, int poderMagico, int velocidade, int armadura, List<DropItem> items) {
        super(nome, nivel, mana, vida, forca, inteligencia, poderMagico, velocidade, armadura);

        this.items = items;
    }


    public int recompensaXP(){
        return getNivel() * 85;
    }

    public double recompensaDinheiro(){
        double recompensa = getDinheiro();
        setDinheiro(0);

        return recompensa;
    }

    public void addDropItem(DropItem dropItem){
        items.add(dropItem);

    }


    public List<Item> gerarDropItems(){

        Random random = new Random();
        List<Item> itemsGerados = new ArrayList<>();

        for (DropItem d : items){

            if (random.nextInt(100) <= d.getChance()){

                itemsGerados.add(d.getItem());
            }

        }

        return itemsGerados;

    }

    public void calcularDinheiro(){
        setDinheiro(20 * getNivel());

    }

    public void calcularCriacao(){

        setVelocidade(getVelocidade() * getNivel());
        setArmadura(getArmadura() * getNivel());
        setForca(getForca() * getNivel());

        setManaMaxima(getManaMaxima() * getNivel());
        setManaAtual(getManaAtual() * getNivel());

        setInteligencia( getInteligencia() * getNivel());

        setVidaMaxima(getVidaMaxima() * getNivel());
        setVidaAtual(getVidaAtual() * getNivel());

        setPoderMagico(getPoderMagico() * getNivel());

        calcularDinheiro();

    }


    //---------------------//

    public List<DropItem> getItems() {
        return new ArrayList<>(items);
    }
}
