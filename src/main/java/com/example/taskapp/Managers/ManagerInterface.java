package com.example.taskapp.Managers;

import com.example.taskapp.DBMethods.getFromDB;

public interface ManagerInterface extends getFromDB {
   public void update();
    public void delete();
    public void change();
}
