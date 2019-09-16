package come.revature.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import come.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {

		try {
			String filename = "src/main/resources/connection.properties";
			Connection conn = ConnectionUtil.getConnectionFromFile(filename);
			System.out.println(conn);
			
			// prepared statement for coding challenge week 2
			String deptQuery = "SELECT * FROM DEPARTMENT";
			PreparedStatement ps = conn.prepareStatement(deptQuery);
			boolean isExecuted = ps.execute(); // returns true if it worked
			System.out.println("Prepared statement for dept executed: " + isExecuted);
			ResultSet rs = ps.getResultSet();
			String departmentName = "";
			while(rs.next()) {
				departmentName = rs.getString("DEPARTMENT_NAME");
				System.out.println(departmentName);
			}
			
			// prepared statement for coding challenge week 2
			String emplQuery = "SELECT * FROM EMPLOYEE";
			ps = conn.prepareStatement(emplQuery);
			isExecuted = ps.execute(); // returns true if it worked
			System.out.println("Prepared statement for empl executed: " + isExecuted);
			rs = ps.getResultSet();
			String empFirstname = "";
			String empSalary = "";
			String empDeptID = "";
			while(rs.next()) {
				empFirstname = rs.getString("EMP_FIRSTNAME");
				empSalary = rs.getString("SALARY");
				empDeptID = rs.getString("DEPARTMENT_ID");
				System.out.println(empFirstname + " : " + empSalary + " : " + empDeptID);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
