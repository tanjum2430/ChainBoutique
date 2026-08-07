package com.example.chainboutique.tanjum.controller;


import javafx.event.ActionEvent;
import javafx.scene.control.*;
import com.example.chainboutique.tanjum.Product;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.example.chainboutique.tanjum.Cart;
import com.example.chainboutique.tanjum.SharedData;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class SearchProductController
{
    @javafx.fxml.FXML
    private TableColumn<Product, String> sizeCol;
    @javafx.fxml.FXML
    private Button btnBack;
    @javafx.fxml.FXML
    private TableColumn<Product, Integer> stockCol;
    @javafx.fxml.FXML
    private Button btnSearch;
    @javafx.fxml.FXML
    private TextField productNameTextField;
    @javafx.fxml.FXML
    private Label productDetailsLabel;
    @javafx.fxml.FXML
    private Button btnAddToCart;
    @javafx.fxml.FXML
    private TableColumn<Product, String> categoryCol;
    @javafx.fxml.FXML
    private Label productNameLabel;
    @javafx.fxml.FXML
    private TableColumn<Product, Integer> productIdCol;
    @javafx.fxml.FXML
    private Label quantityLabel;
    @javafx.fxml.FXML
    private TableColumn<Product, String> productNameCol;
    @javafx.fxml.FXML
    private TableView<Product> searchProductsTableView;
    @javafx.fxml.FXML
    private TableColumn<Product, Double> priceCol;
    @javafx.fxml.FXML
    private Button btnRefresh;
    @javafx.fxml.FXML
    private ComboBox<String> searchCategoryComboBox;
    @javafx.fxml.FXML
    private Label searchProductLabel;
    @javafx.fxml.FXML
    private Button btnCustomerDashboard;
    @javafx.fxml.FXML
    private Button btnCart;
    @javafx.fxml.FXML
    private TextField quantityTextField;

    private final ObservableList<Product> productList =
            FXCollections.observableArrayList();
    private final Cart cart = SharedData.cart;

    @javafx.fxml.FXML
    public void initialize() {
        searchCategoryComboBox.getItems().addAll(
                "Men",
                "Women",
                "Kids"
        );

        productIdCol.setCellValueFactory(
                new PropertyValueFactory<>("productId")
        );

        productNameCol.setCellValueFactory(
                new PropertyValueFactory<>("productName")
        );

        categoryCol.setCellValueFactory(
                new PropertyValueFactory<>("category")
        );

        sizeCol.setCellValueFactory(
                new PropertyValueFactory<>("size")
        );

        priceCol.setCellValueFactory(
                new PropertyValueFactory<>("price")
        );

        stockCol.setCellValueFactory(
                new PropertyValueFactory<>("stock")
        );

        productList.addAll(
                new Product("Men's Shirt", "Men", "M", "shirt.jpg", 101, 1500.0, 20),
                new Product("Women's Kurti", "Women", "L", "kurti.jpg", 102, 1800.0, 15),
                new Product("Kids T-Shirt", "Kids", "S", "kids.jpg", 103, 800.0, 25)
        );

        searchProductsTableView.setItems(productList);

    }


    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {

        String productName = productNameTextField.getText();
        String selectedCategory = searchCategoryComboBox.getValue();

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

        searchProductsTableView.setItems(filteredList);
    }

    @javafx.fxml.FXML
    public void viewCartOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/cart.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnCart.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/customerDashboard.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void dashboardOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/customerDashboard.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnCustomerDashboard.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void refreshOnAction(ActionEvent actionEvent) {

        productNameTextField.clear();
        searchCategoryComboBox.setValue(null);

        searchProductsTableView.setItems(productList);
    }

    @javafx.fxml.FXML
    public void addToCartOnAction(ActionEvent actionEvent) {

        Product selectedProduct =
                searchProductsTableView.getSelectionModel().getSelectedItem();

        if (selectedProduct == null) {
            productDetailsLabel.setText("Please select a product.");
            return;
        }

        if (quantityTextField.getText().isEmpty()) {
            productDetailsLabel.setText("Enter quantity.");
            return;
        }

        int quantity = Integer.parseInt(quantityTextField.getText());

        if (selectedProduct.checkAvailability(quantity)) {

            cart.addItem(selectedProduct, quantity);
            selectedProduct.updateStock(quantity);

            searchProductsTableView.refresh();

            productDetailsLabel.setText("Added to cart.");

        } else {
            productDetailsLabel.setText("Not enough stock.");
        }
    }
}