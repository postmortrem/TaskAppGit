package com.example.taskapp.Managers;

public class managerEpictask implements ManagerInterface{

    @Override
    public void update() {
        System.out.println("epictask updated");
    }

    @Override
    public void delete() {
        System.out.println("epictask deleted");
    }

    @Override
    public void change() {
        System.out.println("epictask changed");
    }

    @Override
    public void getById(int id) {

    }
}
