module com.example.chainboutique {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chainboutique to javafx.fxml;
    opens com.example.chainboutique.tanjum.controller to javafx.fxml;
    exports com.example.chainboutique;

    opens com.example.chainboutique.adib to javafx.fxml;
    exports com.example.chainboutique.adib;
    exports com.example.chainboutique.adib.Controller;
    opens com.example.chainboutique.adib.Controller to javafx.fxml;
}