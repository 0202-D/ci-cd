package ru.petrov.ci_cd.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTest {

    @LocalServerPort
    private int port;

    @Test
    void shouldReturnHello() {

        String response = RestClient
                .create("http://localhost:" + port)
                .get()
                .uri("/hello")
                .retrieve()
                .body(String.class);

        assertEquals("Hello CI/CD!", response);
    }
}
