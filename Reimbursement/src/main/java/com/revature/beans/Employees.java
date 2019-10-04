package com.revature.beans;

public class Employees {

	int employeeId;
	String employeeUsername;
	String employeePassword;
	String employeeEmail;
	String employeeManager;
	int employeeManagerId;

	// getters and setters
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeUsername() {
		return employeeUsername;
	}

	public void setEmployeeUsername(String employeeUsername) {
		this.employeeUsername = employeeUsername;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeManager() {
		return employeeManager;
	}

	public void setEmployeeManager(String employeeManager) {
		this.employeeManager = employeeManager;
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
		result = prime * result + ((employeeEmail == null) ? 0 : employeeEmail.hashCode());
		result = prime * result + employeeId;
		result = prime * result + ((employeeManager == null) ? 0 : employeeManager.hashCode());
		result = prime * result + employeeManagerId;
		result = prime * result + ((employeePassword == null) ? 0 : employeePassword.hashCode());
		result = prime * result + ((employeeUsername == null) ? 0 : employeeUsername.hashCode());
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
		Employees other = (Employees) obj;
		if (employeeEmail == null) {
			if (other.employeeEmail != null)
				return false;
		} else if (!employeeEmail.equals(other.employeeEmail))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (employeeManager == null) {
			if (other.employeeManager != null)
				return false;
		} else if (!employeeManager.equals(other.employeeManager))
			return false;
		if (employeeManagerId != other.employeeManagerId)
			return false;
		if (employeePassword == null) {
			if (other.employeePassword != null)
				return false;
		} else if (!employeePassword.equals(other.employeePassword))
			return false;
		if (employeeUsername == null) {
			if (other.employeeUsername != null)
				return false;
		} else if (!employeeUsername.equals(other.employeeUsername))
			return false;
		return true;
	}

	// toString
	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", employeeUsername=" + employeeUsername + ", employeePassword="
				+ employeePassword + ", employeeEmail=" + employeeEmail + ", employeeManager=" + employeeManager
				+ ", employeeManagerId=" + employeeManagerId + "]";
	}
	
	// constructors
	public Employees(int employeeId, String employeeUsername, String employeePassword, String employeeEmail,
			String employeeManager, int employeeManagerId) {
		super();
		this.employeeId = employeeId;
		this.employeeUsername = employeeUsername;
		this.employeePassword = employeePassword;
		this.employeeEmail = employeeEmail;
		this.employeeManager = employeeManager;
		this.employeeManagerId = employeeManagerId;
	}

	public Employees() {
		super();
	}

	
}
