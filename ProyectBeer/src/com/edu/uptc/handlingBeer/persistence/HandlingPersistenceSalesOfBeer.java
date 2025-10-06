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
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
import com.edu.uptc.handlingBeer.model.SalesOfBeer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HandlingPersistenceSalesOfBeer extends FilePlain implements IActionsFile {

	private List<SalesOfBeer> listSalesOfBeer;
	public static String ID_SALE_SELECTED = "";

	public HandlingPersistenceSalesOfBeer() {
		this.listSalesOfBeer = new ArrayList<>();
	}

	public Boolean addSalesOfBeer(SalesOfBeer salesOfBeer) {
		if (!this.findUserBySalesID(salesOfBeer.getSalesID())) {
			this.listSalesOfBeer.add(salesOfBeer);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;

	}

	public boolean findUserBySalesID(int id) {
		return listSalesOfBeer.stream().anyMatch(s -> s.getSalesID() == id);
	}

	public Boolean deleteBeer(int salesID) {
		int index = -1;
		for (int i = 0; i < this.listSalesOfBeer.size(); i++) {
			if (this.listSalesOfBeer.get(i).getSalesID() == salesID) {
				index = i;
			}
		}
		if (index == -1) {
			return false;
		}
		this.listSalesOfBeer.remove(index);
		return true;
	}

	public Boolean updateSale(SalesOfBeer newSale) {
		SalesOfBeer actualSale = new SalesOfBeer();
		int index = -1;
		for (int i = 0; i < this.listSalesOfBeer.size(); i++) {
			if (this.listSalesOfBeer.get(i).getSalesID() == newSale.getSalesID()) {
				actualSale = this.listSalesOfBeer.get(i);
				index = i;
			}
		}

		if (index == -1) {
			return false;
		}

		actualSale.setNumberOfBeersSold(newSale.getNumberOfBeersSold());
		actualSale.setPriceTotal(newSale.getPriceTotal());
		actualSale.setDateOfSale(LocalDate.parse(newSale.getDateOfSale(), SalesOfBeer.formatter));
		actualSale.setUserName(newSale.getUserName());
		actualSale.setCustomerName(newSale.getCustomerName());
		this.listSalesOfBeer.set(index, actualSale);
		return true;

	}

	public SalesOfBeer findSalesByIndex(int index, String value) {
		switch (index) {
		case CommonConstantsIndexs.INDEX_SALESID:
			try {
				int salesID = Integer.parseInt(value);
				for (SalesOfBeer salesOfBeer : this.listSalesOfBeer) {
					if (salesOfBeer.getSalesID() == salesID) {
						return salesOfBeer;
					}
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "El Id de la venta debe ser un valor numérico.");
			}
			break;
		case CommonConstantsIndexs.INDEX_NUMBERBEERSOLD:
			try {
				int numberBeerSold = Integer.parseInt(value);
				for (SalesOfBeer salesOfBeer : this.listSalesOfBeer) {
					if (salesOfBeer.getNumberOfBeersSold() == numberBeerSold) {
						return salesOfBeer;
					}
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "El numero cervezas vendidas debe ser un valor numérico.");
			}
			break;
		case CommonConstantsIndexs.INDEX_PRICE:
			try {
				int price = Integer.parseInt(value);
				for (SalesOfBeer salesOfBeer : this.listSalesOfBeer) {
					if (salesOfBeer.getPriceTotal() == price) {
						return salesOfBeer;
					}
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "El precio de la  venta debe ser un valor numérico.");
			}
			break;
		case CommonConstantsIndexs.INDEX_DATE:
			try {
				LocalDate date = LocalDate.parse(value, SalesOfBeer.formatter);
				for (SalesOfBeer salesOfBeer : this.listSalesOfBeer) {
					if (salesOfBeer.getDateOfSaleL().equals(date)) {
						return salesOfBeer;
					}
				}
			} catch (DateTimeParseException e) {
				JOptionPane.showMessageDialog(null, "La fecha de la venta debe ser en el formato dado.");
			}
			break;
		case CommonConstantsIndexs.INDEX_USERN:
			for (SalesOfBeer salesOfBeer : this.listSalesOfBeer) {
				if (salesOfBeer.getUserName().equals(value)) {
					return salesOfBeer;
				}
			}
			break;
		case CommonConstantsIndexs.INDEX_CUSTOMERN:
			for (SalesOfBeer salesOfBeer : this.listSalesOfBeer) {
				if (salesOfBeer.getCustomerName().equals(value)) {
					return salesOfBeer;
				}
			}
			break;
		}
		return null;
	}



	public int generateIDSale() {
		int lastID = 0;
		for (SalesOfBeer salesOfBeer : this.listSalesOfBeer) {
			if (salesOfBeer.getSalesID() > lastID) {
				lastID = salesOfBeer.getSalesID();
			}
		}
		return lastID + 1;
	}

	@Override
	public void dumpFile(ETypeFile eTypeFile) {
		if (ETypeFile.FILE_PLAIN.equals(eTypeFile)) {
			String nameFileTXT = config.getSalesOfBeerTXT();
			this.dumpFilePlain(nameFileTXT, null);
		}

		if (ETypeFile.CSV.equals(eTypeFile)) {
			String nameFileCSV = config.getSalesOfBeerCSV();
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

	@Override
	public void loadFile(ETypeFile eTypeFile) {
		if (ETypeFile.FILE_PLAIN.equals(eTypeFile)) {
			String nameFileTXT = config.getSalesOfBeerTXT();
			this.loadFilePlain(nameFileTXT);
		}
		if (ETypeFile.CSV.equals(eTypeFile)) {
			String nameFileCSV = config.getSalesOfBeerCSV();
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

		for (SalesOfBeer salesOfBeer : this.listSalesOfBeer) {
			StringBuilder contentSaleOfBeer = new StringBuilder();
			contentSaleOfBeer.append(salesOfBeer.getSalesID()).append(CommonConstants.SEMICOLON);
			contentSaleOfBeer.append(salesOfBeer.getNumberSerialOfBeer()).append(CommonConstants.SEMICOLON);
			contentSaleOfBeer.append(salesOfBeer.getNumberOfBeersSold()).append(CommonConstants.SEMICOLON);
			contentSaleOfBeer.append(salesOfBeer.getPriceTotal()).append(CommonConstants.SEMICOLON);
			contentSaleOfBeer.append(salesOfBeer.getDateOfSale()).append(CommonConstants.SEMICOLON);
			contentSaleOfBeer.append(salesOfBeer.getUserName()).append(CommonConstants.SEMICOLON);
			contentSaleOfBeer.append(salesOfBeer.getCustomerName());
			records.add(contentSaleOfBeer.toString());
		}
		this.writer(rutaArchivo.toString(), records);
	}

	/** Cargue de la informacion de archivo plano tipo txt/CSV/Entre otros. */
	private void loadFilePlain(String nameFile) {
		List<String> contentInLine = this.reader(config.getPathFile().concat(nameFile));
		contentInLine.forEach(row -> {
			StringTokenizer tokens = new StringTokenizer(row, CommonConstants.SEMICOLON);
			while (tokens.hasMoreElements()) {
				String salesID = tokens.nextToken();
				String numberSerialOfBeer = tokens.nextToken();
				String numberofBeersSold = tokens.nextToken();
				String priceTotal = tokens.nextToken();
				String dateofSale = tokens.nextToken();
				String userName = tokens.nextToken();
				String customerName = tokens.nextToken();

				this.listSalesOfBeer.add(new SalesOfBeer(Integer.parseInt(salesID),
						Integer.parseInt(numberSerialOfBeer), Integer.parseInt(numberofBeersSold),
						Double.parseDouble(priceTotal), dateofSale, userName, customerName));
			}
		});
	}

	/** Volcado de informacion tipo JSON usando la libreria Gson. */
	private void dumpFileJSON(String fullPath) {
		String rutaArchivo = null;
		if (fullPath != null) {
			rutaArchivo = fullPath;
		} else {
			rutaArchivo = config.getPathFile().concat(config.getSalesOfBeerJSON());
		}
		try (FileWriter writer = new FileWriter(rutaArchivo)) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create(); // formato bonito
			gson.toJson(this.listSalesOfBeer, writer); // Serializa toda la lista
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Cargue de informacion tipo JSON usando la libreria Gson. */
	private void loadFileJSON() {
		String rutaArchivo = config.getPathFile().concat(config.getSalesOfBeerJSON());

		try (FileReader reader = new FileReader(rutaArchivo)) {
			Gson gson = new Gson();
			SalesOfBeer[] salesOfBeerArray = gson.fromJson(reader, SalesOfBeer[].class);
			this.listSalesOfBeer = new ArrayList<>(Arrays.asList(salesOfBeerArray));
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
			rutaArchivo = config.getPathFile().concat(config.getSalesOfBeerXML());
		}

		List<String> records = new ArrayList<String>();
		records.add("<XML version= \"1.0\" encoding =\"UTF-8\"> \n");// se inicia la etiqueta del inicio de xml
		for (SalesOfBeer salesOfBeer : this.listSalesOfBeer) {
			records.add("<SalesOfBeers>");
			records.add("\t<SalesID>" + salesOfBeer.getSalesID() + "</SalesID>");
			records.add("\t<NumberSerialOfBeer>" + salesOfBeer.getNumberSerialOfBeer() + "</NumberSerialOfBeer>");
			records.add("\t<NumberofBeersSold>" + salesOfBeer.getNumberOfBeersSold() + "</NumberofBeersSold>");
			records.add("\t<PriceTotal>" + salesOfBeer.getPriceTotal() + "</PriceTotal>");
			records.add("\t<DateOfSale>" + salesOfBeer.getDateOfSale() + "</DateOfSale>");
			records.add("\t<UserName>" + salesOfBeer.getUserName() + "</UserName>");
			records.add("\t<CustomerName>" + salesOfBeer.getCustomerName() + "</CustomerName> \n");
			records.add("</SalesOfBeers>");
		}
		records.add("</XML>");
		this.writer(rutaArchivo, records);

	}

	/** Cargue de informacion tipo XML usando la libreria propia del jdk. */
	private void loadFileXML() {
		try {
			File file = new File(config.getPathFile().concat(config.getSalesOfBeerXML()));
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);

			NodeList list = document.getElementsByTagName(CommonConstants.Name_Tag_SalesOFBeer);
			for (int i = 0; i < list.getLength(); i++) {
				String SalesID = document.getElementsByTagName("SalesID").item(i).getTextContent();
				String numberSerialOfBeer = document.getElementsByTagName("NumberSerialOfBeer").item(i)
						.getTextContent();
				String numberofBeersSold = document.getElementsByTagName("NumberofBeersSold").item(i).getTextContent();
				String priceTotal = document.getElementsByTagName("PriceTotal").item(i).getTextContent();
				String dateofSale = document.getElementsByTagName("DateOfSale").item(i).getTextContent();
				String userName = document.getElementsByTagName("UserName").item(i).getTextContent();
				String customerName = document.getElementsByTagName("CustomerName").item(i).getTextContent();

				this.listSalesOfBeer.add(new SalesOfBeer(Integer.parseInt(SalesID),
						Integer.parseInt(numberSerialOfBeer), Integer.parseInt(numberofBeersSold),
						Double.parseDouble(priceTotal), dateofSale, userName, customerName));

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
			rutaArchivo = config.getPathFile().concat(config.getSalesOfBeerSER());
		}
		try (FileOutputStream fileOut = new FileOutputStream(rutaArchivo);
				ObjectOutput out = new ObjectOutputStream(fileOut)) {
			out.writeObject(this.listSalesOfBeer);
		} catch (IOException i) {
			i.printStackTrace();
		}

	}

	/** Cargue de informacion tipo Ser. */
	@SuppressWarnings("unchecked")
	private void loadFileSerializate() {
		try (FileInputStream fileIn = new FileInputStream(
				this.config.getPathFile().concat(this.config.getSalesOfBeerSER()));
				ObjectInputStream in = new ObjectInputStream(fileIn)) {
			this.listSalesOfBeer = (List<SalesOfBeer>) in.readObject();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public List<SalesOfBeer> getListSalesOfBeer() {
		return listSalesOfBeer;
	}

	public void setListSalesOfBeer(List<SalesOfBeer> listSalesOfBeer) {
		this.listSalesOfBeer = listSalesOfBeer;
	}

}
