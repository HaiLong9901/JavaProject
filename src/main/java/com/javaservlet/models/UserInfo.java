package com.javaservlet.models;

public class UserInfo {
    private String userName;
    private int userAge;
    private String userEmail;

    public UserInfo() {

    }

    public UserInfo(String userName, int userAge, String userEmail) {
        this.userAge = userAge;
        this.userEmail = userEmail;
        this.userName = userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
