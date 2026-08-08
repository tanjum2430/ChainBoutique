package com.example.chainboutique.adib.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CEOLoginController {

    @FXML
    private TextField userIdField;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    private final String CEO_ID = "1234";
    private final String CEO_PASSWORD = "ceo123";

    @FXML
    public void initialize() {
    }

    @FXML
    public void handleLogin(ActionEvent actionEvent) throws IOException {

        String userID = userIdField.getText();
        String password = passwordField.getText();

        if (userID.isEmpty() || password.isEmpty()) {
            System.out.println("Please enter CEO ID and password.");
            return;
        }

        if (userID.equals(CEO_ID) && password.equals(CEO_PASSWORD)) {

            Parent root = FXMLLoader.load(
                    Objects.requireNonNull(
                            getClass().getResource(
                                    "/com/example/chainboutique/adib/CEO.fxml"
                            )
                    )
            );

            Stage stage = (Stage) userIdField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } else {

            System.out.println("Invalid CEO ID or password.");
        }
    }
}