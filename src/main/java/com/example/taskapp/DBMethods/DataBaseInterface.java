package com.example.taskapp.DBMethods;

public interface DataBaseInterface {
   public void taskCreateAndAddToDB(String name, String description); // возможно 3 реализации перебор,потому что меняется меняется одна строчка
   public String taskGetFromDB();
}
