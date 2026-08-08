package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.Dashboard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDateTime;

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
    private TableColumn <Dashboard, LocalDateTime> generatedOnColumn;

    private ObservableList<Dashboard> dashboardList =
            FXCollections.observableArrayList();
    @javafx.fxml.FXML
    public void initialize() {


        dashboardIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("dashboardID"));

        totalJobsPostedColumn.setCellValueFactory(
                new PropertyValueFactory<>("totalJobsPosted"));

        totalHiresColumn.setCellValueFactory(
                new PropertyValueFactory<>("totalHires"));

        totalRevenueColumn.setCellValueFactory(
                new PropertyValueFactory<>("totalRevenue"));

        activeClientsColumn.setCellValueFactory(
                new PropertyValueFactory<>("activeClients"));

        generatedOnColumn.setCellValueFactory(
                new PropertyValueFactory<>("generatedOn"));

        dashboardTable.setItems(dashboardList);

        totalJobsPostedSpinner.getValueFactory().setValue(0);
        totalHiresSpinner.getValueFactory().setValue(0);
        activeClientsSpinner.getValueFactory().setValue(0);
    }

    @javafx.fxml.FXML
    public void addDashboard(ActionEvent actionEvent) {


        String dashboardID = dashboardIdField.getText();

        int totalJobsPosted = totalJobsPostedSpinner.getValue();
        int totalHires = totalHiresSpinner.getValue();
        int activeClients = activeClientsSpinner.getValue();

        double totalRevenue =
                Double.parseDouble(totalRevenueField.getText());

        LocalDateTime generatedOn = null;

        if (generatedOnPicker.getValue() != null) {
            generatedOn = generatedOnPicker.getValue().atStartOfDay();
        }

        Dashboard dashboard = new Dashboard(
                dashboardID,
                totalJobsPosted,
                totalHires,
                totalRevenue,
                activeClients,
                generatedOn
        );

        dashboardList.add(dashboard);

        clearFields(null);
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
        dashboardTable.refresh();

    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {

        dashboardIdField.clear();
        totalRevenueField.clear();

        totalJobsPostedSpinner.getValueFactory().setValue(0);
        totalHiresSpinner.getValueFactory().setValue(0);
        activeClientsSpinner.getValueFactory().setValue(0);

        generatedOnPicker.setValue(null);
        searchField.clear();
    }

    @javafx.fxml.FXML
    public void searchDashboard(ActionEvent actionEvent) {


        String searchText = searchField.getText().toLowerCase();

        if (searchText.isEmpty()) {
            dashboardTable.setItems(dashboardList);
            return;
        }

        ObservableList<Dashboard> searchResults =
                FXCollections.observableArrayList();

        for (Dashboard dashboard : dashboardList) {

            if (dashboard.getDashboardID().toLowerCase().contains(searchText)
                    || String.valueOf(dashboard.getTotalJobsPosted()).contains(searchText)
                    || String.valueOf(dashboard.getTotalHires()).contains(searchText)
                    || String.valueOf(dashboard.getTotalRevenue()).contains(searchText)
                    || String.valueOf(dashboard.getActiveClients()).contains(searchText)) {

                searchResults.add(dashboard);
            }
        }

        dashboardTable.setItems(searchResults);
    }
}