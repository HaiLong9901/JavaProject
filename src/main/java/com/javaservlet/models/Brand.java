package com.javaservlet.models;

public class Brand {
    private String name;
    private int branchId;
    public Brand() {

    }
    public Brand(int branchId, String name) {
        this.branchId = branchId;
        this.name = name;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
