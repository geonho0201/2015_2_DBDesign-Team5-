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
public class EmployeeService {
	private final static String URL = Constants.URL;
	private final static String ID = Constants.ID;
	private final static String PASSWORD = Constants.PASSWORD;
	
	public List<User> getEmployeeList(String option) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<User> userList = new ArrayList<User>();
		User user;
		
		if(option.equals("00")){
			String sql = "select * from (profile natural join EMPLOYEE) natural join "
					+ "(select employee_number, department_name, position from WORKS_DEPARTMENT natural join DEPARTMENT)";
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
		}else{
			String sql = "select * from (profile natural join EMPLOYEE) natural join "
					+ "(select employee_number, department_name, position from WORKS_DEPARTMENT "
					+ "natural join DEPARTMENT where department_number='"+option+"')";
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
		
		
	}
	
	
	
}
