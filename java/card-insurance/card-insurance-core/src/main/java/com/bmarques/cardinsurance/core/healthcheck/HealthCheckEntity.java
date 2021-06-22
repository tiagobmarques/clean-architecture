package com.bmarques.cardinsurance.core.healthcheck;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "healthcheck")
public class HealthCheckEntity {

  @Id
  @Column("healthcheck_id")
  private Integer id;

}
