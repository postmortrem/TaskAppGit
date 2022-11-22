package com.example.taskapp.Tasks;

import java.util.HashMap;

public class SubTask extends Task {
    String state = "NEW";
    public static HashMap<Integer, SubTask> subMap = new HashMap<>();
    Epic epic;


    SubTask() {
        super();
    }

    public SubTask(Integer id, Integer epicId) {
        super(id);
        epic = epicCheck(epicId);
        Epic.epicSubArray.add(this);
    }

    SubTask(String name, Integer id) {
        super(name, id);
    }

    SubTask(String name, String description, Integer id) {
        super(name, description, id);
    }

    public Epic epicCheck(Integer epicId) {
        if (Epic.epicMap.containsKey(epicId))
            epic = Epic.epicMap.get(epicId);
        else epic = null;
        return epic;
    }

    @Override
    public void addToMap(Task task) {
        subMap.put(id, (SubTask) task);
    }

}
