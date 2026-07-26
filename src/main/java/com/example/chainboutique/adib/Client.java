package com.example.chainboutique.adib;

public class Client {

    private String clientID;        // Primary Key (Unique)
    private String clientName;
    private String contactPerson;
    private String email;           // Unique
    private String phoneNo;         // Unique
    private String address;

    public Client(String clientID, String clientName, String contactPerson, String email, String phoneNo, String address, String status) {
        this.clientID = clientID;
        this.clientName = clientName;
        this.contactPerson = contactPerson;
        this.email = email;
        this.phoneNo = phoneNo;
        this.address = address;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID='" + clientID + '\'' +
                ", clientName='" + clientName + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

}