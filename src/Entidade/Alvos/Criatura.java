package Entidade.Alvos;

import Entidade.Classe;
import Entidade.Jogador.Raca;
import Habilidade.Habilidade;
import Item.DropItem;

import java.util.List;

public class Criatura extends Alvos {

    private Raca raca;
    private Classe classe;

    private static final int VIDA_BASE = 500;
    private static final int MANA_BASE = 200;
    private static final int FORCA_BASE = 15;
    private static final int INTELIGENCIA_BASE = 2;
    private static final int PODER_MAGICO_BASE = 15;
    private static final int VELOCIDADE_BASE = 2;
    private static final int ARMADURA_BASE = 7;


    public Criatura(String nome, int nivel, Raca raca, List<DropItem> items, Classe classe) {
        super(nome, nivel, MANA_BASE, VIDA_BASE, FORCA_BASE, INTELIGENCIA_BASE, PODER_MAGICO_BASE, VELOCIDADE_BASE, ARMADURA_BASE, items);


        this.raca = raca;
        this.classe = classe;

        this.raca.bonusAtributo(this);
        this.classe.bonusClasse(this);
        calcularCriacao();
    }

    public Criatura(String nome, int nivel, Raca raca, List<DropItem> items) {
        super(nome, nivel,  MANA_BASE, VIDA_BASE, FORCA_BASE, INTELIGENCIA_BASE, PODER_MAGICO_BASE, VELOCIDADE_BASE, ARMADURA_BASE, items);

        this.raca = raca;

        this.raca.bonusAtributo(this);
        calcularCriacao();
    }

    public Raca getRaca() {
        return raca;
    }

    public Classe getClasse() {
        return classe;
    }


    //------------------//


    @Override
    public int usarHabilidade(Habilidade habilidade) {
        if (!getHabilidadesEquipadas().contains(habilidade)){

            throw new RuntimeException("Essa habilidade não está equipada");
        }

        gastarMana(habilidade.getCustoMana());

        if (getClasse() != null){
            return getClasse().calcularDanoHabilidade(habilidade, this);
        }

        return (int) (habilidade.getDano() + getForca() * 0.20);

    }

    @Override
    public boolean podeAddHabilidade(Habilidade habilidade) {

        if (habilidade.getRequisitoClasse() == null && habilidade.getRequisitoMonstro() == null){
            return true;
        } else if (habilidade.getRequisitoClasse() == this.classe && habilidade.getRequisitoMonstro() == null) {
            return true;
        }

        else return false;
    }

}
