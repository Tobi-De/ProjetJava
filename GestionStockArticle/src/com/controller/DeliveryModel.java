package com.controller;

public  abstract  class DeliveryModel {
    protected int stockMinimum;
    protected int stockMaximun;

    public DeliveryModel(int stockMinimum, int stockMaximun ) {
        this.stockMinimum = stockMinimum;
        this.stockMaximun = stockMaximun;
    }

    public boolean isSupplyNecessary(int nbrInStock){
        return (nbrInStock <= this.stockMinimum);
    }

    public int getStockMaximun() {
        return stockMaximun;
    }

    public void setStockMaximun(int stockMaximum) {
        this.stockMaximun = stockMaximum;
    }

    public int getStockMinimum() {
        return stockMinimum;
    }

    public void setStockMinimum(int stockMinimum) {
        this.stockMinimum = stockMinimum;
    }
    public  abstract SupplyOrder  emitSupplyOrder(ArticleSheet article);
    public abstract String getDescription();
    public abstract String getModelName();

}
