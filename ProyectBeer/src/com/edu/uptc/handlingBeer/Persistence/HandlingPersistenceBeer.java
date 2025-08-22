package com.edu.uptc.handlingBeer.Persistence;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.edu.uptc.handlingBeer.Constants.CommonConstants;
import com.edu.uptc.handlingBeer.Enums.ETypeFile;
import com.edu.uptc.handlingBeer.Interface.*;
import com.edu.uptc.handlingBeer.model.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class HandlingPersistenceBeer extends FilePlain 
	implements IActionsFile  {
	
	private List<Beer> listBeer;
	
	public HandlingPersistenceBeer() {
		listBeer = new ArrayList<>();
	}
	
	public Boolean addBeers(Beer beer) {
		if(Objects.isNull(this.findBeerBySerialNumber(beer.getSerialNumber()))) {
			this.listBeer.add(beer);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public Beer findBeerBySerialNumber(String serialNumber) {
		for(Beer beer: this.listBeer) {
			if(beer.getSerialNumber().contentEquals(serialNumber)) {
				return beer;
			}
		}
		return null;
	}
	
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
	}
	
	

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
		}if (ETypeFile.XML.equals(eTypeFile)) {
			loadFileXML();
		}

		
	}
	

	/*private void dumpFileJSON() {
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
	}*/
	
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

	public List<Beer> getListBeer() {
		return listBeer;
	}

	public void setListBeer(List<Beer> listBeer) {
		this.listBeer = listBeer;
	}

}
