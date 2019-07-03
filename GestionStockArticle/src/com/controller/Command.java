package com.controller;

import java.util.ArrayList;

public class Command {
    private ArrayList<ArticleSheet> articleList;
    private ArrayList<Integer> quantityList;
    private double totalPrice;

    public Command(ArrayList<ArticleSheet> articleList, ArrayList<Integer> quantityList) {
        this.articleList = articleList;
        this.quantityList = quantityList;
        totalPrice = calculateNeeds();
    }

    public double calculateNeeds(){
        double totalPrice = 0;
        for(int i =0; i < this.articleList.size(); i++){
            //totalPrice += this.articleList.get(i).getPrice() * this.quantityList.get(i)
        }
        return  totalPrice;
    }

    public ArrayList<ArticleSheet> getArticleList() {
        return articleList;
    }

    public ArrayList<Integer> getQuantityList() {
        return quantityList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
