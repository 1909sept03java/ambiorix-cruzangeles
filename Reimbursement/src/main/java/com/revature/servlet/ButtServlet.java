package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daos.ReimbursementsDAOImpl;

@WebServlet("/butt")
public class ButtServlet extends HttpServlet {

	private static final long serialVersionUID = 1410349050301361739L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		String verdict = req.getParameter("verdict");
		int id = Integer.parseInt(req.getParameter("id"));
		ReimbursementsDAOImpl reimDAO = new ReimbursementsDAOImpl();
		reimDAO.updateReimbursements(id, verdict);
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
}
