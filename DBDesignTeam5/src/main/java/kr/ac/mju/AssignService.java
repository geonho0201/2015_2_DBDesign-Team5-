package kr.ac.mju;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AssignService {
	private final static String URL = Constants.URL;
	private final static String ID = Constants.ID;
	private final static String PASSWORD = Constants.PASSWORD;
	
	
	public void insertAssign(Assignment assignment) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = null;
		PreparedStatement stmt = null;

	
		
			String sql = "insert into assignment values(?,?,?,?)";
			conn = DriverManager.getConnection(URL,ID,PASSWORD);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, assignment.getEmployee_number());
			stmt.setString(2, assignment.getProject_number());
			stmt.setDate(3, assignment.getAssign_date());
			stmt.setDate(4, assignment.getAbort_date());
			stmt.executeUpdate();
			stmt.close();
			
			sql = "insert into assign_job values(?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, assignment.getEmployee_number());
			stmt.setString(2, assignment.getProject_number());
			stmt.setString(3, assignment.getJob());
			stmt.executeUpdate();
			stmt.close();
			
			
			
			conn.close();

		
		
	}
	
	public void deleteAssign(String employee_number,String project_number) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = null;
		PreparedStatement stmt = null;

	
		
			String sql = "delete from assign_job where employee_number=? and project_number=?";
			conn = DriverManager.getConnection(URL,ID,PASSWORD);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, employee_number);
			stmt.setString(2, project_number);
			
			stmt.executeUpdate();
			stmt.close();
			
			sql = "delete from assignment where employee_number=? and project_number=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, employee_number);
			stmt.setString(2, project_number);
			stmt.executeUpdate();
			stmt.close();
			
			
			
			conn.close();

		
		
	}
	
}
