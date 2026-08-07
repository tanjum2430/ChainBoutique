package com.example.chainboutique.tanjum.controller;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.example.chainboutique.tanjum.Cashier;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CashierLoginController
{
    @javafx.fxml.FXML
    private Label cashierIDLabel;
    @javafx.fxml.FXML
    private Label writeMessageLabel;
    @javafx.fxml.FXML
    private PasswordField pfPassword;
    @javafx.fxml.FXML
    private TextField cashierIDTextField;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private Label passwordLabel;

    @javafx.fxml.FXML
    private Button btnBack;
    @javafx.fxml.FXML
    private Button btnLogin;
    @javafx.fxml.FXML
    private Button btnClear;
    @javafx.fxml.FXML
    private Button btnExit;

    private final Cashier cashier =
            new Cashier(2001, "Cashier", "1234");

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/main.fxml"
                        )
                )
        );

        Stage stage = (Stage) cashierIDTextField.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {

        cashierIDTextField.clear();
        pfPassword.clear();
        messageLabel.setText("");
    }

    @javafx.fxml.FXML
    public void handleLoginButton(ActionEvent actionEvent) throws IOException{

        String idText = cashierIDTextField.getText();
        String password = pfPassword.getText();

        if (idText.isEmpty() || password.isEmpty()) {
            messageLabel.setText("Please enter Cashier ID and password.");
            return;
        }

        int cashierId = Integer.parseInt(idText);

        if (cashierId == cashier.getCashierID()
                && cashier.login(password)) {

            Parent root = FXMLLoader.load(
                    Objects.requireNonNull(
                            getClass().getResource(
                                    "/com/example/chainboutique/tanjum/cashierDashboard.fxml"
                            )
                    )
            );

            Stage stage = (Stage) cashierIDTextField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } else {

            messageLabel.setText("Invalid Cashier ID or password.");
        }
    }

    @javafx.fxml.FXML
    public void handleExitButton(ActionEvent actionEvent) {

        Stage stage = (Stage) cashierIDTextField.getScene().getWindow();
        stage.close();
    }
}