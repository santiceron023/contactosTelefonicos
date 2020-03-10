package com.directoriotelefonico.dominio.excepcion;

public class ExcepcionAtributo extends RuntimeException {
	private static final long serialVersionUID  = 1L;
	public ExcepcionAtributo(String mensaje) {
		super(mensaje);
	}
	
}
