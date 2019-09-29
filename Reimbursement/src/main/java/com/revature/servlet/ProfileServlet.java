package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employees;
import com.revature.beans.Reimbursements;
import com.revature.daos.ReimbursementsDAOImpl;

public class ProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 8343002811379165553L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("employeeManagerId").equals(0)) {
			System.out.println("MANAGER ENTERED");
			req.getRequestDispatcher("Manager.html").forward(req, resp);
		} else if (session != null && !session.getAttribute("employeeManagerId").equals(0)) {
			System.out.println("EMPLOYEE ENTERED");
			req.getRequestDispatcher("Employee.html").forward(req, resp);
		} else {
			resp.sendRedirect("login");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
