package com.controller;

import java.util.ArrayList;

public class Historic {
    private ArrayList<ArticleMove> articleMoveList;

    public Historic(){
        this.articleMoveList =  new ArrayList<>();
    }

    public void addArticleMove(ArticleMove articleMove){
        this.articleMoveList.add(articleMove);
    }

    public ArrayList<ArticleMove> getHistoric(){
        return this.articleMoveList;
    }

    public void editHistoric(int moveIndex, ArticleMove newMove){
        articleMoveList.set(moveIndex, newMove);
    }

    public void removeArticle(int moveIndex){
        articleMoveList.remove(moveIndex);
    }

    public void clearHistoric(){
        articleMoveList.clear();
    }
}
