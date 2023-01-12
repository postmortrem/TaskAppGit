package com.example.taskapp.TaskFabric;

import com.example.taskapp.Tasks.TaskInterface;
import com.example.taskapp.Tasks.Task;

public class TaskFabric extends MainFabric{

    @Override
    public TaskInterface createTask(String name, String description) {
        return new Task(name, description);
    }
}
