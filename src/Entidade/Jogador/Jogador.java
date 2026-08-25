package Entidade.Jogador;

import Entidade.Entidade;
import Entidade.Classe;

public class Jogador extends Entidade {

    private int xp;
    private Raca raca;
    private Inventario inventario;
    private Classe classe;

    private static final int VIDA_BASE = 800;
    private static final int MANA_BASE = 200;
    private static final int FORCA_BASE = 20;
    private static final int INTELIGENCIA_BASE = 10;
    private static final int PODER_MAGICO_BASE = 25;
    private static final int VELOCIDADE_BASE = 10;
    private static final int ARMADURA_BASE = 15;

    public Jogador(String nome, int nivel, Classe classe, Raca raca) {
        super(nome, nivel, MANA_BASE, VIDA_BASE, FORCA_BASE, INTELIGENCIA_BASE, PODER_MAGICO_BASE, VELOCIDADE_BASE, ARMADURA_BASE);


        this.classe = classe;
        this.raca = raca;
        this.xp = 0;

        this.inventario = new Inventario();

        this.raca.bonusAtributo(this);
        this.classe.bonusClasse(this);
    }

    public void subirNivel(){
        setNivel(getNivel() + 1);

        setForca(getForca() +10);
        setMana(getMana() +50);
        setVida(getVida() +100);
        setInteligencia(getInteligencia() +10);
        setArmadura(getArmadura() +10);
        setPoderMagico(getPoderMagico() +10);
        setVelocidade(getVelocidade() +10);

        raca.bonusAtributo(this);
        this.classe.bonusClasse(this);
    }

    public void receberXP(int xp){

        this.xp += xp;

        while (this.xp >= getNivel() * 110){
            this.xp -= getNivel() * 110;

            subirNivel();
        }
    }

    public Inventario getInventario() {
        return inventario;
    }

    public int getXp() {
        return xp;
    }

    public Classe getClasse() {
        return classe;
    }

    public Raca getRaca() {
        return raca;
    }


}
