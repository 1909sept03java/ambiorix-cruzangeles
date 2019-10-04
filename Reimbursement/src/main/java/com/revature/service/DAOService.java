package com.revature.service;

import java.util.List;

import com.revature.beans.Employees;
import com.revature.beans.Reimbursements;
import com.revature.daos.EmployeesDAO;
import com.revature.daos.ReimbursementsDAO;

public class DAOService {

	private static EmployeesDAO emp;

	private static ReimbursementsDAO reim;

	private static List<Employees> getEmployees() {
		return emp.getEmployees();
	}

	private static Employees getEmployeesById(int employeeId) {
		return emp.getEmployeesById(employeeId);
	}

	private static boolean updateEmployees(int employeeId, String username, String password) {
		emp.updateEmployees(employeeId, username, password);
		return true;
	}

	private static List<Reimbursements> getReimbursements() {
		return reim.getReimbursements();
	}

	private static List<Reimbursements> getReimbursementsByEmployeeId(int employeeId) {
		return reim.getReimbursementsByEmployeeId(employeeId);
	}

	private boolean createReimbursements(double reimbursementBalance, int employeeId) {
		reim.createReimbursements(reimbursementBalance, employeeId);
		return true;
	}

	private boolean updateReimbursements(int reimbursementId, String reimbursementStatus) {
		reim.updateReimbursements(reimbursementId, reimbursementStatus);
		return true;
	}

	private List<Reimbursements> getAllPending() {
		return reim.getAllPending();
	}

	private List<Reimbursements> getAllResolved() {
		return reim.getAllResolved();
	}

}
