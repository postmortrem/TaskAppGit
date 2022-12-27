package com.example.taskapp.AppStuff.Controllers;

import com.example.taskapp.AppStuff.TaskApplication;
import com.example.taskapp.DBMethods.DataBaseInterface;
import com.example.taskapp.DBMethods.taskDatabaseConnect;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;


public class MainController {
    TaskApplication application = new TaskApplication();
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

    DataBaseInterface dataBaseInterface = new taskDatabaseConnect();

    @FXML
    public void updateTreeview(ActionEvent event){
        treeItem1.setValue(dataBaseInterface.taskGetFromDB());
        treeItem1.getChildren();
    }

    @FXML
    protected void Exit(ActionEvent event) throws Exception {
        Platform.exit();
    }

    @FXML
    protected void about(ActionEvent event) {
        application.getHostServices().showDocument("https://github.com/postmortrem");
    }

    @FXML
    protected void plusButtonClick(ActionEvent event) throws IOException {
        application.addTaskScene();
    }
}