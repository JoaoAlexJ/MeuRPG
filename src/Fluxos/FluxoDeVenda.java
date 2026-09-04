package Fluxos;

import Entidade.Pacificos.Comerciante.Comerciante;
import Entidade.Pacificos.Comerciante.Transacao;
import Entidade.Personagem.Jogador.Jogador;
import Item.Item;
import Item.Raridade;
import Printer.Printer;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FluxoDeVenda {

    private Comerciante comerciante;
    private Jogador jogador;
    private Scanner scanner;

    public FluxoDeVenda(Comerciante comerciante, Jogador jogador, Scanner scanner) {
        this.comerciante = Objects.requireNonNull(comerciante);
        this.jogador = Objects.requireNonNull(jogador);
        this.scanner = Objects.requireNonNull(scanner);
    }

    public void iniciar(){

        Printer.printComercianteSimpes(comerciante);
        Printer.printLinha();
        System.out.println("1- comprar");
        System.out.println("2- Vender");
        System.out.print("-> ");
        byte escolha = scanner.nextByte();
        System.out.println("----------------------------------");
        scanner.nextLine();

        switch (escolha){
            case 1 -> iniciarJogadorComprador();
            case 2 -> iniciarComercianteComprador();
            default -> throw new IllegalArgumentException("Opção inválida");
        }

    }


    private void iniciarJogadorComprador(){

        Printer.printComerciante(comerciante);
        System.out.println();

        Item item = selecionarItem(comerciante.getItems());

        //---------- Transação ----------//
        Transacao.realizar(comerciante, jogador, item);
        System.out.println("Compra realizada com Sucesso!");
        System.out.println("- "+item.getPreco()+" $");
        Printer.printItem(item);

    }

    private void iniciarComercianteComprador(){

        Printer.printListItems(jogador.getInventario().getItems());
        System.out.println();

        Item item = selecionarItem(jogador.getInventario().getItems());

        //---------- Transação ----------//
        Transacao.realizar(jogador, comerciante, item);
        System.out.println("venda realizada com Sucesso!");
        System.out.println("+ "+item.getPreco()+" $");
        Printer.printLinha();


    }

    private Item selecionarItem(List<Item> items){

        System.out.println("Digite o nome do item desejado");
        System.out.print("-> ");
        String nome = scanner.nextLine();
        Printer.printLinha();

        System.out.println("Informe a raridade do item desejado");
        System.out.println("1- Comum");
        System.out.println("2- Incomum");
        System.out.println("3- Raro");
        System.out.println("4- Épico");
        System.out.println("5- Lendário");
        System.out.println("6- Divíno");
        System.out.print("-> ");
        byte escolhaRaridade = scanner.nextByte();
        Printer.printLinha();

        Raridade raridade = switch (escolhaRaridade){

            case 1 -> Raridade.COMUM;
            case 2 -> Raridade.INCOMUM;
            case 3 -> Raridade.RARO;
            case 4 -> Raridade.EPICO;
            case 5 -> Raridade.LENDARIO;
            case 6 -> Raridade.DIVINO;
            default -> throw new RuntimeException("Opção inválida");
        };

        for (Item i : items){
            if (i.getNome().equalsIgnoreCase(nome) && i.getRaridade().equals(raridade)){
                return i;
            }
        }

        throw new RuntimeException("Item não encontrado");
    }
}
