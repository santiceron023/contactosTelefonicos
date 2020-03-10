package com.directoriotelefonico.dominio.excepcion;

public class ExcepcionDuplicado extends RuntimeException {
	private static final long serialVersionUID  = 1L;
	public ExcepcionDuplicado(String mensaje) {
		super(mensaje);
	}
	
}
