package com.revature.daos;

import java.util.List;

import com.revature.beans.Reimbursements;

public interface ReimbursementsDAO {

	// function used to get all reimbursements
	public List<Reimbursements> getReimbursements();

	// function used to get all reimbursements of a specific employee by id
	public List<Reimbursements> getReimbursementsByEmployeeId(int employeeId);

	// function used to get all reimbursements of a specific employee by id
	public List<Reimbursements> getReimbursementsByEmployeeMangerId(int employeeManagerId);

	// function used to create reimbursements for a specific employee by id
	public void createReimbursements(double reimbursementBalance, int employeeId, int employeeManagerId);

	// function used to D = deny or A = approve a reimbursement
	public void updateReimbursements(int reimbursementId, String reimbursementStatus);

	// function used to get all pending reimbursements
	public List<Reimbursements> getAllPending();

	// function used to get all resolved reimbursements
	public List<Reimbursements> getAllResolved();

}
