package com.diamante.web.model;

import java.time.LocalDate;

public class Job{

private int jobNo;
private LocalDate date;
private String employer;
private String location;
private String position;
private String salary;
private String result;


public Job(LocalDate date, String employer, String location, String position, String salary, String result) {
	super();
	this.date = date;
	this.employer = employer;
	this.location = location;
	this.position = position;
	this.salary = salary;
	this.result = result;
}

public int getJobNo() {
	return jobNo;
}
public void setJobNo(int jobNo) {
	this.jobNo = jobNo;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public String getEmployer() {
	return employer;
}
public void setEmployer(String employer) {
	this.employer = employer;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public String getResult() {
	return result;
}
public void setResult(String result) {
	this.result = result;
}






}