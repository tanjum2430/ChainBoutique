package com.example.chainboutique.adib;

public class ApprovalRequest {

    private String requestID;       // Primary Key (Unique)
    private String requestType;
    private String requestedBy;     // Foreign Key
    private LocalDateTime requestedOn;
    private String status;
    private String remarks;

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    @Override
    public String toString() {
        return "ApprovalRequest{" +
                "requestID='" + requestID + '\'' +
                ", requestType='" + requestType + '\'' +
                ", requestedBy='" + requestedBy + '\'' +
                ", requestedOn=" + requestedOn +
                ", status='" + status + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public LocalDateTime getRequestedOn() {
        return requestedOn;
    }

    public void setRequestedOn(LocalDateTime requestedOn) {
        this.requestedOn = requestedOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public ApprovalRequest(String requestID, String requestType, String requestedBy, LocalDateTime requestedOn, String status, String remarks) {
        this.requestID = requestID;
        this.requestType = requestType;
        this.requestedBy = requestedBy;
        this.requestedOn = requestedOn;
        this.status = status;
        this.remarks = remarks;
    }
}
