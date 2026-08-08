package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.Client;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private ObservableList<Client> clientList =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {


        clientIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("clientID"));

        clientNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("clientName"));

        contactPersonColumn.setCellValueFactory(
                new PropertyValueFactory<>("contactPerson"));

        emailColumn.setCellValueFactory(
                new PropertyValueFactory<>("email"));

        phoneNumberColumn.setCellValueFactory(
                new PropertyValueFactory<>("phoneNo"));

        addressColumn.setCellValueFactory(
                new PropertyValueFactory<>("address"));

        statusColumn.setCellValueFactory(
                new PropertyValueFactory<>("status"));

        statusComboBox.getItems().addAll(
                "Active",
                "Inactive"
        );

        clientTable.setItems(clientList);
    }

    @javafx.fxml.FXML
    public void addClient(ActionEvent actionEvent) {


        String clientID = clientIdField.getText();
        String clientName = clientNameField.getText();
        String contactPerson = contactPersonField.getText();
        String email = emailField.getText();
        String phoneNo = phoneNumberField.getText();
        String address = addressArea.getText();
        String status = statusComboBox.getValue();

        Client client = new Client(
                clientID,
                clientName,
                contactPerson,
                email,
                phoneNo,
                address,
                status
        );

        clientList.add(client);

        clearFields(null);
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
        clientTable.refresh();

    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {

        clientIdField.clear();
        clientNameField.clear();
        contactPersonField.clear();
        emailField.clear();
        phoneNumberField.clear();
        addressArea.clear();

        statusComboBox.setValue(null);
        searchField.clear();
    }

    @javafx.fxml.FXML
    public void searchClient(ActionEvent actionEvent) {


        String searchText = searchField.getText().toLowerCase();

        if (searchText.isEmpty()) {
            clientTable.setItems(clientList);
            return;
        }

        ObservableList<Client> searchResults =
                FXCollections.observableArrayList();

        for (Client client : clientList) {

            if (client.getClientID().toLowerCase().contains(searchText)
                    || client.getClientName().toLowerCase().contains(searchText)
                    || client.getContactPerson().toLowerCase().contains(searchText)
                    || client.getEmail().toLowerCase().contains(searchText)
                    || client.getPhoneNo().toLowerCase().contains(searchText)
                    || client.getAddress().toLowerCase().contains(searchText)
                    || client.getStatus().toLowerCase().contains(searchText)) {

                searchResults.add(client);
            }
        }

        clientTable.setItems(searchResults);
    }
}