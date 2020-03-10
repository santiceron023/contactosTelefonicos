package com.directoriotelefonico.unitaria;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.directoriotelefonico.dominio.excepcion.ExcepcionAtributo;
import com.directoriotelefonico.dominio.excepcion.ExcepcionDuplicado;
import com.directoriotelefonico.dominio.modelo.Contacto;
import com.directoriotelefonico.dominio.puerto.repositorio.ContactoRepositorio;
import com.directoriotelefonico.dominio.servicio.ContactoConsultarServicio;
import com.directoriotelefonico.dominio.servicio.ContactoCrearServicio;
import com.directoriotelefonico.testDataBuilder.ContactoTestDataBuilder;


public class ContactoCrearTests {

	@Test
	public void CrearDuplicado(){

		// arrange
		Contacto contacto = new ContactoTestDataBuilder().build();		

		ContactoRepositorio contactoRepositorioMock= Mockito.mock(ContactoRepositorio.class);
		Mockito.when(contactoRepositorioMock.contactoPorNombre(contacto.getNombre())).thenReturn(contacto);

		ContactoConsultarServicio contactoConsultarServicio = new ContactoConsultarServicio(contactoRepositorioMock);
		ContactoCrearServicio contactoCrearServicio = 
				new ContactoCrearServicio(contactoRepositorioMock,contactoConsultarServicio);

		// act - assert
		assertThrows( 
				ExcepcionDuplicado.class,() ->
				contactoCrearServicio.ejecutar(contacto) );
	}

	@Test
	public void CrearOk(){

		// arrange
		Contacto contacto = new ContactoTestDataBuilder().build();		

		ContactoRepositorio contactoRepositorioMock= Mockito.mock(ContactoRepositorio.class);
		Mockito.when(contactoRepositorioMock.contactoPorNombre(contacto.getNombre())).thenReturn(null);

		ContactoConsultarServicio contactoConsultarServicio = new ContactoConsultarServicio(contactoRepositorioMock);
		ContactoCrearServicio contactoCrearServicio = 
				new ContactoCrearServicio(contactoRepositorioMock,contactoConsultarServicio);

		// act - assert
		assertDoesNotThrow(	() -> contactoCrearServicio.ejecutar(contacto) );
	}

	@Test
	public void CrearContactoNoCumpleLongitud(){

		// arrange
		ContactoTestDataBuilder contactoTestDataBuilder = new ContactoTestDataBuilder();

		// act - assert
		assertThrows( 
				ExcepcionAtributo.class,() -> 
				contactoTestDataBuilder.conNombre( 
						StringUtils.repeat("Nombre largo falla",9) ).build() 
				);
	}


	@Test
	public void CrearContactoTelefonoInvalido(){

		// arrange
		ContactoTestDataBuilder contactoTestDataBuilder = new ContactoTestDataBuilder();

		// act - assert
		assertThrows( 
				ExcepcionAtributo.class,() -> 
				contactoTestDataBuilder.conTelefono(5555555).build()	 
				);
	}
}
