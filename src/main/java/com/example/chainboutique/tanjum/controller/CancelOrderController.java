package com.example.chainboutique.tanjum.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.example.chainboutique.tanjum.Order;
import com.example.chainboutique.tanjum.SharedData;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CancelOrderController
{
    @javafx.fxml.FXML
    private TextArea reasonForCancellationTextArea;
    @javafx.fxml.FXML
    private Label reasonForCancellationLabel;
    @javafx.fxml.FXML
    private TextField orderDateTextField;
    @javafx.fxml.FXML
    private TextField orderIdTextField;
    @javafx.fxml.FXML
    private Label orderIdLabel;
    @javafx.fxml.FXML
    private Label orderDateLabel;
    @javafx.fxml.FXML
    private Label cancelOrderLabel;
    @javafx.fxml.FXML
    private TextField orderStatusTextField;
    @javafx.fxml.FXML
    private Label orderStatusLabel;
    @javafx.fxml.FXML
    private Button btnConfirmCancellation;
    @javafx.fxml.FXML
    private Button btnBack;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/orderHistory.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void handleConfirmCancellationButton(ActionEvent actionEvent) {

        String orderIdText = orderIdTextField.getText();

        if (orderIdText.isEmpty()) {
            orderStatusTextField.setText("Enter Order ID.");
            return;
        }

        int orderId = Integer.parseInt(orderIdText);

        Order foundOrder = null;

        for (Order order : SharedData.orders) {
            if (order.getOrderId() == orderId) {
                foundOrder = order;
                break;
            }
        }

        if (foundOrder == null) {
            orderStatusTextField.setText("Order not found.");
            return;
        }

        if (foundOrder.cancelOrder()) {

            orderDateTextField.setText(
                    foundOrder.getOrderDate().toString()
            );

            orderStatusTextField.setText("Order Cancelled");

        } else {

            orderStatusTextField.setText(
                    "This order cannot be cancelled."
            );
        }
    }
}