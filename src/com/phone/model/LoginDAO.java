package com.phone.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.phone.connection.DBConnectionProvider;
import com.phone.entity.UserDetails;

public class LoginDAO {

	// =======================================================================================================================================//

	// QUERY FOR LOGGING THE USER INFORMATION

	// =======================================================================================================================================//

	private static final String SELECT_LOGIN_USER = "select * from register_login where username=? and password=?";

	// =======================================================================================================================================//

	// DATABASE LOGIC FOR LOGIN THE USER INFORMATION

	// =======================================================================================================================================//

	public UserDetails loginUser(String username, String password) {

		UserDetails user = null;
		PreparedStatement preparedstatement = null;
		Connection connection = null;
		ResultSet result = null;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedstatement = connection.prepareStatement(SELECT_LOGIN_USER);
			System.out.println("LOGIN DETAILS:- " + preparedstatement);

			preparedstatement.setString(1, username);
			preparedstatement.setString(2, password);

			result = preparedstatement.executeQuery();

			while (result.next()) {
				user = new UserDetails();
				user.setId(result.getInt(1));
				user.setFirstname(result.getString(2));
				user.setLastname(result.getString(3));
				user.setUsername(result.getString(4));
				user.setPassword(result.getString(5));
			}
		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}

		return user;
	}

	// =======================================================================================================================================//

}
