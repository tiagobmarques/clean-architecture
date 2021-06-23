package com.bmarques.cardinsurance.controller.v1.healthcheck;

import com.bmarques.cardinsurance.contract.CTBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;

@DirtiesContext
@SpringJUnitConfig
@WebFluxTest(controllers = {HealthCheckController.class})
@ActiveProfiles("dev")
@TestInstance(Lifecycle.PER_CLASS)
public class HealthCheckControllerTest extends CTBase {

    private static final String API_URI = "/v1/healthcheck";

    @Test
    @DisplayName("Should return with successfully when Service is running")
    void shouldReturnSuccessfullyWhenServiceIsRunning() {

        // Act
        ResponseSpec exchange = webClient
                .get()
                .uri(API_URI)
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        // Assert
        exchange
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(String.class)
                .consumeWith(Assertions::assertNotNull)
                .isEqualTo("Service is running!");
    }

}
