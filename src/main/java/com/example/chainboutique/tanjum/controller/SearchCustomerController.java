package com.example.chainboutique.tanjum.controller;

import com.example.chainboutique.tanjum.Customer;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.chainboutique.tanjum.SharedData;
import java.util.ArrayList;
import java.util.Objects;


public class SearchCustomerController
{
    private static final String CUSTOMER_FILE = "customer.bin";
    @javafx.fxml.FXML
    private TextField enterCustomerIdTextField;
    @javafx.fxml.FXML
    private Label customerdeatilsLabel;
    @javafx.fxml.FXML
    private TextArea customerDetailsTextArea;
    @javafx.fxml.FXML
    private Label customerIdLabel;
    @javafx.fxml.FXML
    private TableColumn<Customer,String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<Customer,String> phoneNumberCol;
    @javafx.fxml.FXML
    private TableColumn<Customer,String> emailCol;
    @javafx.fxml.FXML
    private TextField enterCustomerNameTextField;
    @javafx.fxml.FXML
    private TableView<Customer> searchCustomerTableView;
    @javafx.fxml.FXML
    private TableColumn<Customer,Integer> customerIdCol;
    @javafx.fxml.FXML
    private Label customerNameLabel;
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private Button logoutButton;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private Button backButton;
    @javafx.fxml.FXML
    private Button selectButton;

    @javafx.fxml.FXML
    public void initialize() {
        customerIdCol.setCellValueFactory(
                new PropertyValueFactory<>("customerId")
        );

        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );

        phoneNumberCol.setCellValueFactory(
                new PropertyValueFactory<>("phoneNo")
        );

        emailCol.setCellValueFactory(
                new PropertyValueFactory<>("email")
        );
    }

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {

        enterCustomerIdTextField.clear();
        enterCustomerNameTextField.clear();
        customerDetailsTextArea.clear();

        searchCustomerTableView.getItems().clear();
    }

    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {

        String idText = enterCustomerIdTextField.getText();
        String nameText = enterCustomerNameTextField.getText();

        try {

            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(CUSTOMER_FILE)
            );

            ArrayList<Customer> customers = (ArrayList<Customer>) ois.readObject();

            ois.close();

            searchCustomerTableView.getItems().clear();

            for (Customer customer : customers) {

                boolean idMatches =
                        idText.isEmpty()
                                || customer.getCustomerId() == Integer.parseInt(idText);

                boolean nameMatches =
                        nameText.isEmpty()
                                || customer.getName()
                                .toLowerCase()
                                .contains(nameText.toLowerCase());

                if (idMatches && nameMatches) {
                    searchCustomerTableView.getItems().add(customer);
                }
            }

            if (searchCustomerTableView.getItems().isEmpty()) {

                customerDetailsTextArea.setText("Customer not found.");

            } else {

                customerDetailsTextArea.setText(
                        searchCustomerTableView.getItems().size()
                                + " customer(s) found."
                );
            }

        } catch (IOException | ClassNotFoundException e) {

            customerDetailsTextArea.setText(
                    "No registered customer found."
            );
        }
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/cashierDashboard.fxml"
                        )
                )
        );

        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void selectCustomerOnAction(ActionEvent actionEvent) {

        Customer selectedCustomer =
                searchCustomerTableView.getSelectionModel().getSelectedItem();

        if (selectedCustomer == null) {
            customerDetailsTextArea.setText("Please select a customer.");
            return;
        }

        SharedData.selectedCustomer = selectedCustomer;

        customerDetailsTextArea.setText(
                "Customer selected: " + selectedCustomer.getName()
        );
    }

    @javafx.fxml.FXML
    public void logoutOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/cashierLogin.fxml"
                        )
                )
        );

        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}