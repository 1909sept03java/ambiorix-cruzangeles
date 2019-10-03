package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daos.ReimbursementsDAOImpl;

@WebServlet("/createReim")
public class CreateReimServlet extends HttpServlet {

	private static final long serialVersionUID = 8963444282420917325L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		ReimbursementsDAOImpl reim = new ReimbursementsDAOImpl();
		reim.createReimbursements(Double.parseDouble(req.getParameter("reimBal")), Integer.parseInt(session.getAttribute("employeeId").toString()));
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
