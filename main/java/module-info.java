module com.example.hwtrackingapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hwtrackingapp to javafx.fxml;
    exports com.example.hwtrackingapp;
}