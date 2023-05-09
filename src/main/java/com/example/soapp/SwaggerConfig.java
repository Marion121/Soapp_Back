package com.example.soapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.soapp"))
                .paths(PathSelectors.ant("/test/**"))
                .build();
    }
/*
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Titre de votre API")
                .description("Description de votre API")
                .version("1.0.0")
                .contact(new Contact("Votre Nom", "URL de votre site", "votre-email@domaine.com"))
                .build();
    }*/
}
