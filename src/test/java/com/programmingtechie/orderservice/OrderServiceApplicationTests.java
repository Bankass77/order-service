package com.programmingtechie.orderservice;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Disabled
class OrderServiceApplicationTests {

    @ServiceConnection
    static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:latest");

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;

    }

    static {
        postgreSQLContainer.start();
    }

    @Test
    void shouldSubmintOrder() {
        String submitOrderJson = """
                {
                "skuCode": "iphone_16",
                "quantity": 1,
                "price": 2000
                }
                """;

        var responseBodyString = RestAssured.given().contentType("application/json").body(submitOrderJson).when().post("/api/order").then().log().all()
                .statusCode(201).extract().body().asString();

       // assertThat(responseBodyString,Matchers.is("Order Placed Successfully"));
    }

}
