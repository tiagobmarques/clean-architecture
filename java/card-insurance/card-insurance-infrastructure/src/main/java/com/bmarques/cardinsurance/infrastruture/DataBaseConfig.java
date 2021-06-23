package com.bmarques.cardinsurance.infrastruture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJdbcRepositories(basePackages = "com.bmarques.cardinsurance.infrastruture")
@EnableJdbcAuditing
public class DataBaseConfig extends AbstractJdbcConfiguration {

  @Value("${spring.datasource.url}")
  private String url;
  @Value("${spring.datasource.username}")
  private String userName;
  @Value("${spring.datasource.password}")
  private String password;

  @Bean
  public NamedParameterJdbcOperations operations() {
    return new NamedParameterJdbcTemplate(dataSource());
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }

  @Bean
  public DataSource dataSource() {

    DriverManagerDataSource driver = new DriverManagerDataSource();
    driver.setDriverClassName("org.postgresql.Driver");
    driver.setUrl(url);
    driver.setUsername(userName);
    driver.setPassword(password);
    return driver;
  }

}
