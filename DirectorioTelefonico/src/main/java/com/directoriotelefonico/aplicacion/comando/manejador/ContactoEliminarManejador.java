package com.directoriotelefonico.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;
import com.directoriotelefonico.dominio.servicio.ContactoEliminarServicio;

@Component
public class ContactoEliminarManejador {
	private final ContactoEliminarServicio contactoEliminarServicio;
	
	public ContactoEliminarManejador(ContactoEliminarServicio contactoEliminarServicio) {
		this.contactoEliminarServicio = contactoEliminarServicio; 
	}

	public void ejecutar(Integer contactoId) {		
		contactoEliminarServicio.ejecutar(contactoId);
	}
}
