package kr.ac.mju;

import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		 	
	 	
	public List<Assignment> loadAssignedMem(String project_number) throws ClassNotFoundException, SQLException{
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
			stmt.setString(1, project_number);
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
	
	public String getJob(String employee_number, String project_number) throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
				
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select job_number from assign_job where employee_number=? and project_number=?";
			
			conn = DriverManager.getConnection(URL, ID, PASSWORD);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, employee_number);
			stmt.setString(2, project_number);
			rs= stmt.executeQuery();
					
			if(rs.next()){
				return rs.getString(1);
			}
			
			stmt.close();
			conn.close();
			rs.close();
			
		return "";
	}
	
	public List<String> getPM(String constructor_number) throws SQLException, ClassNotFoundException{
		List<String> list= new ArrayList<String>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
				
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select employee_number,project_number from project natural join assign_job where constructor_number = ? and job_number='01'";
		
			conn = DriverManager.getConnection(URL, ID, PASSWORD);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, constructor_number);
			rs= stmt.executeQuery();
					
			while(rs.next()){
				list.add(rs.getString(1)+rs.getString(2));
			}
			stmt.close();
			conn.close();
			rs.close();
				
			return list;
	}
			
	
	public List<Project> getMyProject(String constructor_number) throws SQLException, ClassNotFoundException{
		List<Project> list = new ArrayList<Project>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
				
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from project where constructor_number = ?";
	
			conn = DriverManager.getConnection(URL, ID, PASSWORD);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, constructor_number);
			rs= stmt.executeQuery();
					
			while(rs.next()){
				project = new Project();
				project.setProject_number(rs.getString(1));
				project.setProject_name(rs.getString(2));
				project.setStart_date(rs.getDate(3));
				project.setDue_date(rs.getDate(4));
				project.setOrderer(rs.getString(5));
				project.setProject_desc(rs.getString(6));
				project.setConstructor_number(rs.getString(7));
				list.add(project);
			}
			stmt.close();
			conn.close();
			rs.close();
			
			return list;
	}
	
	public String getProjectNum() throws ClassNotFoundException, SQLException{
		int max=0;
		int projectNum;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select project_number from project";
		
			conn = DriverManager.getConnection(URL, ID, PASSWORD);
			stmt = conn.prepareStatement(sql);
			rs= stmt.executeQuery();
	
			while(rs.next()){
				projectNum=Integer.parseInt(rs.getString(1));
				if(projectNum>max){
					max=projectNum;
				}
			}
			stmt.close();
			conn.close();
			rs.close();
			
		return Integer.toString(max+1);
	}
			
		
	public void insertProject(Project project,String employee_number) throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "insert into project values(?,?,?,?,?,?,?)";
		
			conn = DriverManager.getConnection(URL, ID, PASSWORD);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, project.getProject_number());
			stmt.setString(2, project.getProject_name());
			stmt.setDate(3, project.getStart_date());
			stmt.setDate(4, project.getDue_date());
			stmt.setString(5, project.getOrderer());
			stmt.setString(6, project.getProject_desc());
			stmt.setString(7, project.getConstructor_number());
			stmt.executeUpdate();
			stmt.close();
			
			sql = "insert into assignment values(?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, employee_number);
			stmt.setString(2, project.getProject_number());
			stmt.setDate(3, project.getStart_date());
			stmt.setDate(4, project.getDue_date());
			stmt.executeUpdate();
			stmt.close();
			
			sql = "insert into assign_job values(?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, employee_number);
			stmt.setString(2, project.getProject_number());
			stmt.setString(3, "01");
			stmt.executeUpdate();
			
			stmt.close();
			conn.close();
	}
			
	public void deleteProject(String project_number) throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "delete from assign_job where project_number=?";
	
			conn = DriverManager.getConnection(URL, ID, PASSWORD);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, project_number);
			stmt.executeUpdate();
			stmt.close();
			
			sql = "delete from assignment where project_number =?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, project_number);
			stmt.executeUpdate();
			stmt.close();
			
			sql = "delete from project where project_number = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, project_number);
			stmt.executeUpdate();
			
			stmt.close();
			conn.close();
	}
	
}
