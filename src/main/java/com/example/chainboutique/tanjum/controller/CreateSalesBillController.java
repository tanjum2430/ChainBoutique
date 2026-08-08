package com.example.chainboutique.tanjum.controller;

import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.chainboutique.tanjum.Product;
import com.example.chainboutique.tanjum.CartItem;
import com.example.chainboutique.tanjum.SharedData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import com.example.chainboutique.tanjum.SalesBill;
import java.time.LocalDate;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.io.IOException;
import java.util.Objects;





public class CreateSalesBillController
{
    private static final String SALES_BILL_FILE = "salesBills.bin";
    private static final String PRODUCT_FILE = "products.bin";


    @javafx.fxml.FXML
    private TableColumn<Product,String> sizeCol;
    @javafx.fxml.FXML
    private Button handleAddItemButton;
    @javafx.fxml.FXML
    private TableColumn<Product,Integer> stockCol;
    @javafx.fxml.FXML
    private TextField phoneTextField;
    @javafx.fxml.FXML
    private TextField customerIdTextField;
    @javafx.fxml.FXML
    private TableColumn<CartItem,Double> subtotalCol;
    @javafx.fxml.FXML
    private Button btnCalculate;
    @javafx.fxml.FXML
    private TableColumn<Product,Integer> productIdCol;
    @javafx.fxml.FXML
    private TableColumn<CartItem,Double> unitPriceCol;
    @javafx.fxml.FXML
    private Label phoneLabel;
    @javafx.fxml.FXML
    private Label createSalesBillLabel;
    @javafx.fxml.FXML
    private Label customerNameLabel;
    @javafx.fxml.FXML
    private TableView<Product> createSalesBillTableView;
    @javafx.fxml.FXML
    private TextField quantityTextField;
    @javafx.fxml.FXML
    private Button btnBack;
    @javafx.fxml.FXML
    private Label totalAmountLabel;
    @javafx.fxml.FXML
    private Button btnGenerateBill;
    @javafx.fxml.FXML
    private TextField customerNameTextField;
    @javafx.fxml.FXML
    private Button btnNext;
    @javafx.fxml.FXML
    private Label quantityLabel;
    @javafx.fxml.FXML
    private TableColumn<CartItem,String> productCol;
    @javafx.fxml.FXML
    private TextField totalAmountTextField;
    @javafx.fxml.FXML
    private TableColumn<Product,String> productNameCol;
    @javafx.fxml.FXML
    private TableColumn<Product,Double> priceCol;
    @javafx.fxml.FXML
    private TableView<CartItem> cartItemTableView;
    @javafx.fxml.FXML
    private Label customerIdLabel;
    @javafx.fxml.FXML
    private TableColumn<CartItem,Integer> quantityCol;

    private final ObservableList<Product> productList =
            FXCollections.observableArrayList();

    private final ObservableList<CartItem> billItems =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        // Product table
        productIdCol.setCellValueFactory(cellData ->
                new ReadOnlyObjectWrapper<>(
                        cellData.getValue().getProductId()
                )
        );

        productNameCol.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(
                        cellData.getValue().getProductName()
                )
        );

        sizeCol.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(
                        cellData.getValue().getSize()
                )
        );

        priceCol.setCellValueFactory(cellData ->
                new ReadOnlyObjectWrapper<>(
                        cellData.getValue().getPrice()
                )
        );

        stockCol.setCellValueFactory(cellData ->
                new ReadOnlyObjectWrapper<>(
                        cellData.getValue().getStock()
                )
        );

        // Bill items table
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

        // Temporary products
        File file = new File(PRODUCT_FILE);

        if (file.exists() && file.length() > 0) {

            try {
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream(PRODUCT_FILE)
                );

                ArrayList<Product> products =
                        (ArrayList<Product>) ois.readObject();

                ois.close();

                productList.setAll(products);

            } catch (IOException | ClassNotFoundException e) {
                totalAmountTextField.setText("Error loading products.");
            }

        } else {

            productList.addAll(
                    new Product("Men's Shirt", "Men", "M", "shirt.jpg", 101, 1500.0, 20),
                    new Product("Women's Kurti", "Women", "L", "kurti.jpg", 102, 1800.0, 15),
                    new Product("Kids T-Shirt", "Kids", "S", "kids.jpg", 103, 800.0, 25)
            );
        }

        createSalesBillTableView.setItems(productList);
        cartItemTableView.setItems(billItems);

        // Selected customer
        if (SharedData.selectedCustomer != null) {

            customerIdTextField.setText(
                    String.valueOf(SharedData.selectedCustomer.getCustomerId())
            );

            customerNameTextField.setText(
                    SharedData.selectedCustomer.getName()
            );

            phoneTextField.setText(
                    SharedData.selectedCustomer.getPhoneNo()
            );
        }
    }

    @javafx.fxml.FXML
    public void addItemOnAction(ActionEvent actionEvent) {

        Product selectedProduct =
                createSalesBillTableView.getSelectionModel().getSelectedItem();

        if (selectedProduct == null) {
            totalAmountTextField.setText("Select a product.");
            return;
        }

        if (quantityTextField.getText().isEmpty()) {
            totalAmountTextField.setText("Enter quantity.");
            return;
        }

        int quantity = Integer.parseInt(quantityTextField.getText());

        if (!selectedProduct.checkAvailability(quantity)) {
            totalAmountTextField.setText("Not enough stock.");
            return;
        }

        CartItem item = new CartItem(
                selectedProduct,
                quantity
        );

        billItems.add(item);

        selectedProduct.updateStock(quantity);

        try {

            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(PRODUCT_FILE)
            );

            oos.writeObject(new ArrayList<>(productList));
            oos.close();

        } catch (IOException e) {
            totalAmountTextField.setText("Error updating product stock.");
            return;
        }

        createSalesBillTableView.refresh();
        cartItemTableView.refresh();
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/cashierDashboard.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void generateBillOnAction(ActionEvent actionEvent) {

        if (billItems.isEmpty()) {
            totalAmountTextField.setText("Add items first.");
            return;
        }

        double total = 0.0;

        for (CartItem item : billItems) {
            total += item.getSubTotal();
        }

        int billId = (int) (Math.random() * 9000) + 1000;

        SalesBill salesBill = new SalesBill(
                billId,
                LocalDate.now(),
                total
        );
        if (SharedData.selectedCustomer != null) {
            salesBill.setCustomerName(
                    SharedData.selectedCustomer.getName()
            );
        }

        SharedData.salesBills.add(salesBill);

        try {

            ArrayList<SalesBill> salesBills = new ArrayList<>();

            File file = new File(SALES_BILL_FILE);

            if (file.exists() && file.length() > 0) {

                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream(SALES_BILL_FILE)
                );

                salesBills = (ArrayList<SalesBill>) ois.readObject();
                ois.close();
            }

            salesBills.add(salesBill);

            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(SALES_BILL_FILE)
            );

            oos.writeObject(salesBills);
            oos.close();

        } catch (IOException | ClassNotFoundException e) {

            totalAmountTextField.setText("Error saving bill.");
            return;
        }

        totalAmountTextField.setText(
                "Bill Generated. ID: " + billId
        );
    }

    @javafx.fxml.FXML
    public void nextOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/applyDiscount.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnNext.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void calculateTotalOnAction(ActionEvent actionEvent) {

        double total = 0.0;

        for (CartItem item : billItems) {
            total += item.getSubTotal();
        }

        totalAmountTextField.setText(
                String.valueOf(total)
        );
    }
}