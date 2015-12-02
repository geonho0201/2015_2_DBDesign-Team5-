package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import kr.ac.mju.exception.InputDataNotValidException;
import kr.ac.mju.exception.InputDataRedundantException;
import kr.ac.mju.util.FieldValidator;

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
	 * @throws InputDataNotValidException 
	 * @throws InputDataRedundantException 
	 */
	public boolean join(String employeeNumber, String userID, String userPassword,
			String userPasswordCheck, String name, String age, String phoneNumber,
			String address, String email, String ssnPrefix, String ssnSuffix,
			String worksDepartment, String position, String finalEducaion,
			String previousCareer, String skillName, String skillLevel)
					throws ClassNotFoundException, SQLException, InputDataNotValidException, InputDataRedundantException {
		
		/* 정수형의 입력값들을 초기화한다(Integer 파싱시 에러 방지). */
		if ("".equals(age))						age = "0";
		if ("".equals(previousCareer))		previousCareer = "0";
		if ("".equals(skillLevel))			skillLevel = "0";
		
		int ageInt = Integer.parseInt(age);
		int previousCareerInt = Integer.parseInt(previousCareer);
		int skillLevelInt = Integer.parseInt(skillLevel);
		
		/* 입력된 정보의 유효성을 검사한다. */
		if (!FieldValidator.validateField(employeeNumber, 8, 8, "[^\\d]"))
			throw new InputDataNotValidException("사원번호가 유효하지 않습니다.");
		else if (!FieldValidator.validateField(userID, 6, 20, "[^\\w\\d]"))
			throw new InputDataNotValidException("아이디가 유효하지 않습니다.");
		else if (!FieldValidator.validateField(userPassword, 6, 20, "[^\\x00-\\x7F]")	// [^\\x00-\\x7F]: ASCII 코드
				|| !userPassword.equals(userPasswordCheck))				// 비밀번호 일치여부 추가 검사.
			throw new InputDataNotValidException("비밀번호가 유효하지 않습니다.");
		else if (!FieldValidator.validateField(name, 2, 20, "[^\\가-힣a-zA-Z]"))
			throw new InputDataNotValidException("이름이 유효하지 않습니다.");
		else if (!FieldValidator.validateField(age, 2, 3, "[^\\d]")
				|| (ageInt <= 10 || ageInt > 100))
			throw new InputDataNotValidException("나이가가 유효하지 않습니다.");
		
		/* 입력된 정보의 중복성을 검사한다. */
		else if(FieldValidator.isExistInDB("employee", "employee_number", employeeNumber))
			throw new InputDataRedundantException("입력한 사원번호가 이미 사용중입니다.");
		else if(FieldValidator.isExistInDB("profile", "id", userID))
			throw new InputDataRedundantException("입력한 아이디가 이미 사용중입니다.");
		
		/* 입력된 정보가 유효한 경우, DB에 삽입한다. */
		else {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(URL, ID, PASSWORD);;
			PreparedStatement ps = null;
			String sql = null;
			
			/* employee 테이블에 직원 정보를 삽입한다. */
			sql = "INSERT INTO employee (employee_number, final_education, previous_career) "
					+ "VALUES (?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, employeeNumber);
			ps.setString(2, finalEducaion);
			ps.setInt(3, previousCareerInt);
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
			ps.setInt(5, ageInt);
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
			ps.setInt(3, skillLevelInt);
			ps.executeUpdate();
			ps.close();
			
			return true;
		}
	}
	
}