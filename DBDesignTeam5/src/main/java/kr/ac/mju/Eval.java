package kr.ac.mju;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class Eval {
	private String evaluatee_number;
	private String project_number;
	private String evaluater_number;
	private String eval_type;
	private int business_score;
	private String business_eval;
	private int communication_score;
	private String communication_eval;
	
	public String getEvaluatee_number() {
		return evaluatee_number;
	}
	public void setEvaluatee_number(String evaluatee_number) {
		this.evaluatee_number = evaluatee_number;
	}
	public String getProject_number() {
		return project_number;
	}
	public void setProject_number(String project_number) {
		this.project_number = project_number;
	}
	public String getEvaluater_number() {
		return evaluater_number;
	}
	public void setEvaluater_number(String evaluater_number) {
		this.evaluater_number = evaluater_number;
	}
	public String getEval_type() {
		return eval_type;
	}
	public void setEval_type(String eval_type) {
		this.eval_type = eval_type;
	}
	public int getBusiness_score() {
		return business_score;
	}
	public void setBusiness_score(int business_score) {
		this.business_score = business_score;
	}
	public String getBusiness_eval() {
		return business_eval;
	}
	public void setBusiness_eval(String business_eval) {
		this.business_eval = business_eval;
	}
	public int getCommunication_score() {
		return communication_score;
	}
	public void setCommunication_score(int communication_score) {
		this.communication_score = communication_score;
	}
	public String getCommunication_eval() {
		return communication_eval;
	}
	public void setCommunication_eval(String communication_eval) {
		this.communication_eval = communication_eval;
	}
	
}