package com.example.service;

import java.util.List;

import com.example.model.ERSUsers;

public interface ERSUsersService {

	// READ
	/**
	 * Calls the Dao Layer READ all method of CRUD implementation
	 * 
	 * @return List of all ERSUsers for client-side
	 */
	public List<ERSUsers> getAllUsers();

	/**
	 * Calls the Dao Layer READ method of CRUD implementation
	 * 
	 * @param eU User instance to be compared against client-side IDs
	 * @return User verified server-side
	 */
	public ERSUsers getUserByID(ERSUsers eU);

	/**
	 * Calls the Dao Layer READ method of CRUD implementation
	 * 
	 * @param eU User instance to be compared against client-side usernames
	 * @return User verified server-side
	 */
	public ERSUsers getUserByUsername(ERSUsers eU);
}