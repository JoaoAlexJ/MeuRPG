import Entidade.Alvos.Alvos;
import Entidade.Alvos.Criatura;
import Entidade.Alvos.Monstro;
import Entidade.Alvos.TipoMonstro;
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


        List<DropItem> itemsDragao = List.of(
                new DropItem(new Material("Dente de Dragão", Raridade.COMUM, 45), 80),
                new DropItem(new Material("Escama de Dragão", Raridade.INCOMUM, 60), 42),
                new DropItem(new Material("Coração de Dragão", Raridade.RARO, 150), 10)
        );


        Jogador j1 = new Jogador("Joao", 1, Classe.MAGO, Raca.ELFO);
        Criatura goblim = new Criatura("Divo", 5, Raca.GOBLIM, itemsGoblim, Classe.ASSASINO);
        Monstro dragao = new Monstro("Hyjir", 5, itemsDragao, TipoMonstro.DRAGAO);

        Habilidade habilidadeMago = new Habilidade("Bola de fogo", 60, 25, Raridade.COMUM, TipoHabilidade.MAGICO, null, Classe.MAGO);
        Habilidade habilidaDragao = new Habilidade("Sopro de dragão", 100, 35, Raridade.INCOMUM, TipoHabilidade.MAGICO,null,  TipoMonstro.DRAGAO );
        Habilidade habilidadeComum = new Habilidade("Soco fortalecido", 50, 10, Raridade.COMUM, TipoHabilidade.FISICO, null);

        j1.aprenderHabilidade(habilidadeMago);
        j1.equiparHabilidade(habilidadeMago.getNome());

        goblim.aprenderHabilidade(habilidadeComum);
        goblim.equiparHabilidade(habilidadeComum.getNome());

        dragao.aprenderHabilidade(habilidaDragao);
        dragao.equiparHabilidade(habilidaDragao.getNome());

        j1.aprenderHabilidade(habilidadeComum);













    }

}