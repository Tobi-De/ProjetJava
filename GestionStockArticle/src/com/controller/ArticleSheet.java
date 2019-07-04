package com.controller;

public class ArticleSheet {
    private int id;
    private String articleName;
    private int storeReference;
    private double price;
    private int stockNbr;
    private ArticleFamily family;
    private DeliveryModel deliveryModelType;
    private boolean block;
    private Historic movementHistoric;

    public ArticleSheet(String articleName, int storeReference, double price, int stockNbr, ArticleFamily family, DeliveryModel deliveryModelType) {
        this.id=0;
        this.articleName = articleName;
        this.storeReference = storeReference;
        this.price = price;
        this.stockNbr = stockNbr;
        this.family = family;
        this.deliveryModelType = deliveryModelType;
        this.block=false;
        this.movementHistoric=new Historic();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public int getStoreReference() {
        return storeReference;
    }

    public void setStoreReference(int storeReference) {
        this.storeReference = storeReference;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockNbr() {
        return stockNbr;
    }

    public void setStockNbr(int stockNbr) {
        this.stockNbr = stockNbr;
    }

    public ArticleFamily getFamily() {
        return family;
    }

    public void setFamily(ArticleFamily family) {
        this.family = family;
    }

    public DeliveryModel getDeliveryModelType() {
        return deliveryModelType;
    }

    public void setDeliveryModelType(DeliveryModel deliveryModelType) {
        this.deliveryModelType = deliveryModelType;
    }

    public boolean quantifyTransfer(int transferToId,int quantityToTransfer) {
        // vérifier si l'ID est valide
        if (quantityToTransfer > this.stockNbr)
            return false;
        return true;
    }

    public boolean isAvailable()
    {
        if(this.stockNbr != 0 || !this.block)
        {
            return  true;
        }
        else
        {
            return false;
        }
    }

    public void setAvailability(boolean block)
    {
        this.block=block;
    }

    public int buyArticle(int quantity){
        return 0;
    }

    public boolean addQuantity(int quantity){
        //verifiy if quantity + actualNbrInstock <= stockMax
        return true;
    }

    public boolean removeQuantity(int quantity){
        //verifiy if quantity <= actualNbrInstock
        return  true;
    }

    public ArticleSheet copy(){
        return new ArticleSheet(this.articleName, this.storeReference, this.price, this.stockNbr, this.family, this.deliveryModelType);
    }
}

