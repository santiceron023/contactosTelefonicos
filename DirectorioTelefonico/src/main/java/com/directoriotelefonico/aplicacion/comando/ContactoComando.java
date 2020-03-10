package com.directoriotelefonico.aplicacion.comando;

public class ContactoComando {
	private Integer telefono;
	private String nombre;
	
	
	public ContactoComando() {
	}

	public ContactoComando(Integer telefono, String nombre) {
		this.telefono = telefono;
		this.nombre = nombre;
	}
	
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
