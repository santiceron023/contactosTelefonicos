package com.directoriotelefonico.infraestructura.controlador;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.directoriotelefonico.aplicacion.comando.ContactoComando;
import com.directoriotelefonico.aplicacion.comando.manejador.ContactoCrearManejador;
import com.directoriotelefonico.aplicacion.comando.manejador.ContactoEliminarManejador;
import com.directoriotelefonico.aplicacion.comando.manejador.ContactoListarManejador;
import com.directoriotelefonico.dominio.modelo.Contacto;

@RestController
@RequestMapping("/contactos")
public class ContactoRestController {
	
	private final ContactoCrearManejador contactoCrearManejador;
	private final ContactoListarManejador contactoListarManejador;
	private final ContactoEliminarManejador contactoEliminarManejador;	

	public ContactoRestController(ContactoCrearManejador contactoCrearManejador,
			ContactoListarManejador contactoListarManejador, ContactoEliminarManejador contactoEliminarManejador) {
		this.contactoCrearManejador = contactoCrearManejador;
		this.contactoListarManejador = contactoListarManejador;
		this.contactoEliminarManejador = contactoEliminarManejador;
	}


	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<Contacto> listarTodosContactos() {
		return this.contactoListarManejador.ejecutar();
	}
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void crearContacto(@RequestBody ContactoComando contactoComando) {
		this.contactoCrearManejador.ejecutar(contactoComando);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarContactoPorId(@PathVariable("id") Integer id) {
		this.contactoEliminarManejador.ejecutar(id);
	}
	
	
}
