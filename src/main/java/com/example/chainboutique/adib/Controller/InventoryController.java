package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.Inventory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDateTime;

public class InventoryController
{
    @javafx.fxml.FXML
    private TextField totalStockValueField;
    @javafx.fxml.FXML
    private Button addInventoryButton;
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private TableColumn <Inventory,Double> totalStockValueColumn;
    @javafx.fxml.FXML
    private TextField searchField;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TextField inventoryIdField;
    @javafx.fxml.FXML
    private TableColumn <Inventory, LocalDateTime> lastUpdatedColumn;
    @javafx.fxml.FXML
    private DatePicker lastUpdatedPicker;
    @javafx.fxml.FXML
    private TableColumn <Inventory,String> inventoryIdColumn;
    private ObservableList<Inventory> inventoryList =
            FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private TableView <Inventory>inventoryTable;

    @javafx.fxml.FXML
    public void initialize() {

        inventoryIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("inventoryID"));

        totalStockValueColumn.setCellValueFactory(
                new PropertyValueFactory<>("totalStockValue"));

        lastUpdatedColumn.setCellValueFactory(
                new PropertyValueFactory<>("lastUpdated"));

        inventoryTable.setItems(inventoryList);
    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {

        inventoryIdField.clear();
        totalStockValueField.clear();
        lastUpdatedPicker.setValue(null);
        searchField.clear();

    }

    @javafx.fxml.FXML
    public void addInventory(ActionEvent actionEvent) {


        String inventoryID = inventoryIdField.getText();
        double totalStockValue =
                Double.parseDouble(totalStockValueField.getText());

        LocalDateTime lastUpdated = null;

        if (lastUpdatedPicker.getValue() != null) {
            lastUpdated = lastUpdatedPicker.getValue().atStartOfDay();
        }

        Inventory inventory = new Inventory(
                inventoryID,
                totalStockValue,
                lastUpdated
        );

        inventoryList.add(inventory);

        clearFields(null);
    }

    @javafx.fxml.FXML
    public void refreshtable(ActionEvent actionEvent) {
        inventoryTable.refresh();



    }

    @javafx.fxml.FXML
    public void searchInventory(ActionEvent actionEvent) {

        String searchText = searchField.getText().toLowerCase();

        if (searchText.isEmpty()) {
            inventoryTable.setItems(inventoryList);
            return;
        }

        ObservableList<Inventory> searchResults =
                FXCollections.observableArrayList();

        for (Inventory inventory : inventoryList) {

            if (inventory.getInventoryID().toLowerCase().contains(searchText)
                    || String.valueOf(inventory.getTotalStockValue()).contains(searchText)
                    || String.valueOf(inventory.getLastUpdated()).toLowerCase().contains(searchText)) {

                searchResults.add(inventory);
            }
        }

        inventoryTable.setItems(searchResults);



    }
}