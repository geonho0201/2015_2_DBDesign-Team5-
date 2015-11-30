package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	private final static String URL = Constants.URL;
	private final static String ID = Constants.ID;
	private final static String PASSWORD = Constants.PASSWORD;

	/**
	 * ### 로직 개선 요망 ###
	 * <p>사용자로부터 입력받은 ID와 비밀번호로 로그인을 시도한다.<br />
	 * DB에 저장된 모든 계정정보를 불러와서 입력된 정보와 순차적으로 비교한다.
	 * 일치할 경우 마지막 로그인 시각을 갱신하고 유저 정보를 불러와 반환한다.
	 * 
	 * @param userId
	 * @param userPassword
	 * @return user 로그인한 유저 인스턴스
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public User login(String userId, String userPassword) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM profile";
		User user = null;

		conn = DriverManager.getConnection(URL, ID, PASSWORD);
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();

		while (rs.next()) {
			String id = rs.getString("id");
			String password = rs.getString("password");

			if (id.equals(userId) && password.equals(userPassword)) {
				rs.close();
				stmt.close();

				sql = "UPDATE profile SET last_signin_time=SYSTIMESTAMP WHERE id='" + id + "'";
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
				stmt.close();

				sql = "SELECT * FROM profile NATURAL JOIN works_department WHERE id = '" + id + "'";
				stmt = conn.prepareStatement(sql);
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
				user.setPosition(rs.getString("position"));

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
