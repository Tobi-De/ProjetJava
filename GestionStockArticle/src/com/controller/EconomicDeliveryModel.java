package com.controller;
import java.lang.Math;


public class EconomicDeliveryModel extends  DeliveryModel {
    private int totalUnitPerYear;
    private int launchCommandPrice;

    /**
     * A class which defines a delivery model for an article
     * @param totalUnitPerYear the total unit of the product sold per year
     * @param launchCommandPrice  the the launch command price of one product of the Article
     */
    public EconomicDeliveryModel(int totalUnitPerYear, int launchCommandPrice,  int stockMinimum) {
        super(stockMinimum, 0);
        this.totalUnitPerYear = totalUnitPerYear;
        this.launchCommandPrice = launchCommandPrice;
    }

    public  SupplyOrder  emitSupplyOrder(ArticleSheet article){
        return new SupplyOrder(article.getId(), calculateQuantityToOrder(article.getPrice(), article.getStockNbr()));
    }

    /**
     * @return the quantity to order using the wilson formula
     */
    public int calculateQuantityToOrder(double articlePrice, int nbrInStock){
        return (int)Math.sqrt(2* this.totalUnitPerYear  * this.launchCommandPrice / (articlePrice * nbrInStock));
    }

    public String getDescription() {
        String description = "Ce modele vous permet de calculer automatiquement la quantiter a reapprovisionner" +
                "dans le but d'optimiser le cout du stockage. Elle vous permet de faire le minimum de commandes" +
                "pour votre article et d'obtenir le cout de stockage optimal pour ce meme article.";
        return description;
    }
}
