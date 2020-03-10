package com.directoriotelefonico.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import com.directoriotelefonico.aplicacion.comando.ContactoComando;
import com.directoriotelefonico.dominio.modelo.Contacto;

@Component
public class ContactoFabrica {
	
	public Contacto crear(ContactoComando comandoContacto) {
		return new Contacto(null, comandoContacto.getNombre(), comandoContacto.getTelefono());
	}

}
