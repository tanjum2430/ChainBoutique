package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.AnnualReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDateTime;

public class AnnualReportController {

    @javafx.fxml.FXML
    private TableView<AnnualReport> annualReportTable;

    @javafx.fxml.FXML
    private Button searchButton;

    @javafx.fxml.FXML
    private Button addReportButton;

    @javafx.fxml.FXML
    private TextField searchField;

    @javafx.fxml.FXML
    private TextField reportIdField;

    @javafx.fxml.FXML
    private TextField filePathField;

    @javafx.fxml.FXML
    private Spinner<Integer> reportYearSpinner;

    @javafx.fxml.FXML
    private TableColumn<AnnualReport, String> filePathColumn;

    @javafx.fxml.FXML
    private TableColumn<AnnualReport, String> generatedByColumn;

    @javafx.fxml.FXML
    private DatePicker generatedOnPicker;

    @javafx.fxml.FXML
    private Button clearButton;

    @javafx.fxml.FXML
    private TableColumn<AnnualReport, String> reportIdColumn;

    @javafx.fxml.FXML
    private TextField generatedByField;

    @javafx.fxml.FXML
    private Button refreshButton;

    @javafx.fxml.FXML
    private TableColumn<AnnualReport, Integer> reportYearColumn;

    @javafx.fxml.FXML
    private TableColumn<AnnualReport, LocalDateTime> generatedOnColumn;

    private ObservableList<AnnualReport> reportList =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        reportIdColumn.setCellValueFactory(
                cellData -> new javafx.beans.property.SimpleStringProperty(
                        cellData.getValue().getReportID()
                )
        );

        reportYearColumn.setCellValueFactory(
                cellData -> new javafx.beans.property.SimpleIntegerProperty(
                        cellData.getValue().getReportYear()
                ).asObject()
        );

        generatedOnColumn.setCellValueFactory(
                cellData -> new javafx.beans.property.SimpleObjectProperty<>(
                        cellData.getValue().getGeneratedOn()
                )
        );

        generatedByColumn.setCellValueFactory(
                cellData -> new javafx.beans.property.SimpleStringProperty(
                        cellData.getValue().getGeneratedBy()
                )
        );

        filePathColumn.setCellValueFactory(
                cellData -> new javafx.beans.property.SimpleStringProperty(
                        cellData.getValue().getFilePath()
                )
        );

        annualReportTable.setItems(reportList);
    }

    @javafx.fxml.FXML
    public void addReport(ActionEvent actionEvent) {
        String reportID = reportIdField.getText();
        int reportYear = reportYearSpinner.getValue();
        String generatedBy = generatedByField.getText();
        String filePath = filePathField.getText();

        LocalDateTime generatedOn = null;

        if (generatedOnPicker.getValue() != null) {
            generatedOn = generatedOnPicker.getValue().atStartOfDay();
        }

        AnnualReport report = new AnnualReport(
                reportID,
                reportYear,
                generatedOn,
                generatedBy,
                filePath
        );

        reportList.add(report);

        clearFields(null);
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {

        annualReportTable.refresh();
    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {

        reportIdField.clear();
        generatedByField.clear();
        filePathField.clear();
        generatedOnPicker.setValue(null);
        reportYearSpinner.getValueFactory().setValue(2026);
    }

    @javafx.fxml.FXML
    public void searchReport(ActionEvent actionEvent) {


        String searchText = searchField.getText().toLowerCase();

        if (searchText.isEmpty()) {
            annualReportTable.setItems(reportList);
            return;
        }

        ObservableList<AnnualReport> searchResults =
                FXCollections.observableArrayList();

        for (AnnualReport report : reportList) {

            if (report.getReportID().toLowerCase().contains(searchText)
                    || report.getGeneratedBy().toLowerCase().contains(searchText)
                    || report.getFilePath().toLowerCase().contains(searchText)
                    || String.valueOf(report.getReportYear()).contains(searchText)) {

                searchResults.add(report);
            }
        }

        annualReportTable.setItems(searchResults);
    }
}