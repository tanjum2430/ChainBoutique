package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.PerformanceReport;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PerformanceReportController
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
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private TextField placementRateField;
    @javafx.fxml.FXML
    private TextField timeToHireField;
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TextField recruiterProductivityField;
    @javafx.fxml.FXML
    private ComboBox <String> reportTypeComboBox;
    @javafx.fxml.FXML
    private TableView <PerformanceReport> performanceReportTable;
    @javafx.fxml.FXML
    private TableColumn <PerformanceReport,String> recruiterProductivityColumn;
    @javafx.fxml.FXML
    private TableColumn <PerformanceReport,String> placementRateColumn;
    @javafx.fxml.FXML
    private TableColumn<PerformanceReport, LocalDate> startDateColumn;
    @javafx.fxml.FXML
    private TableColumn <PerformanceReport,String> reportTypeColumn;
    @javafx.fxml.FXML
    private TableColumn<PerformanceReport,LocalDate> endDateColumn;
    @javafx.fxml.FXML
    private TableColumn <PerformanceReport, LocalDateTime> timeToHireColumn;
    @javafx.fxml.FXML
    private TableColumn <PerformanceReport,String> reportIdColumn;

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