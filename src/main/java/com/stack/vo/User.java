package com.stack.vo;

/**
 * 一个简单的实体类
 * @author Administrator
 *
 */
public class User {

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
