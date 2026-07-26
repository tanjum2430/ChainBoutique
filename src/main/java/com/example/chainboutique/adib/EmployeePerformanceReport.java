package com.example.chainboutique.adib;

public class EmployeePerformanceReport {

    private String reportID;        // Primary Key (Unique)
    private String departmentID;    // Foreign Key
    private double averageScore;

    public EmployeePerformanceReport(String reportID, String departmentID, double averageScore, String topPerformer, LocalDateTime generatedOn) {
        this.reportID = reportID;
        this.departmentID = departmentID;
        this.averageScore = averageScore;
        this.topPerformer = topPerformer;
        this.generatedOn = generatedOn;
    }

    public String getReportID() {
        return reportID;
    }

    @Override
    public String toString() {
        return "EmployeePerformanceReport{" +
                "reportID='" + reportID + '\'' +
                ", departmentID='" + departmentID + '\'' +
                ", averageScore=" + averageScore +
                ", topPerformer='" + topPerformer + '\'' +
                ", generatedOn=" + generatedOn +
                '}';
    }

    public void setReportID(String reportID) {
        this.reportID = reportID;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public String getTopPerformer() {
        return topPerformer;
    }

    public void setTopPerformer(String topPerformer) {
        this.topPerformer = topPerformer;
    }

    public LocalDateTime getGeneratedOn() {
        return generatedOn;
    }

    public void setGeneratedOn(LocalDateTime generatedOn) {
        this.generatedOn = generatedOn;
    }

    private String topPerformer;
    private LocalDateTime generatedOn;

}