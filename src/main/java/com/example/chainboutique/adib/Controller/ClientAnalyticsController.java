package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.ClientAnalytics;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDateTime;

public class ClientAnalyticsController
{
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private TextField searchField;
    @javafx.fxml.FXML
    private TableColumn <ClientAnalytics,Integer> newClientsColumn;
    @javafx.fxml.FXML
    private TextField reportIdField;
    @javafx.fxml.FXML
    private TextField retentionRateField;
    @javafx.fxml.FXML
    private TableColumn <ClientAnalytics,Integer> totalClientsColumn;
    @javafx.fxml.FXML
    private TableView <ClientAnalytics> clientAnalyticsTable;
    @javafx.fxml.FXML
    private TableColumn <ClientAnalytics,Double> retentionRateColumn;
    @javafx.fxml.FXML
    private Spinner <Integer> totalClientsSpinner;
    @javafx.fxml.FXML
    private DatePicker generatedOnPicker;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private TableColumn <ClientAnalytics,String> reportIdColumn;
    @javafx.fxml.FXML
    private Spinner <Integer> retainedClientsSpinner;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private Spinner <Integer> newClientsSpinner;
    @javafx.fxml.FXML
    private Button addAnalyticsButton;
    @javafx.fxml.FXML
    private TableColumn<ClientAnalytics,Integer> retainedClientsColumn;
    @javafx.fxml.FXML
    private TableColumn<ClientAnalytics,LocalDateTime> generatedOnColumn;
    private ObservableList<ClientAnalytics> analyticsList =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {


        reportIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("reportID"));

        totalClientsColumn.setCellValueFactory(
                new PropertyValueFactory<>("totalClients"));

        newClientsColumn.setCellValueFactory(
                new PropertyValueFactory<>("newClients"));

        retainedClientsColumn.setCellValueFactory(
                new PropertyValueFactory<>("retainedClients"));

        retentionRateColumn.setCellValueFactory(
                new PropertyValueFactory<>("retentionRate"));

        generatedOnColumn.setCellValueFactory(
                new PropertyValueFactory<>("generatedOn"));

        clientAnalyticsTable.setItems(analyticsList);

        totalClientsSpinner.getValueFactory().setValue(0);
        newClientsSpinner.getValueFactory().setValue(0);
        retainedClientsSpinner.getValueFactory().setValue(0);
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
        clientAnalyticsTable.refresh();

    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {


        reportIdField.clear();

        retentionRateField.clear();

        totalClientsSpinner.getValueFactory().setValue(0);
        newClientsSpinner.getValueFactory().setValue(0);
        retainedClientsSpinner.getValueFactory().setValue(0);

        generatedOnPicker.setValue(null);
        searchField.clear();
    }

    @javafx.fxml.FXML
    public void addAnalytics(ActionEvent actionEvent) {


        String reportID = reportIdField.getText();

        int totalClients = totalClientsSpinner.getValue();
        int newClients = newClientsSpinner.getValue();
        int retainedClients = retainedClientsSpinner.getValue();

        double retentionRate = 0;

        if (totalClients > 0) {
            retentionRate = ((double) retainedClients / totalClients) * 100;
        }

        retentionRateField.setText(String.valueOf(retentionRate));

        LocalDateTime generatedOn = null;

        if (generatedOnPicker.getValue() != null) {
            generatedOn = generatedOnPicker.getValue().atStartOfDay();
        }

        ClientAnalytics analytics = new ClientAnalytics(
                reportID,
                totalClients,
                newClients,
                retainedClients,
                retentionRate,
                generatedOn
        );

        analyticsList.add(analytics);

        clearFields(null);
    }

    @javafx.fxml.FXML
    public void searchAnalytics(ActionEvent actionEvent) {


        String searchText = searchField.getText().toLowerCase();

        if (searchText.isEmpty()) {
            clientAnalyticsTable.setItems(analyticsList);
            return;
        }

        ObservableList<ClientAnalytics> searchResults =
                FXCollections.observableArrayList();

        for (ClientAnalytics analytics : analyticsList) {

            if (analytics.getReportID().toLowerCase().contains(searchText)
                    || String.valueOf(analytics.getTotalClients()).contains(searchText)
                    || String.valueOf(analytics.getNewClients()).contains(searchText)
                    || String.valueOf(analytics.getRetainedClients()).contains(searchText)
                    || String.valueOf(analytics.getRetentionRate()).contains(searchText)) {

                searchResults.add(analytics);
            }
        }

        clientAnalyticsTable.setItems(searchResults);
    }
}