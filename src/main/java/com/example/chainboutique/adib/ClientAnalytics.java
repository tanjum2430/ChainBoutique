package com.example.chainboutique.adib;

import java.time.LocalDateTime;

public class ClientAnalytics {

    private String reportID;        // Primary Key (Unique)
    private int totalClients;
    private int newClients;
    private int retainedClients;
    private double retentionRate;

    public String getReportID() {
        return reportID;
    }

    public void setReportID(String reportID) {
        this.reportID = reportID;
    }

    @Override
    public String toString() {
        return "ClientAnalytics{" +
                "reportID='" + reportID + '\'' +
                ", totalClients=" + totalClients +
                ", newClients=" + newClients +
                ", retainedClients=" + retainedClients +
                ", retentionRate=" + retentionRate +
                ", generatedOn=" + generatedOn +
                '}';
    }

    public int getTotalClients() {
        return totalClients;
    }

    public void setTotalClients(int totalClients) {
        this.totalClients = totalClients;
    }

    public int getNewClients() {
        return newClients;
    }

    public void setNewClients(int newClients) {
        this.newClients = newClients;
    }

    public int getRetainedClients() {
        return retainedClients;
    }

    public void setRetainedClients(int retainedClients) {
        this.retainedClients = retainedClients;
    }

    public double getRetentionRate() {
        return retentionRate;
    }

    public void setRetentionRate(double retentionRate) {
        this.retentionRate = retentionRate;
    }

    public LocalDateTime getGeneratedOn() {
        return generatedOn;
    }

    public void setGeneratedOn(LocalDateTime generatedOn) {
        this.generatedOn = generatedOn;
    }

    public ClientAnalytics(String reportID, int totalClients, int newClients, int retainedClients, double retentionRate, LocalDateTime generatedOn) {
        this.reportID = reportID;
        this.totalClients = totalClients;
        this.newClients = newClients;
        this.retainedClients = retainedClients;
        this.retentionRate = retentionRate;
        this.generatedOn = generatedOn;
    }

    private LocalDateTime generatedOn;

}