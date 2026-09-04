package Fluxos;

import Batalha.Batalha;
import Batalha.IAinimiga;
import Entidade.Alvos.Alvos;
import Entidade.Personagem.Jogador.Jogador;
import Habilidade.Habilidade;
import Printer.Printer;
import Relatorio.RelatorioBatalha;

import java.util.Objects;
import java.util.Scanner;

public class FluxoBatalha {

    private Batalha batalha;
    private Scanner scanner;

    public FluxoBatalha(Batalha batalha, Scanner scanner) {
        this.batalha = Objects.requireNonNull(batalha);
        this.scanner = Objects.requireNonNull(scanner);
    }

    public void iniciar(Jogador jogador, Alvos alvo, IAinimiga iAinimiga) throws InterruptedException {

        while (jogador.estaVivo() && alvo.estaVivo()) {

            Printer.printAlvo(alvo);
            Printer.printLinha();
            Printer.printJogadorBatalha(jogador);
            Printer.printLinha();

            Printer.printMenu1Batalha();
            int escolhaMenu1 = scanner.nextByte();

            scanner.nextLine();
            Printer.printLinha();

            switch (escolhaMenu1) {

                case 1:

                    boolean continuar1 = fluxoAtaqueComumJogador(jogador, alvo, iAinimiga);

                    if (!continuar1){
                        return;
                    }

                    break;

                case 2:

                    boolean continuar2 = fluxoAtaqueHabilidadeJogador(jogador, alvo, iAinimiga);

                    if (!continuar2){
                        return;
                    }

                    break;
                case 3:

                    System.out.println("Fugindo...");
                    return;

                default:
                    System.err.println("Opção inválida");



            }


        }
    }

    private Habilidade fluxoBuscarHabilidade(Jogador jogador){

        for (Habilidade h : jogador.getHabilidadesEquipadas()){
            Printer.printHabilidadeEquipada(h);
            Printer.printLinha();
        }

        System.out.println("Digite o nome da Habilidade desejada");
        System.out.print("-> ");
        String nome = scanner.nextLine();

        return jogador.getHabilidadesEquipadas().stream()
                .filter(h -> h.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Habilidade não encontrada"));


    }

    private boolean fluxoAtaqueComumJogador(Jogador jogador, Alvos alvo, IAinimiga iAinimiga) throws InterruptedException {

        RelatorioBatalha relatorioBatalha1 =  batalha.ataqueComum(jogador, alvo);
        Printer.printRelatorioBatalha(relatorioBatalha1);

        if (!alvo.estaVivo()){
            jogador.receberRecompensa(alvo.recompensaXP(), alvo.recompensaDinheiro(), alvo.gerarDropItems());
            return false;

        }else {

            RelatorioBatalha relatorioBatalha2 = iAinimiga.agir(batalha, alvo, jogador);
            Printer.printRelatorioBatalha(relatorioBatalha2);
            Printer.printLinha();
            System.out.println();

            if (!jogador.estaVivo()){
                System.err.println("Você morreu!");
                System.exit(0);
            }

            return true;

        }
    }

    private boolean fluxoAtaqueHabilidadeJogador(Jogador jogador, Alvos alvo, IAinimiga iAinimiga) throws InterruptedException {

        Habilidade habilidadeEscolhida = fluxoBuscarHabilidade(jogador);

        //Ataque do jogador com habilidade
        System.out.println("===========Chat de batalha===========");
        RelatorioBatalha relatorioBatalha = batalha.ataqueComHabilidade(jogador, alvo, habilidadeEscolhida);
        Printer.printRelatorioBatalha(relatorioBatalha);
        Printer.printLinha();


        //Verificação e ataque do inimigo
        if (!alvo.estaVivo()){
            jogador.receberRecompensa(alvo.recompensaXP(), alvo.recompensaDinheiro(), alvo.gerarDropItems());
            return false;
        }else {

            RelatorioBatalha relatorioBatalha2 = iAinimiga.agir(batalha, alvo, jogador);
            Printer.printRelatorioBatalha(relatorioBatalha2);
            Printer.printLinha();

            if (!jogador.estaVivo()){

                System.err.println("Game over!");
                System.exit(0);
            }

            return true;
        }

    }


}
