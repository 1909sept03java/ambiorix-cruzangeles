package com.revature.service;

import java.util.List;

import com.revature.beans.Credentials;
import com.revature.beans.Employees;
import com.revature.daos.EmployeesDAOImpl;

public class AuthenticationService {

	public Employees authenticateUser(Credentials creds) {
		// if the credentials are not recognized, return null
		// if they are, return user associated with creds
		Employees emp = new Employees();
		EmployeesDAOImpl empDAO = new EmployeesDAOImpl();
		List<Employees> empList = empDAO.getEmployees();
		for (int i = 0; i < empList.size(); i++) {
			if (empList.get(i).getEmployeeUsername() == creds.getUsername() && empList.get(i).getEmployeePassword() == creds.getPassword()) {
				emp.setEmployeeId(empList.get(i).getEmployeeId());
				emp.setEmployeeUsername(empList.get(i).getEmployeeUsername());
				emp.setEmployeePassword(empList.get(i).getEmployeePassword());
				emp.setEmployeeEmail(empList.get(i).getEmployeeEmail());
				emp.setEmployeeManagerId(empList.get(i).getEmployeeManagerId());
				return emp;
			}
		}
		return null;
	}
}
