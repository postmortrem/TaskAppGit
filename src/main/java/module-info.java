module com.example.taskapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports com.example.taskapp.AppStuff;
    opens com.example.taskapp.AppStuff to javafx.fxml;
    exports com.example.taskapp.AppStuff.Controllers;
    opens com.example.taskapp.AppStuff.Controllers to javafx.fxml;
}