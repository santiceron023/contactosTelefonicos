package com.directoriotelefonico.testDataBuilder;

import com.directoriotelefonico.aplicacion.comando.ContactoComando;

public class ContactoComandoTestDataBuilder {
	private Integer telefono;
	private String nombre;
	
	public ContactoComandoTestDataBuilder() {
		this.telefono = 99999;
		this.nombre = "Daniela Ospina";
	}
	
	public ContactoComandoTestDataBuilder conTelefono(Integer telefono) {
		this.telefono = telefono;
		return this;
	}
	public ContactoComandoTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ContactoComando build() {
		return new ContactoComando(telefono, nombre);	
	}
}
