package com.example.taskapp.AppStuff.Controllers;

import com.example.taskapp.AppStuff.TaskApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;


public class TaskController {
    TaskApplication application = new TaskApplication();
    @FXML
    private Button plusButton;

    @FXML
    protected void plusButtonClick(ActionEvent event) throws IOException {
        application.addTaskScene();
    }
}