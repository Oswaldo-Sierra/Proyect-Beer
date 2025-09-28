package com.edu.uptc.handlingBeer.model;

import java.io.Serializable;

import com.edu.uptc.handlingBeer.enums.ETypeFile;


/**
 * Clase del modelo que representa una cerveza con sus características
 * principales como marca, tipo, grado de alcohol, numero de serie, amargor y origen.
 * 
 * <p>Este modelo es usado para gestionar información de cervezas en la aplicación.</p>
 * 
 * @author Oswaldo Sierra
 */
public class Beer implements Serializable{ 
	private static final long serialVersionUID = 7758888672641333914L;

	 /** El numero de serie unico en la botella o lata de la cerveza. */
    private int serialNumber;

    /** Marca de la cerveza. */
    private String brand;
    
    /** Tipo de la cerveza (ej. Lager, IPA, Stout, etc.). */
    private String type;
    
    /** Grado de alcohol por volumen (ABV) de la cerveza. */
    private String ABV; 
    
    /** Amargor de la cerveza medido en IBU (International Bitterness Units). */
    private String IBU;
    
    /**Provedor de la cerveza*/
    private String provider;
    
    /**Precio de la cerveza*/
    private int price;
    
    /**Cantidad de cervezas ingresadas/ comprada*/
    private int quantity; 
    
    /**
     * Constructor que inicializa todos los atributos de la clase Beer.
     *
     */
    public Beer(int serialNumber, String brand, String type, String aBV, String iBU, String provider, int price,
			int quantity) {
		super();
		this.serialNumber = serialNumber;
		this.brand = brand;
		this.type = type;
		ABV = aBV;
		IBU = iBU;
		this.provider = provider;
		this.price = price;
		this.quantity = quantity;
	}
	
	//Constructor vacio
	public Beer() {}

	
	public int getSerialNumber() {
		return serialNumber;
	}
	
	/** Getters y setters */

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return String.valueOf(type);
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getABV() {
		return ABV;
	}

	public void setABV(String aBV) {
		ABV = aBV;
	}

	public String getIBU() {
		return IBU;
	}

	public void setIBU(String iBU) {
		IBU = iBU;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
