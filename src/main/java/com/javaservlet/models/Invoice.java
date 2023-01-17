package com.javaservlet.models;

public class Invoice {
    private String createdAt;
    private int userId;
    private int amount;
    private boolean isImport;

    public Invoice() {

    }

    public Invoice(String createdAt, int userId, int amount, boolean isImport) {
        this.createdAt = createdAt;
        this.userId = userId;
        this.amount = amount;
        this.isImport = isImport;
    }

    public int getAmount() {
        return amount;
    }

    public int getUserId() {
        return userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isImport() {
        return isImport;
    }

    public void setImport(boolean anImport) {
        isImport = anImport;
    }
}
