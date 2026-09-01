import Efeito.Efeito;
import Entidade.Alvos.Criatura;
import Entidade.Alvos.Monstro;
import Entidade.Alvos.TipoMonstro;
import Entidade.Pacificos.Comerciante.Comerciante;
import Entidade.Pacificos.Comerciante.Transacao;
import Entidade.Personagem.Classe;
import Entidade.Personagem.Jogador.Jogador;
import Entidade.Personagem.Raca;
import Habilidade.Habilidade;
import Item.DropItem;
import Item.Item;
import Item.Material;
import Item.Raridade;
import Printer.Printer;
import Habilidade.TipoHabilidade;

import java.util.ArrayList;
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


        Jogador j1 = new Jogador("Joao", 1, Raca.ELFO,  Classe.MAGO);
        Criatura goblim = new Criatura("Divo", 5, Raca.GOBLIM, itemsGoblim, Classe.ASSASINO);
        Monstro dragao = new Monstro("Hyjir", 5, itemsDragao, TipoMonstro.DRAGAO);

        Habilidade habilidadeMago = new Habilidade("Bola de fogo", 60, 25, Raridade.COMUM, TipoHabilidade.MAGICO, Efeito.VENENO, Classe.MAGO);
        Habilidade habilidaDragao = new Habilidade("Sopro de dragão", 100, 35, Raridade.INCOMUM, TipoHabilidade.MAGICO,Efeito.VENENO,  TipoMonstro.DRAGAO );
        Habilidade habilidadeComum = new Habilidade("Soco fortalecido", 50, 10, Raridade.COMUM, TipoHabilidade.FISICO, Efeito.VENENO);

        j1.aprenderHabilidade(habilidadeMago);
        j1.equiparHabilidade(habilidadeMago.getNome());

        goblim.aprenderHabilidade(habilidadeComum);
        goblim.equiparHabilidade(habilidadeComum.getNome());

        dragao.aprenderHabilidade(habilidaDragao);
        dragao.equiparHabilidade(habilidaDragao.getNome());

        j1.aprenderHabilidade(habilidadeComum);
        dragao.aprenderHabilidade(habilidadeComum);

        j1.equiparHabilidade(habilidadeComum.getNome());
        dragao.equiparHabilidade(habilidadeComum.getNome());

        //-------------------//

        /*

        Batalha batalha = new Batalha();
        IAinimiga iAinimiga = new IAinimiga();

        RelatorioBatalha relatorioBatalha = iAinimiga.agir(batalha, goblim, j1);
        RelatorioBatalha relatorioBatalha1 = iAinimiga.agir(batalha, goblim, j1);

        System.out.println("Força"+goblim.getForca());
        System.out.println("Dano habildiade: "+goblim.getHabilidadesEquipadas().get(0).getDano());
        System.out.println("Pdoer Magico: "+goblim.getPoderMagico());
        System.out.println("Inteligencia: "+goblim.getInteligencia());

        Printer.printRelatorioBatalha(relatorioBatalha);
        Printer.printRelatorioBatalha(relatorioBatalha1);
        Printer.printLinha();
         */

        //--------------------//

        //Teste de compra e venda

        //Comerciante
        List<Item> itemsComerciante = new ArrayList<>(List.of(
                new Material("Olho de sapo encantado", Raridade.INCOMUM, 250),
                new Material("Dedos de bruxa", Raridade.EPICO, 120),
                new Material("Pera", Raridade.COMUM, 25)
        ));

        Comerciante c1 = new Comerciante("Juninho", itemsComerciante, Raca.HUMANO);

        //Jogador
        List<Item> itemsJogador = new ArrayList<>(List.of(
                new Material("Escudo de prata", Raridade.RARO, 25),
                new Material("Punhal enferrujado", Raridade.COMUM, 50),
                new Material("Cerejas", Raridade.COMUM, 10)

        ));

        j1.setDinheiro(1500);
        itemsJogador.forEach(i -> j1.getInventario().adicionarItem(i));

        Printer.printComerciante(c1);
        Printer.printLinha();
        Printer.printJogadorBatalha(j1);
        Printer.printLinha();
        Printer.printListItems(j1.getInventario().getItems());
        Printer.printLinha();

        //Venda

        //Aqui o jogador vai coprar um item do comerciante
        //Então ele escolhe o item pelo nome e a raridade

        Item item = null;

        for (Item i : c1.getItems()){

            if (i.getNome().equalsIgnoreCase("Dedos de Bruxa") && i.getRaridade().equals(Raridade.EPICO)){
                item = i;
                break;
            }

        }

        //Agora com o item escolhido começa a trasação

        Transacao.realizar(c1, j1, item);


        Printer.printComerciante(c1);
        Printer.printLinha();
        Printer.printJogadorBatalha(j1);
        Printer.printLinha();
        Printer.printListItems(j1.getInventario().getItems());








    }

}