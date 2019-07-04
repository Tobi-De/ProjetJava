package com.controller;

import java.util.ArrayList;

public class Store {
    private int id = 0;
    private ArrayList<ArticleSheet> articleSheetList;
    private ArrayList<SupplyOrder> listOfSuppliesOrders = new ArrayList<>();
    private ArrayList<Integer> listOfBookArticle = new ArrayList<>();

    public Store() {
    }

    public Store(ArrayList<ArticleSheet> articleSheetList) {
        this.articleSheetList = new ArrayList<>();
        this.articleSheetList = articleSheetList;
    }

    public void addArticleSheet(ArticleSheet articleSheet){
        int articleId = 0;
        this.articleSheetList.add(articleSheet);
        articleId = this.articleSheetList.size() - 1;
        this.articleSheetList.get(articleId).setId(articleId);
        this.articleSheetList.get(articleId).setStoreReference(this.id);
    }

    public boolean editArticleSheet(String articleName, ArticleSheet newArticleSheetData){
        if(isArticleSheetInStore(articleName)){
            int artilceId = getIdOf(articleName);
            this.articleSheetList.set(artilceId, newArticleSheetData);
            return true;
        }
        return false;
    }

    public boolean isArticleSheetInStore(String articleName){
        int articleId = getIdOf(articleName);
        if(articleId < this.articleSheetList.size()) return  true;
        return false;
    }

    public void removeArticleSheet(String articleName){
        if(isArticleSheetInStore(articleName)){
            int articleId = getIdOf(articleName);
            this.articleSheetList.remove(articleId);
        }
    }

    public void removeAllArticleSheet(){
        this.articleSheetList.clear();
        clearBookArticlesList();
        clearSupplyOrderList();
    }

    public ArticleSheet getArticleSheet(String articleName){
        if(isArticleSheetInStore(articleName)){
            int articleId = getIdOf(articleName);
            return this.articleSheetList.get(articleId);
        }
        return null;
    }

    public int getIdOf(String articleName){
        for(int i = 0; i < this.articleSheetList.size(); i++)
            if (articleName.equals(this.articleSheetList.get(i).getArticleName())) return i;
        return -1;
    }

    public boolean articleTransfer(Store toStore, String articleName,  int quantityToTransfer){
        // try to remoev quantity  from article
        ArticleSheet articleInActualStore = this.getArticleSheet(articleName);
        if( articleInActualStore.removeQuantity(quantityToTransfer)){
            //try to get the reference of the article in the other store
            ArticleSheet articleSheetInToStore = toStore.getArticleSheet(articleName);
            if(articleSheetInToStore != null){
                //int transferableQuantity = articleSheetInToStore.getDeliveryModelType().getStockMaximun() - articleSheetInToStore.getStockNbr();
                // if article exist in the other store, make the transfer
                if(articleSheetInToStore.addQuantity(quantityToTransfer)){
                    if(articleInActualStore.getDeliveryModelType().isSupplyNecessary(articleInActualStore.getStockNbr())){
                        this.addSupplyOrder(articleInActualStore.getDeliveryModelType().emitSupplyOrder(articleInActualStore));
                    }
                    return true;
                }
                return false;
            }else{
                toStore.addArticleSheet(this.getArticleSheet(articleName));
                toStore.getArticleSheet(articleName).setStockNbr(quantityToTransfer);
                return true;
            }
        }
        return false;

        //si oui on effectue le transfert
        //si non, on ajoute l'article et on transfer
    }

    public boolean transferArticleQuantity(String firstArticleName, String secondArticleName, int quantityToTransfer){
        return  true;
    }

    public boolean orderArticles(Command command){
        return  true;
    }

    public boolean bookAnArticle(String articleName, int quantity){
        return true;
    }

    public void removeArticleFromBookList(String articleName){
        return;
    }

    public void clearBookArticlesList(){
        this.listOfBookArticle.clear();
    }

    public void articleSupply(){
        return;
    }

    public void addSupplyOrder(SupplyOrder newSupplyOrder){
        return;
    }

    public void removeSupplyOrder(SupplyOrder supplyOrder){
        return;
    }

    public void clearSupplyOrderList(){
        this.listOfSuppliesOrders.clear();
    }
}
