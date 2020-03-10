package com.directoriotelefonico.dominio.puerto.repositorio;

import java.util.List;

import com.directoriotelefonico.dominio.modelo.Contacto;

public interface ContactoRepositorio {
	
	List<Contacto> listarTodos();
	void crear(Contacto contacto);
	void eliminarById(Integer id);
	
	Contacto contactoPorId(Integer contactoId);
	Contacto contactoPorNombre(String nombre);
}
