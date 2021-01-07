package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.example.dao.MyLoggerFactory;
import com.example.model.ERSUsers;
import com.example.service.ERSUsersService;
import com.example.service.ERSUsersServiceImpl;

public class LoginController {

	public static ERSUsersService myServ = new ERSUsersServiceImpl();

	public static String loggedU = null;
	public static String loggedP = null;
	public static Long loggedID = null;

	final static Logger logger = Logger.getLogger(MyLoggerFactory.class);

	public static String login(HttpServletRequest req) {
		loggedU = null;
		loggedP = null;
		loggedID = null;

		if (!req.getMethod().equals("POST")) {
			return "/index.html";
		}
		List<ERSUsers> myList = myServ.getAllUsers();

		// extracting the form data
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		boolean isFound = false;

		for (ERSUsers e : myList) {
			if (!username.equals(e.getUsername()) || !password.equals(e.getPassword())) {
			} else {
				req.getSession().setAttribute("loggedusername", username);
				req.getSession().setAttribute("loggedpassword", password);
				req.getSession().setAttribute("loggedID", e.getUserID());
				loggedU = e.getUsername();
				loggedP = e.getPassword();
				loggedID = e.getUserID();
				logger.info("Logged username, password, and ID successfully...");

				isFound = true;

				if (e.getRoleID() == 1) {
					logger.info("Successful Admin log-in, forwarding to financial manager home...");
					return "/api/forwarding/home";
				}
				if (e.getRoleID() == 2) {
					logger.info("Successful Employee log-in, forwarding to employee home...");
					return "/api/forwarding/employeehome";
				}
			}
		}

		if (isFound == false) {
			logger.info("Incorrect credentials, returning to login...");
			return "/api/forwarding/incorrectcredentials";
		} else {
			logger.info("Unforseen success, forwarding to home...");
			return "/api/forwarding/home";
		}
	}
}