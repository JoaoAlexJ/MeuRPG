package Efeito;

import Entidade.Entidade;

public abstract class EfeitoAtivo {

    private Efeito efeito;
    private int duracao;

    Entidade origem;
    Entidade alvo;

    public EfeitoAtivo(Efeito efeito, int duracao, Entidade origem, Entidade alvo) {
        if (duracao <= 0 ){
            throw new IllegalArgumentException("Duração inválida");
        }

        this.efeito = efeito;
        this.origem = origem;
        this.alvo = alvo;

        this.duracao = duracao;
    }


    public abstract void execultar();

    public void aplicar(){

        if (this.duracao >0) {
            execultar();
        }


    }

    //---------------//

    public int getDuracao() {
        return duracao;
    }

    public Entidade getOrigem() {
        return origem;
    }

    public Entidade getAlvo() {
        return alvo;
    }

    //-----------------//

    public void diminuirDuracao(){
        if (duracao == 0){
            throw new RuntimeException("Duração está zerada");
        }

        this.duracao--;
    }
}
