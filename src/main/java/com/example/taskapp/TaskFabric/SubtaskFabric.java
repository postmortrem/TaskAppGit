package com.example.taskapp.TaskFabric;

import com.example.taskapp.Tasks.FabricTaskInterface;
import com.example.taskapp.Tasks.Subtask;

public class SubtaskFabric extends MainFabric{
    @Override
    public FabricTaskInterface createTask(String name, String description) {
        return new Subtask(name, description);
    }
}
