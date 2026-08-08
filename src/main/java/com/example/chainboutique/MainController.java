package com.example.chainboutique;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainController
{
    @javafx.fxml.FXML
    private Button btnCEO;
    @javafx.fxml.FXML
    private Label welcomeLabel;
    @javafx.fxml.FXML
    private Label titleLabel;
    @javafx.fxml.FXML
    private Button btnCashier;
    @javafx.fxml.FXML
    private Button btnInventoryOfficer;
    @javafx.fxml.FXML
    private Button btnCustomer;
    @javafx.fxml.FXML
    private Button btnExit;
    @javafx.fxml.FXML
    private Label footerLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void inventoryOfficerOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void cashierOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/cashierLogin.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnCashier.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void ceoOnAction(ActionEvent actionEvent)  throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/adib/CEOLogin.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnCEO.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }

    @javafx.fxml.FXML
    public void exitOnAction(ActionEvent actionEvent) {

        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    @javafx.fxml.FXML
    public void customerOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/customerLogin.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnCustomer.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}