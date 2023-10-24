package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // соеденение с БД
    private static final String URL = "jdbc:postgresql://localhost:5432/test";
    private static final String User = "amdin";
    private static final String Pass = "admin";

    public static Connection connection (){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, User, Pass);
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        return connection;
    }
}
