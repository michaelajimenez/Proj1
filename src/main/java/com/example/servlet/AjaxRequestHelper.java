package com.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.example.controller.ERSReimbursementController;
import com.example.controller.ERSUsersController;
import com.example.dao.MyConnectionFactory;
import com.example.dao.MyLoggerFactory;
import com.example.model.ERSUsers;
import com.example.service.ERSUsersService;
import com.example.service.ERSUsersServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AjaxRequestHelper {

	final static Logger logger = Logger.getLogger(MyLoggerFactory.class);

	public static void process(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException {
		logger.info("Ajax Request is now processing...");
		switch (req.getRequestURI()) {
		case "/Project1/api/ajax/allReimbursements":
			ERSReimbursementController.allFinder(req, res);
			break;
		case "/Project1/api/ajax/sendUpdate":
			ERSReimbursementController.sendUpdate(req, res);
			break;
		case "/Project1/api/ajax/denyReimb":
			ERSReimbursementController.denyReimbursement(req, res);
			break;
		case "/Project1/api/ajax/allUsers":
			ERSUsersController.allFinder(req, res);
			break;
		default:
			res.getWriter().println("null");
		}
	}
}