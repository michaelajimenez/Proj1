package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.example.dao.ERSConversionDao;
import com.example.dao.ERSConversionDaoImpl;
import com.example.dao.MyLoggerFactory;
import com.example.model.ERSReimbursement;
import com.example.service.ERSReimbursementService;
import com.example.service.ERSReimbursementServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sun.rmi.runtime.Log;

public class ERSReimbursementController {

	public static ERSConversionDao myConverter = new ERSConversionDaoImpl();
	public static ERSReimbursementService myServ = new ERSReimbursementServiceImpl();

	final static Logger logger = Logger.getLogger(MyLoggerFactory.class);

	public static void allFinder(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException {
		List<ERSReimbursement> myReimbList = myServ.getAllReimbursements();
		res.getWriter().write(new ObjectMapper().writeValueAsString(myReimbList));
		logger.info("All reimbursements were found. Returning...");
	}

	public static String sendRequest(HttpServletRequest req) {
		long leftLimit = 5L;
		long rightLimit = 100000L;
		long generatedID = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
		try {
			String amount = req.getParameter("amount");
			String description = req.getParameter("description");
			String id = null;
			try {
				id = LoginController.loggedID.toString();
			} catch (NullPointerException e) {
				logger.error("An error occurred", e);
				id = req.getParameter("authorID");
			}

			String date = req.getParameter("date");
			long type = myConverter.convertRequest(req.getParameter("type"));

			ERSReimbursement newR = new ERSReimbursement(generatedID, Double.parseDouble(amount), date, null,
					description, null, Long.parseLong(id), 0, 1, type);
			myServ.createReimbursementRequest(newR);
			logger.info("New request successfully made. Returning to employee home...");
		} catch (NullPointerException e) {
			logger.error("An error occurred", e);
			return "/resources/html/newrequest.html";
		}

		return "/resources/html/employeehome.html";
	}

	public static String sendUpdate(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String s = req.getReader().readLine();
		s = s.replace("{", "");
		s = s.replace("}", "");
		String[] newS = s.split(",");

		ERSReimbursement r = new ERSReimbursement();

		try {
			for (int i = 0; i < newS.length; i++) {
				String[] newS2 = newS[i].split("\"");
				newS2[2] = newS2[2].replace(":", "");

				if (i == 0) {
					r.setReimbID(Long.parseLong(newS2[2]));
				}
				if (i == 1) {
					r.setReimbAmount(Double.parseDouble(newS2[2]));
				}
				if (i == 2) {
					r.setReimbSubmitted(newS2[3]);
				}
				if (i == 3) {
					r.setReimbResolved(null);
				}
				if (i == 4) {
					r.setReimDescription(newS2[3]);
				}
				if (i == 5) {
					r.setReimbReciept(null);
				}
				if (i == 6) {
					r.setReimbAuthor(Long.parseLong(newS2[2]));
				}
				if (i == 7) {
					r.setReimbResolver(Long.parseLong(newS2[2]));
				}
				if (i == 8) {
					r.setReimbStatusID(Long.parseLong(newS2[2]));
				}
				if (i == 9) {
					r.setReimbTypeID(Long.parseLong(newS2[2]));
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			logger.error("An error occurred", e);
			// e.printStackTrace();
			return "/resources/html/badlogin.html";
		}

		List<ERSReimbursement> myReimbList = myServ.getAllReimbursements();

		for (ERSReimbursement e : myReimbList) {
			if (e.getReimbID() == r.getReimbID()) {
				myServ.updateReimbursement(r);
				logger.info("Approval of reimbursement successful. Returning to admin home...");
			}
		}

		return "/resources/html/home.html";
	}

	public static String denyReimbursement(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String s = req.getReader().readLine();
		s = s.replace("{", "");
		s = s.replace("}", "");
		String[] newS = s.split(",");

		ERSReimbursement r = new ERSReimbursement();

		for (int i = 0; i < newS.length; i++) {
			String[] newS2 = newS[i].split("\"");
			newS2[2] = newS2[2].replace(":", "");

			if (i == 0) {
				r.setReimbID(Long.parseLong(newS2[2]));
				System.out.println(r.getReimbID());
			}
			if (i == 1) {
				r.setReimbAmount(Double.parseDouble(newS2[2]));
			}
			if (i == 2) {
				r.setReimbSubmitted(newS2[3]);
			}
			if (i == 3) {
				r.setReimbResolved(null);
			}
			if (i == 4) {
				r.setReimDescription(newS2[3]);
			}
			if (i == 5) {
				r.setReimbReciept(null);
			}
			if (i == 6) {
				r.setReimbAuthor(Long.parseLong(newS2[2]));
			}
			if (i == 7) {
				r.setReimbResolver(Long.parseLong(newS2[2]));
			}
			if (i == 8) {
				r.setReimbStatusID(Long.parseLong(newS2[2]));
			}
			if (i == 9) {
				r.setReimbTypeID(Long.parseLong(newS2[2]));
			}
		}

		List<ERSReimbursement> myReimbList = myServ.getAllReimbursements();

		for (ERSReimbursement e : myReimbList) {
			if (e.getReimbID() == r.getReimbID()) {
				myServ.updateReimbursement(r);
				logger.info("Denial of reimbursement successful. Returning to admin home...");
			}
		}

		return "/resources/html/home.html";
	}
}