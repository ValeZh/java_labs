module com.example.studentapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.studentapp.view to javafx.fxml;
    exports com.example.studentapp;
    exports com.example.studentapp.model;
}