package com.text.index;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mysqlClass {
    static Connection connection;

    public static Connection getConnection() throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/qems", "root","");
        System.out.println("Database Successfully Connected");
        return connection;
    }

}
