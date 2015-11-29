package kr.ac.mju;

import java.sql.Date;

public class Assignment {
	private String name;
	private String employee_number;
	private String project_number;
	private Date assign_date;
	private Date abort_date;
	private String job;
	
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getEmployee_number() {return employee_number;}
	public void setEmployee_number(String employee_number) {this.employee_number = employee_number;}
	public String getProject_number() {return project_number;}
	public void setProject_number(String project_number) {this.project_number = project_number;}
	public Date getAssign_date() {return assign_date;}
	public void setAssign_date(Date assign_date) {this.assign_date = assign_date;}
	public Date getAbort_date() {return abort_date;}
	public void setAbort_date(Date abort_date) {this.abort_date = abort_date;}
	public String getJob() {return job;}
	public void setJob(String job) {this.job = job;}
	
	

}