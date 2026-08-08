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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.io.IOException;
import java.util.Objects;

public class CashierLoginController
{

    private static final String CASHIER_FILE = "cashiers.bin";

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

    private final ArrayList<Cashier> cashiers =
            new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        File file = new File(CASHIER_FILE);

        if (file.exists() && file.length() > 0) {

            try {

                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream(CASHIER_FILE)
                );

                ArrayList<Cashier> savedCashiers =
                        (ArrayList<Cashier>) ois.readObject();

                ois.close();

                cashiers.clear();
                cashiers.addAll(savedCashiers);

            } catch (IOException | ClassNotFoundException e) {

                messageLabel.setText("Error loading cashier data.");
            }

        } else {

            cashiers.add(
                    new Cashier(2001, "Nora", "1234")
            );

            cashiers.add(
                    new Cashier(2002, "Reedwan", "5678")
            );

            cashiers.add(
                    new Cashier(2003, "Ahnaf", "91011")
            );

            try {

                ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream(CASHIER_FILE)
                );

                oos.writeObject(cashiers);
                oos.close();

            } catch (IOException e) {

                messageLabel.setText("Error creating cashier file.");
            }
        }
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

        Cashier matchedCashier = null;

        for (Cashier c : cashiers) {

            if (c.getCashierID() == cashierId
                    && c.login(password)) {

                matchedCashier = c;
                break;
            }
        }

        if (matchedCashier != null) {

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