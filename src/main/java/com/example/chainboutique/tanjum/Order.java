package com.example.chainboutique.tanjum;

import java.time.LocalDate;

public class Order {
    private int orderId; // Primary Key
    private LocalDate orderDate;
    private String status,deliveryAddress;
    private double totalAmount;

    public Order(int orderId, LocalDate orderDate, String status, String deliveryAddress, double totalAmount) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.status = status;
        this.deliveryAddress = deliveryAddress;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }

    public void placeOrder(){
        status = "Placed";
        orderDate = LocalDate.now();
    }

    public boolean cancelOrder(){
        if (status.equals("Placed")){
            status = "Cancelled";
            return true;
        }
        return false;
    }

    public double calculateTotal(){
        return totalAmount;
    }
}
