package com.example.module2caseweb.model;

public class User {
    private int id;
    private String userName;
    private String userPassword;
    private double moneyCharge;

    public User(int id, String userName, String userPassword, double moneyCharge) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.moneyCharge = moneyCharge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public double getMoneyCharge() {
        return moneyCharge;
    }

    public void setMoneyCharge(double moneyCharge) {
        this.moneyCharge = moneyCharge;
    }

}
