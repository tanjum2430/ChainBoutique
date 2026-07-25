package com.example.chainboutique.tanjum;

public class Cart {
    private int cartId; // Primary Key
    private double totalPrice;

    public Cart(int cartId, double totalPrice) {
        this.cartId = cartId;
        this.totalPrice = totalPrice;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", totalPrice=" + totalPrice +
                '}';
    }


}
