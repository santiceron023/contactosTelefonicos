package com.directoriotelefonico.dominio.servicio;

import com.directoriotelefonico.dominio.excepcion.ExcepcionDuplicado;
import com.directoriotelefonico.dominio.modelo.Contacto;
import com.directoriotelefonico.dominio.puerto.repositorio.ContactoRepositorio;

public class ContactoCrearServicio {
	
	private static final String EL_CONTACTO_YA_EXISTE = "el contacto ya existe";

	private final ContactoRepositorio contactoRepositorio;
	private final ContactoConsultarServicio contactoConsultarServicio;

	public ContactoCrearServicio(ContactoRepositorio contactoRepositorio,
			ContactoConsultarServicio contactoConsultarServicio) {
		this.contactoConsultarServicio = contactoConsultarServicio;
		this.contactoRepositorio = contactoRepositorio;
	}

	public void ejecutar(Contacto reserva) {
		this.validarExistenciaPrevia(reserva);
		this.contactoRepositorio.crear(reserva);
	}

	private void validarExistenciaPrevia(Contacto reserva){
		if (this.contactoConsultarServicio.validarExistenciaPorNombre(reserva.getNombre())) {
			throw new ExcepcionDuplicado(EL_CONTACTO_YA_EXISTE);
		}		
	}
}
