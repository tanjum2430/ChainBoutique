package com.example.chainboutique.tanjum;

import java.time.LocalDate;
import java.io.Serializable;

public class Cashier implements Serializable {
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

    public boolean login(String password){
        return this.password.equals(password);
    }

    public void searchCustomer(int customerId){
        System.out.println("Searching customer with ID:" + customerId);
    }

    public SalesBill createSalesBill(int billId, double totalAmount){
        return new SalesBill(billId, LocalDate.now(),totalAmount);
    }

    public double applyDiscount(double totalAmount, Discount discount){
        return discount.applyDiscount(totalAmount);
    }

    public Payment receivePayment(int paymentId,
                                  String paymentMethod,
                                  double paidAmount){
        return new Payment(paymentId,
                paymentMethod,
                "Paid",
                "TXN"+ paymentId,
                paidAmount);
    }

    public void processReturn(ReturnRequest request){
        request.approveReturn();
    }


    public void viewDailySalesSummary(DailySalesReport report){
        System.out.println(report);
    }

}
