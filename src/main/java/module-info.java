module com.example.taskapp {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.taskapp.AppStuff;
    opens com.example.taskapp.AppStuff to javafx.fxml;
}