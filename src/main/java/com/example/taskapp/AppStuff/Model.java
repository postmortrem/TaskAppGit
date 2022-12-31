package com.example.taskapp.AppStuff;

import com.example.taskapp.DBMethods.DAOTask;
import com.example.taskapp.DBMethods.taskDatabaseConnect;
import com.example.taskapp.Tasks.Task;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

import java.io.IOException;

public class Model {

    DAOTask daotask = new taskDatabaseConnect();

    public void previewNames(TreeView treeView, TreeItem treeItem) {
        treeView.getRoot().getChildren().clear();
        treeItem.getChildren().clear();
        for (String e : daotask.getTaskNameArray()) {
            treeItem.getChildren().add(new TreeItem(e));
            treeView.setRoot(treeItem);
        }
    }

    public void previewTask(TreeView treeView, TreeItem treeItem) {
        treeView.getRoot().getChildren().clear();
        treeItem.getChildren().clear();
        for (Task e : daotask.getTaskArray()) {
            treeItem.getChildren().add(new TreeItem<>(e));
            treeView.setRoot(treeItem);
        }
    }


    public void gitHub(){
//        application.getHostServices().showDocument("https://github.com/postmortrem");
    }

    public void addTaskScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(TaskApplication.class.getResource("/com/example/taskapp/AddTask.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("New Task");
        stage.setScene(scene);
        stage.show();
    }
}
