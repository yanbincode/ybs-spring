package ioc.bean.impl;

import ioc.bean.DB;

public class MssqlDBImpl implements DB {

	private String username;
	private String password;

	public void save() {
		System.out.println("i am mssql db connect");
		System.out.println(username);
		System.out.println(password);
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

}