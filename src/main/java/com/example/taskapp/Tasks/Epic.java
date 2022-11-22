package com.example.taskapp.Tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Epic extends Task {
    String state = "NEW";
    public static HashMap<Integer, Epic> epicMap = new HashMap<>();
    public static ArrayList<SubTask> epicSubArray;

    Epic() {
        super();
    }

    public Epic(Integer id) {
        super(id);
        epicSubArray = new ArrayList<>();
    }

    Epic(String name, Integer id) {
        super(name, id);
    }

    Epic(String name, String description, Integer id) {
        super(name, description, id);
    }

    public void epicChanged(Integer id) {
        int i = 0;
        Epic task = epicMap.get(id);
        Collection<SubTask> subby = SubTask.subMap.values();
        for (SubTask e : subby) {
            if (e.getState().equals("NEW"))
                i++;
        }
        if (i == subby.size()) {
            task.setState("NEW");
        } else if (i == 0) {
            task.setState("DONE");
        } else task.setState("IN PROGRESS");
    }

    @Override
    public void addToMap(Task task) {
        epicMap.put(id, (Epic) task);
    }
}
