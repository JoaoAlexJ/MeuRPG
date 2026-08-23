import java.util.Objects;

public abstract class Entidade {

    private String nome;
    private int nivel;
    private int mana;
    private int vida;
    private int forca;
    private int inteligencia;
    private int poderMagico;
    private int velocidade;
    private int armadura;

    public Entidade(String nome, int nivel, int mana, int vida, int forca,
                    int inteligencia, int poderMagico, int velocidade, int armadura) {
        if (nivel <= 0 )throw new IllegalArgumentException("Nivel inválido");

        if (mana <= 0) throw new IllegalArgumentException("Mana inválida");

        if (forca <= 0)throw new IllegalArgumentException("Força inválida");

        if (inteligencia <= 0)throw new IllegalArgumentException("Inteligência inválida");

        if (poderMagico < 0)throw new IllegalArgumentException("Poder mágico inválido");

        if (velocidade <= 0 )throw new IllegalArgumentException("Velocidade inválida");

        this.nome = Objects.requireNonNull(nome);
        this.nivel = nivel;
        this.mana = mana;
        this.vida = vida;
        this.forca = forca;
        this.inteligencia = inteligencia;
        this.poderMagico = poderMagico;
        this.velocidade = velocidade;
        this.armadura = armadura;
    }

    public abstract int atacar();

    public void receberDano(int dano){

        int danoFinal = this.armadura - dano;

        if (danoFinal <= 4 ){
            danoFinal = 5;
        }

        this.vida -= danoFinal;


    }

    public void receberDanoVerdadeiro(int dano){

        this.vida -= dano;

        if (this.vida < 0){
            this.vida = 0;
        }
    }

    public boolean estaVivo(){
        return this.vida > 0;
    }

    //----------------------------------//


    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public int getMana() {
        return mana;
    }

    public int getForca() {
        return forca;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getPoderMagico() {
        return poderMagico;
    }

    public int getVelocidade() {
        return velocidade;
    }

    //----------//
}
