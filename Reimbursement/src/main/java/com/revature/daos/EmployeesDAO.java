package com.revature.daos;

import java.util.List;

import com.revature.beans.Employees;

public interface EmployeesDAO {

	// function used to get all employees from the database
	public List<Employees> getEmployees();

	// get a specific employee by his id
	public Employees getEmployeesById(int employeeId);

	// update a specific employee's username and password
	public void updateEmployees(int employeeId, String username, String password);

}
