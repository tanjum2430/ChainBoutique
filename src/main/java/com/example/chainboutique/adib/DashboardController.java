package com.example.chainboutique.adib;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class DashboardController
{
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private TextField searchField;
    @javafx.fxml.FXML
    private Spinner <Integer> totalJobsPostedSpinner;
    @javafx.fxml.FXML
    private TableColumn <Dashboard,Double> totalRevenueColumn;
    @javafx.fxml.FXML
    private Button addDashboardButton;
    @javafx.fxml.FXML
    private TableColumn <Dashboard,Integer> totalJobsPostedColumn;
    @javafx.fxml.FXML
    private TableView <Dashboard> dashboardTable;
    @javafx.fxml.FXML
    private Spinner <Integer> totalHiresSpinner;
    @javafx.fxml.FXML
    private TextField totalRevenueField;
    @javafx.fxml.FXML
    private DatePicker generatedOnPicker;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private TextField dashboardIdField;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TableColumn <Dashboard,Integer> totalHiresColumn;
    @javafx.fxml.FXML
    private TableColumn <Dashboard,Integer> activeClientsColumn;
    @javafx.fxml.FXML
    private TableColumn <Dashboard,String> dashboardIdColumn;
    @javafx.fxml.FXML
    private Spinner <Integer> activeClientsSpinner;
    @javafx.fxml.FXML
    private TableColumn <Dashboard,Integer> generatedOnColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addDashboard(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchDashboard(ActionEvent actionEvent) {
    }
}