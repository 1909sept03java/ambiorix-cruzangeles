package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 8343002811379165553L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// making sure the current session doesn't get killed
		HttpSession session = req.getSession(false);
		// managers are determined by having an employeeManagerId of 0
		// sending current authenticated user to either manager or employee pages
		if (session.getAttribute("employeeManager").equals("Y")) {
			System.out.println("MANAGER ENTERED");
			req.getRequestDispatcher("Manager.html").forward(req, resp);
		} else {
			System.out.println("EMPLOYEE ENTERED");
			req.getRequestDispatcher("Employee.html").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
