package com.edu.uptc.handlingBeer.persistence;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays; 
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.edu.uptc.handlingBeer.constants.CommonConstants;
import com.edu.uptc.handlingBeer.enums.ETypeFile;
import com.edu.uptc.handlingBeer.interfaces.*;
import com.edu.uptc.handlingBeer.model.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

 
public class HandlingPersistenceBeer extends FilePlain 
	implements IActionsFile  {
	
	private List<Beer> listBeer;
	
	public HandlingPersistenceBeer() {
		listBeer = new ArrayList<>();
	}
	
	/** Metodo que se encarga de añadir nuevos objetos(En este caso de tipo beer). */
	public Boolean addBeers(Beer beer) {
		if(Objects.isNull(this.findBeerBySerialNumber(beer.getSerialNumber()))) {
			this.listBeer.add(beer);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	/** Metodo que se encarga de verficar que no existan dos tipos de objetos iguales(Por medio de un atributo en este caso). */
	public Beer findBeerBySerialNumber(String serialNumber) {
		for(Beer beer: this.listBeer) {
			if(beer.getSerialNumber().contentEquals(serialNumber)) {
				return beer;
			}
		}
		return null;
	}
	
	
	/** Metodo que se encarga de volcar la informacion registrada por el usuario dependiendo del tipo de archivo plano. */
	@Override
	public void dumpFile(ETypeFile eTypeFile) {
		if(ETypeFile.FILE_PLAIN.equals(eTypeFile)) {
			String nameFileTXT = config.getNameFileTXT();
			this.dumpFilePlain(nameFileTXT);
		}
		
		if (ETypeFile.CSV.equals(eTypeFile)) {
			String nameFileCSV = config.getNameFileCSV();
			this.dumpFilePlain(nameFileCSV);
			
		}
		if (ETypeFile.JSON.equals(eTypeFile)) {
			dumpFileJSON();
			
		}
		if (ETypeFile.XML.equals(eTypeFile)) {
			dumpFileXML();
			
		}
		if (ETypeFile.SER.equals(eTypeFile)) {
			dumpFileSerializate();
		}
	}
	
	

	/** Metodo encargado de cargar la informacion del archivo plano despues de que se halla cerrado el programa y vuelvo a abrir. */
	@Override 
	public void loadFile(ETypeFile eTypeFile) {
		if(ETypeFile.FILE_PLAIN.equals(eTypeFile)) {
			String nameFileTXT = config.getNameFileTXT();
			this.loadFilePlain(nameFileTXT);
		}
		if (ETypeFile.CSV.equals(eTypeFile)) {
			String nameFileCSV = config.getNameFileCSV();
			this.loadFilePlain(nameFileCSV);
		}
		if (ETypeFile.JSON.equals(eTypeFile)) {
		    loadFileJSON();
		    
		}
		if (ETypeFile.XML.equals(eTypeFile)) {
			loadFileXML();
			
		}
		if (ETypeFile.SER.equals(eTypeFile)) {
			loadFileSerializate();
		}

		
	}
	

	
/*
	private void dumpFileJSON() {
		String rutaArchivo = config.getPathFile()
				.concat(config.getNameFileJSON());
		StringBuilder json = null;
		List<String> content = new ArrayList<String>();
		content.add(CommonConstants.OPENING_BRACKET);
		int cont = 0;
		int total = listBeer.size();
		for (Beer b : this.listBeer) {
			json = new StringBuilder();
			json.append("{");
			json.append(" \"serialNumber\":\"").append(escape(b.getSerialNumber())).append("\",");
			json.append(" \"brand\":\"").append(escape(b.getBrand())).append("\",");
			json.append(" \"type\":\"").append(escape(b.getType())).append("\",");
			json.append(" \"ABV\":\"").append(escape(b.getABV())).append("\",");
			json.append(" \"IBU\":\"").append(escape(b.getIBU())).append("\",");
			json.append(" \"origin\":\"").append(escape(b.getOrigin())).append("\"");
			json.append("}");
			
			cont ++;
			if (cont<total) {
				json.append(",");
			}
			content.add(json.toString());
		}
		
		content.add(CommonConstants.CLOSING_BRACKET);
		this.writer(rutaArchivo, content);
		
	}

	private String escape(String value) {
	    if (value == null) return "";
	    return value.replace("\\", "\\\\").replace("\"", "\\\"");
	    }
	    
	
	    
	    private void loadFileJSON() {
		List<String> contentInLine = this.reader(
				config.getPathFile().concat(config.getNameFileJSON()))
				.stream().filter(line -> !line.equals("[") && !line.equals("]") &&
						!line.equals(CommonConstants.BREAK_LINE) &&
						!line.trim().isEmpty() && !line.trim().isBlank())
				.collect(Collectors.toList());   
		for(String line: contentInLine) {
			line = line.replace("{", "").replace("},", "").replace("}", "");
			StringTokenizer tokens = new StringTokenizer(line, ",");
			
			while(tokens.hasMoreElements()){
				String serialNumber = this.escapeValue(tokens.nextToken().split(":")[1]);
				String brand = this.escapeValue(tokens.nextToken().split(":")[1]);
				String type = this.escapeValue(tokens.nextToken().split(":")[1]);
				String ABV = this.escapeValue(tokens.nextToken().split(":")[1]);
				String IBU = this.escapeValue(tokens.nextToken().split(":")[1]);
				String origin = this.escapeValue(tokens.nextToken().split(":")[1]);
				this.listBeer.add(new Beer(serialNumber, brand,
						type, ABV, IBU, origin));
			}
		}
	}
	
	private String escapeValue(String value) {
		return value.replace("\"", "");
	}
	    
	*/
	
	/** De aqui en adelante estaran los metodos de volcado y carga dependiendo el archivo plano. */
	
	/** Volcado de archivo plano tipo txt/CSV/Entre otros. */
	private void dumpFilePlain(String nameFile) {
		StringBuilder rutaArchivo = new StringBuilder();
		rutaArchivo.append(config.getPathFile());
		rutaArchivo.append(nameFile);
		List<String> records = new ArrayList<>();
		
		 for(Beer beer : this.listBeer){
			 StringBuilder contentBeer = new StringBuilder();
			 contentBeer.append(beer.getSerialNumber()).append(CommonConstants.SEMICOLON);
			 contentBeer.append(beer.getBrand()).append(CommonConstants.SEMICOLON);
			 contentBeer.append(beer.getType()).append(CommonConstants.SEMICOLON);
			 contentBeer.append(beer.getABV()).append(CommonConstants.SEMICOLON);
			 contentBeer.append(beer.getIBU()).append(CommonConstants.SEMICOLON);
			 contentBeer.append(beer.getOrigin());
			 records.add(contentBeer.toString());
		 }
		 this.writer(rutaArchivo.toString(), records);
	}
	
	/** Cargue de la informacion de archivo plano tipo txt/CSV/Entre otros.*/
	private void loadFilePlain(String nameFile) {
		List<String> contentInLine = this.reader(
				config.getPathFile().concat(
						nameFile));
		contentInLine.forEach(row -> {
			StringTokenizer tokens = new StringTokenizer(
					row, CommonConstants.SEMICOLON);
			while(tokens.hasMoreElements()){
				String serialNumber = tokens.nextToken();
				String brand = tokens.nextToken();
				String type = tokens.nextToken();
				String ABV = tokens.nextToken();
				String IBU = tokens.nextToken();
				String origin = tokens.nextToken();
				this.listBeer.add(new Beer(serialNumber, brand,
						type, ABV, IBU, origin));
			}
		});
	}
	
	
	/** Volcado de informacion tipo JSON usando la libreria Gson. */
	private void dumpFileJSON() {
	    String rutaArchivo = config.getPathFile()
	            .concat(config.getNameFileJSON());

	    try (FileWriter writer = new FileWriter(rutaArchivo)) {
	        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // formato bonito
	        gson.toJson(this.listBeer, writer);  // Serializa toda la lista
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	/** Cargue de informacion tipo JSON usando la libreria Gson. */
	private void loadFileJSON() {
	    String rutaArchivo = config.getPathFile()
	            .concat(config.getNameFileJSON());

	    try (FileReader reader = new FileReader(rutaArchivo)) {
	        Gson gson = new Gson();
	        Beer[] beersArray = gson.fromJson(reader, Beer[].class);
	        this.listBeer = new ArrayList<>(Arrays.asList(beersArray));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	
	/** Volcado de informacion tipo XML. */
	private void dumpFileXML() {
		String rutaArchivo = config.getPathFile()
				.concat(config.getNameFileXML());
		
		List<String> records = new ArrayList<String>();
		records.add("<XML version= \"1.0\" encoding =\"UTF-8\"> \n");//se inicia la etiqueta del inicio de xml
		for (Beer beer : this.listBeer) {
			records.add("<Beer>");
			records.add("\t<SerialNumbre>"+beer.getSerialNumber()+"</SerialNumbre>");
			records.add("\t<Brand>" + beer.getBrand() + "</Brand>");
			records.add("\t<Type>"+beer.getType()+"</Type>");
			records.add("\t<ABV>"+beer.getABV()+"</ABV>");
			records.add("\t<IBU>"+beer.getIBU()+"</IBU>");
			records.add("\t<Origin>"+beer.getOrigin()+"</Origin> \n");
			records.add("</Beer>"); 
		}
		records.add("</XML>");
		this.writer(rutaArchivo, records);
		
	}

	
	/** Cargue de informacion tipo XML usando la libreria propia del jdk. */
	private void loadFileXML() {
		try {
			File file = new File(config.getPathFile().concat(config.getNameFileXML()));
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);
			NodeList list = document.getElementsByTagName(CommonConstants.Name_Tag_Beer);
			for (int i = 0; i < list.getLength(); i++) {
				String SerialNumber = document.getElementsByTagName("SerialNumbre").item(i)
						.getTextContent();
				String Brand = document.getElementsByTagName("Brand").item(i)
						.getTextContent();
				String Type = document.getElementsByTagName("Type").item(i)
						.getTextContent();
				String ABV = document.getElementsByTagName("ABV").item(i)
						.getTextContent();
				String IBU = document.getElementsByTagName("IBU").item(i)
						.getTextContent();
				String Origin = document.getElementsByTagName("Origin").item(i)
						.getTextContent();
				this.listBeer.add(new Beer(SerialNumber, Brand, Type, ABV, IBU, Origin));	
			}
			
		} catch (Exception e) {
			System.out.println("No se puedo leer el XML");
		}
		
	}
	
	
	/** Volcado de informacion tipo SER. */
	private void dumpFileSerializate() {
		try (FileOutputStream fileOut = new FileOutputStream(
				this.config.getPathFile().concat(config.getNameFileSer()));
				ObjectOutput out = new ObjectOutputStream(fileOut)){
		out.writeObject(this.listBeer);	
		} catch (IOException i) {
			i.printStackTrace();
		}
		
	}
	
	
	/** Cargue de informacion tipo Ser. */
	@SuppressWarnings("unchecked")
	private void loadFileSerializate() {
		try (FileInputStream fileIn = new FileInputStream(this.config.getPathFile()
				.concat(this.config.getNameFileSer()));
				ObjectInputStream in = new ObjectInputStream(fileIn)){
			this.listBeer = (List<Beer>) in.readObject();
		} catch (IOException i) {
			i.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	/** Metodo get de la lista del objeto(En este caso Beer). */
	public List<Beer> getListBeer() {
		return listBeer;
	}

	/** Metodo set de la lista del objeto(En este caso Beer). */
	public void setListBeer(List<Beer> listBeer) {
		this.listBeer = listBeer;
	}

}
