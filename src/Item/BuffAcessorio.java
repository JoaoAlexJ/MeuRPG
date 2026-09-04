package Item;

public enum BuffAcessorio {

    MANA(100),
    VIDA(100),
    FORCA(15),
    PODER_MAGICO(15),
    INTELIGENCIA(5),
    VELOCIDADE(5),
    ARMADURA(10);

    private int valorBuff;

    BuffAcessorio(int valorBuff) {
        this.valorBuff = valorBuff;
    }


    //-------------------//
    public int getValorBase() {
        return valorBuff;
    }

}
