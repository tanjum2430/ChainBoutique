package com.example.chainboutique.adib;

import java.time.LocalDate;

public class FinancialSummary {

    private String reportID;        // Primary Key (Unique)
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalRevenue ,totalExpense ,netProfit ;

    public String getReportID() {
        return reportID;
    }

    public void setReportID(String reportID) {
        this.reportID = reportID;
    }

    @Override
    public String toString() {
        return "FinancialSummary{" +
                "reportID='" + reportID + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalRevenue=" + totalRevenue +
                ", totalExpense=" + totalExpense +
                ", netProfit=" + netProfit +
                '}';
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }

    public FinancialSummary(String reportID, LocalDate startDate, LocalDate endDate, double totalRevenue, double totalExpense, double netProfit) {
        this.reportID = reportID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalRevenue = totalRevenue;
        this.totalExpense = totalExpense;
        this.netProfit = netProfit;
    }
}