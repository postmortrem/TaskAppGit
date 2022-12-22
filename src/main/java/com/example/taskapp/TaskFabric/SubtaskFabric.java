package com.example.taskapp.TaskFabric;

import com.example.taskapp.Tasks.Subtask;
import com.example.taskapp.Tasks.TaskInterface;

public class SubtaskFabric extends MainFabric{
    @Override
    public TaskInterface createTask() {
        return new Subtask();
    }
}
