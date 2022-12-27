package com.example.taskapp.Managers;

public class managerSubtask implements ManagerInterface{

    @Override
    public void update() {
        System.out.println("subtask updated");
    }

    @Override
    public void delete() {
        System.out.println("subtask deleted");
    }

    @Override
    public void change() {
        System.out.println("subtask changed");
    }

}
