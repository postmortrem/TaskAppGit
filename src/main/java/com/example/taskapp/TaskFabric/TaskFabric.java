package com.example.taskapp.TaskFabric;

import com.example.taskapp.Tasks.FabricTaskInterface;
import com.example.taskapp.Tasks.Task;

public class TaskFabric extends MainFabric{
    @Override
    public FabricTaskInterface createTask(String name, String description) {
        return new Task(name, description);
    }
}
