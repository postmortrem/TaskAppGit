package com.example.taskapp.TaskFabric;

import com.example.taskapp.Tasks.Epictask;
import com.example.taskapp.Tasks.Subtask;
import com.example.taskapp.Tasks.Task;

public class TestOfFabric {
    static MainFabric subFabrique;
    static MainFabric fabrique;
    static MainFabric epicFabrique;

    public static void main(String[] args) {
        subFabrique = new SubtaskFabric();
        fabrique = new TaskFabric();
        epicFabrique = new EpictaskFabric();
        fabrique.realizationOfFabric();
        subFabrique.realizationOfFabric();
        epicFabrique.realizationOfFabric();

        Epictask one = new Epictask();
        one.updateTask();
        Subtask two = new Subtask();
        two.changeTask();
        Task three = new Task();
        three.deleteTask();
        Task four = new Epictask();
        four.deleteTask();
    }
}
