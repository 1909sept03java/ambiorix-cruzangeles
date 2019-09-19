package com.revature.beans;

public class BankAccounts {

	private int bankAccountID;
	private double bankAccountBalance;
	private int userID;
	
	public BankAccounts() {
		super();
	}
	
	public BankAccounts(int bankAccountID, double bankAccountBalance, int userID) {
		this.bankAccountID = bankAccountID;
		this.bankAccountBalance = bankAccountBalance;
		this.userID = userID;
	}

	public int getBankAccountID() {
		return bankAccountID;
	}

	public void setBankAccountID(int bankAccountID) {
		this.bankAccountID = bankAccountID;
	}

	public double getBankAccountBalance() {
		return bankAccountBalance;
	}

	public void setBankAccountBalance(int bankAccountBalance) {
		this.bankAccountBalance = bankAccountBalance;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
}
