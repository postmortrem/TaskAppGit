package com.example.taskapp.AppStuff;


import com.example.taskapp.AppStuff.Controllers.MainController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

import java.io.IOException;

public class TaskApplication extends Application implements ApplicationInterface {

    public Stage stage = new Stage();
    public Scene scene;
    MainController controller;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TaskApplication.class.getResource("/com/example/taskapp/App.fxml"));
        scene = new Scene(fxmlLoader.load());
        this.stage.setTitle("My Task Manager");
        this.stage.setScene(scene);
        this.stage.show();
    }

    public void addTaskScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(TaskApplication.class.getResource("/com/example/taskapp/AddTask.fxml"));
        scene = new Scene(loader.load());
        this.stage.setTitle("New Task");
        this.stage.setScene(scene);
        this.stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}