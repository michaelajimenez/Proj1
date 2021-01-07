package com.example.controller;

import javax.servlet.http.HttpServletRequest;

public class HomeController {

	public static String home(HttpServletRequest req) {
		return "/resources/html/home.html";
	}

	public static String employeeHome(HttpServletRequest req) {
		return "/resources/html/employeehome.html";
	}

	public static String newRequest(HttpServletRequest req) {
		return "/resources/html/newrequest.html";
	}
}