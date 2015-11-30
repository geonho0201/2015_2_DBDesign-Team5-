package kr.ac.mju;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	 */
	public User join(String userID, String userPassword,
			String userPasswordCheck, String name, String age,
			String phoneNumber, String address, String email,
			String ssnPrefix, String ssnSuffix, String worksDepartment,
			String position) throws ClassNotFoundException {
		
		// ID 유효성 검사
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT";

		return null;
	}
}
