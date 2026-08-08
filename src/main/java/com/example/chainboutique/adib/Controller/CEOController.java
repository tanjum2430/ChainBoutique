package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.CEO;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;

public class CEOController {

    @FXML
    private TextField employeeIdField;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private Spinner<Integer> reportYearSpinner;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private ComboBox<String> reportTypeComboBox;
    @FXML
    private ComboBox<String> departmentComboBox;
    @FXML
    private ComboBox<String> decisionComboBox;
    @FXML
    private TextField filterCriteriaField;
    @FXML
    private TextField requestIdField;
    @FXML
    private TextArea remarksTextArea;
    @FXML
    private TextField announcementTitleField;
    @FXML
    private TextArea announcementMessageTextArea;
    @FXML
    private Button saveCEOActionButton;
    @FXML
    private Button generatereportButton;
    @FXML
    private Button reportsummaryButton;
    @FXML
    private Button filterButton;
    @FXML
    private Spinner<Integer> filterYearSpinner;
    @FXML
    private TableView<CEO> ceoTableView;
    private ObservableList<CEO> ceoList = FXCollections.observableArrayList();
    @FXML
    private TableColumn<CEO,String> employeeIdColumn;
    @FXML
    private ComboBox <String> filterDepartmentComboBox;
    @FXML
    private ComboBox <String> filterReportTypeComboBox;
    @FXML
    private TableColumn <CEO, LocalDate> startDateColumn;
    @FXML
    private TableColumn <CEO, String> decisionColumn;
    @FXML
    private TableColumn <CEO, String> announcementTitleColumn;
    @FXML
    private TableColumn <CEO, String> reportTypeColumn;
    @FXML
    private TableColumn <CEO, LocalDate> endDateColumn;
    @FXML
    private TableColumn <CEO, Integer> reportYearColumn;
    @FXML
    private TableColumn <CEO, String> remarksColumn;
    @FXML
    private TableColumn  <CEO, String> departmentColumn;
    @FXML
    private TableColumn <CEO, String> requestIdColumn;
    @FXML
    private TableColumn <CEO, String> announcementMessageColumn;

    @FXML
    public void initialize() {
        ceoTableView.setItems(ceoList);

        employeeIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("employeeID"));

        startDateColumn.setCellValueFactory(
                new PropertyValueFactory<>("startDate"));

        endDateColumn.setCellValueFactory(
                new PropertyValueFactory<>("endDate"));

        reportYearColumn.setCellValueFactory(
                new PropertyValueFactory<>("reportYear"));

        reportTypeColumn.setCellValueFactory(
                new PropertyValueFactory<>("reportType"));

        departmentColumn.setCellValueFactory(
                new PropertyValueFactory<>("department"));

        requestIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("requestID"));

        decisionColumn.setCellValueFactory(
                new PropertyValueFactory<>("decision"));

        remarksColumn.setCellValueFactory(
                new PropertyValueFactory<>("remarks"));

        announcementTitleColumn.setCellValueFactory(
                new PropertyValueFactory<>("announcementTitle"));

        announcementMessageColumn.setCellValueFactory(
                new PropertyValueFactory<>("announcementMessage"));

        reportTypeComboBox.getItems().addAll(
                "Annual",
                "Quarterly",
                "Monthly"
        );

        departmentComboBox.getItems().addAll(
                "Management",
                "Sales",
                "Finance",
                "Inventory",
                "HR"
        );

        decisionComboBox.getItems().addAll(
                "Approve",
                "Reject"
        );

        filterDepartmentComboBox.getItems().addAll(
                "Management",
                "Sales",
                "Finance",
                "Inventory",
                "HR"
        );

        filterReportTypeComboBox.getItems().addAll(
                "Annual",
                "Quarterly",
                "Monthly"
        );

        reportYearSpinner.getValueFactory().setValue(2026);
        filterYearSpinner.getValueFactory().setValue(2026);


    }

    @FXML
    public void filterRecords(ActionEvent actionEvent) {

        String department = filterDepartmentComboBox.getValue();
        String reportType = filterReportTypeComboBox.getValue();
        Integer year = filterYearSpinner.getValue();

        FilteredList<CEO> filteredList = new FilteredList<>(ceoList);

        filteredList.setPredicate(ceo -> {

            boolean departmentMatch =
                    department == null ||
                            department.isEmpty() ||
                            department.equals(ceo.getDepartment());

            boolean reportTypeMatch =
                    reportType == null ||
                            reportType.isEmpty() ||
                            reportType.equals(ceo.getReportType());

            boolean yearMatch =
                    year == null ||
                            year.equals(ceo.getReportYear());

            return departmentMatch && reportTypeMatch && yearMatch;
        });

        ceoTableView.setItems(filteredList);
    }

    @FXML
    public void generateReport(ActionEvent actionEvent) {
        System.out.println("Report generated successfully.");

    }

    @FXML
    public void generateReportSummary(ActionEvent actionEvent) {
        System.out.println("Report summary generated successfully.");
    }

    @FXML
    public void saveCEOAction(ActionEvent actionEvent) {
        String employeeID = employeeIdField.getText();
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();

        Integer reportYear = reportYearSpinner.getValue();

        String reportType = reportTypeComboBox.getValue();
        String department = departmentComboBox.getValue();

        String requestID = requestIdField.getText();
        String decision = decisionComboBox.getValue();

        String remarks = remarksTextArea.getText();

        String announcementTitle = announcementTitleField.getText();
        String announcementMessage = announcementMessageTextArea.getText();

        CEO ceo = new CEO(
                employeeID,
                startDate,
                endDate,
                reportYear,
                reportType,
                department,
                requestID,
                decision,
                remarks,
                announcementTitle,
                announcementMessage
        );

        ceoList.add(ceo);
        employeeIdField.clear();
        startDatePicker.setValue(null);
        endDatePicker.setValue(null);
        reportTypeComboBox.setValue(null);
        departmentComboBox.setValue(null);
        requestIdField.clear();
        decisionComboBox.setValue(null);
        remarksTextArea.clear();
        announcementTitleField.clear();
        announcementMessageTextArea.clear();
    }
}