package com.example.chainboutique.tanjum;

import java.io.Serializable;
public class Customer implements Serializable {

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

    public boolean createAccount(){
        if(name.isEmpty()||email.isEmpty()||phoneNo.isEmpty()
        ||password.isEmpty()||address.isEmpty()){
            return false;
        }
        return true;
    }

    public boolean login(String email,String password){
        return this.email.equals(email) &&
                this.password.equals(password);
    }

    public void viewProducts(){
        System.out.println("Displaying all available products.");
    }

    public void searchProduct(String keyword){
        System.out.println("Searching product."+ keyword);
    }

    public void addToCart(Product product, int quantity){
        System.out.println(quantity+""+product.getProductName()+"added to cart.");
    }

    public void placeOrder(){
        System.out.println("Order placed successfully.");
    }

    public void viewOrderHistory(){
        System.out.println("Displaying order history.");
    }

    public boolean cancelOrder(int orderId){
        System.out.println("Order"+ orderId + "cancelled.");
        return true;
    }


}
