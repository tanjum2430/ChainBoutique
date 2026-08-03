package com.example.chainboutique.adib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class WarehouseController {

    @FXML
    private TextField warehouseIdField;
    @FXML
    private TextField warehouseNameField;
    @FXML
    private TextField locationField;
    @FXML
    private Spinner<Integer> capacitySpinner;
    @FXML
    private TextField managerNameField;
    @FXML
    private TextField searchField;
    @FXML
    private Button addWarehouseButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button refreshButton;
    @FXML
    private TableView<Warehouse> warehouseTable;
    @FXML
    private TableColumn<Warehouse,String> warehouseIdColumn;
    @FXML
    private TableColumn<Warehouse,String>warehouseNameColumn;
    @FXML
    private TableColumn<Warehouse,String> locationColumn;
    @FXML
    private TableColumn<Warehouse,String> capacityColumn;
    @FXML
    private TableColumn<Warehouse,String> managerNameColumn;
    @FXML
    public void initialize() {

    }

    @FXML
    public void addWarehouse(ActionEvent actionEvent) {

    }

    @FXML
    public void clearFields(ActionEvent actionEvent) {

    }

    @FXML
    public void searchWarehouse(ActionEvent actionEvent) {

    }

    @FXML
    public void refreshTable(ActionEvent actionEvent) {

    }
}