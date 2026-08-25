package Entidade.Alvos;

import Habilidade.Habilidade;
import Item.DropItem;
import jdk.dynalink.linker.LinkerServices;

import java.util.List;

public class Monstro extends Alvos{

    private TipoMonstro tipoMonstro;

    private static final int VIDA_BASE = 800;
    private static final int MANA_BASE = 250;
    private static final int FORCA_BASE = 20;
    private static final int INTELIGENCIA_BASE = 5;
    private static final int PODER_MAGICO_BASE = 25;
    private static final int VELOCIDADE_BASE = 5;
    private static final int ARMADURA_BASE = 15;



    public Monstro(String nome, int nivel, List<DropItem> items, TipoMonstro tipoMonstro) {
        super(nome, nivel, MANA_BASE, VIDA_BASE, FORCA_BASE, INTELIGENCIA_BASE, PODER_MAGICO_BASE, VELOCIDADE_BASE, ARMADURA_BASE, items);


        this.tipoMonstro = tipoMonstro;

        calcularCriacao();
    }


    //------------//

    public TipoMonstro getTipoMonstro() {
        return tipoMonstro;
    }

    @Override
    public boolean podeAddHabilidade(Habilidade habilidade) {
        if (habilidade.getRequisitoMonstro() == null && habilidade.getRequisitoClasse() == null){
            return true;
        }
        else if (habilidade.getRequisitoMonstro() == this.tipoMonstro && habilidade.getRequisitoClasse() == null){
            return true;
        }

        else return false;
    }
}
