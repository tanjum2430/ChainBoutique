package com.example.chainboutique.adib.Controller;

import com.example.chainboutique.adib.Announcement;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

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
    private TableColumn <Announcement,String> createdOnColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addAnnouncement(ActionEvent actionEvent) {
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