package com.example.chainboutique.tanjum;

public class Customer {

    private String name;
    private String email;// Unique
    private String phoneNo; // Unique
    private String password,address;
    private int customerId;// Primary Key (Unique)


    public Customer(String name, String email, String phoneNo, String password, String address, int customerId) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
        this.address = address;
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", address='" + address + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
