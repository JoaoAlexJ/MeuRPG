package Printer;

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

import java.util.List;

public class  Printer {


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

    //--------------- Batalha ------------------//

    public static void printRelatorioBatalha(RelatorioBatalha rtb){

        if (!rtb.efeitos().isEmpty()){

            System.out.println("efeitos causado ao "+rtb.alvo().getNome());

            int danoTotal = 0;
            for (RelatorioEfeito re : rtb.efeitos()){
                System.out.println(re.nomeEfeito()+" - "+re.dano());
                danoTotal += re.dano();
            }

            System.out.println("Dano total: "+danoTotal);
        }

        System.out.println("---------------------------------------");

        if (rtb.habilidade() == null) {
            System.out.println(rtb.atacante().getNome() + " atacou " + rtb.alvo()
                    .getNome() + " e causou " + rtb.dano() + " de dano.");
        }else {

            System.out.println(rtb.atacante().getNome()+" usou "+rtb.habilidade().getNome()+" e causou "+
                    rtb.dano() +" de dano");

        };
    }


    public static void printMenu1Batalha(){

        System.out.println("1 - Atacar");
        System.out.println("2 - Usar habilidade");
        System.out.println("3 - fugir");
        System.out.print("-> ");

    }

    public static void printCriaturaBatalha(Criatura criatura){

        System.out.println("<Nível "+criatura.getNivel()+"> "+criatura.getNome());
        System.out.println("Raça: "+criatura.getRaca());
        if (criatura.getClasse() != null) {

            System.out.println("Classe: " + criatura.getClasse());
        }
        System.out.println();
        System.out.println("Vida: ("+criatura.getVidaAtual()+"/"+criatura.getVidaMaxima()+")");
        System.out.println("Mana: ("+criatura.getManaAtual()+"/"+criatura.getManaMaxima()+")");
    }

    public static void printMonstroBatalha(Monstro monstro){

        System.out.println("<Nível "+monstro.getNivel()+"> "+monstro.getNome());
        System.out.println("Monstro: "+monstro.getTipoMonstro());
        System.out.println();
        System.out.println("Vida: ("+monstro.getVidaAtual()+"/"+monstro.getVidaMaxima()+")");
        System.out.println("Mana: ("+monstro.getManaAtual()+"/"+monstro.getManaMaxima()+")");
    }

    public static void printJogadorBatalha(Jogador jogador){

        System.out.println("<Dinheiro: "+jogador.getDinheiro()+" $");
        System.out.println("<Nível "+jogador.getNivel()+"> "+jogador.getNome());
        System.out.println("Raça: "+jogador.getRaca());
        System.out.println("Classe: " + jogador.getClasse());
        System.out.println();
        System.out.println("Vida: ("+jogador.getVidaAtual()+"/"+jogador.getVidaMaxima()+")");
        System.out.println("Mana: ("+jogador.getManaAtual()+"/"+jogador.getManaMaxima()+")");
        System.out.println("XP: "+jogador.getXp()+"/"+jogador.getNivel() * 110+")");
    }

    public static void printListItems(List<Item> listItems){

        listItems.forEach(i -> System.out.println(i.getNome()+"\n"+i.getPreco()+"\n"+i.getRaridade()+"\n"));
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


}
