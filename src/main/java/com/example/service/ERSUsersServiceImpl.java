package com.example.service;

import java.util.List;

import com.example.dao.ERSUsersDao;
import com.example.dao.ERSUsersDaoImpl;
import com.example.model.ERSUsers;

public class ERSUsersServiceImpl implements ERSUsersService {

	ERSUsersDao myDao = new ERSUsersDaoImpl();

	@Override
	public List<ERSUsers> getAllUsers() {
		return myDao.selectAllERSUsers();
	}

	@Override
	public ERSUsers getUserByID(ERSUsers eU) {
		return myDao.selectERSUserByID(eU);
	}

	@Override
	public ERSUsers getUserByUsername(ERSUsers eU) {
		return myDao.selectERSUserByUsername(eU);
	}
}