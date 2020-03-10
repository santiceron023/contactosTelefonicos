package com.directoriotelefonico.infraestructura.excepcion;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.directoriotelefonico.dominio.excepcion.ExcepcionAtributo;
import com.directoriotelefonico.dominio.excepcion.ExcepcionDuplicado;
import com.directoriotelefonico.dominio.excepcion.ExcepcionInexistente;


@RestController
@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> manejarTodasExcepciones(Exception ex, WebRequest request){
		ExceptionResponse excepResp = new ExceptionResponse(
				new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(excepResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}


	@ExceptionHandler(
			{ExcepcionDuplicado.class,ExcepcionAtributo.class, ExcepcionInexistente.class } )
	public final ResponseEntity<Object> manejarExcepcionDominio(Exception ex, WebRequest request){

		ExceptionResponse excepResp = new ExceptionResponse(
				new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(excepResp, HttpStatus.BAD_REQUEST);
	}


}