package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL= "jdbc:mysql://localhost:3306/kata";
    private static final String USERNAME="root";
    private static final String PASSWORD ="aA5771521";
    public static void main(String[] args) {
        Connection connection;

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
