package com.example.chainboutique.adib;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ClientController
{
    @javafx.fxml.FXML
    private TextField contactPersonField;
    @javafx.fxml.FXML
    private TableColumn <Client,String> clientIdColumn;
    @javafx.fxml.FXML
    private TableColumn <Client,String> addressColumn;
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private TableView <Client> clientTable;
    @javafx.fxml.FXML
    private TextField phoneNumberField;
    @javafx.fxml.FXML
    private TextField searchField;
    @javafx.fxml.FXML
    private TextField clientNameField;
    @javafx.fxml.FXML
    private TextField emailField;
    @javafx.fxml.FXML
    private TableColumn <Client,String> clientNameColumn;
    @javafx.fxml.FXML
    private TableColumn <Client,String> contactPersonColumn;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private ComboBox <String> statusComboBox;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private Button addClientButton;
    @javafx.fxml.FXML
    private TableColumn <Client,String> statusColumn;
    @javafx.fxml.FXML
    private TextArea addressArea;
    @javafx.fxml.FXML
    private TableColumn <Client,String> phoneNumberColumn;
    @javafx.fxml.FXML
    private TextField clientIdField;
    @javafx.fxml.FXML
    private TableColumn <Client,String> emailColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addClient(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchClient(ActionEvent actionEvent) {
    }
}