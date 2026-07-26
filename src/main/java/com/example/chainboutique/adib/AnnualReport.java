package com.example.chainboutique.adib;

public class AnnualReport {

    private String reportID;        // Primary Key (Unique)
    private int reportYear;
    private LocalDateTime generatedOn;
    private String generatedBy;     // Foreign Key
    private String filePath;

    public String getReportID() {
        return reportID;
    }

    public void setReportID(String reportID) {
        this.reportID = reportID;
    }

    @Override
    public String toString() {
        return "AnnualReport{" +
                "reportID='" + reportID + '\'' +
                ", reportYear=" + reportYear +
                ", generatedOn=" + generatedOn +
                ", generatedBy='" + generatedBy + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }

    public int getReportYear() {
        return reportYear;
    }

    public void setReportYear(int reportYear) {
        this.reportYear = reportYear;
    }

    public LocalDateTime getGeneratedOn() {
        return generatedOn;
    }

    public void setGeneratedOn(LocalDateTime generatedOn) {
        this.generatedOn = generatedOn;
    }

    public String getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public AnnualReport(String reportID, int reportYear, LocalDateTime generatedOn, String generatedBy, String filePath) {
        this.reportID = reportID;
        this.reportYear = reportYear;
        this.generatedOn = generatedOn;
        this.generatedBy = generatedBy;
        this.filePath = filePath;
    }
}
