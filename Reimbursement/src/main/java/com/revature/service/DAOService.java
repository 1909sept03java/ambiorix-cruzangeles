package com.revature.service;

import java.util.List;

import com.revature.beans.Employees;
import com.revature.beans.Reimbursements;
import com.revature.daos.EmployeesDAO;
import com.revature.daos.EmployeesDAOImpl;
import com.revature.daos.ReimbursementsDAO;
import com.revature.daos.ReimbursementsDAOImpl;

public class DAOService {

	public static List<Employees> getEmployees() {
		EmployeesDAO emp = new EmployeesDAOImpl();
		return emp.getEmployees();
	}

	public static Employees getEmployeesById(int employeeId) {
		EmployeesDAO emp = new EmployeesDAOImpl();
		return emp.getEmployeesById(employeeId);
	}

	public static boolean updateEmployees(int employeeId, String username, String password) {
		EmployeesDAO emp = new EmployeesDAOImpl();
		emp.updateEmployees(employeeId, username, password);
		return true;
	}

	public static List<Reimbursements> getReimbursements() {
		ReimbursementsDAO reim = new ReimbursementsDAOImpl();
		return reim.getReimbursements();
	}

	public static List<Reimbursements> getReimbursementsByEmployeeId(int employeeId) {
		ReimbursementsDAO reim = new ReimbursementsDAOImpl();
		return reim.getReimbursementsByEmployeeId(employeeId);
	}

	public static boolean createReimbursements(double reimbursementBalance, int employeeId, int employeeManagerId) {
		ReimbursementsDAO reim = new ReimbursementsDAOImpl();
		reim.createReimbursements(reimbursementBalance, employeeId, employeeManagerId);
		return true;
	}

	public static boolean updateReimbursements(int reimbursementId, String reimbursementStatus) {
		ReimbursementsDAO reim = new ReimbursementsDAOImpl();
		reim.updateReimbursements(reimbursementId, reimbursementStatus);
		return true;
	}

	public static List<Reimbursements> getAllPending() {
		ReimbursementsDAO reim = new ReimbursementsDAOImpl();
		return reim.getAllPending();
	}

	public static List<Reimbursements> getAllResolved() {
		ReimbursementsDAO reim = new ReimbursementsDAOImpl();
		return reim.getAllResolved();
	}

	public static List<Reimbursements> getReimbursementsByEmployeeManagerId(int employeeManagerId) {
		ReimbursementsDAO reim = new ReimbursementsDAOImpl();
		return reim.getReimbursementsByEmployeeMangerId(employeeManagerId);
	}

}
