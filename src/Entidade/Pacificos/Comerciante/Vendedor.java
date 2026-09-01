package Entidade.Pacificos.Comerciante;

import Item.Item;

public interface Vendedor {

    Item vender(Item item, double valor);
    public void receberDinheiro(double valor);

    }
