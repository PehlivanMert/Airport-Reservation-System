package dev.pehlivan.airportreservationsystem.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Airport Reservation System")
                        .description("Airport Reservation System simulation")
                        .version("v1")
                        .contact(new Contact()
                                .name("Mert Pehlivan")
                                .email("pehlivanmert@outlook.com.tr"))
                        .license(new License()
                                .name("License of API")
                                .url("https://swagger.io/docs/")));
    }
}
