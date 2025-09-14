package com.edu.uptc.handlingBeer.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.edu.uptc.handlingBeer.enums.ETypeFile;
import com.edu.uptc.handlingBeer.interfaces.IActionsFile;
import com.edu.uptc.handlingBeer.model.User;

public class HandlingPersistenceUser extends FilePlain implements IActionsFile {

	private List<User> listusers;

	public HandlingPersistenceUser() {
		listusers = new ArrayList<User>();

	}

	public Boolean addUser(User user) {
		if (!this.findUserByUsernamePassword(user.getNameUser(), user.getPassword())) {
			listusers.add(user);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;

	}

	public boolean findUserByUsernamePassword(String nameUser, String password) {
		return listusers.stream().anyMatch(u -> u.getNameUser().equals(nameUser) && u.getPassword().equals(password));
	}

	/**
	 * Metodo que se encarga de volcar la informacion registrada por el usuario
	 * dependiendo del tipo de archivo plano.
	 */
	@Override
	public void dumpFile(ETypeFile eTypeFile) {
		if (ETypeFile.SER.equals(eTypeFile)) {
			dumpFileSerializate();
		}
	}

	/**
	 * Metodo encargado de cargar la informacion del archivo plano despues de que se
	 * halla cerrado el programa y vuelvo a abrir.
	 */
	@Override
	public void loadFile(ETypeFile eTypeFile) {
		if (ETypeFile.SER.equals(eTypeFile)) {
			loadFileSerializate();
		}
	}

	/** Volcado de informacion tipo SER. */
	private void dumpFileSerializate() {
		try (FileOutputStream fileOut = new FileOutputStream(this.config.getPathFile().concat(config.getUserFileSer()));
				ObjectOutput out = new ObjectOutputStream(fileOut)) {
			out.writeObject(this.listusers);
		} catch (IOException i) {
			i.printStackTrace();
		}

	}

	/** Cargue de informacion tipo Ser. */
	@SuppressWarnings("unchecked")
	private void loadFileSerializate() {
		try (FileInputStream fileIn = new FileInputStream(this.config.getPathFile()
				.concat(this.config.getUserFileSer()));
				ObjectInputStream in = new ObjectInputStream(fileIn)){
			this.listusers = (List<User>) in.readObject();
		} catch (IOException i) {
			i.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public List<User> getListusers() {
		return listusers;
	}

	public void setListusers(List<User> listusers) {
		this.listusers = listusers;
	}
	
	
}
