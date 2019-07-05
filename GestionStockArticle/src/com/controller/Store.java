package com.controller;

import java.util.ArrayList;

public class Store {
    private int id = 0;
    private ArrayList<ArticleSheet> articleSheetList;
    private ArrayList<SupplyOrder> listOfSuppliesOrders = new ArrayList<>();
    private ArrayList<ArticleReservation> listOfBookArticle = new ArrayList<>();

    public Store() {
        this.articleSheetList = new ArrayList<>();
    }

    public Store(ArrayList<ArticleSheet> articleSheetList) {
        this.articleSheetList = new ArrayList<>();
        this.articleSheetList = articleSheetList;
    }

    public void addArticleSheet(ArticleSheet articleSheet){
        int articleId = 0;
        this.articleSheetList.add(articleSheet.copy());
        articleId = this.articleSheetList.size() - 1;
        this.articleSheetList.get(articleId).setId(articleId);
        this.articleSheetList.get(articleId).setStoreReference(this.id);
    }

    public boolean editArticleSheet(String articleName, ArticleSheet newArticleSheetData){
        if(isArticleSheetInStore(articleName)){
            int articleId = getIdOf(articleName);
            this.articleSheetList.set(articleId, newArticleSheetData);
            return true;
        }
        return false;
    }

    public boolean isArticleSheetInStore(String articleName){
        int articleId = getIdOf(articleName);
        if(articleId == -1) return false;
        return articleId < this.articleSheetList.size();
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

    public ArticleSheet getArticleSheet(int articleId){
        if(articleId < this.articleSheetList.size()){
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
        // try to remove quantity  from article
        boolean transferSucess  = false;
        //transferSucess = false;
        ArticleSheet articleInActualStore = this.getArticleSheet(articleName);
        if(articleInActualStore == null) return false;
        if(!articleInActualStore.isAvailable())  return false;

        if(quantityToTransfer <= articleInActualStore.getStockNbr()){
            //try to get the reference of the article in the other store
            ArticleSheet articleSheetInToStore = toStore.getArticleSheet(articleName);
            if(articleSheetInToStore != null){
                // if article exist in the other store, make the transfer
                transferSucess =  articleSheetInToStore.addQuantity(quantityToTransfer);
            }else{
                toStore.addArticleSheet(articleInActualStore.copy());
                toStore.getArticleSheet(articleName).setStockNbr(quantityToTransfer);
                transferSucess = true;
            }
            if(transferSucess){
                articleInActualStore.removeQuantity(quantityToTransfer);
                updateSupplyOrders(articleInActualStore);
                articleInActualStore.getMovementHistoric().addArticleMove(new ArticleMove(quantityToTransfer, this.getId(),toStore.getId()));
                toStore.getArticleSheet(articleName).getMovementHistoric().addArticleMove(new ArticleMove(quantityToTransfer, toStore.getId(), this.getId()));
            }
        }
      return transferSucess;
    }

    public boolean transferArticleQuantity(String firstArticleName, String secondArticleName, int quantityToTransfer){
        ArticleSheet firstArticle = getArticleSheet(firstArticleName);
        ArticleSheet secondArticle = getArticleSheet(secondArticleName);

        //verify is both article exist
        if(firstArticle == null  || secondArticle == null) return false;

        //verify is the article to transfer is available
        if(!firstArticle.isAvailable()) return false;

        if(firstArticle.getFamily().equals(secondArticle.getFamily())){
            if(firstArticle.getStockNbr() >= quantityToTransfer)
                if(secondArticle.addQuantity(quantityToTransfer)) {
                    firstArticle.removeQuantity(quantityToTransfer);
                   updateSupplyOrders(firstArticle);
                   firstArticle.getMovementHistoric().addArticleMove(new ArticleMove(quantityToTransfer, this.getId(), this.getId()));
                   secondArticle.getMovementHistoric().addArticleMove(new ArticleMove(quantityToTransfer, this.getId(), this.getId()));
                   return true;
                }
        }
        return  false;
    }


    public boolean orderArticles(Command command){
        for(int i = 0; i < command.getArticleList().size(); i++){
             if(command.getArticleList().get(i).removeQuantity(command.getQuantityList().get(i)))
                 updateSupplyOrders(command.getArticleList().get(i));
             else
                 return false;
        }
        return true;
    }

    public boolean bookAnArticle(ArticleReservation articleReservation){
        ArticleSheet article = getArticleSheet(articleReservation.getArticleId());
        if(isArticleSheetInStore(article.getArticleName())){
            if(article.isAvailable()){
                if(article.removeQuantity(articleReservation.getQuantityBook())){
                    this.listOfBookArticle.add(articleReservation);
                    updateSupplyOrders(article);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public void removeArticleFromBookList(String articleName){
        if(isArticleSheetInStore(articleName))
            if(this.listOfBookArticle.size() >=1){
                for(int i = 0; i < this.listOfBookArticle.size(); i++){
                    if(this.listOfBookArticle.get(i).getArticleId() == getIdOf(articleName)) {
                        this.listOfBookArticle.remove(i);
                        break;
                    }
                }
            }
    }

    public void clearBookArticlesList(){
        this.listOfBookArticle.clear();
    }

    public void articleSupply(){
        for(int i = 0; i < this.listOfSuppliesOrders.size(); i++){
            getArticleSheet(i).addQuantity(this.listOfSuppliesOrders.get(i).getNeededQuantity());
        }
        this.listOfSuppliesOrders.clear();
    }

    public void updateSupplyOrders(ArticleSheet article){
        if(article.getDeliveryModelType().isSupplyNecessary(article.getStockNbr())){
            article.setAvailability(false);
            this.addSupplyOrder(article.getDeliveryModelType().emitSupplyOrder(article));
        }
    }

    public void addSupplyOrder(SupplyOrder newSupplyOrder){
        this.listOfSuppliesOrders.add(newSupplyOrder);
    }

    public void removeSupplyOrder(SupplyOrder supplyOrder){
        for(int i = 0; i < this.listOfSuppliesOrders.size(); i++){
            if(i == listOfSuppliesOrders.get(i).getArticleId()) {
                this.listOfSuppliesOrders.remove(i);
                break;
            }
        }

    }

    public void clearSupplyOrderList(){
        this.listOfSuppliesOrders.clear();
    }

    public int getId() {
        return id;
    }


    public ArrayList<ArticleSheet> getListOfArticleSheet() {
        return articleSheetList;
    }

    public ArrayList<SupplyOrder> getListOfSuppliesOrders() {
        return listOfSuppliesOrders;
    }

    public ArrayList<ArticleReservation> getListOfBookArticle() {
        return listOfBookArticle;
    }
}
