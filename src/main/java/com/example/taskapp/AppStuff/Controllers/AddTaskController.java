package com.example.taskapp.AppStuff.Controllers;

import com.example.taskapp.AppStuff.Model;
import com.example.taskapp.AppStuff.TaskApplication;
import com.example.taskapp.TaskFabric.MainFabric;
import com.example.taskapp.TaskFabric.TaskFabric;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddTaskController {


    @FXML
    Button btn;
    @FXML
    Button closebtn;
    @FXML
    TextField textfield1;
    @FXML
    TextField textfield2;

    Model model = new Model();

    @FXML
    private void createTask(){
        model.createTaskScene(textfield1,textfield2,closebtn);
    }

    @FXML
    private void closeAddTask(){
            Stage stage = (Stage) closebtn.getScene().getWindow();
            stage.close();
        }
    }
