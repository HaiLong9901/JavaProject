package com.javaservlet.models;

import java.sql.Blob;

public class Product {
    private String code;
    private String name;
    private int price;
    private String product_desc;
    private String brand;
    private String genre;
    private Blob image;
    private int originalPrice;
    public Product() {

    }

    public Product(String code, String name, int price, String brand, String product_desc, String genre, Blob image, int originalPrice) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.product_desc = product_desc;
        this.genre = genre;
        this.image = image;
        this.originalPrice = originalPrice;
    }

    public int getPrice() {
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
