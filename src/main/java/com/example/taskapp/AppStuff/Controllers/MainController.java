package com.example.taskapp.AppStuff.Controllers;

import com.example.taskapp.AppStuff.TaskApplication;
import com.example.taskapp.DBMethods.DAOTask;
import com.example.taskapp.DBMethods.taskDatabaseConnect;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

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

    TreeItem newTreeItem = new TreeItem("Tasks");

    DAOTask DAOTask = new taskDatabaseConnect();

    public void preview() {
        treeView1.getRoot().getChildren().clear();
        newTreeItem.getChildren().clear();
        for (String e : DAOTask.getArrays()) {
            newTreeItem.getChildren().add(new TreeItem(e));
            treeView1.setRoot(newTreeItem);
        }
    }

    @FXML
    public void deleteTaskButton() {

    }

    @FXML
    public void updateTreeview(ActionEvent event) {
        treeItem1.setValue(DAOTask.getTaskName());
        preview();
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