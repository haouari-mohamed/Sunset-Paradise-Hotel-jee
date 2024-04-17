package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBUtil {
	 public static void main(String[] args) {
		 private static final String url = "jdbc:mysql://localhost:3306/hotel_management";
		 private static final String username = "med";
		 private static final String password = "";

	     // Method to establish a database connection
	        public static Connection getConnection() throws SQLException {
	            return DriverManager.getConnection(url, username, password);
	        }

	        // Method to close a database connection
	        public static void close(Connection connection) {
	            if (connection != null) {
	                try {
	                    connection.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	        // Method to close a PreparedStatement
	        public static void close(PreparedStatement statement) {
	            if (statement != null) {
	                try {
	                    statement.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	        // Method to close a ResultSet
	        public static void close(ResultSet resultSet) {
	            if (resultSet != null) {
	                try {
	                    resultSet.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
}
