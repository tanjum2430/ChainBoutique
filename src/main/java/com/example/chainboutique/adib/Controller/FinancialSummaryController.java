package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.FinancialSummary;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

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
    private TableColumn <FinancialSummary, LocalDate> startDateColumn;
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
    private TableColumn <FinancialSummary,LocalDate> endDateColumn;
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
    private ObservableList<FinancialSummary> summaryList =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {


        reportIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("reportID"));

        startDateColumn.setCellValueFactory(
                new PropertyValueFactory<>("startDate"));

        endDateColumn.setCellValueFactory(
                new PropertyValueFactory<>("endDate"));

        totalRevenueColumn.setCellValueFactory(
                new PropertyValueFactory<>("totalRevenue"));

        totalExpenseColumn.setCellValueFactory(
                new PropertyValueFactory<>("totalExpense"));

        netProfitColumn.setCellValueFactory(
                new PropertyValueFactory<>("netProfit"));

        financialSummaryTable.setItems(summaryList);
    }

    @javafx.fxml.FXML
    public void searchSummary(ActionEvent actionEvent) {


        String reportID = reportIdField.getText();
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();

        double totalRevenue = Double.parseDouble(totalRevenueField.getText());
        double totalExpense = Double.parseDouble(totalExpenseField.getText());
        double netProfit = Double.parseDouble(netProfitField.getText());

        FinancialSummary summary = new FinancialSummary(
                reportID,
                startDate,
                endDate,
                totalRevenue,
                totalExpense,
                netProfit
        );

        summaryList.add(summary);

        clearFields(null);
    }

    @javafx.fxml.FXML
    public void addSummary(ActionEvent actionEvent) {


        String searchText = searchField.getText().toLowerCase();

        if (searchText.isEmpty()) {
            financialSummaryTable.setItems(summaryList);
            return;
        }

        ObservableList<FinancialSummary> searchResults =
                FXCollections.observableArrayList();

        for (FinancialSummary summary : summaryList) {

            if (summary.getReportID().toLowerCase().contains(searchText)
                    || String.valueOf(summary.getStartDate()).contains(searchText)
                    || String.valueOf(summary.getEndDate()).contains(searchText)
                    || String.valueOf(summary.getTotalRevenue()).contains(searchText)
                    || String.valueOf(summary.getTotalExpense()).contains(searchText)
                    || String.valueOf(summary.getNetProfit()).contains(searchText)) {

                searchResults.add(summary);
            }
        }

        financialSummaryTable.setItems(searchResults);

    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
        financialSummaryTable.refresh();

    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {


        reportIdField.clear();
        totalRevenueField.clear();
        totalExpenseField.clear();
        netProfitField.clear();

        startDatePicker.setValue(null);
        endDatePicker.setValue(null);
        searchField.clear();
    }
}