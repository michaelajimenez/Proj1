package com.example.model;

public class ERSUsers {

	private long userID;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private long roleID;

	/**
	 * No Args Constructor
	 */
	public ERSUsers() {
	}

	/**
	 * All Args Constructor
	 * 
	 * @param userID    ID of User
	 * @param username  Username of User
	 * @param password  Password of User
	 * @param firstName First Name of User
	 * @param lastName  Last Name of User
	 * @param email     Email of User
	 * @param roleID    Role ID of User
	 */
	public ERSUsers(long userID, String username, String password, String firstName, String lastName, String email,
			long roleID) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleID = roleID;
	}

	/*
	 * Getters and Setters
	 */

	/**
	 * Getter for User ID
	 * 
	 * @return User ID retrieved
	 */
	public long getUserID() {
		return userID;
	}

	/**
	 * Setter for User ID
	 * 
	 * @param userID User ID change
	 */
	public void setUserID(long userID) {
		this.userID = userID;
	}

	/**
	 * Getter for Username
	 * 
	 * @return Username retrieved
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setter for Username
	 * 
	 * @param username Username change
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Getter for User Password
	 * 
	 * @return User Password retrieved
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter for User Password
	 * 
	 * @param password User Password change
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter for User First Name
	 * 
	 * @return User First Name retrieved
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter for User First Name
	 * 
	 * @param firstName User First Name change
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter for User Last Name
	 * 
	 * @return User Last Name retrieved
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter for User Last Name
	 * 
	 * @param lastName User Last Name change
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter for User Email
	 * 
	 * @return User Email retrieved
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter for User Email
	 * 
	 * @param email User Email change
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter for User Role ID
	 * 
	 * @return User Role ID retrieved
	 */
	public long getRoleID() {
		return roleID;
	}

	/**
	 * Setter for User Role ID
	 * 
	 * @param roleID User Role ID change
	 */
	public void setRoleID(long roleID) {
		this.roleID = roleID;
	}

	/*
	 * toString() Override
	 */
	@Override
	public String toString() {
		return "ERSUsers [userID=" + userID + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", roleID=" + roleID + "]";
	}
}