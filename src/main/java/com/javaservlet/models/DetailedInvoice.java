package com.javaservlet.models;

public class DetailedInvoice {
    private int productId;
    private int quantity;

    private int invoiceId;
    public DetailedInvoice() {

    }

    public DetailedInvoice(int invoiceId, int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
        this.invoiceId = invoiceId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }
}
