package kr.ac.mju;

public class Constants {
	
	static String path = Constants.class.getResource("").getPath();
	
	public static final String TypeAdmin = "������";
	public static final String TypeGyosu = "����";
	public static final String TypeStudent = "�л�";

	
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String ID = "sogong2015";
	public static final String PASSWORD = "mju12345";
}
