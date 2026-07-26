package com.example.chainboutique.adib;

public class Dashboard {

    private String dashboardID;     // Primary Key (Unique)
    private int totalJobsPosted;
    private int totalHires;
    private double totalRevenue;

    public String getDashboardID() {
        return dashboardID;
    }

    public void setDashboardID(String dashboardID) {
        this.dashboardID = dashboardID;
    }

    @Override
    public String toString() {
        return "Dashboard{" +
                "dashboardID='" + dashboardID + '\'' +
                ", totalJobsPosted=" + totalJobsPosted +
                ", totalHires=" + totalHires +
                ", totalRevenue=" + totalRevenue +
                ", activeClients=" + activeClients +
                ", generatedOn=" + generatedOn +
                '}';
    }

    public int getTotalJobsPosted() {
        return totalJobsPosted;
    }

    public void setTotalJobsPosted(int totalJobsPosted) {
        this.totalJobsPosted = totalJobsPosted;
    }

    public int getTotalHires() {
        return totalHires;
    }

    public void setTotalHires(int totalHires) {
        this.totalHires = totalHires;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public int getActiveClients() {
        return activeClients;
    }

    public void setActiveClients(int activeClients) {
        this.activeClients = activeClients;
    }

    public LocalDateTime getGeneratedOn() {
        return generatedOn;
    }

    public void setGeneratedOn(LocalDateTime generatedOn) {
        this.generatedOn = generatedOn;
    }

    public Dashboard(String dashboardID, int totalJobsPosted, int totalHires, double totalRevenue, int activeClients, LocalDateTime generatedOn) {
        this.dashboardID = dashboardID;
        this.totalJobsPosted = totalJobsPosted;
        this.totalHires = totalHires;
        this.totalRevenue = totalRevenue;
        this.activeClients = activeClients;
        this.generatedOn = generatedOn;
    }

    private int activeClients;
    private LocalDateTime generatedOn;

}
