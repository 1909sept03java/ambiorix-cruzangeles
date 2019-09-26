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
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "SELECT * FROM EMPLOYEES";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String employeeUsername = rs.getString("EMPLOYEE_USERNAME");
				String employeePassword = rs.getString("EMPLOYEE_PASSWORD");
				String employeeEmail = rs.getString("EMPLOYEE_EMAIL");
				int employeeManagerId = rs.getInt("EMPLOYEE_MANAGER_ID");
				empList.add(new Employees(employeeId, employeeUsername, employeePassword, employeeEmail, employeeManagerId));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empList;
	}

	@Override
	public Employees getEmployeesById(int employeeId) {
		
		/*
		 * this function will reach into the database and pull out a single row of the data,
		 * storing it into an Employees object and returning it
		 */

		Employees emp = new Employees();
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String employeeUsername = rs.getString("EMPLOYEE_USERNAME");
				String employeePassword = rs.getString("EMPLOYEE_PASSWORD");
				String employeeEmail = rs.getString("EMPLOYEE_EMAIL");
				int employeeManagerId = rs.getInt("EMPLOYEE_MANAGER_ID");
				emp.setEmployeeId(employeeId);
				emp.setEmployeeUsername(employeeUsername);
				emp.setEmployeePassword(employeePassword);
				emp.setEmployeeEmail(employeeEmail);
				emp.setEmployeeManagerId(employeeManagerId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}

}
