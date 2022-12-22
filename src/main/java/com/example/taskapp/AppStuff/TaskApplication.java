package com.example.taskapp.AppStuff;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TaskApplication extends Application {

    Stage stage = new Stage();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TaskApplication.class.getResource("/com/example/taskapp/App.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        this.stage.setTitle("My Task Manager");
        this.stage.setScene(scene);
        this.stage.show();
    }

    public void addTaskScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(TaskApplication.class.getResource("/com/example/taskapp/AddTask.fxml"));
        Scene newView = new Scene(loader.load());
        this.stage.setTitle("New Task");
        this.stage.setScene(newView);
        this.stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}