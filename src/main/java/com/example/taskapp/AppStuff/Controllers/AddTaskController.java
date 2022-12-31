package com.example.taskapp.AppStuff.Controllers;

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


    static MainFabric subFabrique;
    static MainFabric fabrique;
    static MainFabric epicFabrique;

    @FXML
    private void createTask(){
        fabrique = new TaskFabric();
        fabrique.realizationOfFabric(textfield1.getText(), textfield2.getText());
        System.out.println(textfield1.getText()+ " " + textfield2.getText());
        Stage stage = (Stage) closebtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void closeAddTask(){
            Stage stage = (Stage) closebtn.getScene().getWindow();
            stage.close();
        }
    }
