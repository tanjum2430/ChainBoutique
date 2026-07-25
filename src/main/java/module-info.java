module com.example.chainboutique {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chainboutique to javafx.fxml;
    exports com.example.chainboutique;
}