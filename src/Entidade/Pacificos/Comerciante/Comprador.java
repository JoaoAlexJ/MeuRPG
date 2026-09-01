package Entidade.Pacificos.Comerciante;

import Item.Item;

public interface Comprador {

    void comprar (Item item, double valor);
    public double pagar(double valor);

    }
