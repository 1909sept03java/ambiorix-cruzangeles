package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employees;

// taking the place of a mapping within my web.xml - annotation-based config vs xml config
@WebServlet("/employeeSession")
public class EmployeeSessionServlet extends HttpServlet {

	private static final long serialVersionUID = -1319793763433572026L;

	// return a JSON representation of the currently authenticated user for a
	// requests JSESSIONID
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// grab current session, if it exists, otherwise return null
		HttpSession session = req.getSession(false);
		try {
			// the following code just gets the CURRENT USER INFO into the /session tab
			Employees emp = new Employees();
			emp.setEmployeeId(Integer.parseInt(session.getAttribute("employeeId").toString()));
			emp.setEmployeeUsername(session.getAttribute("employeeUsername").toString());
			emp.setEmployeePassword(session.getAttribute("employeePassword").toString());
			emp.setEmployeeEmail(session.getAttribute("employeeEmail").toString());
			emp.setEmployeeManager(session.getAttribute("employeeManager").toString());
			emp.setEmployeeManagerId(Integer.parseInt(session.getAttribute("employeeManagerId").toString()));
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(emp));
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("{\"session\":null}");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
