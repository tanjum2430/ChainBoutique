package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.ApprovalRequest;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDateTime;

public class ApprovalRequestController
{
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private TableColumn<ApprovalRequest,String> remarksColumn;
    @javafx.fxml.FXML
    private TextField searchField;
    @javafx.fxml.FXML
    private ComboBox<String> requestTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<ApprovalRequest,String> requestedOnColumn;
    @javafx.fxml.FXML
    private TableColumn<ApprovalRequest,String> requestTypeColumn;
    @javafx.fxml.FXML
    private TextField requestedByField;
    @javafx.fxml.FXML
    private TextField requestIdField;
    @javafx.fxml.FXML
    private Button addRequestButton;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TableColumn<ApprovalRequest,String> statusColumn;
    @javafx.fxml.FXML
    private TextArea remarksArea;
    @javafx.fxml.FXML
    private DatePicker requestedOnPicker;
    @javafx.fxml.FXML
    private TableColumn<ApprovalRequest,String> requestedByColumn;
    @javafx.fxml.FXML
    private TableView<ApprovalRequest> approvalRequestTable;
    @javafx.fxml.FXML
    private TableColumn<ApprovalRequest,String> requestIdColumn;

    private ObservableList<ApprovalRequest> requestList =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        requestIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("requestID"));

        requestTypeColumn.setCellValueFactory(
                new PropertyValueFactory<>("requestType"));

        requestedByColumn.setCellValueFactory(
                new PropertyValueFactory<>("requestedBy"));

        requestedOnColumn.setCellValueFactory(
                new PropertyValueFactory<>("requestedOn"));

        statusColumn.setCellValueFactory(
                new PropertyValueFactory<>("status"));

        remarksColumn.setCellValueFactory(
                new PropertyValueFactory<>("remarks"));

        requestTypeComboBox.getItems().addAll(
                "Leave",
                "Purchase",
                "Budget",
                "Other"
        );

        statusComboBox.getItems().addAll(
                "Pending",
                "Approved",
                "Rejected"
        );

        approvalRequestTable.setItems(requestList);
    }

    @javafx.fxml.FXML
    public void searchRequest(ActionEvent actionEvent) {

        String searchText = searchField.getText().toLowerCase();

        if (searchText.isEmpty()) {
            approvalRequestTable.setItems(requestList);
            return;
        }

        ObservableList<ApprovalRequest> searchResults =
                FXCollections.observableArrayList();

        for (ApprovalRequest request : requestList) {

            if (request.getRequestID().toLowerCase().contains(searchText)
                    || request.getRequestType().toLowerCase().contains(searchText)
                    || request.getRequestedBy().toLowerCase().contains(searchText)
                    || request.getStatus().toLowerCase().contains(searchText)
                    || request.getRemarks().toLowerCase().contains(searchText)) {

                searchResults.add(request);
            }
        }

        approvalRequestTable.setItems(searchResults);

    }

    @javafx.fxml.FXML
    public void addRequest(ActionEvent actionEvent) {

        String requestID = requestIdField.getText();
        String requestType = requestTypeComboBox.getValue();
        String requestedBy = requestedByField.getText();
        String status = statusComboBox.getValue();
        String remarks = remarksArea.getText();

        LocalDateTime requestedOn = null;

        if (requestedOnPicker.getValue() != null) {
            requestedOn = requestedOnPicker.getValue().atStartOfDay();
        }

        ApprovalRequest request = new ApprovalRequest(
                requestID,
                requestType,
                requestedBy,
                requestedOn,
                status,
                remarks
        );

        requestList.add(request);

        clearFields(null);
    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {


        requestIdField.clear();
        requestedByField.clear();
        remarksArea.clear();

        requestTypeComboBox.setValue(null);
        statusComboBox.setValue(null);
        requestedOnPicker.setValue(null);
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {

        approvalRequestTable.refresh();
    }
}