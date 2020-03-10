package com.directoriotelefonico.integracion;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.directoriotelefonico.DirectorioTelefonicoApplication;
import com.directoriotelefonico.aplicacion.comando.ContactoComando;
import com.directoriotelefonico.testDataBuilder.ContactoComandoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = DirectorioTelefonicoApplication.class)
@AutoConfigureMockMvc

@TestPropertySource("/test.properties")
public class ContactoControladorTest {


	private WebApplicationContext webApplicationContext;
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();		
	}


	@Test
	@Transactional
	public void CrearControladorTest() throws Exception {
		//arrange
		ContactoComando contactoComando = new ContactoComandoTestDataBuilder().build();

		//Act-Assert
		mockMvc.perform(post("/contactos")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(contactoComando))
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isCreated());
	}



	@Test
	@Transactional
	public void ListarControladorTest() throws Exception {
		//arrange
		ContactoComando contactoComando = new ContactoComandoTestDataBuilder().build();

		mockMvc.perform(post("/contactos")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(contactoComando))
				.accept(MediaType.APPLICATION_JSON)
				);

		//Act
		mockMvc.perform(get("/contactos")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())

		//Assert
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].nombre").value(contactoComando.getNombre().toString()) )
		.andExpect(jsonPath("$[0].telefono").value(contactoComando.getTelefono().toString()) );
	}

	@Test
	@Transactional
	public void eliminarControladorTest() throws Exception {
		//arrange
		ContactoComando contactoComando = new ContactoComandoTestDataBuilder().build();

		//Act-Assert
		mockMvc.perform(post("/contactos")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(contactoComando))
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print());


		mockMvc.perform(delete("/contactos/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isNoContent());
	}

}
