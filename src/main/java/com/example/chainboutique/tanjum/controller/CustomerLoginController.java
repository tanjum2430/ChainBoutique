package com.example.chainboutique.tanjum.controller;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import com.example.chainboutique.tanjum.Customer;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class CustomerLoginController
{

    private static final String CUSTOMER_FILE = "customer.bin";


    @javafx.fxml.FXML
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private Label customerLoginLabel;
    @javafx.fxml.FXML
    private Label emailLabel;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private Label passwordLabel;
    @javafx.fxml.FXML
    private Button btnLogin;
    @javafx.fxml.FXML
    private Button btnClear;
    @javafx.fxml.FXML
    private Button btnRegister;
    @javafx.fxml.FXML
    private Button btnExit;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {
        emailTextField.clear();
        passwordTextField.clear();
        messageLabel.setText("");
    }

    @javafx.fxml.FXML
    public void handleRegisterButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(getClass().getResource("/com/example/chainboutique/tanjum/customerRegistration.fxml"))
        );

        Stage stage = (Stage) emailTextField.getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void handleLoginButton(ActionEvent actionEvent) {

        String email = emailTextField.getText();
        String password = passwordTextField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            messageLabel.setText("Please enter email and password.");
            return;
        }

        try {

            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(CUSTOMER_FILE)
            );

            ArrayList<Customer> customers =
                    (ArrayList<Customer>) ois.readObject();
            ois.close();

            Customer customer = null;

            for (Customer c : customers) {
                if (c.login(email, password)) {
                    customer = c;
                    break;
                }
            }

            if (customer != null) {

                Parent root = FXMLLoader.load(
                        Objects.requireNonNull(
                                getClass().getResource(
                                        "/com/example/chainboutique/tanjum/customerDashboard.fxml"
                                )
                        )
                );

                Stage stage = (Stage) emailTextField.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

            } else {
                messageLabel.setText("Invalid email or password.");
            }

        } catch (IOException | ClassNotFoundException e) {
            messageLabel.setText("No registered customer found.");
        }
    }

    @javafx.fxml.FXML
    public void handleExitButton(ActionEvent actionEvent) {
        Stage stage = (Stage) emailTextField.getScene().getWindow();
        stage.close();
    }
}