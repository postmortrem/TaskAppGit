package com.example.taskapp.TaskFabric;

import com.example.taskapp.Tasks.Epictask;
import com.example.taskapp.Tasks.FabricTaskInterface;

public class EpictaskFabric extends MainFabric{
    @Override
    public FabricTaskInterface createTask(String name, String description) {
        return new Epictask(name, description);
    }
}
