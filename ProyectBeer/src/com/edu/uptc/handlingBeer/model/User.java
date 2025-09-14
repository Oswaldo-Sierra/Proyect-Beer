package com.edu.uptc.handlingBeer.model;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 7758888672641333914L;
	private String nameUser;
	private String password;
	
	public User(String nameUser, String password) {
		this.nameUser = nameUser;
		this.password = password;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
