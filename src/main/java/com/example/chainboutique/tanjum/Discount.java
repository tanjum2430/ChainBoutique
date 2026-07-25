package com.example.chainboutique.tanjum;

public class Discount {
    private String discountCode; // Primary Key
    private String status;
    private double discountPercentage;

    public Discount(String discountCode, String status, double discountPercentage) {
        this.discountCode = discountCode;
        this.status = status;
        this.discountPercentage = discountPercentage;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountCode='" + discountCode + '\'' +
                ", status='" + status + '\'' +
                ", discountPercentage=" + discountPercentage +
                '}';
    }

    public double applyDiscount(double totalAmount) {
        return totalAmount - (totalAmount*discountPercentage/100);
    }

    public boolean validateDiscount(){
        return status.equalsIgnoreCase("Active");
    }


}
