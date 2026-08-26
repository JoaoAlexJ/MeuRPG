import Entidade.Alvos.Alvos;
import Entidade.Alvos.Criatura;
import Entidade.Classe;
import Entidade.Jogador.Jogador;
import Entidade.Jogador.Raca;
import Habilidade.Habilidade;
import Item.DropItem;
import Item.Item;
import Item.Material;
import Item.Raridade;
import Printer.Printer;
import Habilidade.TipoHabilidade;

import java.util.List;

public class Main {

    static void main(String[] args) {

        List<DropItem> itemsGoblim = List.of(
                        new DropItem(new Material("Dente de Goblim", Raridade.COMUM, 45), 80),
                        new DropItem(new Material("Pele de Goblim", Raridade.INCOMUM, 60), 42),
                        new DropItem(new Material("Cabeça de goblim", Raridade.RARO, 150), 10)

        );

        Jogador j1 = new Jogador("Joao", 1, Classe.ASSASINO, Raca.ELFO);
        Jogador j2 = new Jogador("Juliane", 1, Classe.MAGO, Raca.FADA);
        Criatura goblim = new Criatura("Divo", 5, Raca.GOBLIM, itemsGoblim, Classe.ASSASINO);

        Habilidade habilidadeMago = new Habilidade("Bola de fogo", 60, 25, Raridade.COMUM, TipoHabilidade.MAGICO, Classe.MAGO);

        j2.aprenderHabilidade(habilidadeMago);
        j2.equiparHabilidade(habilidadeMago.getNome());



        Printer.printJogador(j1);
        Printer.printCriatura(goblim);

        System.out.println(j2.usarHabilidade(habilidadeMago));

        goblim.receberDano(j2.usarHabilidade(habilidadeMago));


        Printer.printCriatura(goblim);









    }

}