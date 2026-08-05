package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.ApprovalRequest;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ApprovalRequestController
{
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private TableColumn <ApprovalRequest,String> remarksColumn;
    @javafx.fxml.FXML
    private TextField searchField;
    @javafx.fxml.FXML
    private ComboBox <String> requestTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn <ApprovalRequest,String> requestedOnColumn;
    @javafx.fxml.FXML
    private TableColumn <ApprovalRequest,String> requestTypeColumn;
    @javafx.fxml.FXML
    private TextField requestedByField;
    @javafx.fxml.FXML
    private TextField requestIdField;
    @javafx.fxml.FXML
    private Button addRequestButton;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private ComboBox <String> statusComboBox;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TableColumn <ApprovalRequest,String> statusColumn;
    @javafx.fxml.FXML
    private TextArea remarksArea;
    @javafx.fxml.FXML
    private DatePicker requestedOnPicker;
    @javafx.fxml.FXML
    private TableColumn <ApprovalRequest,String> requestedByColumn;
    @javafx.fxml.FXML
    private TableView <ApprovalRequest> approvalRequestTable;
    @javafx.fxml.FXML
    private TableColumn <ApprovalRequest,String> requestIdColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void searchRequest(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addRequest(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
    }
}