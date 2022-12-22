package com.example.taskapp.TaskFabric;

import com.example.taskapp.Tasks.TaskInterface;

public abstract class MainFabric {

    public void realizationOfFabric(){
        TaskInterface one = createTask();
        one.doSomething();
    }

    public abstract TaskInterface createTask();
}
