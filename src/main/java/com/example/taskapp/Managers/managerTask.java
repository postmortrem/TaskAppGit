package com.example.taskapp.Managers;

public class managerTask implements ManagerInterface{
    @Override
    public void update() {
        System.out.println("task updated");
    }

    @Override
    public void delete() {
        System.out.println("task deleted");
    }

    @Override
    public void change() {
        System.out.println("task changed");
    }

}
