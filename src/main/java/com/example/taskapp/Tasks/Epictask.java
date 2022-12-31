package com.example.taskapp.Tasks;

import com.example.taskapp.DBMethods.DAOTask;
import com.example.taskapp.DBMethods.taskDatabaseConnect;
import com.example.taskapp.DBMethods.taskTable;
import com.example.taskapp.Managers.managerEpictask;

public class Epictask extends Task {
    String name, description;
    int id;
    State state;
    DAOTask database;


    public Epictask() {
        manager = new managerEpictask();
    }

    public Epictask(String name) {
        this.name = name;
    }

    public Epictask(String name, String description) {
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
        database.setTaskTable(taskTable.epic);
        database.taskCreateAndAddToDB(name, description);
    }

    @Override
    public void getTaskNamesFromDatabase(){
        database = new taskDatabaseConnect();
        System.out.println(database.getTaskNameArray());
    }
}
