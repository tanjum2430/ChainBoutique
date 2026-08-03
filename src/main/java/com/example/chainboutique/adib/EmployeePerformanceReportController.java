package com.example.chainboutique.adib;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;

public class EmployeePerformanceReportController
{
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private Button addReportButton;
    @javafx.fxml.FXML
    private TextField searchField;
    @javafx.fxml.FXML
    private TextField reportIdField;
    @javafx.fxml.FXML
    private TableColumn <EmployeePerformanceReport,String> topPerformerColumn;
    @javafx.fxml.FXML
    private TextField departmentIdField;
    @javafx.fxml.FXML
    private TableColumn <EmployeePerformanceReport,String> departmentIdColumn;
    @javafx.fxml.FXML
    private TextField topPerformerField;
    @javafx.fxml.FXML
    private TableColumn <EmployeePerformanceReport,String> averageScoreColumn;
    @javafx.fxml.FXML
    private DatePicker generatedOnPicker;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private TableColumn <EmployeePerformanceReport,String> reportIdColumn;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TextField averageScoreField;
    @javafx.fxml.FXML
    private TableColumn <EmployeePerformanceReport,LocalDate> generatedOnColumn;
    @javafx.fxml.FXML
    private TableView <EmployeePerformanceReport> employeePerformanceReportTable;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchReport(ActionEvent actionEvent) {
    }
}