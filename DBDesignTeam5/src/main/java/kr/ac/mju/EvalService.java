package kr.ac.mju;

import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class EvalService {
	private final static String URL = Constants.URL;
	private final static String ID = Constants.ID;
	private final static String PASSWORD = Constants.PASSWORD;
	private String myJob;
	//private Eval eval;
	//private Assignment assignment;
	
	public String getMyJob(String employee_number, String project_number) throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select job_name from job natural join assign_job where employee_number=? and project_number = ?";
	
			conn = DriverManager.getConnection(URL, ID, PASSWORD);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, employee_number);
			stmt.setString(2, project_number);
			rs= stmt.executeQuery();
			
			if(rs.next()){
				myJob=rs.getString(1);
				}else{
					myJob="NULL";
				}
			stmt.close();
			conn.close();
			rs.close();
			
			return myJob;
		}
	public boolean evalPeriod(String project_number) throws ClassNotFoundException, SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs=null;
		String 	sql="select * from project where due_date>SYSDATE-'8' and due_date<=SYSDATE and project_number =?";
		
		conn = DriverManager.getConnection(URL, ID, PASSWORD);
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, project_number);
		rs = stmt.executeQuery();
		
		if(rs.next()){
			conn.close();
			stmt.close();
			rs.close();
			return true;
		}else{
			conn.close();
			stmt.close();
			rs.close();
			return false;
		}

	}
		 	
	public boolean insertEval(Eval e) throws ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs=null;
		String 	sql="select * from eval where evaluatee_number=? and project_number=? and evaluater_number=? and eval_type=?";

	
			try {
				conn = DriverManager.getConnection(URL, ID, PASSWORD);
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, e.getEvaluatee_number());
				stmt.setString(2, e.getProject_number());
				stmt.setString(3, e.getEvaluater_number());
				stmt.setString(4, e.getEval_type());
				rs=stmt.executeQuery();
				
				if(rs.next()){
					
					return false;
				}else{
					stmt.close();
					sql = "insert into eval values(?,?,?,?,?,?,?,?)";
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, e.getEvaluatee_number());
					stmt.setString(2, e.getProject_number());
					stmt.setString(3, e.getEvaluater_number());
					stmt.setString(4, e.getEval_type());
					stmt.setInt(5, e.getBusiness_score());
					stmt.setString(6, e.getBusiness_eval());
					stmt.setInt(7, e.getCommunication_score());
					stmt.setString(8, e.getCommunication_eval());
					stmt.executeUpdate();
				}
				
				
				conn.close();
				stmt.close();
				rs.close();
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			return true;
	}
	
	public void updateEval(Eval e) throws ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String 	sql="update eval set evaluatee_number = ?, project_number =?, evaluater_number=?, eval_type=?"
				+ "business_score=?, business_eval=?, communication_score=?, communication_eval=?"
				+ "where evaluatee_number = ?, project_number =?, evaluater_number=?, eval_type=?";

	
			try {
				conn = DriverManager.getConnection(URL, ID, PASSWORD);
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, e.getEvaluatee_number());
				stmt.setString(2, e.getProject_number());
				stmt.setString(3, e.getEvaluater_number());
				stmt.setString(4, e.getEval_type());
				stmt.setInt(5, e.getBusiness_score());
				stmt.setString(6, e.getBusiness_eval());
				stmt.setInt(7, e.getCommunication_score());
				stmt.setString(8, e.getCommunication_eval());
				stmt.setString(9, e.getEvaluatee_number());
				stmt.setString(10, e.getProject_number());
				stmt.setString(11, e.getEvaluater_number());
				stmt.setString(12, e.getEval_type());
				stmt.executeUpdate();
				
				
				
				conn.close();
				stmt.close();
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
}
}