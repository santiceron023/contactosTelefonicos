package com.directoriotelefonico.dominio.modelo;

import com.directoriotelefonico.dominio.excepcion.ExcepcionAtributo;
public class Contacto {

	private static final String ATRIBUTO_INVALIDO_OBLIGATORIO = "Campos teléfono y Nombre son requeridos";
	private static final String TELEFONO_CONDICION_INVALIDO = "Telefono debe ser diferente de 5555555";
	private static final String TELEFONO_LONGITUD_INVALIDO = "Longitud teléfono inválida (máx 7 números)";
	private static final String NOMBRE_LONGITUD_INVALIDO = "Longitud nombre inválida (máx 100 caracteres)";

	private Integer id;
	private String nombre;
	private Integer telefono;

	public Contacto(Integer id, String nombre, Integer telefono) {

		validarExistencia(telefono);
		validarExistencia(nombre);
		validarTelefonoCondicionDiferente(telefono);
		validarLongitudtelefono(telefono);
		validarLongitudNombre(nombre);

		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	private void validarExistencia(String nombre) {
		if(nombre == null || nombre.length() == 0) {
			throw new ExcepcionAtributo(ATRIBUTO_INVALIDO_OBLIGATORIO);
		}
	}
	
	private void validarExistencia(Integer telefono) {
		if(telefono == null) {
			throw new ExcepcionAtributo(ATRIBUTO_INVALIDO_OBLIGATORIO);
		}	
	}


	private void validarTelefonoCondicionDiferente(Integer telefono) {
		if(telefono == 5555555) {
			throw new ExcepcionAtributo(TELEFONO_CONDICION_INVALIDO);
		}
	}	
	private void validarLongitudtelefono(Integer telefono) {
		if(telefono > 9999999) {
			throw new ExcepcionAtributo(TELEFONO_LONGITUD_INVALIDO);
		}
	}
	private void validarLongitudNombre(String nombre) {
		if(nombre.length() > 100) {
			throw new ExcepcionAtributo(NOMBRE_LONGITUD_INVALIDO);
		}
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

}
