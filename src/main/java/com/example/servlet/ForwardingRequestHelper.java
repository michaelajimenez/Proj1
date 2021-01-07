package com.example.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.example.controller.ERSReimbursementController;
import com.example.controller.HomeController;
import com.example.controller.LoginController;
import com.example.dao.MyLoggerFactory;

public class ForwardingRequestHelper {

	final static Logger logger = Logger.getLogger(MyLoggerFactory.class);

	public static String process(HttpServletRequest req, HttpServletResponse res) {
		logger.info("Forwarding Request is now processing...");

		switch (req.getRequestURI()) {
		case "/Project1/api/forwarding/login":
			return LoginController.login(req);
		case "/Project1/api/forwarding/employeehome":
			return HomeController.employeeHome(req);
		case "/Project1/api/forwarding/home":
			return HomeController.home(req);
		case "/Project1/api/forwarding/newrequest":
			return HomeController.newRequest(req);
		case "/Project1/api/forwarding/sendrequest":
			return ERSReimbursementController.sendRequest(req);
		case "/Project1/api/forwarding/logout":
			logger.info("Closing out of application. Until next time...");
			System.exit(0);
		default:
			return "/resources/html/badlogin.html";
		}
	}
}