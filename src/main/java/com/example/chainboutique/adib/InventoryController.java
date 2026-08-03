package com.example.chainboutique.adib;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

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
    private TableColumn <Inventory,Integer> lastUpdatedColumn;
    @javafx.fxml.FXML
    private DatePicker lastUpdatedPicker;
    @javafx.fxml.FXML
    private TableColumn <Inventory,String> inventoryIdColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addInventory(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshtable(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchInventory(ActionEvent actionEvent) {
    }
}