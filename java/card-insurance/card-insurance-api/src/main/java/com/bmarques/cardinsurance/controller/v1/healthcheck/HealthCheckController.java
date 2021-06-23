package com.bmarques.cardinsurance.controller.v1.healthcheck;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@RestController
@RequestMapping("/v1/healthcheck")
public class HealthCheckController {

    @GetMapping
    public Mono<ResponseEntity<String>> serviceIsRunning() {
        return Mono
                .fromCallable(() -> "Service is running!")
                .map(message -> ResponseEntity.status(HttpStatus.OK).body(message))
                .doOnError(error -> log.error(error.getMessage(), error))
                .subscribeOn(Schedulers.elastic());
    }
}
