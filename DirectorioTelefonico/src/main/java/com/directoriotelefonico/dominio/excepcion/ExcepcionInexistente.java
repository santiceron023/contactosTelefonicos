package com.directoriotelefonico.dominio.excepcion;

public class ExcepcionInexistente extends RuntimeException{
	private static final long serialVersionUID  = 1L;
	public ExcepcionInexistente(String mensaje) {
		super(mensaje);
	}
}
