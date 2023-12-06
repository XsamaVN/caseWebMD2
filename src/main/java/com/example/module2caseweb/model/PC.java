package com.example.module2caseweb.model;

public class PC {
    private int idPC;
    private double pricePC;

    public PC(int idPC, double pricePC) {
        this.idPC = idPC;
        this.pricePC = pricePC;
    }

    public PC() {
    }

    public int getIdPC() {
        return idPC;
    }

    public void setIdPC(int idPC) {
        this.idPC = idPC;
    }

    public double getPricePC() {
        return pricePC;
    }

    public void setPricePC(double pricePC) {
        this.pricePC = pricePC;
    }

}
