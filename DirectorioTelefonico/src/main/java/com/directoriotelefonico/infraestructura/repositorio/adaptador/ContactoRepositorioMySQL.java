package com.directoriotelefonico.infraestructura.repositorio.adaptador;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.directoriotelefonico.dominio.modelo.Contacto;
import com.directoriotelefonico.dominio.puerto.repositorio.ContactoRepositorio;

@Repository
public class ContactoRepositorioMySQL implements ContactoRepositorio  {

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


	public ContactoRepositorioMySQL(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<Contacto> listarTodos() {
		return namedParameterJdbcTemplate.query(
				"SELECT id,nombre,telefono FROM contacto",
				(rs, rowNum) ->
				new Contacto(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getInt("telefono")
						)
				);
	}

	@Override
	public void crear(Contacto contacto) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("nombre", contacto.getNombre());
		mapSqlParameterSource.addValue("telefono", contacto.getTelefono());
		namedParameterJdbcTemplate.update(
				"insert into contacto (nombre, telefono) values(:nombre,:telefono)",
				mapSqlParameterSource);

	}

	@Override
	public void eliminarById(Integer id) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("id", id);

		namedParameterJdbcTemplate.update(
				"delete from contacto where id = :id",
				mapSqlParameterSource
				);		
	}

	@Override
	public Contacto contactoPorId(Integer contactoId) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("id", contactoId);
		List<Contacto> a = namedParameterJdbcTemplate.query(
				"SELECT id,nombre,telefono FROM contacto where id = :id",
				mapSqlParameterSource,
				(rs, rowNum) ->
				new Contacto(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getInt("telefono")
						)
				);
		return (!a.isEmpty()) ? a.get(0) : null;
	}

	@Override
	public Contacto contactoPorNombre(String nombre) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("nombre", nombre);
		List<Contacto> a = namedParameterJdbcTemplate.query(
				"SELECT id,nombre,telefono FROM contacto where nombre = :nombre",
				mapSqlParameterSource,
				(rs, rowNum) ->
				new Contacto(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getInt("telefono")
						)
				);
		return (!a.isEmpty()) ? a.get(0) : null;
	}

}
