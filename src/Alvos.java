import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Alvos extends Entidade{

    private List<DropItem> items;

    public Alvos(String nome, int nivel, int mana, int vida, int forca, int inteligencia, int poderMagico, int velocidade, int armadura) {
        super(nome, nivel, mana, vida, forca, inteligencia, poderMagico, velocidade, armadura);

        this.items = new ArrayList<>();
        setDinheiro(calcularDinheiro());
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

    public double calcularDinheiro(){

        return 20 * getNivel();

    }




}
