public class DropItem {

    private Item item;
    private int chance;

    public DropItem(Item item, int chance) {
        this.item = item;
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
