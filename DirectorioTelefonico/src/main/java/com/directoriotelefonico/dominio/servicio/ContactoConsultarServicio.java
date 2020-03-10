package com.directoriotelefonico.dominio.servicio;

import java.util.List;
import com.directoriotelefonico.dominio.modelo.Contacto;
import com.directoriotelefonico.dominio.puerto.repositorio.ContactoRepositorio;

public class ContactoConsultarServicio {

	private final ContactoRepositorio contactoRepositorio;

	public ContactoConsultarServicio(ContactoRepositorio contactoRepositorio) {
		this.contactoRepositorio = contactoRepositorio;
	}	
	

	public List<Contacto> ejecutar(){
		return contactoRepositorio.listarTodos();
	}

	public boolean validarExistenciaPorId(int contactoId) {		
		return contactoRepositorio.contactoPorId(contactoId) != null;
	}

	public boolean validarExistenciaPorNombre(String nombre) {
		return contactoRepositorio.contactoPorNombre(nombre) != null;
	}

}
