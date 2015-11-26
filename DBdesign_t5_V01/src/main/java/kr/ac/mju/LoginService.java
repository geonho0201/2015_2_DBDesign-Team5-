package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
					user = new User();
					user.setId(id);
					user.setName(rs.getString("name"));
					
					return user;
				}
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
			return null;
	}
	
	
}
