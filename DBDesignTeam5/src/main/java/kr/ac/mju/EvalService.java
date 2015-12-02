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
public class EvalService {
	private final static String URL = Constants.URL;
	private final static String ID = Constants.ID;
	private final static String PASSWORD = Constants.PASSWORD;
	private String myJob;
	
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
	
	public boolean evalPeriod(String project_number) throws ClassNotFoundException, SQLException{
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

	public List<User> getDeveloperList() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<User> userList = new ArrayList<User>();
		User user;
		
		String sql = "select * from (profile natural join EMPLOYEE) natural join "
				+ "(select employee_number, department_name, position from WORKS_DEPARTMENT natural join DEPARTMENT where department_number='05' or department_number='08')";
		conn = DriverManager.getConnection(URL,ID,PASSWORD);
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
			
			while(rs.next()){
				user = new User();
				user.setEmployee_number(rs.getString("employee_number"));
				user.setName(rs.getString("name"));
				user.setWorks_department(rs.getString("department_name"));
				user.setPosition(rs.getString("position"));
				user.setAge(rs.getShort("age"));
				user.setSSN(rs.getString("ssn"));
				user.setPhone_number(rs.getString("phone_number"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				user.setHired_date(rs.getString("hired_date"));
				user.setSignup_date(rs.getString("signup_date"));
				user.setFinal_education(rs.getString("final_education"));
				user.setPrevious_career(rs.getInt("previous_career"));
				user.setSalary(rs.getInt("salary"));
				userList.add(user);
			}
		rs.close();
		stmt.close();
		conn.close();
		return userList;
	}

	public List<Eval> getEvalList(String employee_number) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Eval> evalList = new ArrayList<Eval>();
		Eval eval;
		
		String sql = "select * from EVAL where EVALUATEE_NUMBER=?";
		
		conn = DriverManager.getConnection(URL,ID,PASSWORD);
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, employee_number);
		rs = stmt.executeQuery();
			
			while(rs.next()){
				eval = new Eval();
				eval.setEvaluatee_number(rs.getString(1));
				eval.setProject_number(rs.getString(2));
				eval.setEvaluater_number(rs.getString(3));
				eval.setEval_type(rs.getString(4));
				eval.setBusiness_score(rs.getInt(5));
				eval.setBusiness_eval(rs.getString(6));
				eval.setCommunication_score(rs.getInt(7));
				eval.setCommunication_eval(rs.getString(8));
				evalList.add(eval);
			}
			
		rs.close();
		stmt.close();
		conn.close();
		return evalList;
	}
}