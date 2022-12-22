package com.example.taskapp.Tasks;

import com.example.taskapp.Managers.ManagerInterface;
import com.example.taskapp.Managers.managerSubtask;

public class Subtask extends Task implements TaskInterface{
    String name, description;
    int id, state;


    public Subtask(){
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
    public void doSomething() {
        System.out.println("done subtask");
    }
}
