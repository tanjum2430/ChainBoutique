package com.example.chainboutique.adib;

public class Inventory {

    private String inventoryID;     // Primary Key (Unique)
    private double totalStockValue;

    public String getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(String inventoryID) {
        this.inventoryID = inventoryID;
    }

    public double getTotalStockValue() {
        return totalStockValue;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryID='" + inventoryID + '\'' +
                ", totalStockValue=" + totalStockValue +
                ", lastUpdated=" + lastUpdated +
                '}';
    }

    public void setTotalStockValue(double totalStockValue) {
        this.totalStockValue = totalStockValue;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Inventory(String inventoryID, double totalStockValue, LocalDateTime lastUpdated) {
        this.inventoryID = inventoryID;
        this.totalStockValue = totalStockValue;
        this.lastUpdated = lastUpdated;
    }

    private LocalDateTime lastUpdated;

}