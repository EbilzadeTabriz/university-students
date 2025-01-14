package com.bmu.university.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SpringDocument {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(
                new Info().title("Check out!")
                        .version("0.0.1")
                        .contact(new Contact()
                                .name("Tabriz Abilzada")
                        .email("tabriz.abilzada@gmail.com"))
                        .description("This is for demo")
        );
    }
}
