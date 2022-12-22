package com.example.taskapp.TaskFabric;

import com.example.taskapp.Tasks.Task;
import com.example.taskapp.Tasks.TaskInterface;

public class TaskFabric extends MainFabric{
    @Override
    public TaskInterface createTask() {
        return new Task();
    }
}
