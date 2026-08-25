package Habilidade;

import Entidade.Alvos.TipoMonstro;
import Entidade.Classe;
import Entidade.Jogador.Raca;
import Item.Raridade;

public class Habilidade {

    private String nome;
    private int dano;
    private int custoMana;
    private Raridade raridade;
    private Classe requisitoClasse;
    private TipoMonstro requisitoMonstro;
    private TipoHabilidade tipoHabilidade;

    public Habilidade(String nome, int dano, int custoMana, Raridade raridade, TipoMonstro requisitoMonstro, TipoHabilidade tipoHabilidade ) {

        this.nome = nome;
        this.dano = dano;
        this.custoMana = custoMana;
        this.raridade = raridade;
        this.requisitoMonstro = requisitoMonstro;
        this.tipoHabilidade = tipoHabilidade;

    }

    public Habilidade(String nome, int dano, int custoMana, Raridade raridade, Classe requisitoClasse ) {
        this.nome = nome;
        this.dano = dano;
        this.custoMana = custoMana;
        this.raridade = raridade;
        this.requisitoClasse = requisitoClasse;
    }


    //--------------------------//
    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }

    public int getCustoMana() {
        return custoMana;
    }

    public Raridade getRaridade() {
        return raridade;
    }

    public Classe getRequisitoClasse() {
        return requisitoClasse;
    }

    public TipoMonstro getRequisitoMonstro() {
        return requisitoMonstro;
    }

    public TipoHabilidade getTipoHabilidade() {
        return tipoHabilidade;
    }
}
