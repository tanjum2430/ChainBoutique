package com.example.chainboutique.tanjum;

public class CartItem {
    private int quantity;
    private double subTotal;


    public CartItem(int quantity, double subTotal) {
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "quantity=" + quantity +
                ", subTotal=" + subTotal +
                '}';
    }
}
