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
public class SkillsetService {
	private final static String URL = Constants.URL;
	private final static String ID = Constants.ID;
	private final static String PASSWORD = Constants.PASSWORD;
	
	public List<Skillset> getSkillsetList() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Skillset> skillsetList = new ArrayList<Skillset>();
		Skillset skillset;
		
		String sql="select * from SKILL_SET";
		
		conn = DriverManager.getConnection(URL,ID,PASSWORD);
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		while (rs.next()){
			skillset = new Skillset();
			skillset.setSkill_number(rs.getString("skill_number"));
			skillset.setSkill_name(rs.getString("skill_name"));
			
			skillsetList.add(skillset);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return skillsetList;
	}
	
	public List<Skillset> getOfskillsetList(String employeeNumber) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Skillset> skillsetList = new ArrayList<Skillset>();
		Skillset skillset;
		
		String sql="select * from (select * from OF_SKILL_SET where EMPLOYEE_NUMBER=?)"
				+ " natural join SKILL_SET";
		
		conn = DriverManager.getConnection(URL,ID,PASSWORD);
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, employeeNumber);
		rs = stmt.executeQuery();
		
		while (rs.next()){
			skillset = new Skillset();
			skillset.setSkill_number(rs.getString("skill_number"));
			skillset.setSkill_name(rs.getString("skill_name"));
			skillset.setSkill_level(rs.getString("skill_level"));
			
			skillsetList.add(skillset);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return skillsetList;
	}
	
	public void newSkillset(String employee_number, String skillset_number, String skillset_name, String skillset_level) throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql;
		int level = Integer.parseInt(skillset_level);
		
		conn = DriverManager.getConnection(URL,ID,PASSWORD);
		
		if(skillset_number.equals("0000")){
			sql = "select skill_number from SKILL_SET minus "
					+ "(select DISTINCT r.SKILL_NUMBER from SKILL_SET s, SKILL_SET r where s.SKILL_NUMBER>r.SKILL_NUMBER)";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			String number = rs.getString("skill_number");
			int i = Integer.parseInt(number)+1;
			for(number = ""+i;number.length()<4;){number="0"+number;}
			skillset_number = number;
			
			sql = "insert into skill_set values (?,?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, skillset_number);
			stmt.setString(2, skillset_name);
			stmt.executeUpdate();
			rs.close();
		}
		
		sql = "insert into of_skill_set values (?,?,?)";
		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, employee_number);
		stmt.setString(2, skillset_number);
		stmt.setInt(3, level);
		stmt.executeUpdate();
		
		stmt.close();
		conn.close();
	}
	
	public void deleteSkillset(String employee_number, String Skill_number) throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql ="delete from of_skill_set where employee_number=? and skill_number=?";
		
		conn = DriverManager.getConnection(URL, ID, PASSWORD);
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, employee_number);
		stmt.setString(2, Skill_number);
		stmt.executeUpdate();
		
		stmt.close();
		conn.close();
	}
	

	public List<User> getSkillsetUserList(String skill_number, int skillset_level, String more_or_under) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<User> userList = new ArrayList<User>();
		User user;
		
		String sql1 = "select * from profile natural join of_skill_set where skill_number = ?";
		String sql2;
		if(more_or_under.equals("이상")){
			sql2 = "and skill_level >= ?";
		}else{
			sql2 = "and skill_level <= ?";
		}
		
		String sql = "select * from (DEPARTMENT natural join WORKS_DEPARTMENT) natural join ("
						+sql1+sql2+")";
		
		conn = DriverManager.getConnection(URL, ID, PASSWORD);
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, skill_number);
		stmt.setInt(2, skillset_level);
		rs = stmt.executeQuery();
		
		while(rs.next()){
			user = new User();
			user.setEmployee_number(rs.getString("employee_number"));
			user.setWorks_department(rs.getString("department_name"));
			user.setName(rs.getString("name"));
			user.setPosition(rs.getString("position"));
			user.setPrevious_career(rs.getInt("skill_level"));
			
			userList.add(user);
		}
		
		
		rs.close();
		stmt.close();
		conn.close();
		
		return userList;
	}

	
}
