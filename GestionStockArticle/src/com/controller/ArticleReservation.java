package com.controller;

public class ArticleReservation {
    private int articleId;
    private int quantityBook;

    public ArticleReservation(int articleId, int quantityBook) {
        this.articleId = articleId;
        this.quantityBook = quantityBook;
    }

    public int getArticleId() {
        return articleId;
    }

    public int getQuantityBook() {
        return quantityBook;
    }
}
