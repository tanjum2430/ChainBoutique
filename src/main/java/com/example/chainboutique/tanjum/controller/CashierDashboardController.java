package com.example.chainboutique.tanjum.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CashierDashboardController
{
    @javafx.fxml.FXML
    private Button btnCreateSalesBill;
    @javafx.fxml.FXML
    private Button btnApplyDiscount;
    @javafx.fxml.FXML
    private Button btnGenerateInvoice;
    @javafx.fxml.FXML
    private Button btnLogout;
    @javafx.fxml.FXML
    private Button btnReturnExchange;
    @javafx.fxml.FXML
    private Button btnReceivePayment;
    @javafx.fxml.FXML
    private Button btnSearchCustomer;
    @javafx.fxml.FXML
    private Button btnDailySalesSummary;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void receivePaymentOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/receivePayment.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnReceivePayment.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
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

        Stage stage = (Stage) btnLogout.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void dailySalesSummaryOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/dailySalesSummary.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnDailySalesSummary.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void generateInvoiceOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/generateInvoice.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnGenerateInvoice.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void searchCustomerOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/searchCustomer.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnSearchCustomer.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void applyDiscountOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/applyDiscount.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnApplyDiscount.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void createSalesBillOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/createSalesBill.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnCreateSalesBill.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void returnExchangeOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/returnExchange.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnReturnExchange.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}