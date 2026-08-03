package com.example.chainboutique.adib;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

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
    private TableColumn<ClientAnalytics,Integer> generatedOnColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addAnalytics(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchAnalytics(ActionEvent actionEvent) {
    }
}