package com.example.chainboutique.adib;

public class InventoryOfficer {

    private String name;
    private String email;// Unique
    private String phoneNo; // Unique
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "InventoryOfficer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", employeeID='" + employeeID + '\'' +
                '}';
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

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public InventoryOfficer(String name, String email, String phoneNo, String password, String address, String employeeID) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
        this.address = address;
        this.employeeID = employeeID;
    }

    private String address;
    private String employeeID; // Primary Key (Unique)

}