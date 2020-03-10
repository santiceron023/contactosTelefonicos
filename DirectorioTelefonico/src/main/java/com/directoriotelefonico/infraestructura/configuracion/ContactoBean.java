package com.directoriotelefonico.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.directoriotelefonico.dominio.puerto.repositorio.ContactoRepositorio;
import com.directoriotelefonico.dominio.servicio.ContactoConsultarServicio;
import com.directoriotelefonico.dominio.servicio.ContactoCrearServicio;
import com.directoriotelefonico.dominio.servicio.ContactoEliminarServicio;

@Configuration
public class ContactoBean {

	@Bean
	public ContactoConsultarServicio contactoConsultarBean(ContactoRepositorio contactoRepositorio) {
		return new ContactoConsultarServicio(contactoRepositorio);
	}

	@Bean
	public ContactoEliminarServicio contactoEliminarBean(
			ContactoRepositorio contactoRepositorio, ContactoConsultarServicio contactoConsultarServicio) {
		return new ContactoEliminarServicio(contactoRepositorio,contactoConsultarServicio);
	}

	@Bean
	public ContactoCrearServicio contactoCrearBean(
			ContactoRepositorio contactoRepositorio, ContactoConsultarServicio contactoConsultarServicio) {
		return new ContactoCrearServicio(contactoRepositorio,contactoConsultarServicio);
	}

}
