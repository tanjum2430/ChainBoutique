package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

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
    private TableColumn <Employee, LocalDate> hireDateColumn;
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
    private ObservableList<Employee> employeeList =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        employeeIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("employeeID"));

        fullNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("fullName"));

        emailColumn.setCellValueFactory(
                new PropertyValueFactory<>("email"));

        phoneNumberColumn.setCellValueFactory(
                new PropertyValueFactory<>("phoneNo"));

        departmentIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("departmentID"));

        designationColumn.setCellValueFactory(
                new PropertyValueFactory<>("designation"));

        statusColumn.setCellValueFactory(
                new PropertyValueFactory<>("status"));

        hireDateColumn.setCellValueFactory(
                new PropertyValueFactory<>("hireDate"));

        statusComboBox.getItems().addAll(
                "Active",
                "Inactive"
        );

        employeeTable.setItems(employeeList);

    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
        employeeTable.refresh();


    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {

        employeeIdField.clear();
        fullNameField.clear();
        emailField.clear();
        phoneNumberField.clear();
        departmentIdField.clear();
        designationField.clear();

        statusComboBox.setValue(null);
        hireDatePicker.setValue(null);
        searchField.clear();
    }

    @javafx.fxml.FXML
    public void searchEmployee(ActionEvent actionEvent) {


        String searchText = searchField.getText().toLowerCase();

        if (searchText.isEmpty()) {
            employeeTable.setItems(employeeList);
            return;
        }

        ObservableList<Employee> searchResults =
                FXCollections.observableArrayList();

        for (Employee employee : employeeList) {

            if (employee.getEmployeeID().toLowerCase().contains(searchText)
                    || employee.getFullName().toLowerCase().contains(searchText)
                    || employee.getEmail().toLowerCase().contains(searchText)
                    || employee.getPhoneNo().toLowerCase().contains(searchText)
                    || employee.getDepartmentID().toLowerCase().contains(searchText)
                    || employee.getDesignation().toLowerCase().contains(searchText)
                    || employee.getStatus().toLowerCase().contains(searchText)) {

                searchResults.add(employee);
            }
        }

        employeeTable.setItems(searchResults);

    }

    @javafx.fxml.FXML
    public void addEmployee(ActionEvent actionEvent) {

        String employeeID = employeeIdField.getText();
        String fullName = fullNameField.getText();
        String email = emailField.getText();
        String phoneNo = phoneNumberField.getText();
        String departmentID = departmentIdField.getText();
        String designation = designationField.getText();
        String status = statusComboBox.getValue();
        LocalDate hireDate = hireDatePicker.getValue();

        Employee employee = new Employee(
                employeeID,
                fullName,
                email,
                phoneNo,
                departmentID,
                designation,
                status,
                hireDate
        );

        employeeList.add(employee);

        clearFields(null);
    }
}