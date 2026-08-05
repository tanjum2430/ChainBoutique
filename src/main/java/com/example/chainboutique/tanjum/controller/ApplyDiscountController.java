package com.example.chainboutique.tanjum.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

import com.example.chainboutique.tanjum.Discount;
import com.example.chainboutique.tanjum.SalesBill;

public class ApplyDiscountController
{
    @javafx.fxml.FXML
    private TextField billIdTextField;
    @javafx.fxml.FXML
    private Button btnBack;
    @javafx.fxml.FXML
    private Label totalAmountLabel;
    @javafx.fxml.FXML
    private Label discountPercentageLabel;
    @javafx.fxml.FXML
    private Button btnApplyDiscount;
    @javafx.fxml.FXML
    private Label billIdLabel;
    @javafx.fxml.FXML
    private Label billInformationLabel;
    @javafx.fxml.FXML
    private TextField finalAmountTextField;
    @javafx.fxml.FXML
    private TextField customerNameTextField;
    @javafx.fxml.FXML
    private Label discountCodeLabel;
    @javafx.fxml.FXML
    private AnchorPane applyDiscountLabel;
    @javafx.fxml.FXML
    private Button btnNext;
    @javafx.fxml.FXML
    private Label discountInformationLabel;
    @javafx.fxml.FXML
    private Button btnValidate;
    @javafx.fxml.FXML
    private TextField totalAmountTextField;
    @javafx.fxml.FXML
    private Label finalAmountLabel;
    @javafx.fxml.FXML
    private TextField discountPercentageTextField;
    @javafx.fxml.FXML
    private Label discountAmountLabel;
    @javafx.fxml.FXML
    private TextField discountAmountTextField;
    @javafx.fxml.FXML
    private TextField discountCodeTextField;
    @javafx.fxml.FXML
    private Label customerNameLabel;
    @javafx.fxml.FXML
    private TextArea discountDetailsTextArea;

    private final Discount discount =
            new Discount("SAVE10", "Active", 10.0);

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/createSalesBill.fxml"
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
                                "/com/example/chainboutique/tanjum/receivePayment.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnNext.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void validateOnAction(ActionEvent actionEvent) {

        String code = discountCodeTextField.getText();

        if (code.isEmpty()) {
            discountDetailsTextArea.setText("Please enter a discount code.");
            return;
        }

        if (code.equalsIgnoreCase(discount.getDiscountCode())
                && discount.validateDiscount()) {

            discountPercentageTextField.setText(
                    String.valueOf(discount.getDiscountPercentage())
            );

            discountDetailsTextArea.setText("Valid discount code.");

        } else {

            discountPercentageTextField.clear();
            discountDetailsTextArea.setText("Invalid or inactive discount code.");
        }
    }

    @javafx.fxml.FXML
    public void applyDiscountOnAction(ActionEvent actionEvent) {

        String totalText = totalAmountTextField.getText();

        if (totalText.isEmpty()) {
            discountDetailsTextArea.setText("Enter total amount first.");
            return;
        }

        double totalAmount = Double.parseDouble(totalText);

        if (!discountCodeTextField.getText()
                .equalsIgnoreCase(discount.getDiscountCode())
                || !discount.validateDiscount()) {

            discountDetailsTextArea.setText("Validate a valid discount code first.");
            return;
        }

        double finalAmount = discount.applyDiscount(totalAmount);
        double discountAmount = totalAmount - finalAmount;

        discountAmountTextField.setText(
                String.valueOf(discountAmount)
        );

        finalAmountTextField.setText(
                String.valueOf(finalAmount)
        );

        discountDetailsTextArea.setText("Discount applied successfully.");
    }
}