package com.example.taskapp.Tasks;

import com.example.taskapp.Managers.ManagerInterface;
import com.example.taskapp.Managers.managerEpictask;
import com.example.taskapp.Managers.managerTask;

public class Task implements TaskInterface{
    String name, description;
    int id, state;
    ManagerInterface manager;

    public Task() {
        manager = new managerTask();
    }

    public Task(String name) {
        this.name = name;
    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void deleteTask(){
        manager.delete();
    }

    public  void updateTask(){
        manager.update();
    }
    public void changeTask(){
        manager.update();
    }

    @Override
    public void doSomething() {
        System.out.println("done task");
    }
}
