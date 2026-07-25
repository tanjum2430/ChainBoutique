package com.example.chainboutique.tanjum;

import java.time.LocalDate;

public class ReturnRequest {
    private int returnId; // Primary Key
    private int invoiceId; // Foreign Key
    private int productId; // Foreign Key
    private LocalDate returnDate;
    private String returnReason,returnType,status;

    public ReturnRequest(int returnId, int invoiceId, int productId, LocalDate returnDate, String returnReason, String returnType, String status) {
        this.returnId = returnId;
        this.invoiceId = invoiceId;
        this.productId = productId;
        this.returnDate = returnDate;
        this.returnReason = returnReason;
        this.returnType = returnType;
        this.status = status;
    }

    public int getReturnId() {
        return returnId;
    }

    public void setReturnId(int returnId) {
        this.returnId = returnId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReturnRequest{" +
                "returnId=" + returnId +
                ", invoiceId=" + invoiceId +
                ", productId=" + productId +
                ", returnDate=" + returnDate +
                ", returnReason='" + returnReason + '\'' +
                ", returnType='" + returnType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public void approveReturn() {
        status = "Approved";
        return true;
    }

    public boolean rejectedReturn(){
        status = "Rejected";
        return true;
    }
}
