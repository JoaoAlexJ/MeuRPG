package Item;

import Efeito.Efeito;

public class Armadura extends Item implements  BonusRaridade{

    private SlotArmadura slotArmadura;
    private int poderProtecao;

    public Armadura(String nome, Raridade raridade, int preco, SlotArmadura slotArmadura, int poderProtecao, Efeito efeito) {
        super(nome, raridade, preco, efeito);

        this.slotArmadura = slotArmadura;
        this.poderProtecao = poderProtecao;
    }

    public Armadura(String nome, Raridade raridade, double preco, SlotArmadura slotArmadura, int poderProtecao) {
        super(nome, raridade, preco);

        this.slotArmadura = slotArmadura;
        this.poderProtecao = poderProtecao;
    }


    //-----------//


    public int getPoderProtecao() {
        return poderProtecao;
    }

    public SlotArmadura getSlotArmadura() {
        return slotArmadura;
    }

    @Override
    public void aplicarBonusRaridade() {
        this.poderProtecao += getRaridade().getBuff();
    }
}
