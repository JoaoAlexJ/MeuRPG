package Batalha;

import Entidade.Alvos.Alvos;
import Entidade.Entidade;
import Entidade.Personagem.Jogador.Jogador;
import Habilidade.Habilidade;
import Printer.Printer;
import Relatorio.RelatorioBatalha;

import java.util.Scanner;

public class FluxoBatalha {

    private Batalha batalha;
    private Scanner scanner;


    public void iniciar(Jogador jogador, Alvos alvo, IAinimiga iAinimiga){

        boolean fugir = false;
        while (jogador.estaVivo() && alvo.estaVivo() || !fugir) {

            Printer.printMenu1Batalha();
            int escolhaMenu1 = scanner.nextByte();

            switch (escolhaMenu1) {

                case 1:

                    RelatorioBatalha relatorioBatalha1 =  batalha.ataqueComum(jogador, alvo);
                    Printer.printRelatorioBatalha(relatorioBatalha1);

                    if (!alvo.estaVivo()){
                        jogador.receberRecompensa(alvo.recompensaXP(), alvo.recompensaDinheiro(), alvo.gerarDropItems());
                        break;
                    }else {

                        RelatorioBatalha relatorioBatalha2 = iAinimiga.agir(batalha, alvo, jogador);
                        Printer.printRelatorioBatalha(relatorioBatalha2);
                        break;
                    }

                case 2:

                    Printer.printJogadorBatalha(jogador);
                    for (Habilidade h : jogador.getHabilidadesEquipadas()){
                        Printer.printHabilidadeEquipada(h);
                    }

                    System.out.println("Digite o nome da Habilidade desejada");
                    System.out.print("-> ");
                    String nome = scanner.nextLine();

                    Habilidade habilidadeEscolhida = jogador.getHabilidadesEquipadas().stream()
                            .filter(h -> h.getNome().equalsIgnoreCase(nome))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("Habilidade não encontrada"));

                    RelatorioBatalha relatorioBatalha = batalha.ataqueComHabilidade(jogador, alvo, habilidadeEscolhida);
                    Printer.printRelatorioBatalha(relatorioBatalha);

                    if (!alvo.estaVivo()){
                        jogador.receberRecompensa(alvo.recompensaXP(), alvo.recompensaDinheiro(), alvo.gerarDropItems());
                        break;
                    }else {
                        RelatorioBatalha relatorioBatalha2 = iAinimiga.agir(batalha, alvo, jogador);
                        Printer.printRelatorioBatalha(relatorioBatalha2);
                        break;
                    }
                case 3:
                    fugir = true;
                    break;

                default:
                    System.err.println("Opção inválida");



            }


        }
    }
}
