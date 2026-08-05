package com.example.chainboutique.tanjum.controller;

import com.example.chainboutique.tanjum.CartItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import com.example.chainboutique.tanjum.Cart;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


public class CartController
{
    @javafx.fxml.FXML
    private TableColumn<CartItem,String> sizeCol;
    @javafx.fxml.FXML
    private Label totalAmountLabel;
    @javafx.fxml.FXML
    private TableColumn<CartItem,Double> subtotalCol;
    @javafx.fxml.FXML
    private Label cartSummaryLabel;
    @javafx.fxml.FXML
    private TableColumn<CartItem,Integer> productIdCol;
    @javafx.fxml.FXML
    private TextField totalAmountTextField;
    @javafx.fxml.FXML
    private TableColumn<CartItem,String> productNameCol;
    @javafx.fxml.FXML
    private Label myShoppingCartLabel;
    @javafx.fxml.FXML
    private TableColumn<CartItem,Double> unitPriceCol;
    @javafx.fxml.FXML
    private TableView<CartItem> myShoppingCartTableView;
    @javafx.fxml.FXML
    private Label discountLabel;
    @javafx.fxml.FXML
    private TableColumn<CartItem,Integer> quantityCol;
    @javafx.fxml.FXML
    private TextField DiscountCodeTextField;
    @javafx.fxml.FXML
    private Button btnApplyDiscount;
    @javafx.fxml.FXML
    private Button btnRemoveItem;
    @javafx.fxml.FXML
    private Button btnCheckOut;
    @javafx.fxml.FXML
    private Button btnCartClear;
    @javafx.fxml.FXML
    private Button btnContinueShopping;

    private final ObservableList<CartItem> cartItemList =
            FXCollections.observableArrayList();
    private Cart cart = new Cart(1, 0);

    @javafx.fxml.FXML
    public void initialize() {

        sizeCol.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(
                        cellData.getValue().getProduct().getSize()
                )
        );

        unitPriceCol.setCellValueFactory(cellData ->
                new ReadOnlyObjectWrapper<>(
                        cellData.getValue().getProduct().getPrice()
                )
        );



        productIdCol.setCellValueFactory(cellData ->
                new ReadOnlyObjectWrapper<>(
                        cellData.getValue().getProduct().getProductId()
                )
        );

        productNameCol.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(
                        cellData.getValue().getProduct().getProductName()
                )
        );

        quantityCol.setCellValueFactory(
                new PropertyValueFactory<>("quantity")
        );

        subtotalCol.setCellValueFactory(
                new PropertyValueFactory<>("subTotal")
        );

        myShoppingCartTableView.setItems(cartItemList);

        cartItemList.setAll(cart.getCartItems());
        myShoppingCartTableView.setItems(cartItemList);

        totalAmountTextField.setText(
                String.valueOf(cart.calculateTotal())
        );

    }

    @javafx.fxml.FXML
    public void handleApplyDiscountButton(ActionEvent actionEvent) {

        String discountCode = DiscountCodeTextField.getText();

        if (discountCode.isEmpty()) {
            discountLabel.setText("Enter a discount code.");
            return;
        }

        if (discountCode.equalsIgnoreCase("SAVE10")) {

            double total = cart.calculateTotal();
            double discountedTotal = total - (total * 0.10);
            cart.setTotalPrice(discountedTotal);

            totalAmountTextField.setText(
                    String.valueOf(discountedTotal)
            );

            discountLabel.setText("10% discount applied.");

        } else {
            discountLabel.setText("Invalid discount code.");
        }
    }

    @javafx.fxml.FXML
    public void handleCheckoutButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/placeOrder.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnCheckOut.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void handleContinueShoppingButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/customerDashboard.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnContinueShopping.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void handleClearCartButton(ActionEvent actionEvent) {

        cart.getCartItems().clear();
        cart.clearCart();

        cartItemList.clear();

        totalAmountTextField.setText("0.0");
        totalAmountLabel.setText("Cart cleared.");
    }

    @javafx.fxml.FXML
    public void handleRemoveItemButton(ActionEvent actionEvent) {

        CartItem selectedItem =
                myShoppingCartTableView.getSelectionModel().getSelectedItem();

        if (selectedItem == null) {
            totalAmountLabel.setText("Please select an item.");
            return;
        }

        cart.getCartItems().remove(selectedItem);

        cart.setTotalPrice(
                cart.getTotalPrice() - selectedItem.getSubTotal()
        );

        cartItemList.setAll(cart.getCartItems());

        totalAmountTextField.setText(
                String.valueOf(cart.calculateTotal())
        );
    }
}