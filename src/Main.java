import Entidade.Alvos.Alvos;
import Entidade.Alvos.Criatura;
import Entidade.Jogador.Raca;
import Item.DropItem;
import Item.Item;
import Item.Material;
import Item.Raridade;

import java.util.List;

public class Main {

    static void main(String[] args) {

        List<DropItem> itemsGoblim = List.of(
                        new DropItem(new Material("Dente de Goblim", Raridade.COMUM, 45), 80),
                        new DropItem(new Material("Pele de Goblim", Raridade.INCOMUM, 60), 42),
                        new DropItem(new Material("Cabeça de goblim", Raridade.RARO, 150), 10)

        );







    }

}