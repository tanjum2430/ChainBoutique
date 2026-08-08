package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.PerformanceReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn <PerformanceReport,Double> recruiterProductivityColumn;
    @javafx.fxml.FXML
    private TableColumn <PerformanceReport,Double> placementRateColumn;
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
    private ObservableList<PerformanceReport> reportList =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        reportIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("reportID"));

        startDateColumn.setCellValueFactory(
                new PropertyValueFactory<>("startDate"));

        endDateColumn.setCellValueFactory(
                new PropertyValueFactory<>("endDate"));

        reportTypeColumn.setCellValueFactory(
                new PropertyValueFactory<>("reportType"));

        timeToHireColumn.setCellValueFactory(
                new PropertyValueFactory<>("timeToHire"));

        placementRateColumn.setCellValueFactory(
                new PropertyValueFactory<>("placementRate"));

        recruiterProductivityColumn.setCellValueFactory(
                new PropertyValueFactory<>("recruiterProductivity"));

        reportTypeComboBox.getItems().addAll(
                "Annual",
                "Quarterly",
                "Monthly"
        );

        performanceReportTable.setItems(reportList);
    }

    @javafx.fxml.FXML
    public void addReport(ActionEvent actionEvent) {

        String reportID = reportIdField.getText();

        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();

        String reportType = reportTypeComboBox.getValue();

        double timeToHire =
                Double.parseDouble(timeToHireField.getText());

        double placementRate =
                Double.parseDouble(placementRateField.getText());

        double recruiterProductivity =
                Double.parseDouble(recruiterProductivityField.getText());

        PerformanceReport report = new PerformanceReport(
                reportID,
                startDate,
                endDate,
                reportType,
                timeToHire,
                placementRate,
                recruiterProductivity
        );

        reportList.add(report);

        clearFields(null);
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
        performanceReportTable.refresh();

    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {

        reportIdField.clear();
        timeToHireField.clear();
        placementRateField.clear();
        recruiterProductivityField.clear();
        searchField.clear();

        startDatePicker.setValue(null);
        endDatePicker.setValue(null);
        reportTypeComboBox.setValue(null);
    }

    @javafx.fxml.FXML
    public void searchReport(ActionEvent actionEvent) {


        String searchText = searchField.getText().toLowerCase();

        if (searchText.isEmpty()) {
            performanceReportTable.setItems(reportList);
            return;
        }

        ObservableList<PerformanceReport> searchResults =
                FXCollections.observableArrayList();

        for (PerformanceReport report : reportList) {

            if (report.getReportID().toLowerCase().contains(searchText)
                    || report.getReportType().toLowerCase().contains(searchText)
                    || String.valueOf(report.getStartDate()).contains(searchText)
                    || String.valueOf(report.getEndDate()).contains(searchText)
                    || String.valueOf(report.getTimeToHire()).contains(searchText)
                    || String.valueOf(report.getPlacementRate()).contains(searchText)
                    || String.valueOf(report.getRecruiterProductivity()).contains(searchText)) {

                searchResults.add(report);
            }
        }

        performanceReportTable.setItems(searchResults);
    }
}