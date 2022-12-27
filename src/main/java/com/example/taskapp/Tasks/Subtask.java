package com.example.taskapp.Tasks;

import com.example.taskapp.DBMethods.DAOTask;
import com.example.taskapp.DBMethods.subtaskDatabaseConnect;
import com.example.taskapp.Managers.managerSubtask;

public class Subtask extends Task {
    String name, description;
    int id, state;
    DAOTask database;


    public Subtask() {
        manager = new managerSubtask();
    }

    public Subtask(String name) {
        this.name = name;
    }

    public Subtask(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void doSomething(String name, String description) {
        addTaskToDatabase(name, description);
    }

    @Override
    public void addTaskToDatabase(String name, String description) { // доработать
        database = new subtaskDatabaseConnect();
        database.taskCreateAndAddToDB(name, description);
        getTaskFromDatabase();
    }

    @Override
    public void getTaskFromDatabase() {
       database = new subtaskDatabaseConnect();
       System.out.println(database.getTaskName());
    }
}
