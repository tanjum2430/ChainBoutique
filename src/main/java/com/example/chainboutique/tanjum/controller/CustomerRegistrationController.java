package com.example.chainboutique.tanjum.controller;

import com.example.chainboutique.tanjum.Customer;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class CustomerRegistrationController
{
    private static final String CUSTOMER_FILE = "customer.bin";

    @javafx.fxml.FXML
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private TextField phoneNoTextField;
    @javafx.fxml.FXML
    private TextField addressTextField;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private Label phoneNoLabel;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private Label addressLabel;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private Label passwordLabel;
    @javafx.fxml.FXML
    private Label customerRegistrationLabel;
    @javafx.fxml.FXML
    private Label emailLabel;
    @javafx.fxml.FXML
    private Label nameLabel;
    @javafx.fxml.FXML
    private Label msgLabel;
    @javafx.fxml.FXML
    private Button btnBack;
    @javafx.fxml.FXML
    private Button btnRegister;
    @javafx.fxml.FXML
    private Button btnReset;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException{
        Parent root = FXMLLoader.load(
                Objects.requireNonNull(CustomerRegistrationController.class.getResource("/com/example/chainboutique/tanjum/customerLogin.fxml")));
        Stage stage = (Stage) nameTextField.getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();

    }

    @javafx.fxml.FXML
    public void handleResetButton(ActionEvent actionEvent) {
        nameTextField.clear();
        phoneNoTextField.clear();
        emailTextField.clear();
        addressTextField.clear();
        passwordTextField.clear();

        messageLabel.setText("");
    }

    @javafx.fxml.FXML
    public void handleRegisterButton(ActionEvent actionEvent) {


        String name = nameTextField.getText();
        String phone = phoneNoTextField.getText();
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String password = passwordTextField.getText();
        int customerId = (int) (Math.random() * 9000) + 1000;


        if (name.isEmpty()|| phone.isEmpty()|| email.isEmpty()
        || address.isEmpty()|| password.isEmpty()){
            messageLabel.setText("Please fill in all the fields.");
            return;





        }



        Customer customer = new Customer(
                name,
                email,
                phone,
                password,
                address,
                customerId
        );



        if (customer.createAccount()) {

            try {
                ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream(CUSTOMER_FILE)
                );

                oos.writeObject(customer);
                oos.close();

                messageLabel.setText("Registration Successful!");

            } catch (IOException e) {
                messageLabel.setText("Error saving customer.");
            }

        } else {
            messageLabel.setText("Registration Failed!");
        }
    }


}