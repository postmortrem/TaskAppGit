package com.example.taskapp.AppStuff.Controllers;

import com.example.taskapp.AppStuff.Model;
import com.example.taskapp.AppStuff.TaskApplication;
import com.example.taskapp.DBMethods.DAOTask;
import com.example.taskapp.DBMethods.taskDatabaseConnect;
import com.example.taskapp.Tasks.Task;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.IOException;


public class MainController{

    @FXML
    private Button plusButton;
    @FXML
    MenuItem updateItem;
    @FXML
    TreeView treeView1;
    @FXML
    TreeItem treeItem1;
    @FXML
    TreeView treeView2;
    @FXML
    TreeView treeView3;
    @FXML
    MenuItem aboutItem;

    Model model = new Model();
    Application application = new TaskApplication();

    @FXML
    public void deleteTaskButton() {

    }

    @FXML
    public void updateTreeview(ActionEvent event) {
        model.previewTask(treeView1,treeItem1);
    }

    @FXML
    protected void Exit(ActionEvent event) throws Exception {
        Platform.exit();
    }

    @FXML
    protected void about(ActionEvent event) {
     model.gitHub();
    }

    @FXML
    protected void plusButtonClick(ActionEvent event) throws IOException {
     model.addTaskScene();
    }
}