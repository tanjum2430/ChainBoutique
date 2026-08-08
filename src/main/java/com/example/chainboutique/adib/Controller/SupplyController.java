package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.Supply;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class SupplyController
{
    @javafx.fxml.FXML
    private DatePicker deliveryDatePicker;
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private TextField supplierIdField;
    @javafx.fxml.FXML
    private TableColumn <Supply, LocalDate> deliveryDateColumn;
    @javafx.fxml.FXML
    private TextField searchField;
    @javafx.fxml.FXML
    private TableColumn <Supply,String >supplyIdColumn;
    @javafx.fxml.FXML
    private TableColumn <Supply,String> productIdColumn;
    @javafx.fxml.FXML
    private TextField supplyIdField;
    @javafx.fxml.FXML
    private TableColumn <Supply,Double> purchasePriceColumn;
    @javafx.fxml.FXML
    private TextField purchasePriceField;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private TextField productIdField;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TableColumn <Supply,String>supplierIdColumn;
    @javafx.fxml.FXML
    private Button addSupplyButton;
    @javafx.fxml.FXML
    private TableView<Supply> supplierTable;
    private ObservableList<Supply> supplyList =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {


        supplyIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("supplyID"));

        productIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("productID"));

        supplierIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("supplierID"));

        purchasePriceColumn.setCellValueFactory(
                new PropertyValueFactory<>("purchasePrice"));

        deliveryDateColumn.setCellValueFactory(
                new PropertyValueFactory<>("deliveryDate"));

        supplierTable.setItems(supplyList);
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
        supplierTable.refresh();

    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {

        supplyIdField.clear();
        productIdField.clear();
        supplierIdField.clear();
        purchasePriceField.clear();
        deliveryDatePicker.setValue(null);
        searchField.clear();
    }

    @javafx.fxml.FXML
    public void addSupply(ActionEvent actionEvent) {

        String supplyID = supplyIdField.getText();
        String productID = productIdField.getText();
        String supplierID = supplierIdField.getText();

        double purchasePrice =
                Double.parseDouble(purchasePriceField.getText());

        LocalDate deliveryDate = deliveryDatePicker.getValue();

        Supply supply = new Supply(
                supplyID,
                productID,
                supplierID,
                purchasePrice,
                deliveryDate
        );

        supplyList.add(supply);

        clearFields(null);
    }

    @javafx.fxml.FXML
    public void searchSupply(ActionEvent actionEvent) {

        String searchText = searchField.getText().toLowerCase();

        if (searchText.isEmpty()) {
            supplierTable.setItems(supplyList);
            return;
        }

        ObservableList<Supply> searchResults =
                FXCollections.observableArrayList();

        for (Supply supply : supplyList) {

            if (supply.getSupplyID().toLowerCase().contains(searchText)
                    || supply.getProductID().toLowerCase().contains(searchText)
                    || supply.getSupplierID().toLowerCase().contains(searchText)
                    || String.valueOf(supply.getPurchasePrice()).contains(searchText)
                    || String.valueOf(supply.getDeliveryDate()).contains(searchText)) {

                searchResults.add(supply);
            }
        }

        supplierTable.setItems(searchResults);


    }
}