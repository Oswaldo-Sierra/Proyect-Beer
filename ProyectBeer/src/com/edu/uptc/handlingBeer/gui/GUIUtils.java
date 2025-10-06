package com.edu.uptc.handlingBeer.gui;

import java.awt.Color;

public class GUIUtils {

	private static long serialVersionUID = 1L;

	public static Color getPrincipalColor() {
		return new Color(Integer.parseInt("255"), Integer.parseInt("209"), Integer.parseInt("102"));
	}

	public static Color getSecundaryColor() {
		return new Color(Integer.parseInt("141"), Integer.parseInt("85"), Integer.parseInt("36"));
	}

	public static Color getComplementaryColor() {
		return new Color(Integer.parseInt("47"), Integer.parseInt("133"), Integer.parseInt("90"));
	}

	public static Color getNeutralColor() {
		return new Color(Integer.parseInt("26"), Integer.parseInt("32"), Integer.parseInt("44"));
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		GUIUtils.serialVersionUID = serialVersionUID;
	}

}
