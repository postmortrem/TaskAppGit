package com.example.taskapp;

import com.example.taskapp.Managers.InMemoryTaskManager;
import com.example.taskapp.Managers.Manager;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    Button btn = new Button("+");
    VBox vBox = new VBox(10);
    VBox vBox1 = new VBox(10);
    Label label = new Label("Выберите тип задачи");
    Button Task = new Button("Task");
    Button Epic = new Button("Epic");
    Button Subtask = new Button("Subtask");
    Manager one = new InMemoryTaskManager();
    String react;

    void addTaskCreate() {

        Stage newStage1 = new Stage();
        Scene addScene1 = new Scene(new VBox(), 200, 100);
        newStage1.setTitle("new Task");
        newStage1.setScene(addScene1);
        TextField tf1 = new TextField();
        tf1.setPromptText("task name");
        TextField tf2 = new TextField();
        tf2.setPromptText("task description");
        Button ok = new Button("OK");
        System.out.println(react);
        tf1.setOnAction((e -> react = tf1.getText()));
//        tf2.setOnAction((e) -> );
        System.out.println(react);
//        .getChildren().addAll(tf1, tf2, ok);
        ok.setOnAction((ae) -> newStage1.close());
        newStage1.show();
    }

    void addEpicCreate() {
        Stage newStage2 = new Stage();
        Scene addScene2 = new Scene(new VBox(), 200, 100);
        newStage2.setTitle("new Epic");
        newStage2.setScene(addScene2);
        TextField tf1 = new TextField();
        tf1.setPromptText("epic name");
        TextField tf2 = new TextField();
        tf2.setPromptText("epic description");
        Button ok = new Button("OK");
        System.out.println(react);
        tf1.setOnAction((e -> react = tf1.getText()));
//        tf2.setOnAction((e) -> );
        System.out.println(react);
        vBox1.getChildren().addAll(tf1, tf2, ok);
        ok.setOnAction((ae) -> newStage2.close());
        newStage2.show();
    }

    void addSubTaskCreate() {
        Stage newStage3 = new Stage();
        Scene addScene3 = new Scene(new VBox(), 200, 100);
        newStage3.setTitle("new Epic");
        newStage3.setScene(addScene3);
        TextField tf1 = new TextField();
        tf1.setPromptText("subtask name");
        TextField tf2 = new TextField();
        tf2.setPromptText("subtask description");
        Button ok = new Button("OK");
        System.out.println(react);
        tf1.setOnAction((e -> react = tf1.getText()));
//        tf2.setOnAction((e) -> );
        System.out.println(react);
        vBox1.getChildren().addAll(tf1, tf2, ok);
        ok.setOnAction((ae) -> newStage3.close());
        newStage3.show();
    }



    public void addTask() {
        Stage newStage = new Stage();
        Scene addScene = new Scene(vBox, 300, 200);
        newStage.setTitle("Add task");
        newStage.setScene(addScene);
        Task.setOnAction((e) -> addTaskCreate());
        Epic.setOnAction((event) -> addEpicCreate());
        Subtask.setOnAction((e) -> addSubTaskCreate());
//        Epic.setOnAction((e) ->);
//        Subtask.setOnAction((e) ->);
        vBox.getChildren().addAll(label, Task, Epic, Subtask);
        newStage.show();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FlowPane Root = new FlowPane(10, 10);
        Root.setAlignment(Pos.BOTTOM_LEFT);
        Scene scene = new Scene(Root, 500, 240);
        stage.setTitle("TaskM");
        stage.setScene(scene);
        btn.setOnAction((ae) -> addTask());
        Root.getChildren().addAll(btn);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}