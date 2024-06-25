package com.chavatte.biblioteca.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Biblioteca API")
            .version("1.0.0")
            .description(
                "API REST para gerenciamento de uma biblioteca, usando Spring Boot 3, Java 17 e fly.io para o Bootcamp Santander Dio"))
        .addServersItem(new Server().url("/"));
  }
}
