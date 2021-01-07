package com.example.dao;

import java.util.List;

import com.example.model.ERSReimbursement;

public interface H2Dao {
	// CRUD Methods

	// CREATE
	/**
	 * Inserts a temporary Reimbursement locally with H2
	 * 
	 * @param eR Reimbursement instance to be inserted locally
	 */
	public void insertERSReimbursement(ERSReimbursement eR);

	// READ
	/**
	 * Selects all temporary Reimbursements locally with H2
	 * 
	 * @return List of all ERSReimbursements locally
	 */
	public List<ERSReimbursement> selectAllERSReimbursements();

	/**
	 * Selects a temporary Reimbursement by ID locally with H2
	 * 
	 * @param eR Reimbursement instance to be compared against local IDs
	 * @return Reimbursement verified locally
	 */
	public ERSReimbursement selectERSReimbursementByID(ERSReimbursement eR);

	// UPDATE
	/**
	 * Updates a temporary Reimbursement locally with H2
	 * 
	 * @param eR Reimbursement instance to be updated locally
	 */
	public void updateERSReimbursement(ERSReimbursement eR);

	// DELETE
	/**
	 * Deletes a temporary Reimbursement locally with H2
	 * 
	 * @param eR Reimbursement instance to be deleted locally
	 */
	public void deleteERSReimbursement(ERSReimbursement eR);

	// H2
	/**
	 * H2 Database Initialization within the H2 Dao layer upon set-up
	 */
	public void h2InitDao();

	/**
	 * H2 Database Destruction within the H2 Dao layer upon tear-down
	 */
	public void h2DestroyDao();
}
