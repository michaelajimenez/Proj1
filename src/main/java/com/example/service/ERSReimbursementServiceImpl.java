package com.example.service;

import java.util.List;

import com.example.dao.ERSReimbursementDao;
import com.example.dao.ERSReimbursementDaoImpl;
import com.example.model.ERSReimbursement;

public class ERSReimbursementServiceImpl implements ERSReimbursementService {

	ERSReimbursementDao myDao = new ERSReimbursementDaoImpl();

	@Override
	public List<ERSReimbursement> getAllReimbursements() {
		return myDao.selectAllERSReimbursements();
	}

	@Override
	public ERSReimbursement getReimbursementByID(ERSReimbursement eR) {
		return myDao.selectERSReimbursementByID(eR);
	}

	@Override
	public void createReimbursementRequest(ERSReimbursement eR) {
		myDao.insertERSReimbursement(eR);
	}

	@Override
	public void updateReimbursement(ERSReimbursement eR) {
		myDao.updateERSReimbursement(eR);
	}

	@Override
	public void deleteReimbursement(ERSReimbursement eR) {
		myDao.deleteERSReimbursement(eR);
	}
}