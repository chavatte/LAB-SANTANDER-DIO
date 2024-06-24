package com.chavate.hotelReservation.config;

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
            .title("Hotel Reservation API")
            .version("1.0.0")
            .description("API para gerenciamento de reservas de hotel"))
        .addServersItem(new Server().url("/api/hotel"));
  }
}