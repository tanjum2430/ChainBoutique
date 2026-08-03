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
    private ComboBox<?> categoryComboBox;

    @FXML
    private Spinner<Integer> quantitySpinner;

    @FXML
    private ComboBox<?> supplierComboBox;

    @FXML
    private ComboBox<?> warehouseComboBox;

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
    private ComboBox<?> filterCategoryComboBox;

    @FXML
    private TableView<?> inventoryTable;

    @FXML
    private TableColumn<?, ?> productIdColumn;

    @FXML
    private TableColumn<?, ?> productNameColumn;

    @FXML
    private TableColumn<?, ?> categoryColumn;

    @FXML
    private TableColumn<?, ?> quantityColumn;

    @FXML
    private TableColumn<?, ?> supplierColumn;

    @FXML
    private TableColumn<?, ?> warehouseColumn;

    @FXML
    private TableColumn<?, ?> unitPriceColumn;

    @FXML
    private TableColumn<?, ?> sellingPriceColumn;

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