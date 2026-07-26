package com.example.chainboutique.adib;

public class Warehouse {

    private String warehouseID;     // Primary Key (Unique)
    private String warehouseName;
    private String location;
    private String status;

    public String getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(String warehouseID) {
        this.warehouseID = warehouseID;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseID='" + warehouseID + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Warehouse(String warehouseID, String warehouseName, String location, String status) {
        this.warehouseID = warehouseID;
        this.warehouseName = warehouseName;
        this.location = location;
        this.status = status;
    }
}

