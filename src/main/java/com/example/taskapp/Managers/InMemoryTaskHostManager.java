package com.example.taskapp.Managers;



import com.example.taskapp.Tasks.Epic;
import com.example.taskapp.Tasks.SubTask;
import com.example.taskapp.Tasks.Task;

import java.util.ArrayList;

public class InMemoryTaskHostManager implements HostManager {
    Integer managerId = 0;

    ArrayList<Task> taskArray = new ArrayList<>();

    public String showTasks() {
        for (Task e : taskArray) {
            System.out.println(e.getName() + " " + e.getDescription() + " " + e.getId() + " " + e.getState());
        }
        return taskArray.toString();
    }

    public Task createTask(String name, String description) {
        Task task = new Task(++managerId);
        task.setName(name);
        task.setDescription(description);
        task.getState();
        task.addToMap(task);
        taskArray.add(task);
        return task;
    }

   public Epic createEpic(String name, String descrip) {
        Epic epic = new Epic(++managerId);
        epic.setName(name);
        epic.setDescription(descrip);
        epic.getState();
        epic.addToMap(epic);
        taskArray.add(epic);
        return epic;
    }

    public SubTask createSubTask(String name, String descrip, Integer epicId) {
        SubTask subtask = new SubTask(++managerId, epicId);
        subtask.setName(name);
        subtask.setDescription(descrip);
        subtask.epicCheck(epicId);
        subtask.getState();
        subtask.addToMap(subtask);
        taskArray.add(subtask);
        return subtask;
    }

    public Task getById(int id) {
        Task task = null;
        for (Task e : taskArray) {
            if (e.getId() == id)
                task = e;
        }
        return task;
    }

    public void showMaps() {
        System.out.println(Task.taskMap.toString());
        System.out.println(Epic.epicMap.toString());
        System.out.println(SubTask.subMap.toString());
    }

    public void updateTask(Integer id) {
        Task task = Task.taskMap.get(id);
        task.setState("DONE");
        Task.taskMap.put(id,task);
    }

    public void updateEpic(Integer id) {
       Epic task = Epic.epicMap.get(id);
       task.epicChanged(id);
       Epic.epicMap.put(id,task);
    }

    public void updateSub(Integer id){
        SubTask task= SubTask.subMap.get(id);
        task.setState("DONE");
        SubTask.subMap.put(id,task);
    }

    public void showEpicSubs(Integer id) {
        Epic epic;
        epic = Epic.epicMap.get(id);
        System.out.println(" Epic " + epic.getName() + " contains subs: ");
        for (SubTask e : Epic.epicSubArray)
            System.out.print(" " + e.getName() + " ");
    }

    @Override
    public void getHistory() {

    }
}
