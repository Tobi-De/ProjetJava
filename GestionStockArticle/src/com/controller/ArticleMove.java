package com.controller;

public class ArticleMove {
    private int quantityTransfer;
    private int toStoreId;
    private int fromStoreId;

    public ArticleMove(int quantityTransfer, int toStoreId, int fromStoreId) {
        this.quantityTransfer = quantityTransfer;
        this.toStoreId = toStoreId;
        this.fromStoreId = fromStoreId;
    }
}
