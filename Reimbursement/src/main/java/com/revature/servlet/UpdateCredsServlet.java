package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daos.EmployeesDAO;
import com.revature.daos.EmployeesDAOImpl;
import com.revature.service.DAOService;

@WebServlet("/updateCreds")
public class UpdateCredsServlet extends HttpServlet {

	private static final long serialVersionUID = 9074319698831268150L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		int employeeId = Integer.parseInt(session.getAttribute("employeeId").toString());
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(employeeId + " " + username + " " + password);
		DAOService.updateEmployees(employeeId, username, password);
		resp.sendRedirect("logout");
	}
}
