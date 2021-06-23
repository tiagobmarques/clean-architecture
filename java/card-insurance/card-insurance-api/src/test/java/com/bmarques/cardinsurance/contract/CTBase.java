package com.bmarques.cardinsurance.contract;

import com.bmarques.cardinsurance.CardInsuranceApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.reactive.server.WebTestClient;

public abstract class CTBase {

  @Autowired
  protected WebTestClient webClient;

  @SpyBean
  protected CardInsuranceApplication config;

  public WebTestClient webClient() {
    return webClient;
  }
}
