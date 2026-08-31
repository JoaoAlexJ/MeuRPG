package Entidade;

import Entidade.Alvos.Criatura;
import Entidade.Jogador.Raca;
import Habilidade.Habilidade;
import Item.DropItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Npc extends Criatura {

    private List<String> falas;

    public Npc(String nome, int nivel, Raca raca, List<DropItem> items, List<String> falas, Classe classe) {
        super(nome, nivel, raca, items, classe);

        this.falas = Objects.requireNonNull(falas);
    }

    public Npc(String nome, int nivel, Raca raca, List<DropItem> items, List<String> falas) {
        super(nome, nivel, raca, items);

        this.falas = Objects.requireNonNull(falas);
    }


    public void adicionarFala(String fala){
        if (fala == null || fala.isBlank()) throw new IllegalArgumentException("Fala inválida");

        falas.add(fala);
    }

    public String retornarFala(int posicao){
        if (posicao < 0 || posicao >= falas.size()) throw new IllegalArgumentException("Indice inválido");

        return falas.get(posicao);
    }

    //---------------------//




    public List<String> getFalas() {
        return new ArrayList<>(falas);
    }


    @Override
    public int usarHabilidade(Habilidade habilidade) {

        if (!getHabilidadesEquipadas().contains(habilidade)){

            throw new RuntimeException("Essa habilidade não está equipada");
        }

        if (getClasse().equals(Classe.MAGO)){
            return (int)(habilidade.getDano() + getPoderMagico() * 0.85 + getInteligencia());

        } else if (getClasse().equals(Classe.ARQUEIRO)) {
            return (int)(habilidade.getDano() + getForca() * 0.40 + getInteligencia() * 0.40 + getVelocidade() * 0.10);

        } else if (getClasse().equals(Classe.ASSASINO)) {
            return (int)(habilidade.getDano() + getForca() * 0.85 +getVelocidade() * 0.05 );

        } else if (getClasse().equals(Classe.GUERREIRO)) {
            return (int)(habilidade.getDano() + getForca() + getArmadura() * 0.38);
        }

        else return (int) (habilidade.getDano() + getForca() * 0.20);

    }

    @Override
    public boolean podeAddHabilidade(Habilidade habilidade) {
        if (habilidade.getRequisitoClasse() == null && habilidade.getRequisitoMonstro() == null){
            return true;
        }else if (habilidade.getRequisitoClasse() == getClasse() && habilidade.getRequisitoMonstro() == null){
            return true;
        }

        else return false;
    }
}
