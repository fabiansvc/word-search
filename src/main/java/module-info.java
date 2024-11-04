module com.example.planeserializablefiles {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.planeserializablefiles to javafx.fxml;
    opens com.example.planeserializablefiles.controller to javafx.fxml;
    exports com.example.planeserializablefiles;
}