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
    private TableView<?> supplyTable;

    @FXML
    private TableColumn<?, ?> supplierIdColumn;

    @FXML
    private TableColumn<?, ?> supplierNameColumn;

    @FXML
    private TableColumn<?, ?> companyNameColumn;

    @FXML
    private TableColumn<?, ?> emailColumn;

    @FXML
    private TableColumn<?, ?> phoneNumberColumn;

    @FXML
    private TableColumn<?, ?> addressColumn;

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