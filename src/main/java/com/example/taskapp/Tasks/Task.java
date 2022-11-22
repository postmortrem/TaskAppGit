package com.example.taskapp.Tasks;

import java.util.HashMap;

public class Task {
    final Integer id;
    String name;
    String description;
    public String state = "NEW";
    public static HashMap<Integer, Task> taskMap = new HashMap<>();

    public void showEpicSubs(Integer id) {

    }

    Task() {
        id = 0;
    }

    public Task(Integer id) {
        this.id = id;
    }

    Task(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    Task(String name, String description, Integer id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addToMap(Task task) {
        taskMap.put(id, task);
    }
}
