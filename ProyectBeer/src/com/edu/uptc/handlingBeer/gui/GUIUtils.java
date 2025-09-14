package com.edu.uptc.handlingBeer.gui;

import java.awt.Color;

public class GUIUtils {

	private static  long serialVersionUID = 1L;

	public static Color getPrincipalcolor() {
		return new Color(Integer.parseInt("24")
				,Integer.parseInt("100")
				,Integer.parseInt("2"));
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		GUIUtils.serialVersionUID = serialVersionUID;
	}

}
