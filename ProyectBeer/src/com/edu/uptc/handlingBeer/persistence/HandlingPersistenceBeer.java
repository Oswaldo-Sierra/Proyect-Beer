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

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.edu.uptc.handlingBeer.constants.CommonConstants;
import com.edu.uptc.handlingBeer.constants.CommonConstantsIndexs;
import com.edu.uptc.handlingBeer.enums.ETypeFile;
import com.edu.uptc.handlingBeer.interfaces.IActionsFile;
import com.edu.uptc.handlingBeer.model.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HandlingPersistenceBeer extends FilePlain implements IActionsFile {

	public static String SERIALNUMBER_BEER_SELECTED = "";
	private List<Beer> listBeer;

	public HandlingPersistenceBeer() {
		listBeer = new ArrayList<>();
	}

	/**
	 * Metodo que se encarga de añadir nuevos objetos(En este caso de tipo beer).
	 */
	public Boolean addBeers(Beer beer) {
		if (Objects.isNull(this.findBeerBySerialNumber(beer.getSerialNumber()))) {
			this.listBeer.add(beer);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * Metodo que se encarga de verficar que no existan dos tipos de objetos
	 * iguales(Por medio de un atributo en este caso).
	 */
	public Beer findBeerBySerialNumber(int serialNumber) {
		for (Beer beer : this.listBeer) {
			if (beer.getSerialNumber() == serialNumber) {
				return beer;
			}
		}
		return null;
	}

	public String[] comboBoxValues() {
		ArrayList<String> values = new ArrayList<>();
		;
		String val = null;
		for (Beer beer : this.listBeer) {
			if (!(beer.getQuantity() == 0)) {
				val = beer.getBrand() + "-" + beer.getSerialNumber();
				values.add(val);
			}
		}

		if (values.isEmpty()) {
			return null;
		}

		return values.toArray(new String[0]);
	}

	public int priceBeer(int serial) {
		Beer beer = this.findBeerBySerialNumber(serial);
		if (beer != null) {
			return beer.getPrice();
		}
		return 0;
	}

	public boolean numberSoldBeer(int serial, int numberSold) {
		Beer beer = this.findBeerBySerialNumber(serial);
		if (beer != null) {
			int subtract = beer.getQuantity() - numberSold;
			if (subtract >= 0) {
				beer.setQuantity(subtract);
				return true;
			}
			return false;
		}
		return false;
	}

	/** metodo encargado de eliminar una cerveza */
	public Boolean deleteBeer(int serialNumber) {
		int index = -1;
		for (int i = 0; i < this.listBeer.size(); i++) {
			if (this.listBeer.get(i).getSerialNumber() == serialNumber) {
				index = i;
			}
		}
		if (index == -1) {
			return false;
		}
		this.listBeer.remove(index);
		return true;
	}

	/** Metodo encargado de actualizar una cerveza */
	public Boolean updateBeer(Beer newBeer) {
		Beer actualBeer = new Beer();
		int index = -1;
		for (int i = 0; i < this.listBeer.size(); i++) {
			if (this.listBeer.get(i).getSerialNumber() == newBeer.getSerialNumber()) {
				actualBeer = this.listBeer.get(i);
				index = i;
			}
		}

		if (index == -1) {
			return false;
		}

		actualBeer.setBrand(newBeer.getBrand());
		actualBeer.setType(newBeer.getType());
		actualBeer.setABV(newBeer.getABV());
		actualBeer.setIBU(newBeer.getIBU());
		actualBeer.setProvider(newBeer.getProvider());
		actualBeer.setPrice(newBeer.getPrice());
		actualBeer.setQuantity(newBeer.getQuantity());
		this.listBeer.set(index, actualBeer);
		return true;

	}

	/** Metodo que busca una cerveza por el index del comboBox */
	public Beer findBeerbyIndex(int index, String value) {
		switch (index) {
		case CommonConstants.INDEX_SSERIAL_NUMBER:
			try {
				int serial = Integer.parseInt(value);
				for (Beer beer : this.listBeer) {
					if (beer.getSerialNumber() == serial) {
						return beer;
					}
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "El número de serie debe ser un valor numérico.");
			}
			break;

		case CommonConstants.INDEX_BRAND:
			for (Beer beer : this.listBeer) {
				if (beer.getBrand().equalsIgnoreCase(value)) {
					return beer;
				}
			}
			break;

		case CommonConstants.INDEX_TYPE:
			for (Beer beer : this.listBeer) {
				if (beer.getType().equalsIgnoreCase(value)) {
					return beer;
				}
			}
			break;

		case CommonConstants.INDEX_ABV:
			for (Beer beer : this.listBeer) {
				if (beer.getABV().equalsIgnoreCase(value)) {
					return beer;
				}
			}
			break;

		case CommonConstants.INDEX_IBU:
			for (Beer beer : this.listBeer) {
				if (beer.getIBU().equalsIgnoreCase(value)) {
					return beer;
				}
			}
			break;

		case CommonConstants.INDEX_PROVIDER:
			for (Beer beer : this.listBeer) {
				if (beer.getProvider().equalsIgnoreCase(value)) {
					return beer;
				}
			}
			break;

		case CommonConstants.INDEX_PRICE:
			try {
				int price = Integer.parseInt(value);
				for (Beer beer : this.listBeer) {
					if (beer.getPrice() == price) {
						return beer;
					}
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "El precio debe ser un valor numérico.");
			}
			break;

		case CommonConstants.INDEX_QUANTITY:
			try {
				int qty = Integer.parseInt(value);
				for (Beer beer : this.listBeer) {
					if (beer.getQuantity() == qty) {
						return beer;
					}
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "La cantidad debe ser un valor numérico.");
			}
			break;
		}
		return null;
	}

	public List<Beer> findBeersByBrand(int index) {
		List<Beer> listAux = new ArrayList<>();
		String brand = "";

		switch (index) {
		case CommonConstantsIndexs.INDEX_POKER:
			brand = "Poker";
			break;
		case CommonConstantsIndexs.INDEX_AGUILLA:
			brand = "Aguila";
			break;
		case CommonConstantsIndexs.INDEX_COSTEÑA:
			brand = "Costeña";
			break;
		case CommonConstantsIndexs.INDEX_CORONA:
			brand = "Corona";
			break;
		case CommonConstantsIndexs.INDEX_GUINNES:
			brand = "Guinness";
			break;
		case CommonConstantsIndexs.INDEX_BUDWEISER:
			brand = "Budweiser";
			break;
		}

		for (Beer beer : this.listBeer) {
			if (beer.getBrand().equalsIgnoreCase(brand)) {
				listAux.add(beer);
			}
		}

		return listAux;

	}

	public String findBrandbyIndex(int index) {
		String brand = "";

		switch (index) {
		case CommonConstantsIndexs.INDEX_POKER:
			brand = "Poker";
			break;
		case CommonConstantsIndexs.INDEX_AGUILLA:
			brand = "Aguila";
			break;
		case CommonConstantsIndexs.INDEX_COSTEÑA:
			brand = "Costeña";
			break;
		case CommonConstantsIndexs.INDEX_CORONA:
			brand = "Corona";
			break;
		case CommonConstantsIndexs.INDEX_GUINNES:
			brand = "Guinness";
			break;
		case CommonConstantsIndexs.INDEX_BUDWEISER:
			brand = "Budweiser";
			break;
		}

		return brand;

	}

	public String findtypebyIndex(int index) {
		String type = "";

		switch (index) {
		case CommonConstantsIndexs.INDEX_LARGE:
			type = "Large";
			break;
		case CommonConstantsIndexs.INDEX_PILSNER:
			type = "Pilsner";
			break;
		case CommonConstantsIndexs.INDEX_STOUT:
			type = "Stout";
			break;
		}

		return type;

	}

	public String findyIBUIndex(int index) {
		String IBU = "";

		switch (index) {
		case CommonConstantsIndexs.INDEX_MUY_BAJA:
			IBU = "Muy Baja";
			break;
		case CommonConstantsIndexs.INDEX_BAJA:
			IBU = "Baja";
			break;
		case CommonConstantsIndexs.INDEX_MEDIA:
			IBU = "Media";
			break;
		case CommonConstantsIndexs.INDEX_ALTA:
			IBU = "Alta";
			break;
		case CommonConstantsIndexs.INDEX_MUY_ALTA:
			IBU = "Muy Alta";
			break;
		}

		return IBU;

	}

	public int generateSerialNumber() {
		int lastSerial = 0;
		for (Beer beer : this.listBeer) {
			if (beer.getSerialNumber() > lastSerial) {
				lastSerial = beer.getSerialNumber();
			}
		}
		return lastSerial + 1;
	}

	/**
	 * Metodo que se encarga de volcar la informacion registrada por el usuario
	 * dependiendo del tipo de archivo plano.
	 */
	@Override
	public void dumpFile(ETypeFile eTypeFile) {
		if (ETypeFile.FILE_PLAIN.equals(eTypeFile)) {
			String nameFileTXT = config.getNameFileTXT();
			this.dumpFilePlain(nameFileTXT, null);
		}

		if (ETypeFile.CSV.equals(eTypeFile)) {
			String nameFileCSV = config.getNameFileCSV();
			this.dumpFilePlain(nameFileCSV, null);

		}
		if (ETypeFile.JSON.equals(eTypeFile)) {
			dumpFileJSON(null);

		}
		if (ETypeFile.XML.equals(eTypeFile)) {
			dumpFileXML(null);

		}
		if (ETypeFile.SER.equals(eTypeFile)) {
			dumpFileSerializate(null);
		}
	}

	/**
	 * Metodo encargado de cargar la informacion del archivo plano despues de que se
	 * halla cerrado el programa y vuelvo a abrir.
	 */
	@Override
	public void loadFile(ETypeFile eTypeFile) {
		if (ETypeFile.FILE_PLAIN.equals(eTypeFile)) {
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

	public void exportFile(ETypeFile eTypeFile, String fullPath) {
		if (eTypeFile.equals(ETypeFile.FILE_PLAIN)) {
			dumpFilePlain(null, fullPath);
		}
		if (eTypeFile.equals(ETypeFile.CSV)) {
			dumpFilePlain(null, fullPath);
		}
		if (eTypeFile.equals(ETypeFile.JSON)) {
			dumpFileJSON(fullPath);
		}
		if (eTypeFile.equals(ETypeFile.XML)) {
			dumpFileXML(fullPath);
		}
		if (eTypeFile.equals(ETypeFile.SER)) {
			this.dumpFileSerializate(fullPath);
		}

	}

	/*
	 * private void dumpFileJSON() { String rutaArchivo = config.getPathFile()
	 * .concat(config.getNameFileJSON()); StringBuilder json = null; List<String>
	 * content = new ArrayList<String>();
	 * content.add(CommonConstants.OPENING_BRACKET); int cont = 0; int total =
	 * listBeer.size(); for (Beer b : this.listBeer) { json = new StringBuilder();
	 * json.append("{");
	 * json.append(" \"serialNumber\":\"").append(escape(b.getSerialNumber())).
	 * append("\",");
	 * json.append(" \"brand\":\"").append(escape(b.getBrand())).append("\",");
	 * json.append(" \"type\":\"").append(escape(b.getType())).append("\",");
	 * json.append(" \"ABV\":\"").append(escape(b.getABV())).append("\",");
	 * json.append(" \"IBU\":\"").append(escape(b.getIBU())).append("\",");
	 * json.append(" \"origin\":\"").append(escape(b.getOrigin())).append("\"");
	 * json.append("}");
	 * 
	 * cont ++; if (cont<total) { json.append(","); } content.add(json.toString());
	 * }
	 * 
	 * content.add(CommonConstants.CLOSING_BRACKET); this.writer(rutaArchivo,
	 * content);
	 * 
	 * }
	 * 
	 * private String escape(String value) { if (value == null) return ""; return
	 * value.replace("\\", "\\\\").replace("\"", "\\\""); }
	 */

//	private void loadFileJSON_1() {
//		List<String> contentInLine = this.reader(config.getPathFile().concat(config.getNameFileJSON())).stream()
//				.filter(line -> !line.equals("[") && !line.equals("]") && !line.equals(CommonConstants.BREAK_LINE)
//						&& !line.trim().isEmpty() && !line.trim().isBlank())
//				.collect(Collectors.toList());
//		for (String line : contentInLine) {
//			line = line.replace("{", "").replace("},", "").replace("}", "");
//			StringTokenizer tokens = new StringTokenizer(line, ",");
//
//			while (tokens.hasMoreElements()) {
//				String serialNumber = this.escapeValue(tokens.nextToken().split(":")[1]);
//				String brand = this.escapeValue(tokens.nextToken().split(":")[1]);
//				String type = this.escapeValue(tokens.nextToken().split(":")[1]);
//				String ABV = this.escapeValue(tokens.nextToken().split(":")[1]);
//				String IBU = this.escapeValue(tokens.nextToken().split(":")[1]);
//				String origin = this.escapeValue(tokens.nextToken().split(":")[1]);
//				//this.listBeer.add(new Beer(serialNumber, brand, type, ABV, IBU, origin));
//			}
//		}
//	}
//	private String escapeValue(String value) {
//		return value.replace("\"", "");
//	}

	/**
	 * De aqui en adelante estaran los metodos de volcado y carga dependiendo el
	 * archivo plano.
	 */

	/** Volcado de archivo plano tipo txt/CSV/Entre otros. */
	private void dumpFilePlain(String nameFile, String fullPath) {
		StringBuilder rutaArchivo = new StringBuilder();
		if (fullPath != null) {
			rutaArchivo.append(fullPath);
		} else {
			rutaArchivo.append(config.getPathFile());
			rutaArchivo.append(nameFile);
		}

		List<String> records = new ArrayList<>();

		for (Beer beer : this.listBeer) {
			StringBuilder contentBeer = new StringBuilder();
			contentBeer.append(beer.getSerialNumber()).append(CommonConstants.SEMICOLON);
			contentBeer.append(beer.getBrand()).append(CommonConstants.SEMICOLON);
			contentBeer.append(beer.getType()).append(CommonConstants.SEMICOLON);
			contentBeer.append(beer.getABV()).append(CommonConstants.SEMICOLON);
			contentBeer.append(beer.getIBU()).append(CommonConstants.SEMICOLON);
			contentBeer.append(beer.getProvider()).append(CommonConstants.SEMICOLON);
			contentBeer.append(beer.getPrice()).append(CommonConstants.SEMICOLON);
			contentBeer.append(beer.getQuantity());
			records.add(contentBeer.toString());
		}
		this.writer(rutaArchivo.toString(), records);
	}

	/** Cargue de la informacion de archivo plano tipo txt/CSV/Entre otros. */
	private void loadFilePlain(String nameFile) {
		List<String> contentInLine = this.reader(config.getPathFile().concat(nameFile));
		contentInLine.forEach(row -> {
			StringTokenizer tokens = new StringTokenizer(row, CommonConstants.SEMICOLON);
			while (tokens.hasMoreElements()) {
				String serialNumber = tokens.nextToken();
				String brand = tokens.nextToken();
				String type = tokens.nextToken();
				String ABV = tokens.nextToken();
				String IBU = tokens.nextToken();
				String provider = tokens.nextToken();
				String price = tokens.nextToken();
				String quantity = tokens.nextToken();

				this.listBeer.add(new Beer(Integer.parseInt(serialNumber), brand, type, ABV, IBU, provider,
						Integer.parseInt(price), Integer.parseInt(quantity)));
			}
		});
	}

	/** Volcado de informacion tipo JSON usando la libreria Gson. */
	private void dumpFileJSON(String fullPath) {
		String rutaArchivo = null;
		if (fullPath != null) {
			rutaArchivo = fullPath;
		} else {
			rutaArchivo = config.getPathFile().concat(config.getNameFileJSON());
		}

		try (FileWriter writer = new FileWriter(rutaArchivo)) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create(); // formato bonito
			gson.toJson(this.listBeer, writer); // Serializa toda la lista
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Cargue de informacion tipo JSON usando la libreria Gson. */
	private void loadFileJSON() {
		String rutaArchivo = config.getPathFile().concat(config.getNameFileJSON());

		try (FileReader reader = new FileReader(rutaArchivo)) {
			Gson gson = new Gson();
			Beer[] beersArray = gson.fromJson(reader, Beer[].class);
			this.listBeer = new ArrayList<>(Arrays.asList(beersArray));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Volcado de informacion tipo XML. */
	private void dumpFileXML(String fullPath) {
		String rutaArchivo = null;
		if (fullPath != null) {
			rutaArchivo = fullPath;
		} else {
			rutaArchivo = config.getPathFile().concat(config.getNameFileXML());
		}

		List<String> records = new ArrayList<String>();
		records.add("<XML version= \"1.0\" encoding =\"UTF-8\"> \n");// se inicia la etiqueta del inicio de xml
		for (Beer beer : this.listBeer) {
			records.add("<Beer>");
			records.add("\t<SerialNumbre>" + beer.getSerialNumber() + "</SerialNumbre>");
			records.add("\t<Brand>" + beer.getBrand() + "</Brand>");
			records.add("\t<Type>" + beer.getType() + "</Type>");
			records.add("\t<ABV>" + beer.getABV() + "</ABV>");
			records.add("\t<IBU>" + beer.getIBU() + "</IBU>");
			records.add("\t<Provider>" + beer.getProvider() + "</Provider>");
			records.add("\t<Price>" + beer.getPrice() + "</Price>");
			records.add("\t<Quantity>" + beer.getQuantity() + "</Quantity> \n");
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
				String serialNumber = document.getElementsByTagName("SerialNumbre").item(i).getTextContent();
				String brand = document.getElementsByTagName("Brand").item(i).getTextContent();
				String type = document.getElementsByTagName("Type").item(i).getTextContent();
				String ABV = document.getElementsByTagName("ABV").item(i).getTextContent();
				String IBU = document.getElementsByTagName("IBU").item(i).getTextContent();
				String provider = document.getElementsByTagName("Provider").item(i).getTextContent();
				String price = document.getElementsByTagName("Price").item(i).getTextContent();
				String quantity = document.getElementsByTagName("Quantity").item(i).getTextContent();

				this.listBeer.add(new Beer(Integer.parseInt(serialNumber), brand, type, ABV, IBU, provider,
						Integer.parseInt(price), Integer.parseInt(quantity)));
			}

		} catch (Exception e) {
			System.out.println("No se puedo leer el XML");
		}

	}

	/** Volcado de informacion tipo SER. */
	private void dumpFileSerializate(String fullPath) {
		String rutaArchivo = null;
		if (fullPath != null) {
			rutaArchivo = fullPath;
		} else {
			rutaArchivo = config.getPathFile().concat(config.getNameFileSer());
		}
		try (FileOutputStream fileOut = new FileOutputStream(rutaArchivo);
				ObjectOutput out = new ObjectOutputStream(fileOut)) {
			out.writeObject(this.listBeer);
		} catch (IOException i) {
			i.printStackTrace();
		}

	}

	/** Cargue de informacion tipo Ser. */
	@SuppressWarnings("unchecked")
	private void loadFileSerializate() {
		try (FileInputStream fileIn = new FileInputStream(
				this.config.getPathFile().concat(this.config.getNameFileSer()));
				ObjectInputStream in = new ObjectInputStream(fileIn)) {
			this.listBeer = (List<Beer>) in.readObject();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	/** Metodo get de la lista del objeto(En este caso Beer). */
	public List<Beer> getListBeer() {
		return listBeer;
	}

	public void setListBeer(List<Beer> listBeer) {
		this.listBeer = listBeer;
	}

}
