package com.example.taskapp.TaskFabric;

import com.example.taskapp.Tasks.Epictask;
import com.example.taskapp.Tasks.TaskInterface;

public class EpictaskFabric extends MainFabric{
    @Override
    public TaskInterface createTask() {
        return new Epictask();
    }
}
