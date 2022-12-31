package com.example.taskapp.DBMethods;

import com.example.taskapp.Tasks.Task;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;


public class taskDatabaseConnect implements DAOTask {

    ArrayList<String> tasknames = new ArrayList<>();
    taskTable table;
    String taskname;
    ArrayList<Task> taskArray = new ArrayList<>();

    @Override
    public void setTaskTable(taskTable table) {
        this.table = table;
    }

    @Override
    public void taskCreateAndAddToDB(String name, String description) {
        try {
            try (Connection conn = createConnect()) {
                String sql = "INSERT " + table+ "(name, description) values (?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, description);
                preparedStatement.executeUpdate();
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

    @Override
    public ArrayList<String>getTaskNameArray() {
        tasknames.clear();
        setTaskTable(taskTable.newtask);// сделать переопределение
        try{
            try(Connection conn = createConnect()){
                Statement statement = conn.createStatement();
                ResultSet set =  statement.executeQuery("SELECT * FROM " +table);
                while (set.next()) {
                    String name = set.getString(2);
                    taskname = name;
                    tasknames.add(name);
                }
            }
        } catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return  tasknames;
    }

    @Override
    public ArrayList<Task> getTaskArray() {
        taskArray.clear();
        setTaskTable(taskTable.newtask);
        try{
            try(Connection conn = createConnect()){
                Statement statement = conn.createStatement();
                ResultSet set =  statement.executeQuery("SELECT * FROM " +table);
                while (set.next()) {
                    Task newTask = new Task(set.getInt(1),set.getString(2), set.getString(3));
                   taskArray.add(newTask);
                }
            }
        } catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        System.out.println(taskArray.toString());
        return  taskArray;
    }


    public static Connection createConnect() throws SQLException, IOException {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("src/main/resources/tasks.properties"))) {
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");
        return DriverManager.getConnection(url, username, password);
    }
}


