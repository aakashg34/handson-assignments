package com.hsbc.model.beans;

public class User {
	
	private int userId;
	private String name;
	private String dob;
	private String password;
	private long phone;
	public User(int userId, String name, String dob, String password, long phone) {
		super();
		this.userId = userId;
		this.name = name;
		this.dob = dob;
		this.password = password;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getUserId() {
		return userId;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", dob=" + dob + ", password=" + password + ", phone="
				+ phone + "]";
	}
	public User(String name2, String dob2, String password2, long cont) {
		super();
		// TODO Auto-generated constructor stub
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
