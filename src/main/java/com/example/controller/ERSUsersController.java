package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.example.dao.MyLoggerFactory;
import com.example.model.ERSUsers;
import com.example.service.ERSUsersService;
import com.example.service.ERSUsersServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ERSUsersController {

	public static ERSUsersService myServ = new ERSUsersServiceImpl();

	final static Logger logger = Logger.getLogger(MyLoggerFactory.class);

	public static void allFinder(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException {
		List<ERSUsers> myUserList = myServ.getAllUsers();
		res.getWriter().write(new ObjectMapper().writeValueAsString(myUserList));
		logger.info("All reimbursements were found. Returning...");
	}
}