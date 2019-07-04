package com.controller;

public class VariableDeliveryModel  extends DeliveryModel{
    private int quantityToOrder;

    public VariableDeliveryModel(int stockMaximun, int quantityToOrder) {
        super(0, stockMaximun);
        this.quantityToOrder = quantityToOrder;
    }

    /**
     *return a value that always below the maximum stock taking account
     * of the number of product sill available in the stock
     */

    public int calculateQuantityToOrder(int nbrInStock){
        if(this.quantityToOrder > this.stockMaximun ||(this.quantityToOrder + nbrInStock) > stockMaximun )
            return stockMaximun - nbrInStock;
        return this.quantityToOrder;
    }

    public int getQuantityToOrder() {
        return quantityToOrder;
    }

    public void setQuantityToOrder(int quantityToOrder) {
        this.quantityToOrder = quantityToOrder;
    }

    public SupplyOrder emitSupplyOrder(ArticleSheet article) {
        return new SupplyOrder(article.getId(), calculateQuantityToOrder(article.getStockNbr()));
    }

    public String getDescription(){
        String description;
        description = "Ce modele vous donne la choisir vous en meme en fonction de la periode et de vos " +
                "prevision la quantiter qui sera reapprovisionner. Noter que vous ne pourrez pas depasser la taille" +
                "de valeur indiquer comme stock Maximum.  ";
        return description;
    }

    @Override
    public String getModelName() {
        return "Modele de reapprovisionnement Variable";
    }
}
