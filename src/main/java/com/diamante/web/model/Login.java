package com.diamante.web.model;

public class Login {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	public Login(String username, String password, String firstName, String lastName){
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public String toString() {
		return "Username: " + username + " Password: " + password + " Name: " +  firstName + " " + lastName;  
	}

}
