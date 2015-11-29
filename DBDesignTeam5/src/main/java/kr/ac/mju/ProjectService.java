package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
	private final static String URL = Constants.URL;
	private final static String ID = Constants.ID;
	private final static String PASSWORD = Constants.PASSWORD;

	Project project;
	Assignment assignment;
	
	public List<Project> loadProject(String comparison) throws ClassNotFoundException, SQLException{
		List<Project> list = new ArrayList<Project>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select distinct project_number, project_name, start_date, due_date, orderer, project_desc "
				+ "from project natural join assignment where employee_number like ? order by start_date";
		
			conn = DriverManager.getConnection(URL, ID, PASSWORD);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, comparison);
			rs= stmt.executeQuery();
			
			while(rs.next()){
				project = new Project();
				project.setProject_number(rs.getString(1));
				project.setProject_name(rs.getString(2));
				project.setStart_date(rs.getDate(3));
				project.setDue_date(rs.getDate(4));
				project.setOrderer(rs.getString(5));
				project.setProject_desc(rs.getString(6));
				list.add(project);
			}
			stmt.close();
			conn.close();
			return list;
	}
	
	
	public List<Assignment> loadAssignedMem(String employee_number) throws ClassNotFoundException, SQLException{
		List<Assignment> list = new ArrayList<Assignment>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select name, employee_number, project_number, assign_date, abort_date, job_name  "
				+ "from profile NATURAL join assignment NATURAL join assign_job NATURAL join job "
				+ "where project_number = ?";
		
			conn = DriverManager.getConnection(URL, ID, PASSWORD);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, employee_number);
			rs= stmt.executeQuery();
			
			while(rs.next()){
				assignment = new Assignment();
				assignment.setName(rs.getString(1));
				assignment.setEmployee_number(rs.getString(2));
				assignment.setProject_number(rs.getString(3));
				assignment.setAssign_date(rs.getDate(4));
				assignment.setAbort_date(rs.getDate(5));
				assignment.setJob(rs.getString(6));
				list.add(assignment);
			}
			stmt.close();
			conn.close();
			rs.close();
			return list;
	}
}
