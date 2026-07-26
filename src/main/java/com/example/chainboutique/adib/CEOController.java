package com.example.chainboutique.adib;

import java.awt.*;

public class CEOController {
    package com.example.chainboutique.adib;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

    public class CEOController {

        @FXML
        private TableColumn<?, ?> announcementColumn;

        @FXML
        private TextArea announcementMessageTextArea;

        @FXML
        private TextField announcementTitleField;

        @FXML
        private TableColumn<?, ?> annualReportColumn;

        @FXML
        private TableView<?> ceoTableView;

        @FXML
        private TableColumn<?, ?> clientAnalyticsColumn;

        @FXML
        private TableColumn<?, ?> dashboardColumn;

        @FXML
        private ComboBox<?> decisionComboBox;

        @FXML
        private ComboBox<?> departmentComboBox;

        @FXML
        private TableColumn<?, ?> employeeIdColumn;

        @FXML
        private TextField employeeIdField;

        @FXML
        private TableColumn<?, ?> employeePerformanceColumn;

        @FXML
        private DatePicker endDatePicker;

        @FXML
        private Button filterButton;

        @FXML
        private TextField filterCriteriaField;

        @FXML
        private ComboBox<?> filterDepartmentCombo;

        @FXML
        private ComboBox<?> filterReportTypeCombo;

        @FXML
        private Spinner<?> filterYearSpinner;

        @FXML
        private TableColumn<?, ?> financialSummaryColumn;

        @FXML
        private Button generatereportButton;

        @FXML
        private TableColumn<?, ?> performanceReportColumn;

        @FXML
        private TextArea remarksTextArea;

        @FXML
        private ComboBox<?> reportTypeComboBox;

        @FXML
        private Spinner<?> reportYearSpinner;

        @FXML
        private Button reportsummaryButton;

        @FXML
        private TextField requestIdField;

        @FXML
        private Button saveCEOActionButton;

        @FXML
        private DatePicker startDatePicker;

    }

}
