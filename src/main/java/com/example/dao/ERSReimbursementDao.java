package com.example.dao;

import java.util.List;

import com.example.model.ERSReimbursement;

public interface ERSReimbursementDao {
	// CRUD Methods

	// CREATE
	/**
	 * Inserts an ERSReimbursement server-side
	 * 
	 * @param eR Reimbursement instance to be inserted server-side
	 */
	public void insertERSReimbursement(ERSReimbursement eR);

	// READ
	/**
	 * Selects all server-side ERSReimbursements
	 * 
	 * @return List of all ERSReimbursements from server-side
	 */
	public List<ERSReimbursement> selectAllERSReimbursements();

	/**
	 * Selects a server-side ERSReimbursement by server-side ID
	 * 
	 * @param eR Reimbursement instance to be compared against server-side IDs
	 * @return Reimbursement verified server-side
	 */
	public ERSReimbursement selectERSReimbursementByID(ERSReimbursement eR);

	// UPDATE
	/**
	 * Updates a server-side ERSReimbursement
	 * 
	 * @param eR Reimbursement instance to be updated server-side
	 */
	public void updateERSReimbursement(ERSReimbursement eR);

	// DELETE
	/**
	 * Deletes a server-side ERSReimbursement
	 * 
	 * @param eR Reimbursement instance to be deleted server-side
	 */
	public void deleteERSReimbursement(ERSReimbursement eR);
}