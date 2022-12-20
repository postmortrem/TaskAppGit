module com.example.taskapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires spring.data.commons;
    requires spring.beans;
    requires spring.context;
    requires spring.web;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires java.sql;


    opens com.example.taskapp to javafx.fxml;
    exports com.example.taskapp;
    exports com.example.taskapp.Controllers;
    opens com.example.taskapp.Controllers to javafx.fxml;
}