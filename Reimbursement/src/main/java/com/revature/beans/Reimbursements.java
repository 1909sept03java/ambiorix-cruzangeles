package com.revature.beans;

public class Reimbursements {

	int reimbursementId;
	double reimbursementBalance;
	String reimbursementStatus; // P = pending, D = deny, A = allow
	int employeeId; // the employee that made the reimbursement
	int employeeManagerId; // the manager that changed the status

	// getters and setters
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

	public String getReimbursementStatus() {
		return reimbursementStatus;
	}

	public void setReimbursementStatus(String reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployeeManagerId() {
		return employeeManagerId;
	}

	public void setEmployeeManagerId(int employeeManagerId) {
		this.employeeManagerId = employeeManagerId;
	}

	// hashcode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		result = prime * result + employeeManagerId;
		long temp;
		temp = Double.doubleToLongBits(reimbursementBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimbursementId;
		result = prime * result + ((reimbursementStatus == null) ? 0 : reimbursementStatus.hashCode());
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
		if (employeeManagerId != other.employeeManagerId)
			return false;
		if (Double.doubleToLongBits(reimbursementBalance) != Double.doubleToLongBits(other.reimbursementBalance))
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (reimbursementStatus == null) {
			if (other.reimbursementStatus != null)
				return false;
		} else if (!reimbursementStatus.equals(other.reimbursementStatus))
			return false;
		return true;
	}

	// toString
	@Override
	public String toString() {
		return "Reimbursements [reimbursementId=" + reimbursementId + ", reimbursementBalance=" + reimbursementBalance
				+ ", reimbursementStatus=" + reimbursementStatus + ", employeeId=" + employeeId + ", employeeManagerId="
				+ employeeManagerId + "]";
	}

	// constructors
	public Reimbursements(int reimbursementId, double reimbursementBalance, String reimbursementStatus, int employeeId,
			int employeeManagerId) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementBalance = reimbursementBalance;
		this.reimbursementStatus = reimbursementStatus;
		this.employeeId = employeeId;
		this.employeeManagerId = employeeManagerId;
	}

	public Reimbursements() {
		super();
	}

}
