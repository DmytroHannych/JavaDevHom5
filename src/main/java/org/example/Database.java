package org.example;

import java.sql.*;

public class Database {
    private final static String DATABASE_URL ="jdbc:h2:~/test3";
    private final static Database DATABASE = new Database();
    Connection connection;

    private Database()  {
        try {
            connection = DriverManager.getConnection(DATABASE_URL);
        } catch (SQLException e) {
         e.printStackTrace();
        }
    }

    public static Database getInstance(){return DATABASE;}
    public Connection getConnection (){return connection;}

    public int executeUpdate(String  sql){

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
