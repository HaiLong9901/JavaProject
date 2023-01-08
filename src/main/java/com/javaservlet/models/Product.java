package com.javaservlet.models;

public class Product {
    private String code;
    private String name;
    private int price;

    private String product_desc;

    private String branch;
    public Product() {

    }

    public Product(String code, String name, int price, String branch, String product_desc) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.branch = branch;
        this.product_desc = product_desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }
}
