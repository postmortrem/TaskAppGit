package com.example.taskapp.DBMethods;

import java.util.ArrayList;

public interface DAOTask {
   public void taskCreateAndAddToDB(String name, String description); // возможно 3 реализации перебор,потому что меняется меняется одна строчка
   public String getTaskName();
   public ArrayList<String> getArrays();
}
