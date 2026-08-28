package Printer;

import Entidade.Alvos.Criatura;
import Entidade.Alvos.Monstro;
import Entidade.Jogador.Jogador;
import Relatorio.RelatoriodeBatalha;

import java.sql.SQLOutput;

public class  Printer {

    public static void printCriatura(Criatura criatura){

        System.out.println("Nome: "+criatura.getNome());
        System.out.println("Raça: "+criatura.getRaca());
        System.out.println("Classe: "+criatura.getClasse());
        System.out.println("Nivel: "+criatura.getNivel());
        System.out.println("Mana: "+criatura.getManaAtual());
        System.out.println("Vida: "+criatura.getVidaAtual());
        System.out.println("Força: "+criatura.getForca());
        System.out.println("Inteligencia: "+criatura.getInteligencia());
        System.out.println("Poder Magico: "+criatura.getPoderMagico());
        System.out.println("Velocidade: "+criatura.getVelocidade());
        System.out.println("Armadura: "+criatura.getArmadura());
        printLinha();

    }

    public static void printJogador(Jogador jogador){

        System.out.println("Nome: "+jogador.getNome());
        System.out.println("Raça: "+jogador.getRaca());
        System.out.println("Classe: "+jogador.getClasse());
        System.out.println("XP: "+jogador.getXp());
        System.out.println("Nivel: "+jogador.getNivel());
        System.out.println("Mana: "+jogador.getManaAtual());
        System.out.println("Vida: "+jogador.getVidaAtual());
        System.out.println("Força: "+jogador.getForca());
        System.out.println("Inteligencia: "+jogador.getInteligencia());
        System.out.println("Poder Magico: "+jogador.getPoderMagico());
        System.out.println("Velocidade: "+jogador.getVelocidade());
        System.out.println("Armadura: "+jogador.getArmadura());
        printLinha();

    }

    public static void printMonstro(Monstro monstro){

        System.out.println("Nome: "+monstro.getNome());
        System.out.println("Monstro: "+monstro.getTipoMonstro());
        System.out.println("Nivel: "+monstro.getNivel());
        System.out.println("Mana: "+monstro.getManaAtual());
        System.out.println("Vida: "+monstro.getVidaAtual());
        System.out.println("Força: "+monstro.getForca());
        System.out.println("Inteligencia: "+monstro.getInteligencia());
        System.out.println("Poder Magico: "+monstro.getPoderMagico());
        System.out.println("Velocidade: "+monstro.getVelocidade());
        System.out.println("Armadura: "+monstro.getArmadura());
        printLinha();

    }


    public static void printLinha(){
        System.out.println("====================================");
    }

    public static void printRelatorioBatalha(RelatoriodeBatalha rtb){

        if (rtb.getHabilidade() == null) {
            System.out.println(rtb.getAtacante().getNome() + " atacou " + rtb.getAlvo()
                    .getNome() + " e causou " + rtb.getDano() + " de dano.");
        }else {

            System.out.println(rtb.getAtacante().getNome()+" usou "+rtb.getHabilidade().getNome()+" e causou "+
                    rtb.getDano() +" de dano");

        };
    }
}
