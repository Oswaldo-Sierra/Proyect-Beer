package com.edu.uptc.handlingBeer.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/** */
public class Config {
	private static Config config;

	private String pathFile;

	private String nameFileTXT;

	private String nameFileCSV;

	private String nameFileJSON;

	private String nameFileXML;

	private String nameFileSer;

	private String userFileSer;
	
	private String SalesOfBeerTXT;
	
	private String SalesOfBeerCSV;
	
	private String SalesOfBeerJSON;
	
	private String SalesOfBeerXML;
	
	private String SalesOfBeerSER;	

	private Properties properties;

	private Config() {
		this.properties = new Properties();
		try (FileInputStream entrada = new FileInputStream("resources/config/appconfig.properties")) {
			// lo connvierte en un mapa
			properties.load(entrada);
			//Cervezas
			this.pathFile = properties.getProperty("app.config.path.file");
			this.nameFileTXT = properties.getProperty("app.config.path.file.name.txt");
			this.nameFileCSV = properties.getProperty("app.config.path.file.name.csv");
			this.nameFileJSON = properties.getProperty("app.config.path.file.name.json");
			this.nameFileXML = properties.getProperty("app.config.path.file.name.xml");
			this.nameFileSer = properties.getProperty("app.config.path.file.name.ser");
			//Usuario
			this.userFileSer = properties.getProperty("app.config.path.file.user.ser");
			//Ventas
			this.SalesOfBeerTXT = properties.getProperty("app.config.path.file.SalesOfBeer.txt");
			this.SalesOfBeerCSV = properties.getProperty("app.config.path.file.SalesOfBeer.csv");
			this.SalesOfBeerJSON = properties.getProperty("app.config.path.file.SalesOfBeer.json");
			this.SalesOfBeerXML = properties.getProperty("app.config.path.file.SalesOfBeer.xml");
			this.SalesOfBeerSER = properties.getProperty("app.config.path.file.SalesOfBeer.ser");
			
		} catch (IOException ex) {
			System.err.println("Error al cargar el archivo properties de configuración: " + ex.getMessage());
		}
	}

	public static Config getInstance() {
		if (Objects.isNull(config)) {
			config = new Config();
		}
		return config;
	}
	
	

	public String getUserFileSer() {
		return userFileSer;
	}

	public void setUserFileSer(String userFileSer) {
		this.userFileSer = userFileSer;
	}

	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public String getNameFileTXT() {
		return nameFileTXT;
	}

	public void setNameFileTXT(String nameFileTXT) {
		this.nameFileTXT = nameFileTXT;
	}

	public String getNameFileCSV() {
		return nameFileCSV;
	}

	public void setNameFileCSV(String nameFileCSV) {
		this.nameFileCSV = nameFileCSV;
	}

	public String getNameFileJSON() {
		return nameFileJSON;
	}

	public void setNameFileJSON(String nameFileJSON) {
		this.nameFileJSON = nameFileJSON;
	}

	public String getNameFileXML() {
		return nameFileXML;
	}

	public void setNameFileXML(String nameFileXML) {
		this.nameFileXML = nameFileXML;
	}

	public String getNameFileSer() {
		return nameFileSer;
	}

	public void setNameFileSer(String nameFileSer) {
		this.nameFileSer = nameFileSer;
	}

	public String getSalesOfBeerTXT() {
		return SalesOfBeerTXT;
	}

	public void setSalesOfBeerTXT(String salesOfBeerTXT) {
		SalesOfBeerTXT = salesOfBeerTXT;
	}

	public String getSalesOfBeerCSV() {
		return SalesOfBeerCSV;
	}

	public void setSalesOfBeerCSV(String salesOfBeerCSV) {
		SalesOfBeerCSV = salesOfBeerCSV;
	}

	public String getSalesOfBeerJSON() {
		return SalesOfBeerJSON;
	}

	public void setSalesOfBeerJSON(String salesOfBeerJSON) {
		SalesOfBeerJSON = salesOfBeerJSON;
	}

	public String getSalesOfBeerXML() {
		return SalesOfBeerXML;
	}

	public void setSalesOfBeerXML(String salesOfBeerXML) {
		SalesOfBeerXML = salesOfBeerXML;
	}

	public String getSalesOfBeerSER() {
		return SalesOfBeerSER;
	}

	public void setSalesOfBeerSER(String salesOfBeerSER) {
		SalesOfBeerSER = salesOfBeerSER;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	
}
