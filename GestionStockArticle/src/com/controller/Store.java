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
        //this.articleSheetList.get(articleId).setId(articleId);
        //this.articleSheetList.get(articleId).setStoreReference(this.id);
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

    public int getIdOf(String articleName){
        for(int i = 0; i < this.articleSheetList.size(); i++)
            if (articleName == this.articleSheetList.get(i).getArticleName()) return i;
        return -1;
    }

    public boolean articleTransfer(Store toStore, String articleName,  int quantityToTransfer){
        //auo
    }

    public boolean transferArticleQuantity()

}
