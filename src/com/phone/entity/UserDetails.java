package com.phone.entity;

public class UserDetails {

	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;

	public UserDetails() {
		super();
	}

	public UserDetails(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public UserDetails(String firstname, String lastname, String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Generating toString() method

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", password=" + password + "]";
	}

}
