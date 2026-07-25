package com.example.chainboutique.tanjum;

import java.time.LocalDate;

public class ReturnRequest {
    private int returnId; // Primary Key
    private int invoiceId; // Foreign Key
    private int productId; // Foreign Key
    private LocalDate returnDate;
    private String returnReason,returnType,status;
}
