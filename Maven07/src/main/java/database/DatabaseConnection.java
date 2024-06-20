package database;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    //private java.sql.Connection connection;
    private Connection connection;
    private String database_path = "D:\\Programowanie Obiektowe\\lab7\\site\\database.sqlite";
    public Connection getConnection() {
        return connection;
    }

    //DriverManager; .getConnection() gets connection
    //in () we put "jdbc:sqlite:+path"; jdbc for it to know it's a sqlite connection
    public void connect(String database_path) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:"+database_path);
        System.out.println("connected successfully");
    }
    public void disconnect() throws SQLException {
        connection.close();
        System.out.println("disconnected successfully");

    }
}
