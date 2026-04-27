package com.crm.Type.sf_mini.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info =
        @Info(
            title = "Mini-CRM Enterprise API",
            description = "RESTful API for Customer and Support Ticket Management.",
            version = "v1.0.0",
            contact = @Contact(name = "Harsh Chaturvedi")))
public class OpenApiConfig {}

