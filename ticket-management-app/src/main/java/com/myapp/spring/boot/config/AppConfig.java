package com.myapp.spring.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class AppConfig {


     @Bean
    OpenAPI ticketManagementOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Ticket Management API")
                        .description("""
                                REST API for managing tickets and agents.
                                Supports ticket CRUD operations and assigning
                                agents to tickets.
                                """)
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("IBM Support Team")
                                .email("support@ibm.org")));
    }
}
