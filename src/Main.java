import Entidade.Alvos.Alvos;
import Entidade.Classe;
import Entidade.Jogador.Raca;

public class Main {

    static void main(String[] args) {


        Alvos elfo = new Alvos("Frieren", 5, Raca.ELFO, Classe.MAGO);
        Alvos elfo2 = new Alvos("Robson", 6, Raca.ELFO);

        System.out.println(elfo.getPoderMagico());
        System.out.println(elfo2.getPoderMagico());


    }

}