package com.example.chainboutique.tanjum;

import java.time.LocalDate;

public class SalesBill {
    private int build; // Primary Key
    private LocalDate billDate;
    private double totalAmount;

    public SalesBill(int build, LocalDate billDate, double totalAmount) {
        this.build = build;
        this.billDate = billDate;
        this.totalAmount = totalAmount;
    }

    public int getBuild() {
        return build;
    }

    public void setBuild(int build) {
        this.build = build;
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
                "build=" + build +
                ", billDate=" + billDate +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
