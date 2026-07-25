package com.example.chainboutique.tanjum;

public class Payment {
    private int paymentID; // Primary Key
    private String paymentMethod, paymentStatus, transactionId;
    private double paidAmount;

    public Payment(int paymentID, String paymentMethod, String paymentStatus, String transactionId, double paidAmount) {
        this.paymentID = paymentID;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.transactionId = transactionId;
        this.paidAmount = paidAmount;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID=" + paymentID +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", paidAmount=" + paidAmount +
                '}';
    }

    public boolean verifyPayment(){
        return paymentStatus.equalsIgnoreCase("Paid");
    }

    public void makePayment(String paymentMethod,
                            double amount){
        this.paymentMethod = paymentMethod;
        this.paidAmount = amount;
        this.paymentStatus = "Paid";
        this.transactionId = "TXN" + paymentID;
    }
}
