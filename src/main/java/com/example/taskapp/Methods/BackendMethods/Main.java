package com.example.taskapp.Methods.BackendMethods;

import com.example.taskapp.Managers.InMemoryTaskHostManager;

public class Main {
    public static void main(String[] args) {

        InMemoryTaskHostManager one = new InMemoryTaskHostManager();

        one.createTask("kek", "zhop");
        System.out.println(one.showTasks());
        System.out.println(one.getById(1).getName());
        one.getById(1).setName("HUI");
        System.out.println(one.getById(1).getName());

    }
}
