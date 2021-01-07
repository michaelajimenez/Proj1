package com.example.service;

import java.util.List;

import com.example.model.ERSReimbursement;

public interface ERSReimbursementService {

	// CREATE
	/**
	 * Calls the Dao Layer CREATE method of CRUD implementation
	 * 
	 * @param eR Reimbursement from client-side
	 */
	public void createReimbursementRequest(ERSReimbursement eR);

	// READ
	/**
	 * Calls the Dao Layer READ all method of CRUD implementation
	 * 
	 * @return List of all ERSReimbursements for client-side
	 */
	public List<ERSReimbursement> getAllReimbursements();

	/**
	 * Calls the Dao Layer READ method of CRUD implementation
	 * 
	 * @param eR Reimbursement instance to be compared against client-side IDs
	 * @return Reimbursement verified server-side
	 */
	public ERSReimbursement getReimbursementByID(ERSReimbursement eR);

	// UPDATE
	/**
	 * Calls the Dao Layer UPDATE method of CRUD implementation
	 * 
	 * @param eR Reimbursement instance to be compared against server-side
	 */
	public void updateReimbursement(ERSReimbursement eR);

	// DELETE
	/**
	 * Calls the Dao layer DELETE method of CRUD implementation
	 * 
	 * @param eR Reimbursement instance to be compared against server-side
	 */
	public void deleteReimbursement(ERSReimbursement eR);
}
