package com.mercadoLibre.quasar.operation.configuration;

import java.util.Collections;

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
	
	public Docket configurationApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.mercadoLibre.quasar.operation.ws"))
				.paths(PathSelectors.any()).build().apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo("Quasar Operation", "Get position and message",
				"1.0", "Private use only",
				new Contact("Fidel Andrés Beltrán Castellanos", null, "stiedan@gmail.com"), "",
				"", Collections.emptyList());
	}

}