package com.revature.daos;

import java.util.List;

import com.revature.beans.Reimbursements;

public interface ReimbursementsDAO {

	/*
	 * a "contract" with useful functions for the Reimbursements
	 */
	
	public List<Reimbursements> getReimbursements();
	public List<Reimbursements> getReimbursementsByEmployeeId(int employeeId);
	public void createReimbursements(double reimbursementBalance, int employeeId);
	public void updateReimbursements(int reimbursementId, String reimbursementStatus);
	public void deleteReimbursements();
	public List<Reimbursements> getAllPending();
	public List<Reimbursements> getAllResolved();
	
}
