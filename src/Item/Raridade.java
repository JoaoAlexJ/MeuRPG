package Item;

public enum Raridade {

    COMUM(5),
    INCOMUM(10),
    RARO(20),
    EPICO(30),
    LENDARIO(40),
    DIVINO(100);

    private int buff;

    Raridade(int buff) {
        this.buff = buff;
    }

    public int getBuff() {
        return buff;
    }
}
