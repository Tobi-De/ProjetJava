package com.controller;

public class VariableDeliveryModel  extends DeliveryModel{

    public VariableDeliveryModel(int stockMaximun) {
        super(0, stockMaximun);
    }

    public SupplyOrder emitSupplyOrder(int idArticle, int nbrInStock, int quantityToOrder) {
        return new SupplyOrder(idArticle, calculateQuantityToOrder(nbrInStock, quantityToOrder));
    }

    /**
     *return a value that always below the maximum stock taking account
     * of the number of product sill available in the stock
     */

    public int calculateQuantityToOrder(int nbrInStock, int quantityToOrder){
        if(quantityToOrder > this.stockMaximun ||(quantityToOrder + nbrInStock) > stockMaximun )
            return stockMaximun - nbrInStock;
        return quantityToOrder;
    }

    public String getDesciption(){
        String description;
        description = "Ce modele vous donne la choisir vous en meme en fonction de la periode et de vos " +
                "prevision la quantiter qui sera reapprovisionner. Noter que vous ne pourrez pas depasser la taille" +
                "de valeur indiquer comme stock Maximum.  ";
        return description;
    }
}
