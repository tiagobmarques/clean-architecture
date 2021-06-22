package com.bmarques.cardinsurance.healthcheck;

import com.bmarques.cardinsurance.core.healthcheck.HealthCheckRepository;
import com.bmarques.cardinsurance.core.healthcheck.HealthCheckService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class HealthCheckServiceTest {

  private static boolean DATA_BASE_UP = true;
  private static boolean DATA_BASE_DOWN = false;

  @Mock
  private HealthCheckRepository mockHealthCheckRepository;
  @InjectMocks
  private HealthCheckService healthCheckService;

  @Test
  @DisplayName("Should indicate that the Service is Running.")
  public void shouldIndicateThatTheServiceIsRunning() {
    assertEquals(healthCheckService.serviceIsRunning(), "Service is running!");
  }

  @Test
  @DisplayName("Should indicate that the Database is Running.")
  public void shouldIndicateThatTheDataBaseIsRunning() {
    // Arrange
    when(mockHealthCheckRepository.dataBaseIsUp()).thenReturn(DATA_BASE_UP);

    // Act
    String expectedMessage = healthCheckService.dataBaseIsUp();

    // Assert
    assertEquals(expectedMessage, "Database is up!");
    verify(mockHealthCheckRepository, times(1)).dataBaseIsUp();
  }

  @Test
  @DisplayName("Should indicate that the DataBase not is running")
  public void shouldIndicateThatTheDataBaseNotIsRunning() {
    // Arrange
    when(mockHealthCheckRepository.dataBaseIsUp()).thenReturn(DATA_BASE_DOWN);

    // Act
    String expectedMessage = healthCheckService.dataBaseIsUp();

    // Assert
    assertEquals(expectedMessage, "Database is down!");
    verify(mockHealthCheckRepository, times(1)).dataBaseIsUp();
  }
}
