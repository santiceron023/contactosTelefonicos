package com.directoriotelefonico.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import com.directoriotelefonico.aplicacion.comando.ContactoComando;
import com.directoriotelefonico.aplicacion.comando.fabrica.ContactoFabrica;
import com.directoriotelefonico.dominio.modelo.Contacto;
import com.directoriotelefonico.dominio.servicio.ContactoCrearServicio;

@Component
public class ContactoCrearManejador {
	private final ContactoCrearServicio contactoCrearServicio;
	private final ContactoFabrica contactoFabrica;
	
	public ContactoCrearManejador(
			ContactoCrearServicio contactoCrearServicio, ContactoFabrica contactoFabrica) {
		this.contactoCrearServicio = contactoCrearServicio;
		this.contactoFabrica = contactoFabrica;
	}


	public void ejecutar(ContactoComando contactoComando) {
		Contacto contacto = contactoFabrica.crear(contactoComando);
		contactoCrearServicio.ejecutar(contacto);
	}
}
