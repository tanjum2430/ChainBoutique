package com.example.chainboutique.tanjum.controller;

import com.example.chainboutique.tanjum.Product;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.chainboutique.tanjum.SharedData;
import java.io.IOException;
import java.util.Objects;
import com.example.chainboutique.tanjum.Invoice;
import com.example.chainboutique.tanjum.ReturnRequest;
import java.time.LocalDate;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class ReturnExchangeController
{
    private static final String INVOICE_FILE = "invoices.bin";

    @javafx.fxml.FXML
    private Button btnBack;
    @javafx.fxml.FXML
    private TextField invoiceIdTextField;
    @javafx.fxml.FXML
    private TextField customerIdTextField;
    @javafx.fxml.FXML
    private TextField customerNameTextField;
    @javafx.fxml.FXML
    private Button btnNext;
    @javafx.fxml.FXML
    private Label invoiceIdLabel;
    @javafx.fxml.FXML
    private Button btnClear;
    @javafx.fxml.FXML
    private TableColumn<Product,Integer> productIdCol;
    @javafx.fxml.FXML
    private TableColumn<Product,String> productNameCol;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private Label returnQuantityLabel;
    @javafx.fxml.FXML
    private Label actionLabel;
    @javafx.fxml.FXML
    private ComboBox<String> actionComboBox;
    @javafx.fxml.FXML
    private TableColumn<Product, Double> unitPriceCol;
    @javafx.fxml.FXML
    private Button btnSearchInvoice;
    @javafx.fxml.FXML
    private Label customerIdLabel;
    @javafx.fxml.FXML
    private TextField statusTextField;
    @javafx.fxml.FXML
    private Button btnProcessReturn;
    @javafx.fxml.FXML
    private TableColumn<Product,Integer> quantityCol;
    @javafx.fxml.FXML
    private Label returnTitleLabel;
    @javafx.fxml.FXML
    private Label customerNameLabel;
    @javafx.fxml.FXML
    private TextField returnQuantityTextField;
    @javafx.fxml.FXML
    private TextArea reasonTextArea;
    @javafx.fxml.FXML
    private TableView<Product> purchasedItemTableView;

    @javafx.fxml.FXML
    public void initialize() {
        actionComboBox.getItems().addAll(
                "Return",
                "Exchange"
        );

        statusTextField.setText("Pending");
    }

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {

        invoiceIdTextField.clear();
        customerIdTextField.clear();
        customerNameTextField.clear();
        returnQuantityTextField.clear();
        reasonTextArea.clear();

        actionComboBox.setValue(null);
        statusTextField.setText("Pending");

        purchasedItemTableView.getItems().clear();
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/generateInvoice.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void nextOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/dailySalesSummary.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnNext.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void processReturnOnAction(ActionEvent actionEvent) {

        String invoiceIdText = invoiceIdTextField.getText();
        String reason = reasonTextArea.getText();
        String returnType = actionComboBox.getValue();

        Product selectedProduct =
                purchasedItemTableView.getSelectionModel().getSelectedItem();

        if (invoiceIdText.isEmpty()
                || reason.isEmpty()
                || returnType == null
                || selectedProduct == null) {

            statusTextField.setText("Please complete all required fields.");
            return;
        }

        int invoiceId = Integer.parseInt(invoiceIdText);
        int returnId = (int) (Math.random() * 9000) + 1000;

        ReturnRequest request = new ReturnRequest(
                returnId,
                invoiceId,
                selectedProduct.getProductId(),
                LocalDate.now(),
                reason,
                returnType,
                "Pending"
        );

        SharedData.returnRequests.add(request);

        statusTextField.setText(
                "Request Created. Return ID: " + returnId
        );
    }

    @javafx.fxml.FXML
    public void searchInvoiceOnAction(ActionEvent actionEvent) {

        String invoiceIdText = invoiceIdTextField.getText();

        try {

            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(INVOICE_FILE)
            );

            ArrayList<Invoice> invoices =
                    (ArrayList<Invoice>) ois.readObject();

            ois.close();

            SharedData.invoices.setAll(invoices);

        } catch (IOException | ClassNotFoundException e) {
            statusTextField.setText("No saved invoices found.");
            return;
        }

        if (invoiceIdText.isEmpty()) {
            statusTextField.setText("Enter Invoice ID.");
            return;
        }

        int invoiceId = Integer.parseInt(invoiceIdText);

        Invoice foundInvoice = null;

        for (Invoice invoice : SharedData.invoices) {
            if (invoice.getInvoiceId() == invoiceId) {
                foundInvoice = invoice;
                break;
            }
        }

        if (foundInvoice == null) {
            statusTextField.setText("Invoice not found.");
            return;
        }

        statusTextField.setText("Invoice Found");
    }
}