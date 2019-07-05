package com.controller;

public class ArticleSheet {
    private int id;
    private String articleName;
    private int storeReference;
    private double price;
    private int stockNbr;
    private ArticleFamily family;
    private DeliveryModel deliveryModelType;
    private boolean available;
    private Historic movementHistoric;

    public ArticleSheet(String articleName, int storeReference, double price, int stockNbr, ArticleFamily family, DeliveryModel deliveryModelType) {
        this.id=0;
        this.articleName = articleName;
        this.storeReference = storeReference;
        this.price = price;
        this.stockNbr = stockNbr;
        this.family = family;
        this.deliveryModelType = deliveryModelType;
        this.available=true;
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

    public boolean isAvailable()
    {
        return  this.available;
    }

    public void setAvailability(boolean availability)
    {
        this.available=availability;
    }

    public double buyArticle(int quantity){
        if(quantity <= this.stockNbr){
            this.removeQuantity(quantity);
            return  quantity * this.getPrice();
        }
        return 0;
    }

    public boolean addQuantity(int quantity){
        //verifiy if quantity + actualNbrInstock <= stockMax
        int finalQuantity = quantity + this.stockNbr;
        if(finalQuantity <= deliveryModelType.getStockMaximun()) {
            this.setStockNbr(finalQuantity);
            setAvailability(true);
            return true;
        }
        return false;
    }

    public boolean removeQuantity(int quantity){
        //verifiy if quantity <= actualNbrInstock
        if(quantity <= this.stockNbr){
            this.stockNbr -= quantity;
            if(this.stockNbr <= deliveryModelType.getStockMinimum())
                setAvailability(false);
            return true;
        }else
            return false;
    }

    public Historic getMovementHistoric() {
        return movementHistoric;
    }

    public ArticleSheet copy(){
        return new ArticleSheet(this.articleName, this.storeReference, this.price, this.stockNbr, this.family, this.deliveryModelType);
    }

    public String toString(){
        String repr = "" +
                "\nID: " + this.id+
                "\nNom: " + this.articleName+
                "\nID du Magasin de provenence: " + this.storeReference+
                "\nPrix: " + this.price+
                "\nFamille: " + this.family.getFamilyName()+
                "\nModele d'approsivionnement: "+ this.deliveryModelType.getModelName()+
                "\nDisponibilite: " + this.available+
                "\nHistoric: " + this.movementHistoric.getHistoric();
        return repr;
    }
}

