package com.example.taskapp.DBMethods;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class taskDatabaseConnect implements DAOTask {

    String taskname;
    ArrayList<String> tasknames = new ArrayList<>();

    @Override
    public void taskCreateAndAddToDB(String name, String description) {
        try {
            try (Connection conn = createConnect()) {
                String sql = "INSERT task(name, description) values (?, ?)";
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
    public String getTaskName() {
        tasknames.clear();
        try{
            try(Connection conn = createConnect()){
                Statement statement = conn.createStatement();
                ResultSet set =  statement.executeQuery("SELECT * FROM task");
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
        System.out.println(tasknames.toString());
        return  taskname;
    }

    @Override
    public ArrayList<String> getArrays() {
        return tasknames;
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


