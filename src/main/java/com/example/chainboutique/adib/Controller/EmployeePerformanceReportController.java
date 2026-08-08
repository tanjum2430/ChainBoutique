package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.EmployeePerformanceReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDateTime;

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
    private TableColumn <EmployeePerformanceReport,Double> averageScoreColumn;
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
    private TableColumn <EmployeePerformanceReport, LocalDateTime> generatedOnColumn;
    @javafx.fxml.FXML
    private TableView <EmployeePerformanceReport> employeePerformanceReportTable;
    private ObservableList<EmployeePerformanceReport> reportList =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {


        reportIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("reportID"));

        departmentIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("departmentID"));

        averageScoreColumn.setCellValueFactory(
                new PropertyValueFactory<>("averageScore"));

        topPerformerColumn.setCellValueFactory(
                new PropertyValueFactory<>("topPerformer"));

        generatedOnColumn.setCellValueFactory(
                new PropertyValueFactory<>("generatedOn"));

        employeePerformanceReportTable.setItems(reportList);
    }

    @javafx.fxml.FXML
    public void addReport(ActionEvent actionEvent) {

        String reportID = reportIdField.getText();
        String departmentID = departmentIdField.getText();
        double averageScore = Double.parseDouble(averageScoreField.getText());
        String topPerformer = topPerformerField.getText();

        LocalDateTime generatedOn = null;

        if (generatedOnPicker.getValue() != null) {
            generatedOn = generatedOnPicker.getValue().atStartOfDay();
        }

        EmployeePerformanceReport report =
                new EmployeePerformanceReport(
                        reportID,
                        departmentID,
                        averageScore,
                        topPerformer,
                        generatedOn
                );

        reportList.add(report);

        clearFields(null);
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
        employeePerformanceReportTable.refresh();


    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {


        reportIdField.clear();
        departmentIdField.clear();
        averageScoreField.clear();
        topPerformerField.clear();

        generatedOnPicker.setValue(null);
        searchField.clear();
    }

    @javafx.fxml.FXML
    public void searchReport(ActionEvent actionEvent) {


        String searchText = searchField.getText().toLowerCase();

        if (searchText.isEmpty()) {
            employeePerformanceReportTable.setItems(reportList);
            return;
        }

        ObservableList<EmployeePerformanceReport> searchResults =
                FXCollections.observableArrayList();

        for (EmployeePerformanceReport report : reportList) {

            if (report.getReportID().toLowerCase().contains(searchText)
                    || report.getDepartmentID().toLowerCase().contains(searchText)
                    || String.valueOf(report.getAverageScore()).contains(searchText)
                    || report.getTopPerformer().toLowerCase().contains(searchText)) {

                searchResults.add(report);
            }
        }

        employeePerformanceReportTable.setItems(searchResults);
    }
}