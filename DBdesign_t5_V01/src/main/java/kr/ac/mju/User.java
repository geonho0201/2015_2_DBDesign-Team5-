package kr.ac.mju;

public class User {
	private String employee_number;
	private String id;
	private String password;
	private String name;
	private int age;
	private String phone_number;
	private String address;
	private String email;
	private String SSN;
	private String signup_date;
	private String last_modified_time;
	private String last_signin_time;
	
	public String getEmployee_number() {return employee_number;}
	public void setEmployee_number(String employee_number) {this.employee_number = employee_number;}
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public String getPhone_number() {return phone_number;}
	public void setPhone_number(String phone_number) {this.phone_number = phone_number;}
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getSSN() {return SSN;}
	public void setSSN(String sSN) {SSN = sSN;}
	public String getSignup_date() {return signup_date;}
	public void setSignup_date(String signup_date) {this.signup_date = signup_date;}
	public String getLast_modified_time() {return last_modified_time;}
	public void setLast_modified_time(String last_modified_time) {this.last_modified_time = last_modified_time;}
	public String getLast_signin_time() {return last_signin_time;}
	public void setLast_signin_time(String last_signin_time) {this.last_signin_time = last_signin_time;}
	
}
