package Entidade;

import Efeito.Efeito;
import Efeito.EfeitoAtivo;
import Habilidade.Habilidade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public abstract class Entidade {

    private String nome;
    private int nivel;
    private int manaMaxima;
    private int manaAtual;

    private int vidaMaxima;
    private int vidaAtual;


    private int forca;
    private int inteligencia;
    private int poderMagico;
    private int velocidade;
    private int armadura;

    private double dinheiro;

    private List<Habilidade> habilidadesEquipadas;
    private List<Habilidade> habilidadesAprendidas;
    private List<EfeitoAtivo> efeitoAtivos;

    public Entidade(String nome, int nivel, int manaMaxima, int vidaMaxima, int forca,
                    int inteligencia, int poderMagico, int velocidade, int armadura) {
        if (nivel <= 0 ) throw new IllegalArgumentException("Nivel inválido");

        if (manaMaxima <= 0) throw new IllegalArgumentException("Mana inválida");

        if (forca <= 0) throw new IllegalArgumentException("Força inválida");

        if (inteligencia <= 0) throw new IllegalArgumentException("Inteligência inválida");

        if (poderMagico < 0) throw new IllegalArgumentException("Poder mágico inválido");

        if (velocidade <= 0 )throw new IllegalArgumentException("Velocidade inválida");

        if (vidaMaxima <= 0)throw new IllegalArgumentException("Vida inválida");

        if (armadura <= 0)throw new IllegalArgumentException("Armadura inválida");


        this.nome = Objects.requireNonNull(nome);
        this.nivel = nivel;
        this.manaMaxima = manaMaxima;
        this.manaAtual = manaMaxima;

        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;

        this.forca = forca;
        this.inteligencia = inteligencia;
        this.poderMagico = poderMagico;
        this.velocidade = velocidade;
        this.armadura = armadura;

        this.dinheiro = 0;

        this.habilidadesEquipadas = new ArrayList<>();
        this.habilidadesAprendidas = new ArrayList<>();
        this.efeitoAtivos = new ArrayList<>();
    }

    public int atacar(){
        return forca;
    }

    public abstract int usarHabilidade(Habilidade habilidade);

    public int receberDano(int dano){

        int danoFinal = dano - this.armadura;

        if (danoFinal <= 4 ){
            danoFinal = 5;
        }

        this.vidaAtual -= danoFinal;
        return danoFinal;
    }

    public void receberDanoVerdadeiro(int dano){

        this.vidaAtual -= dano;

        if (this.vidaAtual < 0){
            this.vidaAtual = 0;
        }
    }

    public void aplicarEfeitos(){

        if (!efeitoAtivos.isEmpty()){

            Iterator<EfeitoAtivo> it = efeitoAtivos.iterator();

            while (it.hasNext()){

                EfeitoAtivo e = it.next();

                if (e.getDuracao() == 0){
                    it.remove();
                }

            }

        }

    }

    public void adicionarEfeito(EfeitoAtivo efeitoAtivo){
        if (efeitoAtivo.getAlvo().equals(this)){

            throw new RuntimeException("Esse efeito não aplicado a essa entidade");
        }


        efeitoAtivos.add(efeitoAtivo);
    }

    public boolean estaVivo(){
        return this.vidaAtual > 0;
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

    public void gastarMana(int valor){

        if (valor > this.manaAtual){
            throw new IllegalArgumentException("Mana insuficiente");
        }

        this.manaAtual -= valor;

    }
    //----------------------------------//


    public List<Habilidade> getHabilidadesAprendidas() {
        return new ArrayList<>(habilidadesAprendidas);
    }

    public List<Habilidade> getHabilidadesEquipadas() {
        return new ArrayList<>(habilidadesEquipadas);
    }

    public List<EfeitoAtivo> getEfeitos() {
        return new ArrayList<>(efeitoAtivos);
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public int getManaAtual() {
        return manaAtual;
    }

    public int getManaMaxima() {
        return manaMaxima;
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

    public void setManaAtual(int mana) {
        if (mana <= 0) throw new IllegalArgumentException("Mana inválida");


        this.manaAtual = mana;
    }

    public void setManaMaxima(int mana) {
        if (mana <= 0) throw new IllegalArgumentException("Mana inválida");


        this.manaMaxima = mana;
    }

    public void setVidaMaxima(int vida) {
        if (vida <= 0 )throw new IllegalArgumentException("vida inválida");

        this.vidaMaxima = vida;
    }

    public void setVidaAtual(int vida) {
        if (vida <= 0 )throw new IllegalArgumentException("vida inválida");

        this.vidaAtual = vida;
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
