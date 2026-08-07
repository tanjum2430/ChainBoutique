package com.example.chainboutique.tanjum.controller;

import javafx.scene.control.*;
import javafx.event.ActionEvent;
import com.example.chainboutique.tanjum.Payment;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.chainboutique.tanjum.SharedData;
import com.example.chainboutique.tanjum.SalesBill;

import java.io.IOException;
import java.util.Objects;

public class ReceivePaymentController
{
    @javafx.fxml.FXML
    private Label transactionIdLabel;
    @javafx.fxml.FXML
    private Button btnBack;
    @javafx.fxml.FXML
    private Label paidAmountLabel;
    @javafx.fxml.FXML
    private Label billIDLabel;
    @javafx.fxml.FXML
    private TextField transactionIdTextField;
    @javafx.fxml.FXML
    private TextField finalAmountTextField;
    @javafx.fxml.FXML
    private TextField customerNameTextField;
    @javafx.fxml.FXML
    private TextArea paymentDeatilsTextArea;
    @javafx.fxml.FXML
    private Label paymentStatusLabel;
    @javafx.fxml.FXML
    private Label finalAmountLabel;
    @javafx.fxml.FXML
    private TextField paymentStatusTextField;
    @javafx.fxml.FXML
    private Label paymentDetailsLabel;
    @javafx.fxml.FXML
    private TextField billIDTextField;
    @javafx.fxml.FXML
    private TextField paidAmountTextField;
    @javafx.fxml.FXML
    private Button btnVerify;
    @javafx.fxml.FXML
    private ComboBox<String> paymentMethodComboBox;
    @javafx.fxml.FXML
    private Button btnReceive;
    @javafx.fxml.FXML
    private Label customerNameLabel;
    @javafx.fxml.FXML
    private Button btnInvoice;
    @javafx.fxml.FXML
    private Label receivePaymentLabel;

    private Payment currentPayment;

    @javafx.fxml.FXML
    public void initialize() {
        paymentMethodComboBox.getItems().addAll(
                "Cash",
                "Card",
                "bKash",
                "Nagad"
        );

        paymentStatusTextField.setText("Pending");
    }

    @javafx.fxml.FXML
    public void receivePaymentOnAction(ActionEvent actionEvent) {

        String method = paymentMethodComboBox.getValue();
        String amountText = paidAmountTextField.getText();

        if (method == null || amountText.isEmpty()) {
            paymentDeatilsTextArea.setText(
                    "Please select payment method and enter paid amount."
            );
            return;
        }

        double amount = Double.parseDouble(amountText);

        int paymentID = (int) (Math.random() * 9000) + 1000;

        currentPayment = new Payment(
                paymentID,
                method,
                "Pending",
                "",
                amount
        );

        currentPayment.makePayment(method, amount);

        if (!SharedData.salesBills.isEmpty()) {
            SalesBill latestBill =
                    SharedData.salesBills.get(
                            SharedData.salesBills.size() - 1
                    );

            latestBill.setPaymentMethod(method);
        }

        paymentStatusTextField.setText(
                currentPayment.getPaymentStatus()
        );

        transactionIdTextField.setText(
                currentPayment.getTransactionId()
        );
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/applyDiscount.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void verifyPaymentOnAction(ActionEvent actionEvent) {

        if (currentPayment == null) {
            paymentDeatilsTextArea.setText(
                    "No payment has been received yet."
            );
            return;
        }

        if (currentPayment.verifyPayment()) {

            paymentStatusTextField.setText("Paid");

            paymentDeatilsTextArea.setText(
                    "Payment verified successfully."
            );

        } else {

            paymentStatusTextField.setText("Pending");

            paymentDeatilsTextArea.setText(
                    "Payment verification failed."
            );
        }
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

        Stage stage = (Stage) btnInvoice.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}