package com.example.taskapp;

import com.example.taskapp.Controllers.AddTaskController;
import com.example.taskapp.Controllers.StartController;
import com.example.taskapp.Interfaces.Subject;
import com.example.taskapp.Managers.InMemoryTaskManager;
import com.example.taskapp.Managers.Manager;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TaskApplication extends Application implements Subject {

    Label label = new Label("Выберите тип задачи");
    Button Task = new Button("Task");
    Button Epic = new Button("Epic");
    Button Subtask = new Button("Subtask");
    Manager one = new InMemoryTaskManager();
    AddTaskController adder;


    void addTaskCreate() {
        String name;
        Stage newStage1 = new Stage();
        VBox vbox = new VBox(10);
        Scene addScene1 = new Scene(vbox, 200, 100);
        newStage1.setTitle("new Task");
        newStage1.setScene(addScene1);
        TextField tf1 = new TextField();
        tf1.setPromptText("task name");
        TextField tf2 = new TextField();
        tf2.setPromptText("task description");
        Button ok = new Button("OK");
        ok.setOnAction(event ->
                {
                    com.example.taskapp.Tasks.Task task = one.createTask(tf1.getText(), tf2.getText());
                    newStage1.close();
                    one.showTasks();
                    one.showMaps();
                    StartController.newList.add(task.getName());
                }
        );
        vbox.getChildren().addAll(tf1, tf2, ok);
        newStage1.show();
    }

    void addEpicCreate() {
        Stage newStage2 = new Stage();
        VBox vbox = new VBox(10);
        Scene addScene2 = new Scene(vbox, 200, 100);
        newStage2.setTitle("new Epic");
        newStage2.setScene(addScene2);
        TextField tf1 = new TextField();
        tf1.setPromptText("epic name");
        TextField tf2 = new TextField();
        tf2.setPromptText("epic description");
        Button ok = new Button("OK");
        ok.setOnAction(event ->
                {
                    com.example.taskapp.Tasks.Task task = one.createEpic(tf1.getText(), tf2.getText());
                    newStage2.close();
                    one.showTasks();
                   StartController.newList.add(task.getName());
                }
        );
        vbox.getChildren().addAll(tf1, tf2, ok);
        newStage2.show();
    }

    void addSubTaskCreate() {
        Stage newStage3 = new Stage();
        VBox vbox = new VBox(10);
        Scene addScene3 = new Scene(vbox, 200, 150);
        newStage3.setTitle("new Epic");
        newStage3.setScene(addScene3);
        TextField tf1 = new TextField();
        tf1.setPromptText("subtask name");
        TextField tf2 = new TextField();
        tf2.setPromptText("subtask description");
        TextField tf3 = new TextField();
        tf3.setPromptText("choose epic for subtask");
        Button ok = new Button("OK");
        ok.setOnAction(event ->
                {
                    try {

                        com.example.taskapp.Tasks.Task task = one.createSubTask(tf1.getText(), tf2.getText(), Integer.valueOf(tf3.getText()));
                        newStage3.close();
                        one.showTasks();
                        StartController.newList.add(task.getName());
                    }
                    catch (NumberFormatException | NullPointerException e){
                        newStage3.close();
                    }
                }
        );
        vbox.getChildren().addAll(tf1, tf2, tf3, ok);
        newStage3.show();
    }

    public void addTask() {
        Stage newStage = new Stage();
        VBox vbox = new VBox();
        Scene addScene = new Scene(vbox, 300, 200);
        newStage.setTitle("Add task");
        newStage.setScene(addScene);
        Task.setOnAction((e) -> addTaskCreate());
        Epic.setOnAction((event) -> addEpicCreate());
        Subtask.setOnAction((e) -> addSubTaskCreate());
        vbox.getChildren().addAll(label, Task, Epic, Subtask);
        newStage.show();
    }


   public
   void createAdderControllerButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(TaskApplication.class.getResource("Mocha.fxml"));
        Scene newView = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(newView);
        stage.show();
    }


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TaskApplication.class.getResource("Zhopa.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}