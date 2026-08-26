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

        this.tipoMonstro.bonusMonstro(this);
        calcularCriacao();
    }


    //------------//

    public TipoMonstro getTipoMonstro() {
        return tipoMonstro;
    }

    @Override
    public int usarHabilidade(Habilidade habilidade) {
        if (!getHabilidadesEquipadas().contains(habilidade)){

            throw new RuntimeException("Essa habilidade não está equipada");
        }

        gastarMana(habilidade.getCustoMana());

        if (tipoMonstro.equals(TipoMonstro.DRAGAO)){
            return (int)(habilidade.getDano() + getPoderMagico() * 0.85 + getForca() * 0.20);

        }else if (tipoMonstro.equals(TipoMonstro.ARACNIDEO)){
            return (int)(habilidade.getDano() + getInteligencia() * 0.85 + getPoderMagico() * 0.15 + getForca() * 0.15);

        }else if (tipoMonstro.equals(TipoMonstro.GOLEM)){
            return (int)(habilidade.getDano() + getForca() + getPoderMagico() * 0.85);
        }

        return 0;
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
