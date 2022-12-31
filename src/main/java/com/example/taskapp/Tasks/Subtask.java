package com.example.taskapp.Tasks;

import com.example.taskapp.DBMethods.DAOTask;
import com.example.taskapp.DBMethods.taskDatabaseConnect;
import com.example.taskapp.DBMethods.taskTable;
import com.example.taskapp.Managers.managerSubtask;

public class Subtask extends Task {
    String name, description;
    int id;
    DAOTask database;
    State state;


    public Subtask() {
        manager = new managerSubtask();
    }

    public Subtask(String name) {
        this.name = name;
    }

    public Subtask(String name, String description) {
        this.name = name;
        this.description = description;
        state = State.NEW;
    }

    @Override
    public void doSomething(String name, String description) {
        addTaskToDatabase(name, description);
    }

    @Override
    public void addTaskToDatabase(String name, String description) { // доработать
        database = new taskDatabaseConnect();
        database.setTaskTable(taskTable.subtask);
        database.taskCreateAndAddToDB(name, description);
    }

    @Override
    public void getTaskNamesFromDatabase() {
       database = new taskDatabaseConnect();
       System.out.println(database.getTaskNameArray());
    }
}
