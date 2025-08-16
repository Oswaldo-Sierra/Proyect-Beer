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
	
	private Properties properties;
	
	private Config() {
		this.properties= new Properties();
		try (FileInputStream entrada = new FileInputStream("resources/config/appconfig.properties")) {
			//lo connvierte en un mapa
			properties.load(entrada);
            this.pathFile = properties.getProperty("app.config.path.file");
            this.nameFileTXT =  properties.getProperty("app.config.path.file.name.txt");
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
	
	

}
