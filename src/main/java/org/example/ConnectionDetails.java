package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDetails {

   // public static final String LoadDriver = "com.mysql.cj.jdbc.Driver";

    public static final String URL = "jdbc:mysql://localhost:3306/TruckManagementSys";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "password";

    public static Connection getconnection() throws SQLException {
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }


}
