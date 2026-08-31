package Entidade.Personagem.Jogador;

import Entidade.Pacificos.Comerciante;
import Entidade.Personagem.Personagem;
import Entidade.Personagem.Classe;
import Entidade.Personagem.Raca;
import Entidade.Vendedor;
import Habilidade.Habilidade;
import Item.Item;

public class Jogador extends Personagem implements Vendedor {

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

    //-----------------//

    @Override
    public Item vender(Item item, double valor){

        if (inventario.getItems().contains(item) && valor == item.getPreco()){

            inventario.removerItem(item);
            setDinheiro(getDinheiro() + valor);
            return item;
        }

        System.err.println("Erro na venda");
        return null;
    }

    public void comprarItem(Comerciante comerciante, Item item){

        if (getDinheiro() >= item.getPreco()){

            inventario.adicionarItem(comerciante.vender(item, gastarDinheiro(item.getPreco())));

        }

    }

    public double gastarDinheiro(double valor){
        if (valor > getDinheiro())throw new IllegalArgumentException("saldo insuficiente");
        if (valor <= getDinheiro())throw new IllegalArgumentException("Valor inválido");

        setDinheiro(getDinheiro() - valor);
        return valor;

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
