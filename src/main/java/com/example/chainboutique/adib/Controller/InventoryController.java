package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.Inventory;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import com.example.chainboutique.tanjum.Product;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class InventoryController
{

    private static final String PRODUCT_FILE = "products.bin";


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
    private Button updateStockButton;
    @javafx.fxml.FXML
    private TextField productIdField;
    @javafx.fxml.FXML
    private TextField stockQuantityField;

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

    @javafx.fxml.FXML
    public void updateStockOnAction(ActionEvent actionEvent) {
    }
}