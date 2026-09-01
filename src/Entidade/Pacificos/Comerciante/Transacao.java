package Entidade.Pacificos.Comerciante;

import Item.Item;

public class Transacao {

    public static void realizar(Vendedor vendedor, Comprador comprador, Item item){

        double valor = item.getPreco();

        comprador.comprar(vendedor.vender(item, valor), valor);

    }
}
