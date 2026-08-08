package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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

    private ObservableList<Supplier> supplierList =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {


        supplierIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("supplierID"));

        supplierNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("supplierName"));

        companyNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("companyName"));

        emailColumn.setCellValueFactory(
                new PropertyValueFactory<>("email"));

        phoneNumberColumn.setCellValueFactory(
                new PropertyValueFactory<>("phoneNumber"));

        addressColumn.setCellValueFactory(
                new PropertyValueFactory<>("address"));

        supplierTable.setItems(supplierList);

    }

    @FXML
    public void addSupplier(ActionEvent actionEvent) {

        String supplierID = supplierIdField.getText();
        String supplierName = supplierNameField.getText();
        String companyName = companyNameField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();
        String address = addressArea.getText();

        Supplier supplier = new Supplier(
                supplierID,
                supplierName,
                companyName,
                email,
                phoneNumber,
                address
        );

        supplierList.add(supplier);

        clearFields(null);

    }

    @FXML
    public void clearFields(ActionEvent actionEvent) {

        supplierIdField.clear();
        supplierNameField.clear();
        companyNameField.clear();
        emailField.clear();
        phoneNumberField.clear();
        addressArea.clear();
        searchField.clear();


    }

    @FXML
    public void searchSupplier(ActionEvent actionEvent) {

        String searchText = searchField.getText().toLowerCase();

        if (searchText.isEmpty()) {
            supplierTable.setItems(supplierList);
            return;
        }

        ObservableList<Supplier> searchResults =
                FXCollections.observableArrayList();

        for (Supplier supplier : supplierList) {

            if (supplier.getSupplierID().toLowerCase().contains(searchText)
                    || supplier.getSupplierName().toLowerCase().contains(searchText)
                    || supplier.getCompanyName().toLowerCase().contains(searchText)
                    || supplier.getEmail().toLowerCase().contains(searchText)
                    || supplier.getPhoneNumber().toLowerCase().contains(searchText)
                    || supplier.getAddress().toLowerCase().contains(searchText)) {

                searchResults.add(supplier);
            }
        }

        supplierTable.setItems(searchResults);

    }

    @FXML
    public void refreshTable(ActionEvent actionEvent) {
        supplierTable.refresh();


    }
}