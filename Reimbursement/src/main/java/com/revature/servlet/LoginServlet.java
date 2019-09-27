package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Credentials;
import com.revature.beans.Employees;
import com.revature.service.AuthenticationService;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 817105812389880890L;
	private AuthenticationService authService = new AuthenticationService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// serve the login.html page as a response
		// RequestDispatcher is used to perform a 'forward'
		// (pass the request to another resource without the client knowing)
		req.getRequestDispatcher("Login.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// grab credentials from the request - use getParameter for form data
		// String username = req.getParameter("username");
		// String password = req.getParameter("password");
		// System.out.println("username: "+username+" password: "+password);
		// if the request was not form data then it can be get using a bunch of other methods
		// check whether a session already exists, and create one if not
		// overloaded version takes a boolean parameter, if false returns null
		// if not session exists matching the incomind request's JESSIONID token
		HttpSession session = req.getSession();
		Credentials creds = new Credentials();
		creds.setUsername(req.getParameter("username"));
		creds.setPassword(req.getParameter("password"));
		// passing the responsibility for performing auth logic to a service
		Employees emp = authService.authenticateUser(creds);
		if (emp != null) {
			// they're real
			System.out.println("Employee exists");
			System.out.println(emp.toString());
			session.setAttribute("employeeId", emp.getEmployeeId());
			session.setAttribute("employeeUsername", emp.getEmployeeUsername());
			session.setAttribute("employeePassword", emp.getEmployeePassword());
			session.setAttribute("employeeEmail", emp.getEmployeeEmail());
			session.setAttribute("employeeManagerId", emp.getEmployeeManagerId());
			// req.getRequestDispatcher("profile").forward(req, resp);
			resp.sendRedirect("profile");
		} else {
			// they're not real
			// resp.getWriter().write("Invalid Credentials!");
			// redirect back to login
			session.setAttribute("problem", "Invalid Credentials");
			System.out.println("User doesn't exists");
			resp.sendRedirect("login");
		}
	}
	
}
