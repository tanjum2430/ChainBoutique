package com.example.chainboutique.adib;
import java.time.LocalDate;
public class Supply {

    private String supplyID;        // Primary Key (Unique)
    private String productID;       // Foreign Key
    private String supplierID;      // Foreign Key
    private double purchasePrice;
    private LocalDate deliveryDate;

    public String getSupplyID() {
        return supplyID;
    }

    public void setSupplyID(String supplyID) {
        this.supplyID = supplyID;
    }

    public String getProductID() {
        return productID;
    }

    @Override
    public String toString() {
        return "Supply{" +
                "supplyID='" + supplyID + '\'' +
                ", productID='" + productID + '\'' +
                ", supplierID='" + supplierID + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", deliveryDate=" + deliveryDate +
                '}';
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Supply(String supplyID, String productID, String supplierID, double purchasePrice, LocalDate deliveryDate) {
        this.supplyID = supplyID;
        this.productID = productID;
        this.supplierID = supplierID;
        this.purchasePrice = purchasePrice;
        this.deliveryDate = deliveryDate;
    }
}
