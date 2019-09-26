package com.revature.daos;

import java.util.List;

import com.revature.beans.Reimbursements;

public interface ReimbursementsDAO {

	/*
	 * a "contract" with useful functions for the Reimbursements
	 */
	
	public List<Reimbursements> getReimbursements();
	public Reimbursements getReimbursementsById();
	public void createReimbursements();
	public void updateReimbursements();
	public void deleteReimbursements();
	
}
