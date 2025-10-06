package com.edu.uptc.handlingBeer.gui;

public class InfoSesion {
	private static String userName;
	private static String passwordUser;

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		InfoSesion.userName = userName;
	}

	public static String getPasswordUser() {
		return passwordUser;
	}

	public static void setPasswordUser(String passwordUser) {
		InfoSesion.passwordUser = passwordUser;
	}

	// Cerrar sesión
    public static void clear() {
        userName = null;
        passwordUser = null;
    }
}
