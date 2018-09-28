package org.bildit.model;

public class User {
	
	private int userId;
	private String firstName;
	private String lastName;
	private String password;
	
	public User(){
		
	}
	public User(int userId, String firstName, String lastName, String password) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User ID:" + userId + ", first name:" + firstName
				+ ", last name:" + lastName + ", password:" + password;
	}
}
