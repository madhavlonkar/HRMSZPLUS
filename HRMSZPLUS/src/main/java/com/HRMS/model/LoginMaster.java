package com.HRMS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_login")

public class LoginMaster {

	@Id
	private int userId;

	private String username;
	private String password;
	private String position;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "LoginMaster [userId=" + userId + ", username=" + username + ", password=" + password + ", position="
				+ position + "]";
	}

	public LoginMaster(int userId, String username, String password, String position) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.position = position;
	}

	public LoginMaster() {
		super();
	}

}
