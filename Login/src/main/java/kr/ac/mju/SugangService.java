package kr.ac.mju;

import java.awt.List;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SugangService {
	
	public Vector<KangjwaInfo> getList() throws FileNotFoundException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from dkangjwa";
		
		connection = DriverManager.getConnection(Constants.URL,Constants.ID,Constants.PASSWORD);
		statement = connection.prepareStatement(sql);
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

	public void sincheong(String sID, String kID) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "Insert into dsugang(S_ID, K_NUMBER) values(?,?)";
		
		connection = DriverManager.getConnection(Constants.URL,Constants.ID,Constants.PASSWORD);
		statement = connection.prepareStatement(sql);
		statement.setString(1, sID);
		statement.setString(2, kID);
		statement.executeUpdate();
		
		System.out.println("학번 : "+sID);
		System.out.println("강좌번호 : "+kID);
		System.out.println("수강신청");
		
		connection.close();
		statement.close();
	}

	public Vector<SugangInfo> mysugang(String ID) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select K_NUMBER, K_NAME, P_NAME, K_YEAR, K_GRADE, K_CREDIT, K_MEMBER, S_CREDIT from (select * from dsugang where S_ID=?) natural join DKANGJWA";
		
		connection = DriverManager.getConnection(Constants.URL,Constants.ID,Constants.PASSWORD);
		statement = connection.prepareStatement(sql);
		statement.setString(1, ID);
		resultSet = statement.executeQuery();
		
		Vector<SugangInfo> result = new Vector<SugangInfo>();
		
		
		while(resultSet.next()){
			SugangInfo tmp = new SugangInfo();
			tmp.setSugangID(resultSet.getString("K_NUMBER"));
			tmp.setSugangName(resultSet.getString("K_NAME"));
			tmp.setSugangGyosu(resultSet.getString("P_NAME"));
			tmp.setSugangYear(resultSet.getString("K_YEAR"));
			tmp.setSugangGrade(resultSet.getString("K_GRADE"));
			tmp.setSugangCredit(resultSet.getString("K_CREDIT"));
			tmp.setSugangMember(resultSet.getString("K_MEMBER"));
			tmp.setSugangMyCredit(resultSet.getString("S_CREDIT"));
			
			result.add(tmp);
		}
		
		connection.close();
		statement.close();
		resultSet.close();
		
		return result;
	}

	
//	public List getList() throws SQLException, ClassNotFoundException{
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Connection connection = null;
//		PreparedStatement statement = null;
//		ResultSet resultSet = null;
//		
//		String sql = "select * from dkangjwa";
//		
//		connection = DriverManager.getConnection(Constants.URL,Constants.ID,Constants.PASSWORD);
//		statement = connection.prepareStatement(sql);
//		resultSet = statement.executeQuery();
//		
//		return (List) resultSet;
//		
//	}
	
}
