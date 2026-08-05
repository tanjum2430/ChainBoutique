package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.Supply;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class SupplyController
{
    @javafx.fxml.FXML
    private DatePicker deliveryDatePicker;
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private TextField supplierIdField;
    @javafx.fxml.FXML
    private TableColumn <Supply,DatePicker> deliveryDateColumn;
    @javafx.fxml.FXML
    private TextField searchField;
    @javafx.fxml.FXML
    private TableColumn <Supply,String >supplyIdColumn;
    @javafx.fxml.FXML
    private TableColumn <Supply,String> productIdColumn;
    @javafx.fxml.FXML
    private TextField supplyIdField;
    @javafx.fxml.FXML
    private TableColumn <Supply,String> purchasePriceColumn;
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
    private TableView <Supply> supplierTable;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addSupply(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchSupply(ActionEvent actionEvent) {
    }
}