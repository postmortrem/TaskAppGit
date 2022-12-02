package com.example.taskapp.Managers;


import com.example.taskapp.Tasks.Epic;
import com.example.taskapp.Tasks.SubTask;
import com.example.taskapp.Tasks.Task;

public interface HostManager { //мэнеджер с функционалом высшего звена
    String showTasks();

    Task createTask(String name, String description);

    Epic createEpic(String name, String descrip);

    SubTask createSubTask(String name, String descrip, Integer epicId);

    Task getById(int id);

    void showMaps();

    void updateTask(Integer id);

    void updateEpic(Integer id);

    void updateSub(Integer id);

    void showEpicSubs(Integer id);

    void getHistory();

}
