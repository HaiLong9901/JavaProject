package com.javaservlet.models;

public class Brand {
    private String name;
    private int brandId;
    public Brand() {

    }
    public Brand(int brandId, String name) {
        this.brandId = brandId;
        this.name = name;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int branchId) {
        this.brandId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
