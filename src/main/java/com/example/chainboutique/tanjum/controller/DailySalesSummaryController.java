package com.example.chainboutique.tanjum.controller;

import javafx.scene.control.*;
import javafx.event.ActionEvent;
import com.example.chainboutique.tanjum.SalesBill;
import java.time.LocalDate;
import javafx.scene.control.cell.PropertyValueFactory;
import com.example.chainboutique.tanjum.SharedData;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DailySalesSummaryController
{
    @javafx.fxml.FXML
    private TableView<SalesBill> salesSummaryTableView;
    @javafx.fxml.FXML
    private Label totalSalesSummaryLabel;
    @javafx.fxml.FXML
    private Button btnLogout;
    @javafx.fxml.FXML
    private Button btnPrint;
    @javafx.fxml.FXML
    private Label netSalesLabel;
    @javafx.fxml.FXML
    private DatePicker reportDateDatePicker;
    @javafx.fxml.FXML
    private Label dailySalesSummaryTitleLabel;
    @javafx.fxml.FXML
    private TableColumn paymentMethodCol;
    @javafx.fxml.FXML
    private Label totalReturnsSummaryLabel;
    @javafx.fxml.FXML
    private TextField totalBillsSummaryTextField;
    @javafx.fxml.FXML
    private TableColumn<SalesBill,Integer> billIdCol;
    @javafx.fxml.FXML
    private Button btnRefresh;
    @javafx.fxml.FXML
    private TableColumn<SalesBill,Double> totalAmountCol;
    @javafx.fxml.FXML
    private TableColumn<SalesBill,LocalDate> dateCol;
    @javafx.fxml.FXML
    private TextField totalSalesSummaryTextField;
    @javafx.fxml.FXML
    private TextField totalReturnsSummaryTextField;
    @javafx.fxml.FXML
    private TableColumn customerNameCol;
    @javafx.fxml.FXML
    private Button btnGenerateReport;
    @javafx.fxml.FXML
    private TextField totalDiscountSummaryTextField;
    @javafx.fxml.FXML
    private Label cashierIdLabel;
    @javafx.fxml.FXML
    private Label totalBillsSummaryLabel;
    @javafx.fxml.FXML
    private TextField netSalesTextField;
    @javafx.fxml.FXML
    private TextField cashierIdTextField;
    @javafx.fxml.FXML
    private Button btnExit;

    @javafx.fxml.FXML
    public void initialize() {
        billIdCol.setCellValueFactory(
                new PropertyValueFactory<>("billId")
        );

        totalAmountCol.setCellValueFactory(
                new PropertyValueFactory<>("totalAmount")
        );

        dateCol.setCellValueFactory(
                new PropertyValueFactory<>("billDate")
        );

        reportDateDatePicker.setValue(LocalDate.now());

        salesSummaryTableView.setItems(SharedData.salesBills);
    }

    @javafx.fxml.FXML
    public void generateReportOnAction(ActionEvent actionEvent) {

        int totalBills = SharedData.salesBills.size();

        double totalSales = 0.0;

        for (SalesBill bill : SharedData.salesBills) {
            totalSales += bill.getTotalAmount();
        }

        totalBillsSummaryTextField.setText(
                String.valueOf(totalBills)
        );

        totalSalesSummaryTextField.setText(
                String.valueOf(totalSales)
        );

        totalDiscountSummaryTextField.setText("0.0");
        totalReturnsSummaryTextField.setText("0.0");

        netSalesTextField.setText(
                String.valueOf(totalSales)
        );
    }

    @javafx.fxml.FXML
    public void exitOnAction(ActionEvent actionEvent) {

        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    @javafx.fxml.FXML
    public void logoutOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(
                Objects.requireNonNull(
                        getClass().getResource(
                                "/com/example/chainboutique/tanjum/cashierLogin.fxml"
                        )
                )
        );

        Stage stage = (Stage) btnLogout.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @javafx.fxml.FXML
    public void refreshOnAction(ActionEvent actionEvent) {

        salesSummaryTableView.refresh();

        generateReportOnAction(actionEvent);
    }

    @javafx.fxml.FXML
    public void printReportOnAction(ActionEvent actionEvent) {

        System.out.println("===== DAILY SALES SUMMARY =====");
        System.out.println("Report Date: " + reportDateDatePicker.getValue());
        System.out.println("Cashier ID: " + cashierIdTextField.getText());
        System.out.println("Total Bills: " + totalBillsSummaryTextField.getText());
        System.out.println("Total Sales: " + totalSalesSummaryTextField.getText());
        System.out.println("Total Discount: " + totalDiscountSummaryTextField.getText());
        System.out.println("Total Returns: " + totalReturnsSummaryTextField.getText());
        System.out.println("Net Sales: " + netSalesTextField.getText());
        System.out.println("===============================");
    }
}