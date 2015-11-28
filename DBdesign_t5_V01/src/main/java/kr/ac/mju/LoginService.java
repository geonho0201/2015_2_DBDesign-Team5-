package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String ID = "team5";
	private final static String PASSWORD = "delab";
	
	public User login(String UserID, String UserPassword) throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from profile";
		User user = null;
		
			conn = DriverManager.getConnection(URL, ID, PASSWORD);
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				String id = rs.getString("id");
				String password = rs.getString("password");
				
				if(id.equals(UserID) && password.equals(UserPassword)){
					rs.close();
					stmt.close();
					
					sql = "UPDATE profile SET LAST_SIGNIN_TIME=SYSTIMESTAMP where id='"+id+"'";
					stmt = conn.prepareStatement(sql);
					stmt.executeUpdate();
					stmt.close();
					
					sql = "select * from profile natural join works_department where id = '"+id+"'";
					stmt=conn.prepareStatement(sql);
					rs = stmt.executeQuery();
					
					user = new User();
					rs.next();
					user.setEmployee_number(rs.getString("employee_number"));
					user.setId(rs.getString("id"));
					user.setPassword(rs.getString("password"));
					user.setName(rs.getString("name"));
					user.setAge(rs.getInt("age"));
					user.setPhone_number(rs.getString("phone_number"));
					user.setAddress(rs.getString("address"));
					user.setEmail(rs.getString("email"));
					user.setSSN(rs.getString("SSN"));
					user.setSignup_date(rs.getString("signup_date"));
					user.setLast_modified_time(rs.getString("last_modified_time"));
					user.setLast_signin_time(rs.getString("last_signin_time"));
					user.setWorks_department(rs.getString("department_number"));
					user.setPostion(rs.getString("position"));
					
					return user;
				}
			}
			
			rs.close();
			stmt.close();
			conn.close();
			user = new User();
			user.setName("");
			return user;
	}
	
	
}
