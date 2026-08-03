package com.example.chainboutique.adib;

public class InventoryOfficer {

    private String productID;
    private String productName;
    private String category;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "InventoryOfficer{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", supplier='" + supplier + '\'' +
                ", warehouse='" + warehouse + '\'' +
                ", unitPrice=" + unitPrice +
                ", sellingPrice=" + sellingPrice +
                '}';
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public InventoryOfficer(String productID, String productName, String category, int quantity, String supplier, String warehouse, double unitPrice, double sellingPrice) {
        this.productID = productID;
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
        this.supplier = supplier;
        this.warehouse = warehouse;
        this.unitPrice = unitPrice;
        this.sellingPrice = sellingPrice;
    }

    private int quantity;

    private String supplier;
    private String warehouse;

    private double unitPrice;
    private double sellingPrice;

}