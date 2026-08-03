package com.example.chainboutique.adib;

public class Supplier {

    private String supplierID;      // Primary Key (Unique)
    private String supplierName, address, status, contactPerson;
    private String email;           // Unique
    private String phoneNo;         // Unique
    @javafx.fxml.FXML
    private TableColumn companyNameColumn;
    @javafx.fxml.FXML
    private TableColumn addressColumn;
    @javafx.fxml.FXML
    private TextField companyNameField;
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private TextField phoneNumberField;
    @javafx.fxml.FXML
    private TextField supplierIdField;
    @javafx.fxml.FXML
    private TableView supplierTable;
    @javafx.fxml.FXML
    private TextField searchField;
    @javafx.fxml.FXML
    private TextField supplierNameField;
    @javafx.fxml.FXML
    private TextField emailField;
    @javafx.fxml.FXML
    private Button addSupplierButton;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private TableColumn supplierNameColumn;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TableColumn supplierIdColumn;
    @javafx.fxml.FXML
    private TableColumn phoneNumberColumn;
    @javafx.fxml.FXML
    private TextArea addressArea;
    @javafx.fxml.FXML
    private TableColumn emailColumn;

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierID='" + supplierID + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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

    public Supplier(String supplierID, String supplierName, String address, String status, String contactPerson, String email, String phoneNo) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.address = address;
        this.status = status;
        this.contactPerson = contactPerson;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    @javafx.fxml.FXML
    public void searchSupplier(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addSupplier(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {
    }
}
