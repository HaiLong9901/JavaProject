package com.javaservlet.models;

public class UserAccount {
    public static final String GENDER_MALE = "M";
    public static final String GENDER_FEMALE = "F";

    private String userName;
    private String gender;
    private String password;

    private String email;
    private String fullName;

    public UserAccount() {

    }

    public UserAccount(String userName, String gender, String password, String email, String fullName) {
        this.userName = userName;
        this.gender = gender;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
}
