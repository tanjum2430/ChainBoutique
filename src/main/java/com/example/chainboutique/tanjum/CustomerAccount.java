package com.example.chainboutique.tanjum;

public class CustomerAccount {
    private int accountId; // Primary Key
    private String email; //Unique
    private String phoneNo; // Unique
    private String password;

    public CustomerAccount(int accountId, String email, String phoneNo, String password) {
        this.accountId = accountId;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CustomerAccount{" +
                "accountId=" + accountId +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
