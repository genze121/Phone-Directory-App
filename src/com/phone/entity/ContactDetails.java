package com.phone.entity;

public class ContactDetails {

	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String mobileNo;
	private String about;
	private int userId;

	public ContactDetails() {
		super();
	}

	public ContactDetails(int id, String firstname, String lastname, String username, String mobileNo, String about) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.mobileNo = mobileNo;
		this.about = about;
	}

	public ContactDetails(String firstname, String lastname, String username, String mobileNo, String about) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.mobileNo = mobileNo;
		this.about = about;
	}

	public ContactDetails(String firstname, String lastname, String username, String mobileNo, String about,
			int userId) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.mobileNo = mobileNo;
		this.about = about;
		this.userId = userId;
	}

	// Generating setters and getters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	// Generating toString() method

	@Override
	public String toString() {
		return "ContactDetails [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", mobileNo=" + mobileNo + ", about=" + about + ", userId=" + userId + "]";
	}

}
