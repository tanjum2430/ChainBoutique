package com.example.chainboutique.tanjum;

import java.time.LocalDate;

public class DailySalesReport {
    private int reportID; // Primary Key
    private LocalDate reportDate;
    private double totalSales,totalDiscount,totalReturns;

    public DailySalesReport(int reportID, LocalDate reportDate, double totalSales, double totalDiscount, double totalReturns) {
        this.reportID = reportID;
        this.reportDate = reportDate;
        this.totalSales = totalSales;
        this.totalDiscount = totalDiscount;
        this.totalReturns = totalReturns;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double getTotalReturns() {
        return totalReturns;
    }

    public void setTotalReturns(double totalReturns) {
        this.totalReturns = totalReturns;
    }

    @Override
    public String toString() {
        return "DailySalesReport{" +
                "reportID=" + reportID +
                ", reportDate=" + reportDate +
                ", totalSales=" + totalSales +
                ", totalDiscount=" + totalDiscount +
                ", totalReturns=" + totalReturns +
                '}';
    }
    public void generateReport(){
        System.out.println("Sales Report Generated");
    }

    public void displaySummary(){
        System.out.println("Report Date:"+ reportDate);
        System.out.println("Total Sales:"+totalSales);
        System.out.println("Total Discount:"+totalDiscount);
        System.out.println("Total returns"+totalReturns);

    }
}
