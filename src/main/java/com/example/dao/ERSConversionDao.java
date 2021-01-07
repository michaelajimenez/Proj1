package com.example.dao;

public interface ERSConversionDao {
	/**
	 * Converts Reimbursement request type input to readable long
	 * 
	 * @param s String input by user client-side
	 * @return Readable long for reimbTypeID
	 */
	public long convertRequest(String s);
}