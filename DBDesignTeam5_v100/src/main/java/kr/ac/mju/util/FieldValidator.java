package kr.ac.mju.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kr.ac.mju.Constants;

/**
 * 문자열 필드의 유효성과 중복성(DB)을 검사하는 클래스.
 */
public class FieldValidator
{
	
	/**
	 * 'tableName' 테이블의 'attrName'이란 속성값 중에
	 * 'field'라는 필드가 존재하는지 검사한다.
	 * 
	 * @param tableName
	 * @param attrName
	 * @param field
	 * @return 이미 존재할 경우 true, 존재하지 않을 경우 false를 반환한다.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static boolean isExistInDB(String tableName, String attrName, String field) throws SQLException, ClassNotFoundException {
		Class.forName(Constants.DRIVER);
		Connection conn = DriverManager.getConnection(
				Constants.URL, Constants.ID, Constants.PASSWORD);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql;
		
		sql = String.format("SELECT * FROM %s WHERE %s=?", tableName, attrName);
		ps = conn.prepareStatement(sql);
		ps.setString(1, field);
		rs = ps.executeQuery();
		
		if (rs.next())	return true;
		else			return false;
	}
	
	/**
	 * 입력된 정보의 유효성을 검사한다.<br />
	 * 'field'의 길이가 'minLen'과 'maxLen' 사이인지(in-bound) 검사한다.
	 * @return 위 조건들을 만족할 경우 true, 만족하지 않을 경우 false.
	 */
	public static boolean validateField(String field, int minLen, int maxLen) {
		return validateField(field, minLen, maxLen, null);
	}
	
	/**
	 * 입력된 정보의 유효성을 검사한다.<br />
	 * 'field'의 길이가 'minLen'과 'maxLen' 사이인지(in-bound),
	 * 그리고 'regex'를 만족하지 않는지 여부를 검사한다.
	 * <p>주의: regex를 만족하면 false를 반환한다.
	 * 
	 * @return 위 조건들을 만족할 경우 true, 만족하지 않을 경우 false.
	 */
	public static boolean validateField(String field, int minLen, int maxLen, String regex) {
		
		/* field의 길이가 minLen과 maxLen 사이인지 검사한다. */
		if (field.length() < minLen || field.length() > maxLen) {
			return false;
		}
		
		/* regex가 존재하면,
		 * regex와 일치하는지 추가로 검사한다. */
		if (regex != null) {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(field);
			
			return !matcher.find();
		}
		
		/* 모든 검사를 통과하면 true 반환. */
		return true;
		
	}
	
	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		String fields[] = {"12345", "123456", "12a3b4c56", "10000101", "!Q@W#E$R%T^Y"};
		
		String tableName = "employee";
		String attrName = "employee_number";
		String empNums[] = {"10000001", "10000050", "10000100", "10000150", "10000200"};
		
		System.out.println("### DB 중복성 검사 ###");
		for (String entry : empNums) {
			System.out.println("Is '" + attrName + "' '" + entry + "' exists in table '" + tableName + "'? "
					+ isExistInDB(tableName, attrName, entry));
		}
		System.out.println();
		
		System.out.println("### 직원사번 검사 ###");
		for (String entry : fields) {
			System.out.println(entry + ": " + FieldValidator.validateField(entry, 8, 8, "[^\\d]"));
		}
		System.out.println();
		
		System.out.println("### 아이디 검사 ###");
		for (String entry : fields) {
			System.out.println(entry + ": " + FieldValidator.validateField(entry, 6, 20, "[^\\w\\d]"));
		}
		System.out.println();
		
		System.out.println("### 비밀번호 검사 ###");
		for (String entry : fields) {
			System.out.println(entry + ": " + FieldValidator.validateField(entry, 6, 20, "[^\\x00-\\x7F]"));
		}
		System.out.println();
	}
	
}