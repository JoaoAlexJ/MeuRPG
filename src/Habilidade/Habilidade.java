package Habilidade;

import Efeito.Efeito;
import Entidade.Alvos.TipoMonstro;
import Entidade.Personagem.Classe;
import Item.BonusRaridade;
import Item.Raridade;

public class Habilidade implements BonusRaridade {

    private String nome;
    private int dano;
    private int custoMana;
    private Raridade raridade;
    private Classe requisitoClasse;

    private TipoMonstro requisitoMonstro;
    private TipoHabilidade tipoHabilidade;

    private Efeito efeito;

    public Habilidade(String nome, int dano, int custoMana, Raridade raridade, TipoHabilidade tipoHabilidade, Efeito efeito, TipoMonstro requisitoMonstro ) {

        this.nome = nome;
        this.dano = dano;
        this.custoMana = custoMana;
        this.raridade = raridade;
        this.requisitoMonstro = requisitoMonstro;
        this.tipoHabilidade = tipoHabilidade;
        this.efeito = efeito;

        aplicarBonusRaridade();

    }

    public Habilidade(String nome, int dano, int custoMana, Raridade raridade, TipoHabilidade tipoHabilidade, Efeito efeito, Classe requisitoClasse ) {
        this.nome = nome;
        this.dano = dano;
        this.custoMana = custoMana;
        this.raridade = raridade;
        this.requisitoClasse = requisitoClasse;
        this.tipoHabilidade = tipoHabilidade;
        this.efeito = efeito;

        aplicarBonusRaridade();
    }

    public Habilidade(String nome, int dano, int custoMana, Raridade raridade, TipoHabilidade tipoHabilidade, Efeito efeito) {

        this.nome = nome;
        this.dano = dano;
        this.custoMana = custoMana;
        this.raridade = raridade;
        this.tipoHabilidade = tipoHabilidade;
        this.efeito = efeito;

        aplicarBonusRaridade();
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

    public Efeito getEfeito() {
        return efeito;
    }

    @Override
    public void aplicarBonusRaridade() {

        this.dano += this.raridade.getBuff();
    }
}
