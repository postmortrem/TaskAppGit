package com.example.taskapp.DBMethods;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

public class DataBaseMethods {

    String taskname;

    public void taskCreateAndAddToDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection conn = getConnection()){
                Statement statement = conn.createStatement();
                statement.executeUpdate("INSERT Task(name, description, state) values ('my', 'first', 'try')");
//                StartController.newList.add(taskGetFromDB());
            }
        } catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

    public String taskGetFromDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection conn = getConnection()){
                Statement statement = conn.createStatement();
                ResultSet set =  statement.executeQuery("SELECT * FROM task");
                while (set.next()) {
                    int id = set.getInt(1);
                    String name = set.getString(2);
                    taskname = name;
                }
            }
        } catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return  taskname;
    }

//    public static void main(String[] args) {
//
//        String sqlCommand = "CREATE TABLE products (Id INT PRIMARY KEY AUTO_INCREMENT, ProductName VARCHAR(20), Price INT)";
//        try{
//
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//            try (Connection conn = getConnection()){
//
//                Statement statement = conn.createStatement();
//                // создание таблицы
//                 statement.executeUpdate(sqlCommand);
//                //заполнение столбцов
//                int rows = statement.executeUpdate("INSERT Products(ProductName, Price) VALUES ('iPhone X', 76000)," +
//                        "('Galaxy S9', 45000), ('Nokia 9', 36000)");
//                System.out.printf("Added %d rows", rows);
//
//            }
//        }
//        catch(Exception ex){
//            System.out.println("Connection failed...");
//
//            System.out.println(ex);
//        }
//    }

    public static Connection getConnection() throws SQLException, IOException {
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("src/main/resources/appProps.properties"))){
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");
        return DriverManager.getConnection(url, username, password);
    }
}
