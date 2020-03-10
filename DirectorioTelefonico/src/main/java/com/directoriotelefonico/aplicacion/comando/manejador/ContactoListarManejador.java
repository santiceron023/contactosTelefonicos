package com.directoriotelefonico.aplicacion.comando.manejador;

import java.util.List;

import org.springframework.stereotype.Component;
import com.directoriotelefonico.dominio.modelo.Contacto;
import com.directoriotelefonico.dominio.servicio.ContactoConsultarServicio;

@Component
public class ContactoListarManejador {
	private final ContactoConsultarServicio contactoConsultarServicio;

	public ContactoListarManejador(ContactoConsultarServicio contactoConsultarServicio) {
		this.contactoConsultarServicio = contactoConsultarServicio; 
	}

	public List<Contacto> ejecutar() {
		return contactoConsultarServicio.ejecutar();
	}
}
