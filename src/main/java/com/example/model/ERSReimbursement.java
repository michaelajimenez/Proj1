package com.example.model;

public class ERSReimbursement {

	private long reimbID;
	private double reimbAmount;
	private String reimbSubmitted;
	private String reimbResolved;
	private String reimbDescription;
	private Object reimbReciept;
	private long reimbAuthor;
	private long reimbResolver;
	private long reimbStatusID;
	private long reimbTypeID;

	/**
	 * No Args Constructor for ERSReimbursement
	 */
	public ERSReimbursement() {
	}

	/**
	 * All Arg Constructor for ERSReimbursement
	 * 
	 * @param reimbID          ID for Reimbursement
	 * @param reimbAmount      Amount for Reimbursement
	 * @param reimbSubmitted   Submitted Timestamp for Reimbursement
	 * @param reimbResolved    Resolved Timestamp for Reimbursement
	 * @param reimbDescription Description for Reimbursement
	 * @param reimbReciept     Reciept object for Reimbursement
	 * @param reimbAuthor      User ID for Reimbursement author
	 * @param reimbResolver    User ID for Reimbursement resolver
	 * @param reimbStatusID    Status ID for Reimbursement
	 * @param reimbTypeID      Type ID for Reimbursement
	 */
	public ERSReimbursement(long reimbID, double reimbAmount, String reimbSubmitted, String reimbResolved,
			String reimbDescription, Object reimbReciept, long reimbAuthor, long reimbResolver, long reimbStatusID,
			long reimbTypeID) {
		super();
		this.reimbID = reimbID;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbReciept = reimbReciept;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusID = reimbStatusID;
		this.reimbTypeID = reimbTypeID;
	}

	/*
	 * Getters and Setters
	 */

	/**
	 * Getter for Reimbursement ID
	 * 
	 * @return Reimbursement ID retrieved
	 */
	public long getReimbID() {
		return reimbID;
	}

	/**
	 * Setter for Reimbursement ID
	 * 
	 * @param reimbID Reimbursement ID change
	 */
	public void setReimbID(long reimbID) {
		this.reimbID = reimbID;
	}

	/**
	 * Getter for Reimbursement Amount
	 * 
	 * @return Reimbursement Amount retrieved
	 */
	public double getReimbAmount() {
		return reimbAmount;
	}

	/**
	 * Setter for Reimbursement Amount
	 * 
	 * @param reimbAmount Reimbursement Amount change
	 */
	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	/**
	 * Getter for Reimbursement Submitted
	 * 
	 * @return Reimbursement Submitted retrieved
	 */
	public String getReimbSubmitted() {
		return reimbSubmitted;
	}

	/**
	 * Setter for Reimbursement Submitted
	 * 
	 * @param reimbSubmitted Reimbursement Submitted change
	 */
	public void setReimbSubmitted(String reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	/**
	 * Getter for Reimbursement Resolved
	 * 
	 * @return Reimbursement Resolved retrieved
	 */
	public String getReimbResolved() {
		return reimbResolved;
	}

	/**
	 * Setter for Reimbursement Resolved
	 * 
	 * @param reimbResolved Reimbursement Resolved change
	 */
	public void setReimbResolved(String reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	/**
	 * Getter for Reimbursement Description
	 * 
	 * @return Reimbursement Description retrieved
	 */
	public String getReimDescription() {
		return reimbDescription;
	}

	/**
	 * Setter for Reimbursement Description
	 * 
	 * @param reimDescription Reimbursement Description change
	 */
	public void setReimDescription(String reimDescription) {
		this.reimbDescription = reimDescription;
	}

	/**
	 * Getter for Reimbursement Receipt
	 * 
	 * @return Reimbursement Receipt retrieved
	 */
	public Object getReimbReciept() {
		return reimbReciept;
	}

	/**
	 * Setter for Reimbursement Receipt
	 * 
	 * @param reimbReciept Reimbursement Receipt change
	 */
	public void setReimbReciept(Object reimbReciept) {
		this.reimbReciept = reimbReciept;
	}

	/**
	 * Getter for Reimbursement Author
	 * 
	 * @return Reimbursement Author retrieved
	 */
	public long getReimbAuthor() {
		return reimbAuthor;
	}

	/**
	 * Setter for Reimbursement Author
	 * 
	 * @param reimbAuthor Reimbursement Author change
	 */
	public void setReimbAuthor(long reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	/**
	 * Getter for Reimbursement Resolver
	 * 
	 * @return Reimbursement Resolver retrieved
	 */
	public long getReimbResolver() {
		return reimbResolver;
	}

	/**
	 * Setter for Reimbursement Resolver
	 * 
	 * @param reimbResolver Reimbursement Resolver change
	 */
	public void setReimbResolver(long reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	/**
	 * Getter for Reimbursement Status ID
	 * 
	 * @return Reimbursement Status ID retrieved
	 */
	public long getReimbStatusID() {
		return reimbStatusID;
	}

	/**
	 * Setter for Reimbursement Status ID
	 * 
	 * @param reimbStatusID Reimbursement Status ID change
	 */
	public void setReimbStatusID(long reimbStatusID) {
		this.reimbStatusID = reimbStatusID;
	}

	/**
	 * Getter for Reimbursement Type ID
	 * 
	 * @return Reimbursement Type ID retrieved
	 */
	public long getReimbTypeID() {
		return reimbTypeID;
	}

	/**
	 * Setter for Reimbursement Type ID
	 * 
	 * @param reimbTypeID Reimbursement Type ID change
	 */
	public void setReimbTypeID(long reimbTypeID) {
		this.reimbTypeID = reimbTypeID;
	}

	/*
	 * toString() Override
	 */
	@Override
	public String toString() {
		return "ERSReimbursement [reimbID=" + reimbID + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbReceipt=" + reimbReciept + ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver
				+ ", reimbStatusID=" + reimbStatusID + ", reimbTypeID=" + reimbTypeID + "]";
	}
}
