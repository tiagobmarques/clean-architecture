package com.bmarques.cardinsurance.core.healthcheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckService {

  @Autowired
  private HealthCheckRepository healthRepository;

  /**
   * Message indicating than service is running!
   *
   * @return a simply string
   */
  public String serviceIsRunning() {
    return "Service is running!";
  }

  /**
   * Message indicating than database is running!
   *
   * @return a simply string
   */
  public String dataBaseIsUp() {
    return Boolean.TRUE.equals(healthRepository.dataBaseIsUp()) ? "Database is up!" : "Database "
        + "is down!";
  }
}
