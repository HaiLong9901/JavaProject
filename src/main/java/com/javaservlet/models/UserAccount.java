package com.javaservlet.models;

import java.sql.Blob;

public class UserAccount {
    private String userName;
    private String password;
    private String email;
    private String fullName;
    private String phone;
    private Blob image;

    public UserAccount() {

    }

    public UserAccount(String userName, String password, String email, String fullName, String phone, Blob image) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.image = image;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public Blob getImage() {
        return image;
    }
}
