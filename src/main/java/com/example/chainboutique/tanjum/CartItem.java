package com.example.chainboutique.tanjum;

public class CartItem {
    private int quantity;
    private double subTotal;
    private final Product product;


    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.subTotal = calculateSubtotal();
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

    public Product getProduct() {
        return product; }

    @Override
    public String toString() {
        return "CartItem{" +
                "quantity=" + quantity +
                ", subTotal=" + subTotal +
                '}';
    }
    
    public double calculateSubtotal(){
        return quantity * product.getPrice();
    }
}
