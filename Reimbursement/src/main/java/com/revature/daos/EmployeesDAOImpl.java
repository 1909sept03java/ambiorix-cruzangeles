package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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

		try (Connection con = ConnectionService.getConnection();) {

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Employees getEmployeesById(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
