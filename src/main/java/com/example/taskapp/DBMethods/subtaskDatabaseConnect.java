package com.example.taskapp.DBMethods;

import com.example.taskapp.TaskFabric.MainFabric;
import com.example.taskapp.Tasks.FabricTaskInterface;
import com.example.taskapp.TaskFabric.SubtaskFabric;
import com.example.taskapp.Tasks.Subtask;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class subtaskDatabaseConnect implements DataBaseInterface {

    @Override
    public void taskCreateAndAddToDB(String name, String description) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = createConnect()) {
                String sql = "INSERT subtask(name, description) values (?, ?)";
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
