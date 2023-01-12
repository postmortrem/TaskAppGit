package com.example.taskapp.TaskFabric;

import com.example.taskapp.Tasks.TaskInterface;

public abstract class MainFabric {

    public TaskInterface createTaskAndAddToDB(String name, String description) {
        TaskInterface one = createTask(name, description);

        one.doSomething(name, description);

        return one;
    }

   protected abstract TaskInterface createTask(String name, String decription); // сделать обычное создание таски вместо кастомного или нет хз
}
