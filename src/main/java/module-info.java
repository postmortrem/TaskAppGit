module com.example.taskapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.taskapp to javafx.fxml;
    exports com.example.taskapp;
    exports com.example.taskapp.Controllers;
    opens com.example.taskapp.Controllers to javafx.fxml;
}