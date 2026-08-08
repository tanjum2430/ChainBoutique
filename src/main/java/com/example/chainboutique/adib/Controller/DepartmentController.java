package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.Department;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class DepartmentController
{
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private TableView <Department> departmentTable;
    @javafx.fxml.FXML
    private TextArea descriptionArea;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private TextField searchField;
    @javafx.fxml.FXML
    private Button addDepartmentButton;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TextField departmentNameField;
    @javafx.fxml.FXML
    private TextField departmentIdField;
    @javafx.fxml.FXML
    private TableColumn <Department,String> departmentIdColumn;
    @javafx.fxml.FXML
    private TableColumn <Department,String> departmentNameColumn;
    @javafx.fxml.FXML
    private TableColumn <Department,String> descriptionColumn;
    private ObservableList<Department> departmentList =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {


        departmentIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("departmentID"));

        departmentNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("departmentName"));

        descriptionColumn.setCellValueFactory(
                new PropertyValueFactory<>("description"));

        departmentTable.setItems(departmentList);
    }

    @javafx.fxml.FXML
    public void addDepartment(ActionEvent actionEvent) {


        String departmentID = departmentIdField.getText();
        String departmentName = departmentNameField.getText();
        String description = descriptionArea.getText();

        Department department = new Department(
                departmentID,
                departmentName,
                description
        );

        departmentList.add(department);

        clearFields(null);

    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
        departmentTable.refresh();

    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {


        departmentIdField.clear();
        departmentNameField.clear();
        descriptionArea.clear();
        searchField.clear();
    }

    @javafx.fxml.FXML
    public void searchDepartment(ActionEvent actionEvent) {


        String searchText = searchField.getText().toLowerCase();

        if (searchText.isEmpty()) {
            departmentTable.setItems(departmentList);
            return;
        }

        ObservableList<Department> searchResults =
                FXCollections.observableArrayList();

        for (Department department : departmentList) {

            if (department.getDepartmentID().toLowerCase().contains(searchText)
                    || department.getDepartmentName().toLowerCase().contains(searchText)
                    || department.getDescription().toLowerCase().contains(searchText)) {

                searchResults.add(department);
            }
        }

        departmentTable.setItems(searchResults);
    }
}