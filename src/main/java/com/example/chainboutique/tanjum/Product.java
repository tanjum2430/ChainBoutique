package com.example.chainboutique.tanjum;
import java.io.Serializable;

public class Product implements Serializable {
    private String productName,category,size,image;
    private int productId; // Primary Key
    private int stock;
    private double price;

    public Product(String productName, String category, String size, String image, int productId, double price, int stock) {
        this.productName = productName;
        this.category = category;
        this.size = size;
        this.image = image;
        this.productId = productId;
        this.price = price;
        this.stock = stock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", size='" + size + '\'' +
                ", image='" + image + '\'' +
                ", productId=" + productId +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }

    public boolean checkAvailability(int quantity){
        return stock >= quantity;
    }

    public void updateStock(int quantity){
        stock = stock - quantity;
    }

    public void addStock(int quantity) {
        stock = stock + quantity;
    }

    public String getProductDetails(){

        return "Product: " + productName +
                "\nCategory:" + category +
                "\nSize:" + size +
                "\nPrice:" + price +
                "\nStock:" + stock;
    }
}
