import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventario {

    private List<String> items;

    public Inventario() {
        this.items = new ArrayList<>();
    }

    public void adicionarItem(String item){

        if (item == null || item.isBlank())throw new IllegalArgumentException("Item inválido");

        items.add(item);
    }

    public String removerItem(String item){

        if (items.contains(item)){
            items.remove(item);
            return item;
        }

        else return null;
    }

    public List<String> getItems() {
        return new ArrayList<>(items);
    }
}
