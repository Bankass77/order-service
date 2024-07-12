package com.programmingtechie.orderservice.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderServiceConfig {

    @Bean
    public OpenAPI OrderServiceApi() {

        return new OpenAPI().info(new Info().title("Order Service").version("1.0").description("Order Service API")).externalDocs(
                new ExternalDocumentation().description("You can refer to the Order Service Wiki Documentation")
                        .url("https://github.com/programmingtechie/order-service"));
    }

}
