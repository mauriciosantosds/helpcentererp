package com.br.helpcenter.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mauriciods
 */
public class ConnectionFactory {
    
    private static final String USER = "root";
    private static final String PASSWORD = "3421";
    private static final String URL = "jdbc:mysql://localhost:3306/helpcenter";
    
        public static Connection getConnection() {
             try {
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

        }
}
