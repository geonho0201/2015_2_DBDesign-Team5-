package kr.ac.mju;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;


@Service
public class LoginService {

	private final static String URL= Constants.URL;
	private final static String ID= Constants.ID;
	private final static String PASSWORD= Constants.PASSWORD;
	private void closeConnection(Connection connection, Statement statement, ResultSet resultSet)throws SQLException{
		if(connection == null){
			return;
		}
		connection.close();
		statement.close();
		resultSet.close();
	}
	
	public User login(String userID, String userPassword) throws FileNotFoundException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from profile";
		User user = null;
		
			connection = DriverManager.getConnection(URL, ID, PASSWORD);
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				String id = resultSet.getString("id");
				String password = resultSet.getString("password");
				
				if(id.equals(userID) && password.equals(userPassword)){
					user = new User();
					user.setID(id);
					user.setName(resultSet.getString("name"));
					user.setPassword(password);
					closeConnection(connection, statement, resultSet);
					return user;
				}
			}
			
		closeConnection(connection, statement, resultSet);
		
		return null;
	}

//	public void join(String userID, String userPW, String userName,
//			String userType) throws ClassNotFoundException, SQLException {
//		// TODO Auto-generated method stub
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Connection connection = null;
//		PreparedStatement statement = null;
//		ResultSet resultSet = null;
//		
//		String sql = "Insert into duser values (?,?,?,?)";
//		
//		connection = DriverManager.getConnection(URL,ID,PASSWORD);
//		statement = connection.prepareStatement(sql);
//		statement.setString(1, userID);
//		statement.setString(2, userPW);
//		statement.setString(3, userName);
//		statement.setString(4, userType);
//		statement.executeUpdate();
//		
//		connection.close();
//		statement.close();
//		
//		System.out.println("회원가입완료");
//	}
}

