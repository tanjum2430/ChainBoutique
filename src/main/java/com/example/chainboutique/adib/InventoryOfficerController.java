package com.example.chainboutique.adib;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class InventoryOfficerController {

    @FXML
    private TextField productIdField;
    @FXML
    private TextField productNameField;
    @FXML
    private ComboBox<String> categoryComboBox;
    @FXML
    private Spinner<Integer> quantitySpinner;
    @FXML
    private ComboBox<String> supplierComboBox;
    @FXML
    private ComboBox<String> warehouseComboBox;
    @FXML
    private TextField unitPriceField;
    @FXML
    private TextField sellingPriceField;
    @FXML
    private Button addProductButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button filterButton;
    @FXML
    private Button refreshButton;
    @FXML
    private TextField searchField;
    @FXML
    private ComboBox<String> filterCategoryComboBox;
    @FXML
    private TableView<InventoryOfficer> inventoryTable;
    @FXML
    private TableColumn<InventoryOfficer,String> productIdColumn;
    @FXML
    private TableColumn<InventoryOfficer,String> productNameColumn;
    @FXML
    private TableColumn<InventoryOfficer,String> categoryColumn;
    @FXML
    private TableColumn<InventoryOfficer,String> quantityColumn;
    @FXML
    private TableColumn<InventoryOfficer,String> supplierColumn;
    @FXML
    private TableColumn<InventoryOfficer,String> warehouseColumn;
    @FXML
    private TableColumn<InventoryOfficer,Double> unitPriceColumn;
    @FXML
    private TableColumn<InventoryOfficer,Double> sellingPriceColumn;
    @FXML
    public void initialize() {

    }

    @FXML
    private void addProduct() {

    }

    @FXML
    private void clearFields() {

    }

    @FXML
    private void searchProduct() {

    }

    @FXML
    private void filterProducts() {

    }

    @FXML
    private void refreshTable() {

    }
}