package com.example.taskapp.TaskFabric;

import com.example.taskapp.Tasks.TaskInterface;
import com.example.taskapp.Tasks.Subtask;

public class SubtaskFabric extends MainFabric{
    @Override
    public TaskInterface createTask(String name, String description) {
        return new Subtask(name, description);
    }
}
