package com.example.chainboutique.adib;

import java.time.LocalDate;

public class CEO {

    private String employeeID;

    private LocalDate startDate;
    private LocalDate endDate;

    private int reportYear;

    private String reportType;
    private String department;

    private String requestID;
    private String decision;
    private String remarks;

    private String announcementTitle;
    private String announcementMessage;

    public CEO(String employeeID, LocalDate startDate, LocalDate endDate,
               int reportYear, String reportType, String department,
               String requestID, String decision, String remarks,
               String announcementTitle, String announcementMessage) {

        this.employeeID = employeeID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reportYear = reportYear;
        this.reportType = reportType;
        this.department = department;
        this.requestID = requestID;
        this.decision = decision;
        this.remarks = remarks;
        this.announcementTitle = announcementTitle;
        this.announcementMessage = announcementMessage;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
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

    public int getReportYear() {
        return reportYear;
    }

    public void setReportYear(int reportYear) {
        this.reportYear = reportYear;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
    }

    public String getAnnouncementMessage() {
        return announcementMessage;
    }

    public void setAnnouncementMessage(String announcementMessage) {
        this.announcementMessage = announcementMessage;
    }

    @Override
    public String toString() {
        return "CEO{" +
                "employeeID='" + employeeID + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", reportYear=" + reportYear +
                ", reportType='" + reportType + '\'' +
                ", department='" + department + '\'' +
                ", requestID='" + requestID + '\'' +
                ", decision='" + decision + '\'' +
                ", remarks='" + remarks + '\'' +
                ", announcementTitle='" + announcementTitle + '\'' +
                ", announcementMessage='" + announcementMessage + '\'' +
                '}';
    }
}