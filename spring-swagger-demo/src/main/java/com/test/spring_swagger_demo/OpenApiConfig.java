package com.test.spring_swagger_demo;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("Customer Service API XXXXXXXXXXXXxx")
            .version("1.0")
            .description("API for customer-related operations XXXXXXXXXXXXXxx"));
    }
}
