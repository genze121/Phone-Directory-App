package com.phone.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.phone.connection.DBConnectionProvider;
import com.phone.entity.UserDetails;

public class RegisterDAO {

	// =======================================================================================================================================//

	// QUERY FOR REGISTERING THE USER INFORMATION

	// =======================================================================================================================================//

	private static final String INSERT_REGISTER_USER = "insert into register_login"
			+ "(firstname,lastname,username,password)" + "values(?,?,?,?)";

	// =======================================================================================================================================//

	// DATABASE LOGIC FOR REGISTRATION THE USER INFORMATION

	// =======================================================================================================================================//

	public boolean registerUser(UserDetails users) {

		boolean register = false;
		PreparedStatement preparedstatement;
		Connection connection;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedstatement = connection.prepareStatement(INSERT_REGISTER_USER);
			System.out.println("QUERY DETAILS:- " + preparedstatement);

			preparedstatement.setString(1, users.getFirstname());
			preparedstatement.setString(2, users.getLastname());
			preparedstatement.setString(3, users.getUsername());
			preparedstatement.setString(4, users.getPassword());

			int registeredUser = preparedstatement.executeUpdate();

			if (registeredUser < 0 || registeredUser != 1) {
				register = true;
				System.out.println("User information is not registered.Please try again....");
			} else if (registeredUser == 1 || registeredUser > 0) {
				register = true;
				System.out.println("User information is registered successfully.You can Login Now...");
			} else {
				System.out.println("Something went wrong the server.Please try again.....");
			}
		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}

		return register;
	}

	// =======================================================================================================================================//

}
