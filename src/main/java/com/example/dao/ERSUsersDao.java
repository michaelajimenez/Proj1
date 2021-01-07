package com.example.dao;

import java.util.List;

import com.example.model.ERSUsers;

public interface ERSUsersDao {
	// CRUD Methods

	// CREATE
	/**
	 * Unused insert method for future-proofing
	 * 
	 * @param eU User instance to be inserted server-side
	 */
	public void insertERSUser(ERSUsers eU);

	// READ
	/**
	 * Selects all server-side ERSUsers
	 * 
	 * @return List of all ERSUsers from server-side
	 */
	public List<ERSUsers> selectAllERSUsers();

	/**
	 * Selects a server-side ERSUser by server-side ID
	 * 
	 * @param eU User instance to be compared against server-side IDs
	 * @return User verified server-side
	 */
	public ERSUsers selectERSUserByID(ERSUsers eU);

	/**
	 * Selects a server-side ERSUser by server-side username
	 * 
	 * @param eU User instance to be compared against server-side usernames
	 * @return User verified server-side
	 */
	public ERSUsers selectERSUserByUsername(ERSUsers eU);

	// UPDATE
	/**
	 * Unused update method for future-proofing
	 * 
	 * @param eU User Instance to be updated server-side
	 */
	public void updateERSUser(ERSUsers eU);

	// DELETE
	/**
	 * Unused delete method for future-proofing
	 * 
	 * @param eU User instance to be deleted server-side
	 */
	public void deleteERSUser(ERSUsers eU);
}