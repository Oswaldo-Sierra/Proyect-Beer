package com.edu.uptc.handlingBeer.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase del modelo que representa una venda de cervezas con sus características
 * principales como idVenta, marca de la cerveza, entre otros.
 * 
 * <p>
 * Este modelo es usado para gestionar información de venta de cervezas en la
 * aplicación.
 * </p>
 * 
 * @author Oswaldo Sierra
 */
public class SalesOfBeer implements Serializable {
	private static final long serialVersionUID = 1L;

	/** Id de la venta realizada */
	private int salesID;

	/** Numero de serie de la cerveza */
	private int numberSerialOfBeer;

	/** Numero de cervezas vendidas */
	private int numberOfBeersSold;

	/**Precio a pagar por el comprador*/
	private double priceTotal;
	
	/** Fecha de la venta */
	private String dateOfSale; // se pone en string pero despues de parsea como localdate para evitar
								// confuciones con el gson

	/**Nombre del Usuario que hizo la venta*/
	private String userName;
	
	/** Nombre del cliente que hizo la compra */
	private String customerName;
	
	/** Constante para parsear la fecha*/
	private  static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public SalesOfBeer(int salesID, int numberSerialOfBeer, int numberOfBeersSold, double priceTotal, String dateOfSale,
			String userName, String customerName) {
		this.salesID = salesID;
		this.numberSerialOfBeer = numberSerialOfBeer;
		this.numberOfBeersSold = numberOfBeersSold;
		this.priceTotal = priceTotal;
		this.dateOfSale = dateOfSale;
		this.userName = userName;
		this.customerName = customerName;
	}

	public int getSalesID() {
		return salesID;
	}

	public void setSalesID(int salesID) {
		this.salesID = salesID;
	}

	public int getNumberSerialOfBeer() {
		return numberSerialOfBeer;
	}

	public void setNumberSerialOfBeer(int numberSerialOfBeer) {
		this.numberSerialOfBeer = numberSerialOfBeer;
	}

	public int getNumberOfBeersSold() {
		return numberOfBeersSold;
	}

	public void setNumberOfBeersSold(int numberOfBeersSold) {
		this.numberOfBeersSold = numberOfBeersSold;
	}

	public double getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(double priceTotal) {
		this.priceTotal = priceTotal;
	}

	/**Getters y setters parseados*/
	public LocalDate getDateOfSale() {
		return LocalDate.parse(dateOfSale,formatter);
	}

	public void setDateOfSale(LocalDate dateOfSale) {
		this.dateOfSale = dateOfSale.format(formatter);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
