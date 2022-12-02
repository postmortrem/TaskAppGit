package com.example.taskapp.AppStuff;

import com.example.taskapp.Managers.HostManager;
import com.example.taskapp.Managers.InMemoryTaskHostManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TaskApplication extends Application {
    Button btn = new Button("+");
    Label label = new Label("Выберите тип задачи");
    Button Task = new Button("Task");
    Button Epic = new Button("Epic");
    Button Subtask = new Button("Subtask");
    HostManager one = new InMemoryTaskHostManager();
    TextField tf1 = new TextField();

    void addTaskCreate() {
        Stage newStage1 = new Stage();
        VBox vbox = new VBox();
        Scene addScene1 = new Scene(vbox, 200, 100);
        newStage1.setTitle("new Task");
        newStage1.setScene(addScene1);
        tf1 = new TextField();
        tf1.setPromptText("task name");
        TextField tf2 = new TextField();
        tf2.setPromptText("task description");
        Button ok = new Button("OK");
        com.example.taskapp.Tasks.Task task = one.createTask("kek", "kek2");
        ok.setOnAction(e -> task.setName(tf1.getText()));
        ok.setOnAction(e -> task.setDescription(tf2.getPromptText()));
        vbox.getChildren().addAll(tf1, tf2, ok);
        ok.setOnAction((ae) -> newStage1.close());
        newStage1.show();
    }

    void addEpicCreate() {
        Stage newStage2 = new Stage();
        VBox vbox = new VBox();
        Scene addScene2 = new Scene(vbox, 200, 100);
        newStage2.setTitle("new Epic");
        newStage2.setScene(addScene2);
        TextField tf1 = new TextField();
        tf1.setPromptText("epic name");
        TextField tf2 = new TextField();
        tf2.setPromptText("epic description");
        Button ok = new Button("OK");
        tf1.setOnAction((e -> tf1.getText()));
        vbox.getChildren().addAll(tf1, tf2, ok);
        ok.setOnAction((ae) -> newStage2.close());
        newStage2.show();
    }

    void addSubTaskCreate() {
        Stage newStage3 = new Stage();
        VBox vbox = new VBox();
        Scene addScene3 = new Scene(vbox, 200, 100);
        newStage3.setTitle("new Epic");
        newStage3.setScene(addScene3);
        TextField tf1 = new TextField();
        tf1.setPromptText("subtask name");
        TextField tf2 = new TextField();
        tf2.setPromptText("subtask description");
        Button ok = new Button("OK");
        tf1.setOnAction((e -> tf1.getText()));
        vbox.getChildren().addAll(tf1, tf2, ok);
        ok.setOnAction((ae) -> newStage3.close());
        newStage3.show();
    }

    public void addTask() {
        Stage newStage = new Stage();
        AnchorPane root = new AnchorPane();
        Scene addScene = new Scene(root, 300, 200);
        label.setAlignment(Pos.TOP_CENTER);
        Task.setLayoutX(10);
        Task.setLayoutY(100);
        Epic.setLayoutX(130);
        Epic.setLayoutY(100);
        Subtask.setLayoutX(230);
        Subtask.setLayoutY(100);
        newStage.setTitle("Add task");
        newStage.setScene(addScene);
        Task.setOnAction((e) -> addTaskCreate());
        Epic.setOnAction((event) -> addEpicCreate());
        Subtask.setOnAction((e) -> addSubTaskCreate());
        root.getChildren().addAll(label, Task, Epic, Subtask);
        newStage.show();
    }

    public void TaskScene(Stage stage) {
        VBox vbox = new VBox();
        one.createTask("!", "!");
        one.createTask("@", "@");
        Scene scene = new Scene(vbox, 140, 200);
        stage.setScene(scene);
        Label label = new Label(one.showTasks());
        label.setPrefHeight(30);
        vbox.getChildren().add(label);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TaskApplication.class.getResource("App.fxml"));
        // FlowPane Root = new FlowPane(10, 10);
        // Root.setAlignment(Pos.BOTTOM_LEFT);
        Scene scene = new Scene(fxmlLoader.load(),322,333);
        stage.setTitle("TaskM");
        stage.setScene(scene);
//        btn.setOnAction((ae) -> addTask());
//      Root.getChildren().addAll(btn);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}