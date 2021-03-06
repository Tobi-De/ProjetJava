package com.controller;

public class MaximumStockDeliveryModel extends DeliveryModel{

    public MaximumStockDeliveryModel(int stockMinimum, int stockMaximum) {
        super(stockMinimum, stockMaximum);
    }

    public MaximumStockDeliveryModel(int stockMaximum) {
        super(stockMaximum,  stockMaximum);
    }

    @Override
    public boolean isSupplyNecessary(int nbrInStock) {
        if(stockMinimum == stockMaximun)  return nbrInStock < stockMaximun;
        return nbrInStock <= stockMinimum;
    }

    public int calculateQuantityToOrder(int nbrInStock){
        return stockMaximun - nbrInStock;
    }

    @Override
    public  SupplyOrder  emitSupplyOrder(ArticleSheet article){
        return new SupplyOrder(article.getId(), calculateQuantityToOrder(article.getStockNbr()));
    }

@Override
    public String getDescription(){
        String description = "Ce Model offre deux options. La premiere Consiste a avoir un stock fixe pour" +
                "votre article en ne precisant pas de valeur de stock Minimum, Le reapprovisionnement sera fait" +
                "a chaque fois qu'un produit de l'article est ecoule. La deuxieme possibililte consiste a fixer un stock" +
                "Minimum, dans ce cas le reapprovisionnement sera fait chaque fois que ce dernier est atteint. Dans" +
                "les deux cas le reapprosisionnement ramenera le stock a sa valeur Maximum.";
        return  description;
    }

    @Override
    public String getModelName() {
        return "Modele de Reapprovisonnement plein";
    }
}
