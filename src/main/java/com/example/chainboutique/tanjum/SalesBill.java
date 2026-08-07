package com.example.chainboutique.tanjum;

import java.time.LocalDate;

public class SalesBill {
    private int billId; // Primary Key
    private LocalDate billDate;
    private double totalAmount;


    public SalesBill(int billId, LocalDate billDate, double totalAmount) {
        this.billId = billId;
        this.billDate = billDate;
        this.totalAmount = totalAmount;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "SalesBill{" +
                "billId=" + billId +
                ", billDate=" + billDate +
                ", totalAmount=" + totalAmount +
                '}';
    }
    
    public double calculateBill(){
        return totalAmount;
    }
    
    public void generateBill(){
        System.out.println("Bill ID:"+ billId);
        System.out.println("Date:" + billDate);
        System.out.println("Total Amount:"+totalAmount);
    }
}
