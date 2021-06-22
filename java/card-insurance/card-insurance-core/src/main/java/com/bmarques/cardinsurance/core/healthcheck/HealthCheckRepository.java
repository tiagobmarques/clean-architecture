package com.bmarques.cardinsurance.core.healthcheck;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;

public interface HealthCheckRepository extends Repository<HealthCheckEntity, Integer> {

  @Query(value = "select true from healthcheck")
  Boolean dataBaseIsUp();
}
