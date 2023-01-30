package com.javaservlet.models;

import java.sql.Blob;

public class UserAccount {
    private int userId;
    private String userName;
    private String password;
    private String email;
    private String fullName;
    private String phone;

    public UserAccount() {

    }
    public UserAccount(int userId,String fullName, String userName, String email, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.fullName = fullName;
    }
    public UserAccount(String userName, String password, String email, String fullName, String phone) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
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

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void print() {
        System.out.println("Name: " + this.fullName + " Account: " + this.userName + " Email: " + this.email + " Phone: " + this.phone);
    }
}
