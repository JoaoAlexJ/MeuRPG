package Item;

import Efeito.Efeito;

public class Acessorio extends Item implements BonusRaridade{

    private SlotAcessorio slotAcessorio;
    private BuffAcessorio buffAcessorio;
    private int valor;


    public Acessorio(String nome, Raridade raridade, int preco, SlotAcessorio slotAcessorio, BuffAcessorio buffAcessorio, Efeito efeito) {
        super(nome, raridade, preco, efeito);

        this.slotAcessorio = slotAcessorio;
        this.buffAcessorio = buffAcessorio;
        this.valor = buffAcessorio.getValorBase();

        aplicarBonusRaridade();
    }

    public Acessorio(String nome, Raridade raridade, double preco, SlotAcessorio slotAcessorio, BuffAcessorio buffAcessorio) {
        super(nome, raridade, preco);

        this.slotAcessorio = slotAcessorio;
        this.buffAcessorio = buffAcessorio;
        this.valor = buffAcessorio.getValorBase();

        aplicarBonusRaridade();
    }


    @Override
    public void aplicarBonusRaridade() {
        this.valor += getRaridade().getBuff();
    }
    //------------------------------//


    public SlotAcessorio getSlotAcessorio() {
        return slotAcessorio;
    }

    public BuffAcessorio getBuffAcessorio() {
        return buffAcessorio;
    }

    public int getValor() {
        return valor;
    }
}
