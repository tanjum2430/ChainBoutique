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
import javafx.beans.property.ReadOnlyStringWrapper;

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
    }

    @javafx.fxml.FXML
    public void handleConfirmOrderButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleCancelOrderButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBackToCartButton(ActionEvent actionEvent) {
    }
}