package com.example.taskapp.Controllers;

import com.example.taskapp.TaskApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class StartController  {

    TaskApplication application = new TaskApplication();

    public static ObservableList newList = FXCollections.observableArrayList();

    static ObservableList inProgressList = FXCollections.observableArrayList();

    static ObservableList doneList = FXCollections.observableArrayList();

    @FXML
    private ListView<String> newColumn;
    @FXML
    private ListView inProgressColumn;
    @FXML
    public ListView<String> doneColumn;
    @FXML
    private Button btn;



    private void loadNewList() {
        newColumn.getItems().clear();
        newColumn.getItems().addAll(newList);
    }

    private void loadInProgressList() {
        inProgressColumn.getItems().clear();
        inProgressColumn.getItems().addAll(inProgressList);
    }

    public void loadDoneListView() {
        doneColumn.getItems().clear();
        doneColumn.getItems().addAll(doneList);
    }

    @FXML
    protected void click(ActionEvent event) {
        application.addTask();
    }

    @FXML
    protected void operation(MouseEvent event) throws Exception { // нихрена не работает
        application.stop();
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//       // loadNewList(); если чето не работает - раскоментить
//        preLoad();
//    }
//
//    void preLoad(){
//       TasksRepository pre = new TasksRepository();
//        Iterable<TasksRepository> post =loadTasks.findAll();
//        newList.addAll(post);
//    }


    @FXML
    void createAdderControllerButton() throws IOException {
        application.createAdderControllerButton();
    }

    public void update(ActionEvent event) {
        loadNewList();
        loadInProgressList();
        loadDoneListView();
    }
}