package com.example.chainboutique.adib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SupplierController {

    @FXML
    private TextField supplierIdField;

    @FXML
    private TextField supplierNameField;

    @FXML
    private TextField companyNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextArea addressArea;

    @FXML
    private TextField searchField;

    @FXML
    private Button addSupplierButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button refreshButton;

    @FXML
    private TableColumn<Supplier,String> supplierIdColumn;

    @FXML
    private TableColumn<Supplier,String> supplierNameColumn;

    @FXML
    private TableColumn<Supplier,String> companyNameColumn;

    @FXML
    private TableColumn<Supplier,String> emailColumn;

    @FXML
    private TableColumn<Supplier,String> phoneNumberColumn;

    @FXML
    private TableColumn<Supplier,String> addressColumn;
    @FXML
    private TableView supplierTable;

    @FXML
    public void initialize() {

    }

    @FXML
    public void addSupplier(ActionEvent actionEvent) {

    }

    @FXML
    public void clearFields(ActionEvent actionEvent) {

    }

    @FXML
    public void searchSupplier(ActionEvent actionEvent) {

    }

    @FXML
    public void refreshTable(ActionEvent actionEvent) {

    }
}