package com.bmarques.cardinsurance.api.v1.healthcheck;

import com.bmarques.cardinsurance.core.healthcheck.HealthCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private HealthCheckService healthService;

  @GetMapping
  public Mono<ResponseEntity<String>> serviceIsRunning() {
    return Mono
        .fromCallable(healthService::serviceIsRunning)
        .map(message -> ResponseEntity.status(HttpStatus.OK).body(message))
        .doOnError(error -> log.error(error.getMessage(), error))
        .subscribeOn(Schedulers.elastic());
  }

  @GetMapping("/database")
  public Mono<ResponseEntity<String>> databaseIsUp() {
    return Mono.fromCallable(healthService::dataBaseIsUp)
        .map(message -> ResponseEntity.status(HttpStatus.OK).body(message))
        .doOnError(error -> log.error(error.getMessage(), error))
        .subscribeOn(Schedulers.elastic());
  }
}
