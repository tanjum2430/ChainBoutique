package com.example.chainboutique.adib;

public class Department {

    private String departmentID;    // Primary Key (Unique)
    private String departmentName;

    public Department(String departmentID, String departmentName, String description) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.description = description;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID='" + departmentID + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

}