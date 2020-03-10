package com.directoriotelefonico.testDataBuilder;

import com.directoriotelefonico.dominio.modelo.Contacto;

public class ContactoTestDataBuilder {
	
	private Integer id;
	private String nombre;
	private Integer telefono;
	
	public ContactoTestDataBuilder() {
		this.id = 1;
		this.nombre = "Daniela Orozco";
		this.telefono = 9999999;
	}
	
	public ContactoTestDataBuilder conId(Integer id) {
		this.id = id;
		return this;
	}
	public ContactoTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	public ContactoTestDataBuilder conTelefono(Integer telefono) {
		this.telefono = telefono;
		return this;
	}

	public Contacto build() {
		return new Contacto(id, nombre, telefono);
	}
	
	
}
