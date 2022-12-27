package com.example.taskapp.Tasks;

import com.example.taskapp.DBMethods.DAOTask;
import com.example.taskapp.DBMethods.epictaskDatabaseConnect;
import com.example.taskapp.Managers.managerEpictask;

public class Epictask extends Task {
    String name, description;
    int id, state;
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
    }

    @Override
    public void doSomething(String name, String description) {
        addTaskToDatabase(name, description);
    }

    @Override
    public void addTaskToDatabase(String name, String description) { // доработать
        database = new epictaskDatabaseConnect();
        database.taskCreateAndAddToDB(name, description);
        getTaskFromDatabase();
    }

    @Override
    public void getTaskFromDatabase(){
        database = new epictaskDatabaseConnect();
        System.out.println(database.getTaskName());
    }
}
