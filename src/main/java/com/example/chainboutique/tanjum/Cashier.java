package com.example.chainboutique.tanjum;

public class Cashier {
    private int cashierID; // Primary Key (Unique)
    private String name,password;

    public Cashier(int cashierID, String name, String password) {
        this.cashierID = cashierID;
        this.name = name;
        this.password = password;
    }

    public int getCashierID() {
        return cashierID;
    }

    public void setCashierID(int cashierID) {
        this.cashierID = cashierID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "name='" + name + '\'' +
                ", cashierID=" + cashierID +
                '}';
    }
}
