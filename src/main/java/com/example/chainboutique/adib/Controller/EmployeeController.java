package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.Employee;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class EmployeeController
{
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private TextField employeeIdField;
    @javafx.fxml.FXML
    private TextField phoneNumberField;
    @javafx.fxml.FXML
    private TextField searchField;
    @javafx.fxml.FXML
    private DatePicker hireDatePicker;
    @javafx.fxml.FXML
    private TableColumn <Employee,String> fullNameColumn;
    @javafx.fxml.FXML
    private TableColumn <Employee,Integer> hireDateColumn;
    @javafx.fxml.FXML
    private TextField departmentIdField;
    @javafx.fxml.FXML
    private TextField emailField;
    @javafx.fxml.FXML
    private TextField designationField;
    @javafx.fxml.FXML
    private TableColumn <Employee,String> departmentIdColumn;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private TextField fullNameField;
    @javafx.fxml.FXML
    private Button addEmployeeButton;
    @javafx.fxml.FXML
    private ComboBox <String> statusComboBox;
    @javafx.fxml.FXML
    private Button RefreshButton;
    @javafx.fxml.FXML
    private TableView <Employee> employeeTable;
    @javafx.fxml.FXML
    private TableColumn <Employee,String> employeeIdColumn;
    @javafx.fxml.FXML
    private TableColumn <Employee,String> statusColumn;
    @javafx.fxml.FXML
    private TableColumn <Employee,String> designationColumn;
    @javafx.fxml.FXML
    private TableColumn <Employee,String> phoneNumberColumn;
    @javafx.fxml.FXML
    private TableColumn <Employee,String> emailColumn;

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
    public void searchEmployee(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addEmployee(ActionEvent actionEvent) {
    }
}