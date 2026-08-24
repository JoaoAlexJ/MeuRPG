public abstract class Jogador extends Entidade{

    private int xp;
    private Raca raca;

    public Jogador(String nome, int nivel, int mana, int vida, int forca, int inteligencia, int poderMagico, int velocidade, int armadura,
                   Raca raca) {
        super(nome, nivel, mana, vida, forca, inteligencia, poderMagico, velocidade, armadura);


        this.raca = raca;
        this.xp = 0;

        this.raca.bonusAtributo(this);
        bonusClasse();
    }

    public void subirNivel(){
        setNivel(getNivel() + 1);

        setForca(+10);
        setMana(+50);
        setVida(+100);
        setInteligencia(+10);
        setArmadura(+10);
        setPoderMagico(+10);
        setVelocidade(+10);

        raca.bonusAtributo(this);
        bonusClasse();
    }

    public void receberXP(int xp){

        this.xp += xp;

        while (xp >= getNivel() * 110){
            this.xp -= getNivel() * 110;

            subirNivel();
        }
    }

    public abstract void bonusClasse();



}
