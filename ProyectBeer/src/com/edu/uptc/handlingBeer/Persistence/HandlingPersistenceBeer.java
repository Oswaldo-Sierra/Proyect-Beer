package com.edu.uptc.handlingBeer.Persistence;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;


import com.edu.uptc.handlingBeer.Constants.CommonConstants;
import com.edu.uptc.handlingBeer.Enums.ETypeFile;
import com.edu.uptc.handlingBeer.Interface.*;
import com.edu.uptc.handlingBeer.model.*;


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
	public void loadFile(ETypeFile eTypeFile) {
		if(ETypeFile.FILE_PLAIN.equals(eTypeFile)) {
			this.loadFilePlain();
		}
		
	}
	
	@Override
	public void dumpFile(ETypeFile eTypeFile) {
		if(ETypeFile.FILE_PLAIN.equals(eTypeFile)) {
			this.dumpFilePlain();
		}
		
	}
	
	
	private void dumpFilePlain() {
		StringBuilder rutaArchivo = new StringBuilder();
		rutaArchivo.append(config.getPathFile());
		rutaArchivo.append(config.getNameFileTXT());
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
	
	
	private void loadFilePlain() {
		List<String> contentInLine = this.reader(
				config.getPathFile().concat(
						config.getNameFileTXT()));
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
