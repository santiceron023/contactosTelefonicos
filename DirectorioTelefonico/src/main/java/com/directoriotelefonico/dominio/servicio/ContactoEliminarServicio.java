package com.directoriotelefonico.dominio.servicio;

import com.directoriotelefonico.dominio.excepcion.ExcepcionInexistente;
import com.directoriotelefonico.dominio.puerto.repositorio.ContactoRepositorio;

public class ContactoEliminarServicio {
	private static final String CONTACTO_INEXISTENTE = "El contacto no existe";

	private final ContactoRepositorio contactoRepositorio;
	private final ContactoConsultarServicio contactoConsultarServicio;

	public ContactoEliminarServicio(ContactoRepositorio contactoRepositorio,
			ContactoConsultarServicio contactoConsultarServicio) {
		this.contactoConsultarServicio = contactoConsultarServicio;
		this.contactoRepositorio = contactoRepositorio;
	}


	public void ejecutar(Integer contactoId) {
		this.validarExistenciaPrevia(contactoId);
		this.contactoRepositorio.eliminarById(contactoId);
	}

	private void validarExistenciaPrevia(Integer contactoId){
		if (! this.contactoConsultarServicio.validarExistenciaPorId(contactoId)) {
			throw new ExcepcionInexistente(CONTACTO_INEXISTENTE);
		}		
	}

}
