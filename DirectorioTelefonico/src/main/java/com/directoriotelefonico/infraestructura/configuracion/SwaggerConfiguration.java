package com.directoriotelefonico.infraestructura.configuracion;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	public static final Contact contacto = new Contact("Santago Ceron", 
			"https://www.linkedin.com/in/santiago-ceron-araujo", "santiceron023@gmail.com");
	public static final ApiInfo info = new ApiInfo("Directorio de Contactos", "BackEnd App",
			"version 1.0", "termsOfServiceUrl",contacto, "uso educativo, APACHE 2.0",
			" http://www.apache.com",new ArrayList<>());

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(info)
				.select().apis(RequestHandlerSelectors.basePackage
						("com.directoriotelefonico.infraestructura.controlador")).paths(PathSelectors.any())
				.build();
	}

}
