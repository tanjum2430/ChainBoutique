package com.example.chainboutique.adib;

public class Warehouse {

    private String warehouseID;
    private String warehouseName;
    private String location;
    private int capacity;
    private String managerName;

    public Warehouse(String warehouseID, String warehouseName, String location,
                     int capacity, String managerName) {
        this.warehouseID = warehouseID;
        this.warehouseName = warehouseName;
        this.location = location;
        this.capacity = capacity;
        this.managerName = managerName;
    }

    public String getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(String warehouseID) {
        this.warehouseID = warehouseID;
    }

    public String getWarehouseName() {
        return warehouseName;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseID='" + warehouseID + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                ", managerName='" + managerName + '\'' +
                '}';
    }
}