package Printer;

import Entidade.Alvos.Alvos;
import Entidade.Alvos.Criatura;
import Entidade.Alvos.Monstro;
import Entidade.Entidade;
import Entidade.Pacificos.Comerciante.Comerciante;
import Entidade.Personagem.Npc.Npc;
import Entidade.Personagem.Jogador.Jogador;
import Habilidade.Habilidade;
import Item.Item;
import Relatorio.RelatorioBatalha;
import Relatorio.RelatorioEfeito;

import java.util.ArrayList;
import java.util.List;

public class  Printer {

    private static final int VELOCIDADE_RAPIDA = 30;
    private static final int VELOCIDADE_NORMAL = 100;
    private static final int VELOCIDADE_LENTA = 200;



    private static final int PAUSA_LENTA = 2000;
    private static final int PAUSA_NORMAL = 1000;
    private static final int PAUSA_RAPIDA = 450;

    private static final String AMARELO = "\u001B[33m";
    private static final String VERMELHO = "\u001B[31m";
    private static final String CIANO = "\u001B[36m";
    private static final String VERDE = "\u001B[32m";
    private static final String AZUL = "\u001B[34m";

    private static final String RESET = "\u001B[0m";

    private static void fraseRPG(String frase, int velocidade, int pausa) throws InterruptedException {

        for (char c : frase.toCharArray()){
            System.out.print(c);
            Thread.sleep(velocidade);
        }

        Thread.sleep(pausa);
        pularLinha();
    }

    public static void printAtributos(Entidade entidade){

        System.out.println("Mana: "+entidade.getManaAtual());
        System.out.println("Vida: "+entidade.getVidaAtual());
        System.out.println("Força: "+entidade.getForca());
        System.out.println("Inteligencia: "+entidade.getInteligencia());
        System.out.println("Poder Magico: "+entidade.getPoderMagico());
        System.out.println("Velocidade: "+entidade.getVelocidade());
        System.out.println("Armadura: "+entidade.getArmadura());
        printLinha();


    }

    public static void printNpc(Npc npc){
        System.out.println("<Nível "+npc.getNivel()+"> "+npc.getNome());
        System.out.println("Raça: "+npc.getRaca());


    }

    public static void printLinha(){
        System.out.println("====================================");
    }

    public static void pularLinha(){
        System.out.println();
    }

    //--------------- Batalha ------------------//

    public static void printRelatorioBatalha(RelatorioBatalha rtb) throws InterruptedException {

        System.out.println(AMARELO+"Turno: "+rtb.atacante().getNome()+RESET);
        Thread.sleep(1000);

        if (!rtb.efeitos().isEmpty()){

            System.out.println("efeitos causado ao "+rtb.atacante().getNome());
            Thread.sleep(1000);


            int danoTotal = 0;
            for (RelatorioEfeito re : rtb.efeitos()){
                System.out.println(re.nomeEfeito()+" - "+VERMELHO+re.dano()+RESET);
                Thread.sleep(1000);

                danoTotal += re.dano();
            }

            System.out.println("Dano total: "+VERMELHO+danoTotal+RESET);
            printLinha();
        }


        if (rtb.habilidade() == null) {

            String fraseAtaqueComum = rtb.atacante().getNome() + " atacou " + rtb.alvo().getNome() + " e causou " +VERMELHO+ rtb.dano() +RESET
            +" de dano.";
            Printer.fraseRPG(fraseAtaqueComum, VELOCIDADE_NORMAL, PAUSA_NORMAL);

        }else {

            String fraseAtaquehabildiade = rtb.atacante().getNome()+" usou "+rtb.habilidade().getNome()+" e causou "+VERMELHO+ rtb.dano() +RESET+" de dano";
            Printer.fraseRPG(fraseAtaquehabildiade, VELOCIDADE_NORMAL, PAUSA_NORMAL);
        };

    }


    public static void printMenu1Batalha(){

        System.out.println("1 - Atacar");
        System.out.println("2 - Usar habilidade");
        System.out.println("3 - fugir");
        System.out.print("-> ");

    }

    public static void printVidaManaBatalha(Entidade entidade) throws InterruptedException {

        String vida = VERDE+"Vida: ("+entidade.getVidaAtual()+"/"+entidade.getVidaMaxima()+")"+RESET;
        String mana = CIANO+"Mana: ("+entidade.getManaAtual()+"/"+entidade.getManaMaxima()+")"+RESET;

        fraseRPG(vida, VELOCIDADE_RAPIDA, PAUSA_RAPIDA);
        fraseRPG(mana, VELOCIDADE_RAPIDA, PAUSA_RAPIDA);

    }

    public static void printAlvo(Alvos alvo) throws InterruptedException {

        if (alvo instanceof Criatura){
            System.out.println(VERMELHO+"          CRIATURA"+RESET);
        }
        if (alvo instanceof Monstro){
            System.out.println(VERMELHO+"          MONSTRO"+RESET);
        }

        System.out.println();
        System.out.println("<Nível "+alvo.getNivel()+"> "+alvo.getNome());
        if (alvo instanceof Criatura criatura){

            System.out.println("Raça: "+criatura.getRaca());

            if (criatura.getClasse() != null) {
                System.out.println("Classe: " + criatura.getClasse());
            }
        }else if (alvo instanceof Monstro monstro){

            System.out.println("Monstro: "+monstro.getTipoMonstro());
        }

        pularLinha();
        printVidaManaBatalha(alvo);

    }

    public static void printJogadorBatalha(Jogador jogador) throws InterruptedException {

        System.out.println(AZUL+"              JOGADOR"+RESET);
        System.out.println();
        System.out.println("<Dinheiro: "+jogador.getDinheiro()+" $");
        System.out.println("<Nível "+jogador.getNivel()+"> "+jogador.getNome());
        System.out.println("Raça: "+jogador.getRaca());
        System.out.println("Classe: " + jogador.getClasse());
        pularLinha();
        printVidaManaBatalha(jogador);
        System.out.println("XP: "+jogador.getXp()+"/"+jogador.getNivel() * 110+")");
    }

    public static void printListItems(List<Item> listItems){

        listItems.forEach(i -> printItem(i));
    }

    public static void printItem(Item item){
        System.out.println("      ITEM");
        System.out.println("Nome: "+item.getNome());
        System.out.println("Raridade: "+item.getRaridade());
        System.out.printf("Preço: %.2f\n", item.getPreco());
        printLinha();
    }

    public static void printComerciante(Comerciante comerciante){

        System.out.println("        COMERCIANTE");
        System.out.println();
        System.out.println("Nome: "+comerciante.getNome());
        System.out.println("Raça: "+comerciante.getRaca());
        System.out.println("Dinheiro: "+comerciante.getDinheiro()+" $");
        System.out.println("========================");
        System.out.println("       <Itens>");

        printListItems(comerciante.getItems());
    }

    public static void printHabilidadeEquipada(Habilidade habilidade){

        System.out.println("         HABILIDADE");
        System.out.println();
        System.out.println("Nome: "+habilidade.getNome());
        System.out.println("Dano: "+habilidade.getDano());
        System.out.println("Custo de mana: "+habilidade.getCustoMana());
        System.out.println("Raridade: "+habilidade.getRaridade());
        System.out.println("Efeito: "+habilidade.getEfeito());
    }

    public static void printHabilidade(Habilidade habilidade){

        printHabilidadeEquipada(habilidade);

        if (habilidade.getRequisitoClasse() != null){
            System.out.println("Requisito Classe: "+habilidade.getRequisitoClasse());
        }
        if (habilidade.getRequisitoMonstro() != null){
            System.out.println("Requisito Monstro: "+habilidade.getRequisitoMonstro());
        }

    }

    public static void printComercianteSimpes(Comerciante comerciante){

        System.out.println("        COMERCIANTE");
        System.out.println();
        System.out.println("Nome: "+comerciante.getNome());
        System.out.println("Raça: "+comerciante.getRaca());

    }

}
