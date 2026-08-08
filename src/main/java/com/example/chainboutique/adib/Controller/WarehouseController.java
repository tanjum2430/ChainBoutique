package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.Warehouse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn<Warehouse,Integer> capacityColumn;
    @FXML
    private TableColumn<Warehouse,String> managerNameColumn;

    private ObservableList<Warehouse> warehouseList =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {


        warehouseTable.setItems(warehouseList);

        warehouseIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("warehouseID"));

        warehouseNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("warehouseName"));

        locationColumn.setCellValueFactory(
                new PropertyValueFactory<>("location"));

        capacityColumn.setCellValueFactory(
                new PropertyValueFactory<>("capacity"));

        managerNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("managerName"));

        capacitySpinner.getValueFactory().setValue(0);

    }

    @FXML
    public void addWarehouse(ActionEvent actionEvent) {

        String warehouseID = warehouseIdField.getText();
        String warehouseName = warehouseNameField.getText();
        String location = locationField.getText();

        Integer capacity = capacitySpinner.getValue();

        String managerName = managerNameField.getText();

        Warehouse warehouse = new Warehouse(
                warehouseID,
                warehouseName,
                location,
                capacity,
                managerName
        );

        warehouseList.add(warehouse);

        clearFields(null);

    }

    @FXML
    public void clearFields(ActionEvent actionEvent) {


        warehouseIdField.clear();
        warehouseNameField.clear();
        locationField.clear();
        capacitySpinner.getValueFactory().setValue(0);
        managerNameField.clear();
        searchField.clear();

    }

    @FXML
    public void searchWarehouse(ActionEvent actionEvent) {

        String searchText = searchField.getText().toLowerCase();

        if (searchText.isEmpty()) {
            warehouseTable.setItems(warehouseList);
            return;
        }

        ObservableList<Warehouse> searchResults =
                FXCollections.observableArrayList();

        for (Warehouse warehouse : warehouseList) {

            if (warehouse.getWarehouseID().toLowerCase().contains(searchText)
                    || warehouse.getWarehouseName().toLowerCase().contains(searchText)
                    || warehouse.getLocation().toLowerCase().contains(searchText)
                    || String.valueOf(warehouse.getCapacity()).contains(searchText)
                    || warehouse.getManagerName().toLowerCase().contains(searchText)) {

                searchResults.add(warehouse);
            }
        }

        warehouseTable.setItems(searchResults);

    }

    @FXML
    public void refreshTable(ActionEvent actionEvent) {

        warehouseTable.setItems(warehouseList);
        warehouseTable.refresh();

    }
}