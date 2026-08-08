package com.example.chainboutique.tanjum.controller;

import com.example.chainboutique.tanjum.Product;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
import com.example.chainboutique.tanjum.Cart;
import com.example.chainboutique.tanjum.SharedData;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;

public class CustomerDashboardController
{
    @javafx.fxml.FXML
    private TableColumn<Product,String> sizeCol;
    @javafx.fxml.FXML
    private TableColumn<Product, Integer> stockCol;
    @javafx.fxml.FXML
    private TextField enterProductNameTextField;
    @javafx.fxml.FXML
    private Label searchProductsLabel;
    @javafx.fxml.FXML
    private TextField selectedProductTextField;
    @javafx.fxml.FXML
    private Label categoryLabel;
    @javafx.fxml.FXML
    private TableColumn<Product,String> categoryCol;
    @javafx.fxml.FXML
    private TableColumn<Product,Integer> productIdCol;
    @javafx.fxml.FXML
    private Label quantityLabel;
    @javafx.fxml.FXML
    private TableColumn<Product,String> productNameCol;
    @javafx.fxml.FXML
    private TableColumn<Product, Double> priceCol;
    @javafx.fxml.FXML
    private Label selectedProductLabel;
    @javafx.fxml.FXML
    private ComboBox<String> categoryComboBox;
    @javafx.fxml.FXML
    private TableView<Product> customerDashboardTableView;
    @javafx.fxml.FXML
    private TextField quantityTextField;


    @javafx.fxml.FXML
    private Button btnOrderHistory;
    @javafx.fxml.FXML
    private Button btnLogOut;
    @javafx.fxml.FXML
    private Button btnViewCart;

    @javafx.fxml.FXML
    private Button btnSearch;
    @javafx.fxml.FXML
    private Button btnAddToCart;
    @javafx.fxml.FXML
    private Button btnRefresh;

    private final ObservableList<Product> productList =
            FXCollections.observableArrayList();
    private final Cart cart = SharedData.cart;

    @javafx.fxml.FXML
    public void initialize() {
        categoryComboBox.getItems().addAll(
                "Men",
                "Women",
                "Kids"
        );

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

        categoryCol.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(
                        cellData.getValue().getCategory()
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

        productList.addAll(
                new Product("Men's Shirt", "Men", "M", "shirt.jpg", 101, 1500.0, 20),
                new Product("Women's Kurti", "Women", "L", "kurti.jpg", 102, 1800.0, 15),
                new Product("Kids T-Shirt", "Kids", "S", "kids.jpg", 103, 800.0, 25)
        );


        customerDashboardTableView.setItems(productList);


    }

    @javafx.fxml.FXML
    public void handleOrderHistoryButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/orderHistory.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnOrderHistory.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void handleAddToCartButton(ActionEvent actionEvent) {

        Product selectedProduct =
                customerDashboardTableView.getSelectionModel().getSelectedItem();

        if (selectedProduct == null) {
            searchProductsLabel.setText("Please select a product.");
            return;
        }

        if (quantityTextField.getText().isEmpty()) {
            searchProductsLabel.setText("Enter quantity.");
            return;
        }

        int quantity = Integer.parseInt(quantityTextField.getText());

        if (selectedProduct.checkAvailability(quantity)) {

            cart.addItem(selectedProduct, quantity);
            selectedProduct.updateStock(quantity);

            selectedProductTextField.setText(
                    selectedProduct.getProductName()
            );

            customerDashboardTableView.refresh();

            searchProductsLabel.setText("Added to cart.");
        } else {

            searchProductsLabel.setText("Not enough stock.");

        }
    }

    @javafx.fxml.FXML
    public void handleSearchButton(ActionEvent actionEvent) {

        String productName = enterProductNameTextField.getText();
        String selectedCategory = categoryComboBox.getValue();

        ObservableList<Product> filteredList =
                FXCollections.observableArrayList();

        for (Product product : productList) {

            boolean nameMatches =
                    productName.isEmpty()
                            || product.getProductName()
                            .toLowerCase()
                            .contains(productName.toLowerCase());

            boolean categoryMatches =
                    selectedCategory == null
                            || product.getCategory()
                            .equalsIgnoreCase(selectedCategory);

            if (nameMatches && categoryMatches) {
                filteredList.add(product);
            }
        }

        customerDashboardTableView.setItems(filteredList);
    }

    @javafx.fxml.FXML
    public void handleRefreshButton(ActionEvent actionEvent) {

        enterProductNameTextField.clear();
        categoryComboBox.setValue(null);

        customerDashboardTableView.setItems(productList);
    }

    @javafx.fxml.FXML
    public void handleLogoutButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/customerLogin.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnLogOut.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void handleViewCartButton(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/cart.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnViewCart.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}