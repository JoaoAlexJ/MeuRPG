package Entidade.Alvos;

import Entidade.Entidade;
import Entidade.Classe;
import Entidade.Jogador.Raca;
import Item.DropItem;
import Item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Alvos extends Entidade {

    private List<DropItem> items;
    private Raca raca;
    private Classe classe;

    private static final int VIDA_BASE = 500;
    private static final int MANA_BASE = 200;
    private static final int FORCA_BASE = 15;
    private static final int INTELIGENCIA_BASE = 2;
    private static final int PODER_MAGICO_BASE = 15;
    private static final int VELOCIDADE_BASE = 2;
    private static final int ARMADURA_BASE = 7;



    public Alvos(String nome, int nivel, Raca raca, Classe classe) {
        super(nome, nivel, MANA_BASE, VIDA_BASE, FORCA_BASE, INTELIGENCIA_BASE, PODER_MAGICO_BASE, VELOCIDADE_BASE, ARMADURA_BASE);

        calcularCriacao();

        this.classe = classe;
        this.raca = raca;
        this.items = new ArrayList<>();

        this.raca.bonusAtributo(this);
    }

    public Alvos(String nome, int nivel, Raca raca) {
        super(nome, nivel, MANA_BASE, VIDA_BASE, FORCA_BASE, INTELIGENCIA_BASE, PODER_MAGICO_BASE, VELOCIDADE_BASE, ARMADURA_BASE);

        calcularCriacao();

        this.classe = null;
        this.raca = raca;
        this.items = new ArrayList<>();

        this.raca.bonusAtributo(this);
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


    protected List<Item> gerarDropItems(){

        Random random = new Random();
        List<Item> itemsGerados = new ArrayList<>();

        for (DropItem d : items){

            if (random.nextInt(100 + 1) <= d.getChance()){

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
        setMana(getMana() * getMana());
        setInteligencia( getInteligencia() * getNivel());
        setVida(getVida() * getNivel());
        setPoderMagico(getPoderMagico() * getNivel());

        calcularDinheiro();

    }


    //---------------------//


    public Classe getClasse() {
        return classe;
    }

    public Raca getRaca() {
        return raca;
    }

    public List<DropItem> getItems() {
        return new ArrayList<>(items);
    }
}
