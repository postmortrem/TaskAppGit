package com.example.taskapp.DBMethods;

import com.example.taskapp.Tasks.Task;

import java.util.ArrayList;

public interface DAOTask {
   public void taskCreateAndAddToDB(String name, String description); // возможно 3 реализации перебор,потому что меняется меняется одна строчка
   public ArrayList<String> getTaskNameArray();
   public ArrayList<Task> getTaskArray();
   public void setTaskTable(taskTable table);
}
