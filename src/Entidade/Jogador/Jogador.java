package Entidade.Jogador;

import Entidade.Personagem;
import Entidade.Classe;
import Habilidade.Habilidade;

public class Jogador extends Personagem {

    private int xp;
    private Inventario inventario;

    private static final int VIDA_BASE = 800;
    private static final int MANA_BASE = 200;
    private static final int FORCA_BASE = 20;
    private static final int INTELIGENCIA_BASE = 10;
    private static final int PODER_MAGICO_BASE = 25;
    private static final int VELOCIDADE_BASE = 10;
    private static final int ARMADURA_BASE = 15;

    public Jogador(String nome, int nivel, Raca raca, Classe classe) {
        super(nome, nivel, MANA_BASE, VIDA_BASE, FORCA_BASE, INTELIGENCIA_BASE, PODER_MAGICO_BASE, VELOCIDADE_BASE, ARMADURA_BASE, raca, classe);


        this.xp = 0;

        this.inventario = new Inventario();

    }

    public void subirNivel(){
        setNivel(getNivel() + 1);

        setForca(getForca() +10);

        setManaMaxima(getManaMaxima() +50);
        setManaAtual(getManaAtual() +50);

        setVidaMaxima(getVidaMaxima() +100);
        setVidaAtual(getVidaAtual() +100);

        setInteligencia(getInteligencia() +10);
        setArmadura(getArmadura() +10);
        setPoderMagico(getPoderMagico() +10);
        setVelocidade(getVelocidade() +10);

        getRaca().bonusAtributo(this);
        getClasse().bonusClasse(this);
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


    @Override
    public boolean podeAddHabilidade(Habilidade habilidade) {
        if (habilidade.getRequisitoClasse() == null && habilidade.getRequisitoMonstro() == null){
            return true;
        }
        else if (habilidade.getRequisitoClasse() == getClasse() && habilidade.getRequisitoMonstro() == null){
            return true;

        }
        else return false;
    }
}
