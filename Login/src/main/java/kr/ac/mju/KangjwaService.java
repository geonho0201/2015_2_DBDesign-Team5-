package kr.ac.mju;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KangjwaService {
	private final static String URL= Constants.URL;
	private final static String ID= Constants.ID;
	private final static String PASSWORD= Constants.PASSWORD;
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, ID, PASSWORD);
	}
	
	private void closeConnection(Connection connection, Statement statement, ResultSet resultSet)throws SQLException{
		if(connection == null){
			return;
		}
		connection.close();
		statement.close();
		resultSet.close();
	}
	
	public void gaseol(String professorID, String professorName, String kangjwaID, String kangjwaName,
			String kangjwaYear, String kangjwaGrade, String kangjwaMember, String kangjwaCredit) throws FileNotFoundException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "Insert into dkangjwa values(?,?,?,?,?,?,?,?)";
		
		connection = DriverManager.getConnection(URL,ID,PASSWORD);
		statement = connection.prepareStatement(sql);
		statement.setString(1, professorID);
		statement.setString(2, kangjwaID);
		statement.setString(3, kangjwaName);
		statement.setString(4, kangjwaYear);
		statement.setString(5, kangjwaGrade);
		statement.setString(6, kangjwaMember);
		statement.setString(7, kangjwaCredit);
		statement.setString(8, professorName);
		statement.executeQuery();
		
		System.out.println("개설완료");
		connection.close();
		statement.close();
	}

	public Vector<KangjwaInfo> myKangjwa(String pID) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from dkangjwa where P_ID=?";
		
		connection = DriverManager.getConnection(URL,ID,PASSWORD);
		statement = connection.prepareStatement(sql);
		statement.setString(1, pID);
		resultSet = statement.executeQuery();
		
		Vector<KangjwaInfo> result = new Vector<KangjwaInfo>();
		
		while(resultSet.next()){
			KangjwaInfo tmp = new KangjwaInfo();
			tmp.setKangjwaGyosuID(resultSet.getString("P_ID"));
			tmp.setKangjwaID(resultSet.getString("K_NUMBER"));
			tmp.setKangjwaName(resultSet.getString("K_NAME"));
			tmp.setKangjwaYear(resultSet.getString("K_YEAR"));
			tmp.setKangjwaGrade(resultSet.getString("K_GRADE"));
			tmp.setKangjwaMember(resultSet.getString("K_MEMBER"));
			tmp.setKangjwaCredit(resultSet.getString("K_CREDIT"));
			tmp.setKangjwaGyosu(resultSet.getString("P_NAME"));
			result.add(tmp);
		}
		
		connection.close();
		statement.close();
		resultSet.close();
		
		return result;
	}

	public Vector<SugangInfo> seongjeok(String kID) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from DUSER join (select * from dsugang where K_NUMBER = ?) on DUSER.ID = S_ID";
		
		connection = DriverManager.getConnection(URL,ID,PASSWORD);
		statement = connection.prepareStatement(sql);
		statement.setString(1, kID);
		resultSet = statement.executeQuery();
		
		Vector<SugangInfo> result = new Vector<SugangInfo>();
		
		while(resultSet.next()){
			SugangInfo tmp = new SugangInfo();
			tmp.setSugangName(resultSet.getString("NAME"));
			tmp.setSugangMyCredit(resultSet.getString("S_CREDIT"));
			tmp.setSugangID(resultSet.getString("S_ID"));
			tmp.setSugangGyosu(resultSet.getString("K_NUMBER"));
			result.add(tmp);
		}
		
		connection.close();
		statement.close();
		resultSet.close();
		
		return result;
	}

	public void seongjeokBuyeo(String sJK, String kID, String sID) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql ="UPDATE DSUGANG SET S_CREDIT = ? WHERE S_ID=? AND K_NUMBER=?";
		
		connection = DriverManager.getConnection(URL,ID,PASSWORD);
		statement = connection.prepareStatement(sql);
		statement.setString(1, sJK);
		statement.setString(2, sID);
		statement.setString(3, kID);
		statement.executeUpdate();
	}

}
