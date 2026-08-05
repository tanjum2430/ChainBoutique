package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.AnnualReport;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class AnnualReportController
{
    @javafx.fxml.FXML
    private TableView <AnnualReport> annualReportTable;
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
    private Spinner <Integer> reportYearSpinner;
    @javafx.fxml.FXML
    private TableColumn <AnnualReport,String> filePathColumn;
    @javafx.fxml.FXML
    private TableColumn <AnnualReport,String> generatedByColumn;
    @javafx.fxml.FXML
    private DatePicker generatedOnPicker;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private TableColumn <AnnualReport,String>reportIdColumn;
    @javafx.fxml.FXML
    private TextField generatedByField;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TableColumn <AnnualReport,Integer> reportYearColumn;
    @javafx.fxml.FXML
    private TableColumn <AnnualReport,Integer> generatedOnColumn;

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