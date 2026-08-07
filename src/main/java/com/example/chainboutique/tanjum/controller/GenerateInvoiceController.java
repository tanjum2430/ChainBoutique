package com.example.chainboutique.tanjum.controller;

import javafx.scene.control.*;
import javafx.event.ActionEvent;
import com.example.chainboutique.tanjum.CartItem;
import com.example.chainboutique.tanjum.Cart;
import com.example.chainboutique.tanjum.SharedData;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import com.example.chainboutique.tanjum.Invoice;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import java.time.LocalDate;

public class GenerateInvoiceController
{
    @javafx.fxml.FXML
    private TextField invoiceIdTextField;
    @javafx.fxml.FXML
    private Label paymentMethodLabel;
    @javafx.fxml.FXML
    private Label purchasedProductsLabel;
    @javafx.fxml.FXML
    private Label invoiceIdLabel;
    @javafx.fxml.FXML
    private TextField discountTextField;
    @javafx.fxml.FXML
    private TableColumn<CartItem, Double> subtotalCol;
    @javafx.fxml.FXML
    private Label invoiceInfoLabel;
    @javafx.fxml.FXML
    private TableColumn<CartItem,Double> unitPriceCol;
    @javafx.fxml.FXML
    private Label customerNameLabel;
    @javafx.fxml.FXML
    private Label vatLabel;
    @javafx.fxml.FXML
    private TextField vatTextField;
    @javafx.fxml.FXML
    private Button btnBack;
    @javafx.fxml.FXML
    private TextField grandTotalTextField;
    @javafx.fxml.FXML
    private TextField customerNameTextField;
    @javafx.fxml.FXML
    private Label subtotalLabel;
    @javafx.fxml.FXML
    private TableColumn<CartItem,String> productCol;
    @javafx.fxml.FXML
    private DatePicker invoiceDatePicker;
    @javafx.fxml.FXML
    private Label grandTotalLabel;
    @javafx.fxml.FXML
    private Label discountLabel;
    @javafx.fxml.FXML
    private Button btnGenerateInvoice;
    @javafx.fxml.FXML
    private TextField subtotalTextField;
    @javafx.fxml.FXML
    private Button btnReturn;
    @javafx.fxml.FXML
    private TableColumn<CartItem,Integer> quantityCol;
    @javafx.fxml.FXML
    private Button btnPrintInvoice;
    @javafx.fxml.FXML
    private TextField paymentMethodTextField;
    @javafx.fxml.FXML
    private TableView<CartItem> invoiceTableView;
    private final Cart cart = SharedData.cart;

    private final ObservableList<CartItem> invoiceItems =
            FXCollections.observableArrayList();

    private Invoice currentInvoice;

    @javafx.fxml.FXML
    public void initialize() {
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

        invoiceItems.setAll(cart.getCartItems());
        invoiceTableView.setItems(invoiceItems);

        invoiceDatePicker.setValue(LocalDate.now());

        subtotalTextField.setText(
                String.valueOf(cart.calculateTotal())
        );
    }

    @javafx.fxml.FXML
    public void printInvoiceOnAction(ActionEvent actionEvent) {

        if (currentInvoice == null) {
            grandTotalTextField.setText("Generate invoice first.");
            return;
        }

        currentInvoice.printInvoice();
    }

    @javafx.fxml.FXML
    public void returnOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/returnExchange.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnReturn.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/receivePayment.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void generateInvoiceOnAction(ActionEvent actionEvent) {

        int invoiceId = (int) (Math.random() * 9000) + 1000;

        double totalAmount = cart.calculateTotal();

        currentInvoice = new Invoice(
                invoiceId,
                LocalDate.now(),
                totalAmount
        );

        SharedData.invoices.add(currentInvoice);

        currentInvoice.generateInvoice();

        invoiceIdTextField.setText(
                String.valueOf(currentInvoice.getInvoiceId())
        );

        invoiceDatePicker.setValue(
                currentInvoice.getDate()
        );

        grandTotalTextField.setText(
                String.valueOf(currentInvoice.getTotalAmount())
        );
    }
}