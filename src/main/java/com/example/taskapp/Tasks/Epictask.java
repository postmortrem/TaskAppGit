package com.example.taskapp.Tasks;

import com.example.taskapp.Managers.ManagerInterface;
import com.example.taskapp.Managers.managerEpictask;

public class Epictask extends Task implements TaskInterface{
    String name, description;
    int id, state;


    public Epictask(){
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
    public void doSomething() {
        System.out.println("done epic");
    }
}
