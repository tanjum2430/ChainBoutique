package com.example.chainboutique.tanjum;

import java.time.LocalDate;

public class Invoice {
    private int invoiceId; // Primary Key
    private LocalDate date;
    private double totalAmount;

    public Invoice(int invoiceId, LocalDate date, double totalAmount) {
        this.invoiceId = invoiceId;
        this.date = date;
        this.totalAmount = totalAmount;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", date=" + date +
                ", totalAmount=" + totalAmount +
                '}';
    }
    public void generateInvoice(){
        date = LocalDate.now();
    }

    public void printInvoice(){
        System.out.println(this);
    }
}
