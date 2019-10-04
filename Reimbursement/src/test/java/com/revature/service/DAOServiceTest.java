package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.beans.Employees;
import com.revature.beans.Reimbursements;

class DAOServiceTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test() {
		// tests to see if all 4 employees are returned by the DAOService
		List<Employees> empList = DAOService.getEmployees();
		assertEquals(empList.size(), 4);
	}
	
	@Test
	void test2() {
		// testing the first employee
		Employees emp = DAOService.getEmployeesById(1);
		assertEquals(emp.getEmployeeId(), 1);
		assertEquals(emp.getEmployeeUsername(), "REX14");
		assertEquals(emp.getEmployeePassword(), "REXPASS");
		assertEquals(emp.getEmployeeEmail(), "REX@EXAMPLE.COM");
		assertEquals(emp.getEmployeeManagerId(), 2);
	}
	
	@Test
	void test3() {
		boolean isUpdated = DAOService.updateEmployees(1, "REX14", "REXPASS");
		assertEquals(isUpdated, true);
	}
	
	@Test
	void test4() {
		List<Reimbursements> reimList = DAOService.getReimbursements();
		assertNotEquals(reimList.size(), 0);
	}
	
	@Test
	void test5() {
		List<Reimbursements> reimList = DAOService.getReimbursementsByEmployeeId(1);
		assertNotEquals(reimList.size(), 0);
	}
	
	@Test
	void test6() {
		boolean isCreated = DAOService.createReimbursements(999, 1, 2);
		assertEquals(isCreated, true);
	}
	
	@Test
	void test7() {
		boolean isUpdated = DAOService.updateReimbursements(1, "D");
		assertEquals(isUpdated, true);
	}
	
	@Test
	void test8() {
		List<Reimbursements> reimList = DAOService.getAllPending();
		assertNotEquals(reimList.size(), 0);
	}
	
	void test9() {
		List<Reimbursements> reimList = DAOService.getAllResolved();
		assertNotEquals(reimList.size(), 0);
	}
	
	void test10() {
		List<Reimbursements> reimList = DAOService.getReimbursementsByEmployeeManagerId(1);
		assertNotEquals(reimList.size(), 0);
	}

}
