package kr.ac.mju;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyInfoService {
	private final static String URL = Constants.URL;
	private final static String ID = Constants.ID;
	private final static String PASSWORD = Constants.PASSWORD;

	
	@Autowired
	User user;
	
	public User modifyInfo(User user, String password, String name,String SSN,
						int age,String phone_number,String address, String position, String works_department,String email) throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "update profile set password=?,name=?,SSN=?, age=?,phone_number=?,address=?,email=? where id =?";
		
			conn = DriverManager.getConnection(URL, ID, PASSWORD);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, password);
			stmt.setString(2, name);
			stmt.setString(3, SSN);
			stmt.setInt(4, age);
			stmt.setString(5, phone_number);
			stmt.setString(6, address);
			stmt.setString(7, email);
			stmt.setString(8,user.getId());
			stmt.executeUpdate();
			stmt.close();
		
		sql = "update works_department set position=?, department_number = ? where employee_number=?";
		stmt = conn.prepareStatement(sql);
			stmt.setString(1, position);
			stmt.setString(2, works_department);
			stmt.setString(3, user.getEmployee_number());
			stmt.executeUpdate();
				if(user!=null){
					user.setPassword(password);
					user.setName(name);
					user.setSSN(SSN);
					user.setAge(age);
					user.setPhone_number(phone_number);
					user.setAddress(address);
					user.setPosition(position);
					user.setWorks_department(works_department);
					user.setEmail(email);
				}

			stmt.close();
			conn.close();

			return user;
	}
	
	
}
