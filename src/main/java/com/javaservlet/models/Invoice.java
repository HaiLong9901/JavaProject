package com.javaservlet.models;

public class Invoice {

    private int invoiceId;
    private String createdAt;
    private String account;
    private int amount;
    private boolean isImport;
    private String partner;

    public Invoice() {

    }

    public Invoice(int invoiceId, String createdAt, String account, int amount, String partner) {
        this.createdAt = createdAt;
        this.account = account;
        this.amount = amount;
        this.partner = partner;
        this.invoiceId = invoiceId;
    }
    public Invoice(String account, int amount, String partner) {
        this.account = account;
        this.amount = amount;
        this.partner = partner;
    }

    public int getAmount() {
        return amount;
    }

    public String getAccount() {
        return this.account;
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

    public void setAccount(String account) {
        this.account = account;
    }

    public boolean isImport() {
        return isImport;
    }

    public void setImport(boolean anImport) {
        isImport = anImport;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void print() {
        System.out.println("account: " + this.account + "date: " +this.createdAt + " amount: " + this.amount);
    }
}
