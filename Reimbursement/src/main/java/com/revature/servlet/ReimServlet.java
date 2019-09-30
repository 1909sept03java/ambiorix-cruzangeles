package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employees;
import com.revature.beans.Reimbursements;
import com.revature.daos.ReimbursementsDAOImpl;

// taking the place of a mapping within my web.xml - annotation-based config vs xml config
@WebServlet("/reimsession")
public class ReimServlet extends HttpServlet {

	private static final long serialVersionUID = -1319793763433572026L;

	// return a JSON representation of the currently authenticated user for a
	// requests JSESSIONID
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// grab current session, if it exists, otherwise return null
		HttpSession session = req.getSession(false);
		try {
			/*
			 * the following code puts all employees in /session
			 * EmployeesDAOImpl empDAO = new EmployeesDAOImpl();
			 * List<Employees> empList = empDAO.getEmployees();
			 * resp.getWriter().write((new ObjectMapper()).writeValueAsString(empList));
			 */
			
			// the following code just gets the CURRENT USER INFO into the /session tab
			Employees emp = new Employees();
			emp.setEmployeeId(Integer.parseInt(session.getAttribute("employeeId").toString()));
			emp.setEmployeeUsername(session.getAttribute("employeeUsername").toString());
			emp.setEmployeePassword(session.getAttribute("employeePassword").toString());
			emp.setEmployeeEmail(session.getAttribute("employeeEmail").toString());
			emp.setEmployeeManagerId(Integer.parseInt(session.getAttribute("employeeManagerId").toString()));
			ReimbursementsDAOImpl reimDAO = new ReimbursementsDAOImpl();
			List<Reimbursements> reimList = reimDAO.getReimbursementsByEmployeeId(emp.getEmployeeId());
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(reimList));
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
