package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employees;
import com.revature.service.ConnectionService;

public class EmployeesDAOImpl implements EmployeesDAO {

	@Override
	public List<Employees> getEmployees() {

		/*
		 * this function will reach into the database and pull out all of the data,
		 * storing it into an ArrayList object and returning it
		 */

		List<Employees> empList = new ArrayList<Employees>();
		try (Connection con = ConnectionService.getConnection()) {
			// basic query string
			String sql = "SELECT * FROM EMPLOYEES";
			PreparedStatement ps = con.prepareStatement(sql);
			// getting the result set
			ResultSet rs = ps.executeQuery();
			// looping through the result set
			while (rs.next()) {
				// getting the information for an employee object
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String employeeUsername = rs.getString("EMPLOYEE_USERNAME");
				String employeePassword = rs.getString("EMPLOYEE_PASSWORD");
				String employeeEmail = rs.getString("EMPLOYEE_EMAIL");
				String employeeManager = rs.getString("EMPLOYEE_MANAGER");
				int employeeManagerId = rs.getInt("EMPLOYEE_MANAGER_ID");
				// pushing that employee into the list of employee's
				empList.add(new Employees(employeeId, employeeUsername, employeePassword, employeeEmail, employeeManager,
						employeeManagerId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// returning the employee list
		return empList;
	}

	@Override
	public Employees getEmployeesById(int employeeId) {

		/*
		 * this function will reach into the database and pull out a single row of the
		 * data, storing it into an Employees object and returning it
		 */

		// creating an emp object to return
		Employees emp = new Employees();
		try (Connection con = ConnectionService.getConnection()) {
			// basic query string
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			// setting the employee id of the query string
			ps.setInt(1, employeeId);
			// getting the result set
			ResultSet rs = ps.executeQuery();
			// looping through the result set
			while (rs.next()) {
				// getting information from the database and setting it into the emp object
				// setting the
				emp.setEmployeeId(employeeId);
				emp.setEmployeeUsername(rs.getString("EMPLOYEE_USERNAME"));
				emp.setEmployeePassword(rs.getString("EMPLOYEE_PASSWORD"));
				emp.setEmployeeEmail(rs.getString("EMPLOYEE_EMAIL"));
				emp.setEmployeeManager(rs.getString("EMPLOYEE_MANAGER"));
				emp.setEmployeeManagerId(rs.getInt("EMPLOYEE_MANAGER_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public void updateEmployees(int employeeId, String username, String password) {

		/*
		 * this function will update the username and password of an employee
		 * by his employee id
		 */
		
		try (Connection con = ConnectionService.getConnection()) {
			// basic query string
			String sql = "UPDATE EMPLOYEES SET EMPLOYEE_USERNAME = ?, EMPLOYEE_PASSWORD = ? WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			// setting the username, password, and employee id of the query string
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, employeeId);
			// execute the query and update the database
			ps.executeUpdate();
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

}
