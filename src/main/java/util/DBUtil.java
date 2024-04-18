package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    // Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/hotel_management";
    private static final String USER = "med"; // Replace with your MySQL username
    private static final String PASSWORD = ""; // Replace with your MySQL password

    // Method to establish a database connection
    public static Connection getConnection() throws SQLException {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create and return the connection
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            // Handle ClassNotFoundException
            e.printStackTrace();
            throw new SQLException("Database driver not found");
        }
    }

    // Method to close a database connection
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Handle SQLException
                e.printStackTrace();
            }
        }
    }
}
