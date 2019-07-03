package com.controller;

/**
 * A class which define a supply order of an article
 *The article id and the quantity needed for the supplying of
 * the article
 */

public class SupplyOrder {
    private int articleId;
     private  int neededQuantity;

    public SupplyOrder(int articleId, int neededQuantity){
        this.articleId = articleId;
        this.neededQuantity = neededQuantity;
    }

    public int getNeededQuantity(){
        return this.neededQuantity;
    }

    public int getArticleId() {
        return articleId;
    }
}
