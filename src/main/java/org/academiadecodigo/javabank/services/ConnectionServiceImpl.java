package org.academiadecodigo.javabank.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionServiceImpl{
    private Connection connection = null;

    public Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabank.sql", "root", "");
            }
        } catch (SQLException ex) {
            System.out.println("Failure to connect to database: " + ex.getMessage());
        }
        return connection;
    }
    public void close(){
        try{
            if (connection != null){
                connection.close();
            }
        }
        catch (SQLException ex){
            System.out.println("Failure to close database connections: " + ex.getMessage());
        }
    }
}
