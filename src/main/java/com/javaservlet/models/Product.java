package com.javaservlet.models;

import java.io.InputStream;
import java.sql.Blob;

public class Product {
    private int code;
    private String name;
    private int price;
    private String product_desc;
    private String brand;
    private String genre;
    private InputStream image;
    private int originalPrice;
    public Product() {

    }

    public Product(String name, int price, String brand, String product_desc, String genre, int originalPrice) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.product_desc = product_desc;
        this.genre = genre;
        this.originalPrice = originalPrice;
    }
    public Product( String name, int price, String brand, String product_desc, String genre, InputStream image, int originalPrice) {
        this.name = name;
        this.code = code;
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

    public int getCode(){
        return code;
    }

    public void setCode(int code){
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

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
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
