package com.example.taskapp.TaskFabric;

import com.example.taskapp.Tasks.FabricTaskInterface;

public abstract class MainFabric {

    public void realizationOfFabric(String name, String description) {
        FabricTaskInterface one = createTask(name, description);
        one.doSomething(name, description);
    }

    public abstract FabricTaskInterface createTask(String name, String decription);
}
