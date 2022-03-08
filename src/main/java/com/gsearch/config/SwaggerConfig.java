package com.gsearch.config;

import org.springdoc.core.*;
import org.springframework.context.annotation.*;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.security.*;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI().components(
				new Components().addSecuritySchemes("OAuth", new SecurityScheme().type(SecurityScheme.Type.APIKEY)
						.scheme("bearer").bearerFormat("jwt").in(SecurityScheme.In.HEADER).name("Authorization")));
	}

	@Bean
	public GroupedOpenApi authorisedApi() {
		return GroupedOpenApi.builder().group("search").pathsToMatch("/**").build();
	}

}