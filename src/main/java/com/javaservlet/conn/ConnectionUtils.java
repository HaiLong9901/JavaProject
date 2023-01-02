package com.javaservlet.conn;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        return DBConnUtils.getDBConnection();
    }

    public static void closeQuietly(Connection conn) {
        try{
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void rollbackQuitely(Connection conn) {
        try{
            conn.rollback();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
