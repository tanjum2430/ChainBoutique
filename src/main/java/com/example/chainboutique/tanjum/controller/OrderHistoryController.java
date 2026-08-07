package com.example.chainboutique.tanjum.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import com.example.chainboutique.tanjum.Order;
import com.example.chainboutique.tanjum.SharedData;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;


import java.util.Objects;

public class OrderHistoryController
{
    private static final String ORDER_FILE = "orders.bin";

    @javafx.fxml.FXML
    private Label orderHistoryLabel;
    @javafx.fxml.FXML
    private Label orderDetailsLabel;
    @javafx.fxml.FXML
    private TextArea orderDetailsTextArea;
    @javafx.fxml.FXML
    private TableColumn<Order,Double> totalAmountCol;
    @javafx.fxml.FXML
    private TableColumn<Order,String> statusCol;
    @javafx.fxml.FXML
    private TableView<Order> orderHistoryTableView;
    @javafx.fxml.FXML
    private TableColumn<Order,LocalDate> orderDateCol;
    @javafx.fxml.FXML
    private Label deliveryAddressLabel;
    @javafx.fxml.FXML
    private TextArea deliveryAddressTextArea;
    @javafx.fxml.FXML
    private TableColumn<Order, Integer> orderIdCol;
    @javafx.fxml.FXML
    private Button btnBack;
    @javafx.fxml.FXML
    private Button btnViewDetails;
    @javafx.fxml.FXML
    private Button btnCancelOrder;

    @javafx.fxml.FXML
    public void initialize() {
        orderIdCol.setCellValueFactory(
                new PropertyValueFactory<>("orderId")
        );

        orderDateCol.setCellValueFactory(
                new PropertyValueFactory<>("orderDate")
        );

        totalAmountCol.setCellValueFactory(
                new PropertyValueFactory<>("totalAmount")
        );

        statusCol.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );

        try {

            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(ORDER_FILE)
            );

            ArrayList<Order> orders =
                    (ArrayList<Order>) ois.readObject();

            ois.close();

            SharedData.orders.setAll(orders);

        } catch (IOException | ClassNotFoundException e) {
            // If no file exists yet, keep the list empty.
        }

        orderHistoryTableView.setItems(SharedData.orders);



    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/customerDashboard.fxml"
                        )
                )
        );

        Stage stage = (Stage) orderHistoryTableView.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


    @javafx.fxml.FXML
    public void handleViewDetailsButton(ActionEvent actionEvent) {
        Order selectedOrder =
                orderHistoryTableView.getSelectionModel().getSelectedItem();

        if (selectedOrder == null) {
            orderDetailsTextArea.setText("Please select an order.");
            return;
        }

        orderDetailsTextArea.setText(
                "Order ID: " + selectedOrder.getOrderId()
                        + "\nOrder Date: " + selectedOrder.getOrderDate()
                        + "\nStatus: " + selectedOrder.getStatus()
                        + "\nTotal Amount: " + selectedOrder.getTotalAmount()
        );

        deliveryAddressTextArea.setText(
                selectedOrder.getDeliveryAddress()
        );
    }

    @javafx.fxml.FXML
    public void handleCancelOrderButton(ActionEvent actionEvent) {
        Order selectedOrder =
                orderHistoryTableView.getSelectionModel().getSelectedItem();

        if (selectedOrder == null) {
            orderDetailsTextArea.setText("Please select an order.");
            return;
        }

        if (selectedOrder.cancelOrder()) {

            orderHistoryTableView.refresh();

            orderDetailsTextArea.setText(
                    "Order " + selectedOrder.getOrderId() + " cancelled successfully."
            );

        } else {

            orderDetailsTextArea.setText(
                    "This order cannot be cancelled."
            );
        }
    }
}