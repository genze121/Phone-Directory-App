package com.phone.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.phone.connection.DBConnectionProvider;
import com.phone.entity.ContactDetails;

public class ContactDAO {

	// =======================================================================================================================================//

	// 1) QUERY FOR ADDING THE USER INFORMATION
	// 2) QUERY FOR GETTING THE LIST OF CONTACT DETAILS
	// 3) QUERY FOR GETTING THE CONTACT DETAILS BY ID
	// 4) QUERY FOR UPDATING THE CONTACT DETAILS
	// 5) QUERY FOR DELETING THE CONTACT DETAILS

	// =======================================================================================================================================//

	private static final String INSERT_CONTACT_USER = "insert into contact_details"
			+ "(firstname,lastname,email,mob_no,about,userid)" + "values(?,?,?,?,?,?)";

	private static final String SELECT_CONTACT_BYLIST = "select * from contact_details where userid=?";

	private static final String SELECT_CONTACT_BYID = "select * from contact_details where id=?";

	private static final String UPDATE_CONTACT = "update contact_details set firstname=?,lastname=?,email=?,mob_no=?,about=?,userid=? where id=?";

	private static final String DELETE_CONTACT = "delete from contact_details where id=?";

	// =======================================================================================================================================//

	// DATABASE LOGIC FOR ADDING THE USER INFORMATION

	// =======================================================================================================================================//

	public boolean saveContact(ContactDetails contact) {

		boolean contactInfo = false;
		PreparedStatement preparedstatement;
		Connection connection;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedstatement = connection.prepareStatement(INSERT_CONTACT_USER);

			preparedstatement.setString(1, contact.getFirstname());
			preparedstatement.setString(2, contact.getLastname());
			preparedstatement.setString(3, contact.getUsername());
			preparedstatement.setString(4, contact.getMobileNo());
			preparedstatement.setString(5, contact.getAbout());
			preparedstatement.setInt(6, contact.getUserId());

			int savedContact = preparedstatement.executeUpdate();

			if (savedContact < 0 || savedContact != 0) {
				contactInfo = true;
				System.out.println("Contact is not saved successfully!!!");
			} else if (savedContact == 1 || savedContact > 0) {
				contactInfo = true;
				System.out.println("Contact is saved successfully!!!");
			} else {
				System.out.println("Something went wrong on the server.Please try again....");
			}

		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}

		return contactInfo;

	}

	// =======================================================================================================================================//

	// DATABASE LOGIC FOR GETTING THE LIST OF CONTACT DETAILS

	// =======================================================================================================================================//

	public List<ContactDetails> getAllContactDetails(int uid) {

		List<ContactDetails> lists = new ArrayList<ContactDetails>();
		ContactDetails details = null;
		PreparedStatement preparedstatement = null;
		Connection connection = null;
		ResultSet result = null;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedstatement = connection.prepareStatement(SELECT_CONTACT_BYLIST);
			System.out.println(preparedstatement);

			preparedstatement.setInt(1, uid);
			result = preparedstatement.executeQuery();

			while (result.next()) {

				details = new ContactDetails();
				details.setId(result.getInt(1));
				details.setFirstname(result.getString(2));
				details.setLastname(result.getString(3));
				details.setUsername(result.getString(4));
				details.setMobileNo(result.getString(5));
				details.setAbout(result.getString(6));
				lists.add(details);

			}
		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}

		return lists;
	}

	// =======================================================================================================================================//

	// DATABASE LOGIC FOR GETTING THE CONTACT DETAILS BY ID

	// =======================================================================================================================================//

	public ContactDetails getContactById(int cid) {

		ContactDetails contact = null;
		PreparedStatement preparedstatement = null;
		Connection connection = null;
		ResultSet result = null;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedstatement = connection.prepareStatement(SELECT_CONTACT_BYID);
			System.out.println(preparedstatement);
			preparedstatement.setInt(1, cid);
			result = preparedstatement.executeQuery();

			while (result.next()) {
				contact = new ContactDetails();
				contact.setId(result.getInt(1));
				contact.setFirstname(result.getString(2));
				contact.setLastname(result.getString(3));
				contact.setUsername(result.getString(4));
				contact.setMobileNo(result.getString(5));
				contact.setAbout(result.getString(6));

			}

		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}
		return contact;
	}

	// =======================================================================================================================================//

	// DATABASE LOGIC FOR UPDATING THE CONTACT DETAILS

	// =======================================================================================================================================//

	public boolean updateContact(ContactDetails contact) {

		boolean updateContact = false;
		PreparedStatement preparedstatement;
		Connection connection;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedstatement = connection.prepareStatement(UPDATE_CONTACT);

			preparedstatement.setString(1, contact.getFirstname());
			preparedstatement.setString(2, contact.getLastname());
			preparedstatement.setString(3, contact.getUsername());
			preparedstatement.setString(4, contact.getMobileNo());
			preparedstatement.setString(5, contact.getAbout());
			preparedstatement.setInt(6, contact.getUserId());
			preparedstatement.setInt(7, contact.getId());

			int savedContact = preparedstatement.executeUpdate();

			if (savedContact < 0 || savedContact != 0) {
				updateContact = true;
				System.out.println("Contact is not updated successfully!!!");
			} else if (savedContact == 1 || savedContact > 0) {
				updateContact = true;
				System.out.println("Contact is updated successfully!!!");
			} else {
				System.out.println("Something went wrong on the server.Please try again....");
			}

		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}

		return updateContact;
	}

	// =======================================================================================================================================//

	// DATABASE LOGIC FOR DELETING THE CONTACT DETAILS

	// =======================================================================================================================================//

	public boolean deleteContactById(int cid) {

		boolean deleteContact = false;
		PreparedStatement preparedstatement;
		Connection connection;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedstatement = connection.prepareStatement(DELETE_CONTACT);
			preparedstatement.setInt(1, cid);

			int deletedContact = preparedstatement.executeUpdate();

			if (deletedContact < 0 || deletedContact != 0) {
				deleteContact = true;
				System.out.println("Contact is not deleted successfully!!!");
			} else if (deletedContact == 1 || deletedContact > 0) {
				deleteContact = true;
				System.out.println("Contact is deleted successfully!!!");
			} else {
				System.out.println("Something went wrong on the server.Please try again....");
			}
		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}

		return deleteContact;
	}

	// =======================================================================================================================================//

}
