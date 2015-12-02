package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class JoinService {
	private final static String URL = Constants.URL;
	private final static String ID = Constants.ID;
	private final static String PASSWORD = Constants.PASSWORD;

	/**
	 * 사용자로부터 입력받은 정보들을 이용하여 회원가입을 시도한다.<br />
	 * 각 정보들의 유효성을 검사하여 유효한 경우 입력된 정보를 DB에 쓴 다음
	 * 유저 인스턴스를 반환하고 유효하지 않을 경우 null 값을 반환한다.
	 * 
	 * @param userID
	 * @param userPassword
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	public boolean join(String employeeNumber, String userID, String userPassword,
			String userPasswordCheck, String name, int age, String phoneNumber,
			String address, String email, String ssnPrefix, String ssnSuffix,
			String worksDepartment, String position, String finalEducaion,
			int previousCareer, String skillName, int skillLevel)
					throws ClassNotFoundException, SQLException {
		
		// 입력된 정보의 유효성을 검사한다.
		if (!validateId(userID) || !validatePassword(userPassword, userPasswordCheck)) {
			return false;
		} else {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(URL, ID, PASSWORD);;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = null;
			
			/* employee 테이블에 직원 정보를 삽입한다. */
			sql = "INSERT INTO employee (employee_number, final_education, previous_career) "
					+ "VALUES (?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, employeeNumber);
			ps.setString(2, finalEducaion);
			ps.setInt(3, previousCareer);
			ps.executeUpdate();
			ps.close();
			
			/* profile 테이블에 회원 정보를 삽입한다. */
			sql = "INSERT INTO profile (employee_number, id, password, name, age,"
					+ "phone_number, address, email, ssn, signup_date)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, SYSTIMESTAMP)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, employeeNumber);
			ps.setString(2, userID);
			ps.setString(3, userPassword);
			ps.setString(4, name);
			ps.setInt(5, age);
			ps.setString(6, phoneNumber);
			ps.setString(7, address);
			ps.setString(8, email);
			ps.setString(9, ssnPrefix + ssnSuffix);
			ps.executeUpdate();
			ps.close();
			
			/*
			 * department 테이블에서 부서명에 해당하는 부서번호를 찾은 뒤,
			 * 직원 정보를 works_department 테이블에 삽입한다.
			 */
			sql = "INSERT INTO works_department (department_number, employee_number, position) "
					+ "VALUES ("
					+ "	(SELECT department_number FROM department WHERE department_name=?), "
					+ "?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, worksDepartment);
			ps.setString(2, employeeNumber);
			ps.setString(3, position);
			ps.executeUpdate();
			ps.close();
			
			/*
			 * skill_set 테이블에서 기술명에 해당하는 기술번호를 찾은 뒤,
			 * 직원 정보를 of_skill_set 테이블에 삽입한다.
			 */
			sql = "INSERT INTO of_skill_set (skill_number, employee_number, skill_level) "
					+ "VALUES ("
					+ "	(SELECT skill_number FROM skill_set WHERE skill_name=?), "
					+ "?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, skillName);
			ps.setString(2, employeeNumber);
			ps.setInt(3, skillLevel);
			ps.executeUpdate();
			ps.close();
			
			return true;
		}
	}
	
	/**
	 * 사용자로부터 입력된 ID의 유효성을 검사한다.<br />
	 * ID는 6~20자의 영문자(대소문자) 혹은 숫자로 이루어져야 한다.
	 * 
	 * @param userID
	 * @return
	 */
	private boolean validateId(String userID) {
		Pattern pattern;
		Matcher matcher;
		
		if (userID.length() < 6 || userID.length() > 20) {
			return false;
		}
		
		pattern = Pattern.compile("[^\\w\\d]");
		matcher = pattern.matcher(userID);
		if (matcher.find()) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 사용자로부터 입력된 비밀번호의 유효성을 검사한다.<br />
	 * 비밀번호는 6~20자의 영문자(대소문자) 혹은 숫자 혹은
	 * 특수문자로 이루어져야 하며 확인용으로 입력된 비밀번호와
	 * 정확히 일치해야 한다.
	 * 
	 * @param userPassword
	 * @param userPasswordCheck
	 * @return
	 */
	private boolean validatePassword(String userPassword,
			String userPasswordCheck) {
		Pattern pattern;
		Matcher matcher;
		
		if (!userPassword.equals(userPasswordCheck)
				|| (userPassword.length() < 6 || userPassword.length() > 20)) {
			return false;
		}
		
		// 0x00~0x7F는 ASCII 코드의 범위이다.
		// ASCII 코드는 영문자(대소문자), 숫자, 일부 특수문자(!@#$%^&*()+- 등)을 포함한다.
		pattern = Pattern.compile("[^\\x00-\\x7F]");
		matcher = pattern.matcher(userPassword);
		if (matcher.find()) {
			return false;
		}
		
		return true;
	}
	
}
