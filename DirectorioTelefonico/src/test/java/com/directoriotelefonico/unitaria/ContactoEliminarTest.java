
package com.directoriotelefonico.unitaria;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.directoriotelefonico.dominio.excepcion.ExcepcionInexistente;
import com.directoriotelefonico.dominio.modelo.Contacto;
import com.directoriotelefonico.dominio.puerto.repositorio.ContactoRepositorio;
import com.directoriotelefonico.dominio.servicio.ContactoConsultarServicio;
import com.directoriotelefonico.dominio.servicio.ContactoEliminarServicio;
import com.directoriotelefonico.testDataBuilder.ContactoTestDataBuilder;

public class ContactoEliminarTest {

	@Test
	public void EliminarIdNoExiste() {
		// arrange
		Contacto contacto = new ContactoTestDataBuilder().build();		

		ContactoRepositorio contactoRepositorioMock= Mockito.mock(ContactoRepositorio.class);
		Mockito.when(contactoRepositorioMock.contactoPorId(contacto.getId())).thenReturn(contacto);

		ContactoConsultarServicio contactoConsultarServicio = new ContactoConsultarServicio(contactoRepositorioMock);
		ContactoEliminarServicio contactoEliminarServicio = 
				new ContactoEliminarServicio(contactoRepositorioMock,contactoConsultarServicio);

		// act - assert
		assertDoesNotThrow(	() -> 
			contactoEliminarServicio.ejecutar(contacto.getId()) );
	}

	@Test
	public void EliminarOk() {
		// arrange
		Contacto contacto = new ContactoTestDataBuilder().build();		

		ContactoRepositorio contactoRepositorioMock= Mockito.mock(ContactoRepositorio.class);
		Mockito.when(contactoRepositorioMock.contactoPorId(contacto.getId())).thenReturn(null);

		ContactoConsultarServicio contactoConsultarServicio = new ContactoConsultarServicio(contactoRepositorioMock);
		ContactoEliminarServicio contactoEliminarServicio = 
				new ContactoEliminarServicio(contactoRepositorioMock,contactoConsultarServicio);

		// act - assert
		assertThrows(ExcepcionInexistente.class, () -> 
			contactoEliminarServicio.ejecutar(contacto.getId()) );

	}

}
