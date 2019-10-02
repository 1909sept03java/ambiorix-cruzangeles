package com.revature.service;

import java.util.List;

import com.revature.beans.Credentials;
import com.revature.beans.Employees;
import com.revature.daos.EmployeesDAOImpl;

public class AuthenticationService {

	public Employees authenticateUser(Credentials creds) {
		// if the credentials are not recognized, return null
		// if they are, return employee associated with creds
		Employees emp = new Employees();
		// getting all employees from database
		EmployeesDAOImpl empDAO = new EmployeesDAOImpl();
		List<Employees> empList = empDAO.getEmployees();
		// looping through the list of employees looking for the user
		for (int i = 0; i < empList.size(); i++) {
			// if username and password match with array, return that employee
			if (empList.get(i).getEmployeeUsername().equals(creds.getUsername())
					&& empList.get(i).getEmployeePassword().equals(creds.getPassword())) {
				emp = empList.get(i);
				return emp;
			}
		}
		return null;
	}
}
