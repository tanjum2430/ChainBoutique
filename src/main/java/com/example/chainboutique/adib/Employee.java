package com.example.chainboutique.adib;

public class Employee {

    private String employeeID;      // Primary Key (Unique)
    private String fullName;
    private String email;           // Unique

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", departmentID='" + departmentID + '\'' +
                ", designation='" + designation + '\'' +
                ", status='" + status + '\'' +
                ", hireDate=" + hireDate +
                '}';
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

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Employee(String employeeID, String fullName, String email, String phoneNo, String departmentID, String designation, String status, LocalDate hireDate) {
        this.employeeID = employeeID;
        this.fullName = fullName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.departmentID = departmentID;
        this.designation = designation;
        this.status = status;
        this.hireDate = hireDate;
    }

    private String phoneNo;         // Unique
    private String departmentID;    // Foreign Key
    private String designation , status;
    private LocalDate hireDate;


}