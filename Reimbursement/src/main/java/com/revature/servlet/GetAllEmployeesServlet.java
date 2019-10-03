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
import com.revature.daos.EmployeesDAOImpl;

@WebServlet("/getAllEmployees")
public class GetAllEmployeesServlet extends HttpServlet {

	private static final long serialVersionUID = 6727265780782089769L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			EmployeesDAOImpl empDAO = new EmployeesDAOImpl();
			List<Employees> empList = empDAO.getEmployees();
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(empList));
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
