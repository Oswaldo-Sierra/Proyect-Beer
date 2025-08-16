package com.edu.uptc.handlingBeer.model;

/**
 * Clase del modelo que representa una cerveza con sus características
 * principales como marca, tipo, grado de alcohol, numero de serie, amargor y origen.
 * 
 * <p>Este modelo es usado para gestionar información de cervezas en la aplicación.</p>
 * 
 * @author Oswaldo Sierra
 */
public class Beer {
	
	 /** El numero de serie unico en la botella o lata de la cerveza. */
    private String serialNumber;

    /** Marca de la cerveza. */
    private String brand;
    
    /** Tipo de la cerveza (ej. Lager, IPA, Stout, etc.). */
    private String type;
    
    /** Grado de alcohol por volumen (ABV) de la cerveza. */
    private String ABV; 
    
    /** Amargor de la cerveza medido en IBU (International Bitterness Units). */
    private String IBU;
    
    /** País de origen de la cerveza. */
    private String origin;
    
    /**
     * Constructor que inicializa todos los atributos de la clase Beer.
     *
     */
	public Beer(String serialNumber, String brand, String type, String aBV, String iBU, String origin) {
		super();
		this.serialNumber = serialNumber;
		this.brand = brand;
		this.type = type;
		ABV = aBV;
		IBU = iBU;
		this.origin = origin;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
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

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
}
