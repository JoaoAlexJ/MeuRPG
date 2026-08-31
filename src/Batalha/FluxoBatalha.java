package Batalha;

import Entidade.Entidade;
import Entidade.Jogador.Jogador;
import Printer.Printer;

import java.util.Scanner;

public class FluxoBatalha {

    private Batalha batalha;
    private Scanner scanner;


    public void iniciar(Jogador jogador, Entidade alvo, IAinimiga iAinimiga){

        while (jogador.estaVivo() && alvo.estaVivo()) {
            Printer.printMenu1Batalha();
            int escolhaMenu1 = scanner.nextByte();

            switch (escolhaMenu1) {

                case 1:

                    batalha.ataqueComum(jogador, alvo);

                    if (!alvo.estaVivo()){

                    }

            }


        }
    }
}
