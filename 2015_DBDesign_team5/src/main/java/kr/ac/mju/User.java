package kr.ac.mju;

public class User {
	private String ID;
	private String Password;
	private String Name;
	private String type;
	private String office;
	
	public String getID() { return ID; }
	public void setID(String iD) { ID = iD; }
	public String getName() { return Name; }
	public void setName(String name) { Name = name; }
	public String getPassword() { return Password; }
	public void setPassword(String password) { Password = password; }
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }
	public String getOffice(){return office;}
	public void setOffice(String office){this.office=office;}
	
}
