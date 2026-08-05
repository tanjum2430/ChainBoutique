package com.example.chainboutique.tanjum.controller;

import com.example.chainboutique.tanjum.CartItem;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import com.example.chainboutique.tanjum.Cart;
import com.example.chainboutique.tanjum.SharedData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
import javafx.beans.property.ReadOnlyStringWrapper;
import com.example.chainboutique.tanjum.Order;
import java.time.LocalDate;


public class PlaceOrderController
{
    @javafx.fxml.FXML
    private TableView<CartItem> orderSummaryTableView;
    @javafx.fxml.FXML
    private Label paymentMethodLabel;
    @javafx.fxml.FXML
    private Label totalAmountLabel;
    @javafx.fxml.FXML
    private TextField phoneTextField;
    @javafx.fxml.FXML
    private TextField customerNameTextField;
    @javafx.fxml.FXML
    private Label deliveryAddressLabel;
    @javafx.fxml.FXML
    private TableColumn<CartItem,Double> subtotalCol;
    @javafx.fxml.FXML
    private Label checkoutPlaceOrderLabel;
    @javafx.fxml.FXML
    private TextField deliveryAddressTextField;
    @javafx.fxml.FXML
    private TableColumn<CartItem,String> productCol;
    @javafx.fxml.FXML
    private TextField totalAmountTextField;
    @javafx.fxml.FXML
    private TextField orderStatusTextField;
    @javafx.fxml.FXML
    private Label orderStatusLabel;
    @javafx.fxml.FXML
    private TableColumn<CartItem,Double> unitPriceCol;
    @javafx.fxml.FXML
    private Label phoneLabel;
    @javafx.fxml.FXML
    private TableColumn<CartItem,Integer> quantityCol;
    @javafx.fxml.FXML
    private ComboBox<String> paymentMethodComboBox;
    @javafx.fxml.FXML
    private Label customerNameLabel;
    @javafx.fxml.FXML
    private Button btnCancelOrder;
    @javafx.fxml.FXML
    private Button btnBackToCart;
    @javafx.fxml.FXML
    private Button btnConfirmOrder;

    private final Cart cart = SharedData.cart;

    private final ObservableList<CartItem> orderList =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        paymentMethodComboBox.getItems().addAll(
                "Cash",
                "Card",
                "bKash",
                "Nagad"
        );

        productCol.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(
                        cellData.getValue().getProduct().getProductName()
                )
        );

        quantityCol.setCellValueFactory(
                new PropertyValueFactory<>("quantity")
        );

        unitPriceCol.setCellValueFactory(cellData ->
                new ReadOnlyObjectWrapper<>(
                        cellData.getValue().getProduct().getPrice()
                )
        );

        subtotalCol.setCellValueFactory(
                new PropertyValueFactory<>("subTotal")
        );

        orderList.setAll(cart.getCartItems());
        orderSummaryTableView.setItems(orderList);

        totalAmountTextField.setText(
                String.valueOf(cart.calculateTotal())
        );

        orderStatusTextField.setText("Pending");
    }

    @javafx.fxml.FXML
    public void handleConfirmOrderButton(ActionEvent actionEvent) {

        String customerName = customerNameTextField.getText();
        String phone = phoneTextField.getText();
        String deliveryAddress = deliveryAddressTextField.getText();
        String paymentMethod = paymentMethodComboBox.getValue();

        if (customerName.isEmpty()
                || phone.isEmpty()
                || deliveryAddress.isEmpty()
                || paymentMethod == null) {

            orderStatusTextField.setText("Please complete all fields.");
            return;
        }

        if (cart.getCartItems().isEmpty()) {
            orderStatusTextField.setText("Your cart is empty.");
            return;
        }

        int orderId = (int) (Math.random() * 9000) + 1000;

        Order order = new Order(
                orderId,
                LocalDate.now(),
                "Placed",
                deliveryAddress,
                cart.calculateTotal()
        );

        SharedData.orders.add(order);

        orderStatusTextField.setText( "Order Confirmed! Order ID: " + orderId);
    }

    @javafx.fxml.FXML
    public void handleCancelOrderButton(ActionEvent actionEvent) {

        orderStatusTextField.setText("Cancelled");
        paymentMethodComboBox.setValue(null);
        deliveryAddressTextField.clear();
    }

    @javafx.fxml.FXML
    public void handleBackToCartButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/cart.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnBackToCart.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}