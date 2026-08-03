package com.example.chainboutique.adib;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

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

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addDepartment(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchDepartment(ActionEvent actionEvent) {
    }
}