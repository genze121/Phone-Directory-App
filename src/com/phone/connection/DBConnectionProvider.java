package com.phone.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionProvider {

	// =======================================================================================================================================//

	// PROVIDING DETAILS FOR MYSQL DB

	// =======================================================================================================================================//

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/phone_directory";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	// =======================================================================================================================================//

	// LOADING AND REGISTERING THE DRIVER

	// =======================================================================================================================================//

	private static String JDBC_DRIVER;
	static {
		try {
			JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// =======================================================================================================================================//

	// OPENING THE CONNECTION BETWEEN JDBC AND MYSQL DB

	// =======================================================================================================================================//

	@SuppressWarnings("unused")
	public static Connection getConnection() {

		Connection connection = null;
		try {
			if (connection == null) {
				connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				System.out.println("Connection is Established Successfully!!!");
			} else {
				System.out.println("Something went wrong on the server.Please rectify and try again....");
			}
		} catch (SQLException ex) {
			printSQLException(ex);
		}
		return connection;
	}

	// =======================================================================================================================================//

	// Defining Generic Exception

	// =======================================================================================================================================//

	public static void printSQLException(SQLException ex) {

		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQL State:- " + ((SQLException) e).getSQLState());
				System.err.println("Error Code:- " + ((SQLException) e).getErrorCode());
				System.err.println("Message Stack:- " + ((SQLException) e).getMessage());
				Throwable thrown = ex.getCause();
				while (thrown != null) {
					thrown = thrown.getCause();
				}

			}
		}

	}

	// =======================================================================================================================================//

}
