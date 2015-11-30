package kr.ac.mju;

import java.sql.Date;

import org.springframework.stereotype.Repository;

public class Project {
	private String project_number;
	private String project_name;
	private Date start_date;
	private Date due_date;
	private String orderer;
	private String project_desc;
	
	public String getProject_number() {return project_number;}
	public void setProject_number(String project_number) {this.project_number = project_number;}
	public String getProject_name() {return project_name;}
	public void setProject_name(String project_name) {this.project_name = project_name;}
	public Date getStart_date() {return start_date;}
	public void setStart_date(Date start_date) {this.start_date = start_date;}
	public Date getDue_date() {return due_date;}
	public void setDue_date(Date due_date) {this.due_date = due_date;}
	public String getOrderer() {return orderer;}
	public void setOrderer(String orderer) {this.orderer = orderer;}
	public String getProject_desc() {return project_desc;}
	public void setProject_desc(String project_desc) {this.project_desc = project_desc;}
	
	

}