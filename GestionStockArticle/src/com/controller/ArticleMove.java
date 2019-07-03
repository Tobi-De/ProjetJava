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

    public int getQuantityTransfer() {
        return quantityTransfer;
    }

    public void setQuantityTransfer(int quantityTransfer) {
        this.quantityTransfer = quantityTransfer;
    }

    public int getToStoreId() {
        return toStoreId;
    }

    public void setToStoreId(int toStoreId) {
        this.toStoreId = toStoreId;
    }

    public int getFromStoreId() {
        return fromStoreId;
    }

    public void setFromStoreId(int fromStoreId) {
        this.fromStoreId = fromStoreId;
    }
}
