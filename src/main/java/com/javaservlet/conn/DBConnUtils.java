package com.javaservlet.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtils {
    public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
        String hostName = "localhost";
        String dbName = "Servlet";
        String userName = "postgres";
        String password = "longdh9901";

        return getDBConnection(hostName, dbName, userName, password);
    }

    public static Connection getDBConnection(String hostName, String dbName, String userName, String password) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String connectionUrl = "jdbc:postgresql://" +  hostName + ":5432/" + dbName;
        Connection conn = DriverManager.getConnection(connectionUrl, userName, password);

        return conn;
    }

}


