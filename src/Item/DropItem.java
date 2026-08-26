package Item;

import java.util.Objects;

public class DropItem {

    private Item item;
    private int chance;

    public DropItem(Item item, int chance) {

        if(chance <= 0){
            throw new IllegalArgumentException("Chance inválida");
        }

        this.item = Objects.requireNonNull(item);
        this.chance = chance;
    }

    //---------------//

    public Item getItem() {
        return item;
    }

    public int getChance() {
        return chance;
    }
}
