package com.example.chainboutique.adib;

public class PerformanceReport {

    private String reportID;        // Primary Key (Unique)
    private LocalDate startDate;

    public PerformanceReport(String reportID, LocalDate startDate, LocalDate endDate, String reportType, double timeToHire, double placementRate, double recruiterProductivity) {
        this.reportID = reportID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reportType = reportType;
        this.timeToHire = timeToHire;
        this.placementRate = placementRate;
        this.recruiterProductivity = recruiterProductivity;
    }

    private LocalDate endDate;
    private String reportType;

    public String getReportID() {
        return reportID;
    }

    @Override
    public String toString() {
        return "PerformanceReport{" +
                "reportID='" + reportID + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", reportType='" + reportType + '\'' +
                ", timeToHire=" + timeToHire +
                ", placementRate=" + placementRate +
                ", recruiterProductivity=" + recruiterProductivity +
                '}';
    }

    public void setReportID(String reportID) {
        this.reportID = reportID;
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

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public double getTimeToHire() {
        return timeToHire;
    }

    public void setTimeToHire(double timeToHire) {
        this.timeToHire = timeToHire;
    }

    public double getPlacementRate() {
        return placementRate;
    }

    public void setPlacementRate(double placementRate) {
        this.placementRate = placementRate;
    }

    public double getRecruiterProductivity() {
        return recruiterProductivity;
    }

    public void setRecruiterProductivity(double recruiterProductivity) {
        this.recruiterProductivity = recruiterProductivity;
    }

    private double timeToHire;
    private double placementRate;
    private double recruiterProductivity;

}
