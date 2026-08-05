package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.FinancialSummary;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class FinancialSummaryController
{
    @javafx.fxml.FXML
    private TextField netProfitField;
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private TextField searchField;
    @javafx.fxml.FXML
    private TextField reportIdField;
    @javafx.fxml.FXML
    private TableColumn <FinancialSummary,Integer> startDateColumn;
    @javafx.fxml.FXML
    private TableColumn <FinancialSummary,Double> totalRevenueColumn;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private TableColumn <FinancialSummary,Double> netProfitColumn;
    @javafx.fxml.FXML
    private Button addSummaryButton;
    @javafx.fxml.FXML
    private TextField totalRevenueField;
    @javafx.fxml.FXML
    private TableColumn <FinancialSummary,Integer> endDateColumn;
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private TableColumn <FinancialSummary,String> reportIdColumn;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TableView <FinancialSummary> financialSummaryTable;
    @javafx.fxml.FXML
    private TextField totalExpenseField;
    @javafx.fxml.FXML
    private TableColumn <FinancialSummary,Double> totalExpenseColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void searchSummary(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addSummary(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {
    }
}