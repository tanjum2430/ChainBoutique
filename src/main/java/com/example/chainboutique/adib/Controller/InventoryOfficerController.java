package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.InventoryOfficer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private ObservableList<InventoryOfficer> inventoryList =
            FXCollections.observableArrayList();
    @FXML
    private TableColumn<InventoryOfficer,String> productIdColumn;
    @FXML
    private TableColumn<InventoryOfficer,String> productNameColumn;
    @FXML
    private TableColumn<InventoryOfficer,String> categoryColumn;
    @FXML
    private TableColumn<InventoryOfficer,Integer> quantityColumn;
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
        inventoryTable.setItems(inventoryList);

        productIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("productID"));

        productNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("productName"));

        categoryColumn.setCellValueFactory(
                new PropertyValueFactory<>("category"));

        quantityColumn.setCellValueFactory(
                new PropertyValueFactory<>("quantity"));

        supplierColumn.setCellValueFactory(
                new PropertyValueFactory<>("supplier"));

        warehouseColumn.setCellValueFactory(
                new PropertyValueFactory<>("warehouse"));

        unitPriceColumn.setCellValueFactory(
                new PropertyValueFactory<>("unitPrice"));

        sellingPriceColumn.setCellValueFactory(
                new PropertyValueFactory<>("sellingPrice"));

        categoryComboBox.getItems().addAll(
                "Clothing",
                "Accessories",
                "Footwear",
                "Bags"
        );

        supplierComboBox.getItems().addAll(
                "Supplier A",
                "Supplier B",
                "Supplier C"
        );

        warehouseComboBox.getItems().addAll(
                "Warehouse A",
                "Warehouse B",
                "Warehouse C"
        );

        filterCategoryComboBox.getItems().addAll(
                "Clothing",
                "Accessories",
                "Footwear",
                "Bags"
        );

        quantitySpinner.getValueFactory().setValue(0);

    }

    @FXML
    private void addProduct() {
        String productID = productIdField.getText();
        String productName = productNameField.getText();
        String category = categoryComboBox.getValue();

        Integer quantity = quantitySpinner.getValue();

        String supplier = supplierComboBox.getValue();
        String warehouse = warehouseComboBox.getValue();

        double unitPrice = Double.parseDouble(unitPriceField.getText());
        double sellingPrice = Double.parseDouble(sellingPriceField.getText());

        InventoryOfficer product = new InventoryOfficer(
                productID,
                productName,
                category,
                quantity,
                supplier,
                warehouse,
                unitPrice,
                sellingPrice
        );

        inventoryList.add(product);

    }

    @FXML
    private void clearFields() {

        productIdField.clear();
        productNameField.clear();
        categoryComboBox.setValue(null);
        quantitySpinner.getValueFactory().setValue(0);
        supplierComboBox.setValue(null);
        warehouseComboBox.setValue(null);
        unitPriceField.clear();
        sellingPriceField.clear();

    }

    @FXML
    private void searchProduct() {
        String searchText = searchField.getText().toLowerCase();

        ObservableList<InventoryOfficer> searchResults =
                FXCollections.observableArrayList();

        for (InventoryOfficer product : inventoryList) {

            if (product.getProductID().toLowerCase().contains(searchText)
                    || product.getProductName().toLowerCase().contains(searchText)) {

                searchResults.add(product);
            }
        }

        inventoryTable.setItems(searchResults);

    }

    @FXML
    private void filterProducts() {
        String category = filterCategoryComboBox.getValue();

        ObservableList<InventoryOfficer> filteredProducts =
                FXCollections.observableArrayList();

        for (InventoryOfficer product : inventoryList) {

            if (category == null
                    || category.isEmpty()
                    || category.equals(product.getCategory())) {

                filteredProducts.add(product);
            }
        }

        inventoryTable.setItems(filteredProducts);

    }

    @FXML
    private void refreshTable() {
        inventoryTable.setItems(inventoryList);


    }
}