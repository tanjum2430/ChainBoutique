package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.Announcement;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class AnnouncementController
{
    @javafx.fxml.FXML
    private TextField createdByField;
    @javafx.fxml.FXML
    private Button searchButton;
    @javafx.fxml.FXML
    private TableView <Announcement> announcementTable;
    @javafx.fxml.FXML
    private TextField searchField;
    @javafx.fxml.FXML
    private TextField titleField;
    @javafx.fxml.FXML
    private TableColumn <Announcement,String> announcementIdColumn;
    @javafx.fxml.FXML
    private TableColumn <Announcement,String> messageColumn;
    @javafx.fxml.FXML
    private TextField announcementIdField;
    @javafx.fxml.FXML
    private DatePicker createdOnPicker;
    @javafx.fxml.FXML
    private TableColumn <Announcement,String> createdByColumn;
    @javafx.fxml.FXML
    private Button addAnnouncementButton;
    @javafx.fxml.FXML
    private Button clearButton;
    @javafx.fxml.FXML
    private TableColumn <Announcement,String> titleColumn;
    @javafx.fxml.FXML
    private Button refreshButton;
    @javafx.fxml.FXML
    private TextArea messageArea;
    @javafx.fxml.FXML
    private TableColumn <Announcement,LocalDateTime> createdOnColumn;
    private ObservableList<Announcement> announcementList =
            FXCollections.observableArrayList();
    @javafx.fxml.FXML
    public void initialize() {
        announcementIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("announcementID"));

        titleColumn.setCellValueFactory(
                new PropertyValueFactory<>("title"));

        messageColumn.setCellValueFactory(
                new PropertyValueFactory<>("message"));

        createdByColumn.setCellValueFactory(
                new PropertyValueFactory<>("createdBy"));

        createdOnColumn.setCellValueFactory(
                new PropertyValueFactory<>("createdOn"));

    }

    @javafx.fxml.FXML
    public void addAnnouncement(ActionEvent actionEvent) {
        if (announcementIdField.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Announcement ID cannot be empty.");
            alert.showAndWait();

            return;
        }

        String id = announcementIdField.getText();
        String title = titleField.getText();
        String message = messageArea.getText();
        String createdBy = createdByField.getText();

        LocalDateTime createdOn = createdOnPicker.getValue().atStartOfDay();

        Announcement announcement = new Announcement(
                id,
                title,
                message,
                createdBy,
                createdOn
        );
        announcementList.add(announcement);
        announcementTable.setItems(announcementList);


    }

    @javafx.fxml.FXML
    public void searchAnnouncement(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshTable(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearFields(ActionEvent actionEvent) {
    }
}