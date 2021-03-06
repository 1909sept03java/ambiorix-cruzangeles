package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbursements;
import com.revature.service.ConnectionService;

public class ReimbursementsDAOImpl implements ReimbursementsDAO {

	@Override
	public List<Reimbursements> getReimbursements() {

		/*
		 * this function will reach into the database and pull out all of the data,
		 * storing it into an ArrayList object and returning it
		 */

		List<Reimbursements> reimList = new ArrayList<Reimbursements>();
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENTS";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				double reimbursementBalance = rs.getDouble("REIMBURSEMENT_BALANCE");
				String reimbursementStatus = rs.getString("REIMBURSEMENT_STATUS"); // P = pending, D = deny, A = allow
				int employeeId = rs.getInt("EMPLOYEE_ID");
				int employeeManagerId = rs.getInt("EMPLOYEE_MANAGER_ID");
				reimList.add(new Reimbursements(reimbursementId, reimbursementBalance, reimbursementStatus, employeeId,
						employeeManagerId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reimList;
	}

	@Override
	public List<Reimbursements> getReimbursementsByEmployeeId(int employeeId) {

		/*
		 * this function will reach into the database and pull out all of the data,
		 * storing it into an ArrayList object and returning it
		 */

		List<Reimbursements> reimList = new ArrayList<Reimbursements>();
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				double reimbursementBalance = rs.getDouble("REIMBURSEMENT_BALANCE");
				String reimbursementStatus = rs.getString("REIMBURSEMENT_STATUS"); // P = pending, D = deny, A = allow
				int employeeManagerId = rs.getInt("EMPLOYEE_MANAGER_ID");
				reimList.add(new Reimbursements(reimbursementId, reimbursementBalance, reimbursementStatus, employeeId,
						employeeManagerId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reimList;
	}

	@Override
	public void createReimbursements(double reimbursementBalance, int employeeId, int employeeManagerId) {
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "INSERT INTO REIMBURSEMENTS(REIMBURSEMENT_ID, REIMBURSEMENT_BALANCE, REIMBURSEMENT_STATUS, EMPLOYEE_ID, EMPLOYEE_MANAGER_ID) VALUES(REIMBURSEMENTS_SEQUENCE.NEXTVAL, ?, 'P', ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, reimbursementBalance);
			ps.setInt(2, employeeId);
			ps.setInt(3, employeeManagerId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateReimbursements(int reimbursementId, String reimbursementStatus) {
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "UPDATE REIMBURSEMENTS SET REIMBURSEMENT_STATUS = ? WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, reimbursementStatus);
			ps.setInt(2, reimbursementId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Reimbursements> getAllPending() {
		List<Reimbursements> reimList = new ArrayList<Reimbursements>();
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE REIMBURSEMENT_STATUS = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "P");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				double reimbursementBalance = rs.getDouble("REIMBURSEMENT_BALANCE");
				String reimbursementStatus = rs.getString("REIMBURSEMENT_STATUS"); // P = pending, D = deny, A = allow
				int employeeId = rs.getInt("EMPLOYEE_ID");
				int employeeManagerId = rs.getInt("EMPLOYEE_MANAGER_ID");
				reimList.add(new Reimbursements(reimbursementId, reimbursementBalance, reimbursementStatus, employeeId,
						employeeManagerId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reimList;
	}

	public List<Reimbursements> getAllResolved() {
		List<Reimbursements> reimList = new ArrayList<Reimbursements>();
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE REIMBURSEMENT_STATUS = ? OR REIMBURSEMENT_STATUS = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "A");
			ps.setString(2, "D");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				double reimbursementBalance = rs.getDouble("REIMBURSEMENT_BALANCE");
				String reimbursementStatus = rs.getString("REIMBURSEMENT_STATUS"); // P = pending, D = deny, A = allow
				int employeeId = rs.getInt("EMPLOYEE_ID");
				int employeeManagerId = rs.getInt("EMPLOYEE_MANAGER_ID");
				reimList.add(new Reimbursements(reimbursementId, reimbursementBalance, reimbursementStatus, employeeId,
						employeeManagerId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reimList;
	}

	@Override
	public List<Reimbursements> getReimbursementsByEmployeeMangerId(int employeeManagerId) {
		List<Reimbursements> reimList = new ArrayList<Reimbursements>();
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE EMPLOYEE_MANAGER_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employeeManagerId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				double reimbursementBalance = rs.getDouble("REIMBURSEMENT_BALANCE");
				String reimbursementStatus = rs.getString("REIMBURSEMENT_STATUS"); // P = pending, D = deny, A = allow
				int employeeId = rs.getInt("EMPLOYEE_ID");
				reimList.add(new Reimbursements(reimbursementId, reimbursementBalance, reimbursementStatus, employeeId,
						employeeManagerId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reimList;
	}

}
