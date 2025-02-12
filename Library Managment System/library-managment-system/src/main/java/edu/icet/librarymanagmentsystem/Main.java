package edu.icet.librarymanagmentsystem;

import edu.icet.librarymanagmentsystem.dbconnection.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection= DBConnection.getInstance().getConnection();
        System.out.println(connection);
        Starter.main(args);

    }
}