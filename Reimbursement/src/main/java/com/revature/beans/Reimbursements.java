package com.revature.beans;

public class Reimbursements {

	/*
	 * a direct mirror of the Reimbursements table in the database
	 */
	
	int reimbursementId;
	double reimbursementBalance;
	char reimbursementStatus; // P = pending, D = deny, A = allow
	int employeeId;
	
	public Reimbursements() {
		super();
	}
	public Reimbursements(int reimbursementId, double reimbursementBalance, char reimbursementStatus, int employeeId) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementBalance = reimbursementBalance;
		this.reimbursementStatus = reimbursementStatus;
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "Reimbursements [reimbursementId=" + reimbursementId + ", reimbursementBalance=" + reimbursementBalance
				+ ", reimbursementStatus=" + reimbursementStatus + ", employeeId=" + employeeId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		long temp;
		temp = Double.doubleToLongBits(reimbursementBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimbursementId;
		result = prime * result + reimbursementStatus;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursements other = (Reimbursements) obj;
		if (employeeId != other.employeeId)
			return false;
		if (Double.doubleToLongBits(reimbursementBalance) != Double.doubleToLongBits(other.reimbursementBalance))
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (reimbursementStatus != other.reimbursementStatus)
			return false;
		return true;
	}
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public double getReimbursementBalance() {
		return reimbursementBalance;
	}
	public void setReimbursementBalance(double reimbursementBalance) {
		this.reimbursementBalance = reimbursementBalance;
	}
	public char getReimbursementStatus() {
		return reimbursementStatus;
	}
	public void setReimbursementStatus(char reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
}
