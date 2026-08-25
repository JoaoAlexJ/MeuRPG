package Entidade;

import Habilidade.Habilidade;

import java.util.ArrayList;
import java.util.List;
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

    private double dinheiro;
    private List<Habilidade> habilidadesEquipadas;
    private List<Habilidade> habilidadesAprendidas;

    public Entidade(String nome, int nivel, int mana, int vida, int forca,
                    int inteligencia, int poderMagico, int velocidade, int armadura) {
        if (nivel <= 0 ) throw new IllegalArgumentException("Nivel inválido");

        if (mana <= 0) throw new IllegalArgumentException("Mana inválida");

        if (forca <= 0) throw new IllegalArgumentException("Força inválida");

        if (inteligencia <= 0) throw new IllegalArgumentException("Inteligência inválida");

        if (poderMagico < 0) throw new IllegalArgumentException("Poder mágico inválido");

        if (velocidade <= 0 )throw new IllegalArgumentException("Velocidade inválida");

        if (vida <= 0)throw new IllegalArgumentException("Vida inválida");

        if (armadura <= 0)throw new IllegalArgumentException("Armadura inválida");


        this.nome = Objects.requireNonNull(nome);
        this.nivel = nivel;
        this.mana = mana;
        this.vida = vida;
        this.forca = forca;
        this.inteligencia = inteligencia;
        this.poderMagico = poderMagico;
        this.velocidade = velocidade;
        this.armadura = armadura;

        this.dinheiro = 0;

        this.habilidadesEquipadas = new ArrayList<>();
        this.habilidadesAprendidas = new ArrayList<>();
    }

    public int atacar(){
        return forca;
    }

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

    public abstract boolean podeAddHabilidade(Habilidade habilidade);

    public void aprenderHabilidade(Habilidade habilidade){
        if (!podeAddHabilidade(habilidade)){
            throw new RuntimeException("A entidade não pode aprender essa habilidade");
        }

        habilidadesAprendidas.add(habilidade);
    }

    public void equiparHabilidade(String nomeHabilidade){

        if (habilidadesEquipadas.size() == 5){
            throw new RuntimeException("Limite de habilidades equipadas atingido");
        }

        Habilidade hab = habilidadesAprendidas.stream()
                        .filter(h -> h.getNome().equalsIgnoreCase(nomeHabilidade))
                .findFirst().orElseThrow(() -> new RuntimeException("Habilidade não encontrada."));


        habilidadesEquipadas.add(hab);
    }
    //----------------------------------//


    public List<Habilidade> getHabilidadesAprendidas() {
        return new ArrayList<>(habilidadesAprendidas);
    }

    public List<Habilidade> getHabilidadesEquipadas() {
        return new ArrayList<>(habilidadesEquipadas);
    }

    public int getVida() {
        return vida;
    }

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

    public double getDinheiro() {
        return dinheiro;
    }

    public int getArmadura() {
        return armadura;
    }

    //----------//


    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setMana(int mana) {
        if (mana <= 0) throw new IllegalArgumentException("Mana inválida");


        this.mana = mana;
    }

    public void setVida(int vida) {
        if (vida <= 0 )throw new IllegalArgumentException("vida inválida");

        this.vida = vida;
    }

    public void setForca(int forca) {
        if (forca <= 0 )throw new IllegalArgumentException("Força inválida");


        this.forca = forca;
    }

    public void setInteligencia(int inteligencia) {
        if (inteligencia <= 0 )throw new IllegalArgumentException("Inteligência inválida");


        this.inteligencia = inteligencia;
    }

    public void setPoderMagico(int poderMagico) {
        if (poderMagico <= 0 )throw new IllegalArgumentException("Poder Magico inválida");


        this.poderMagico = poderMagico;
    }

    public void setVelocidade(int velocidade) {
        if (velocidade <= 0 )throw new IllegalArgumentException("Velocidade inválida");


        this.velocidade = velocidade;
    }

    public void setArmadura(int armadura) {
        if (armadura <= 0 )throw new IllegalArgumentException("Armadura inválida");


        this.armadura = armadura;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }
}
