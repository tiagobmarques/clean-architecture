package com.bmarques.cardinsurance.infrastruture.card;

import com.bmarques.cardinsurance.core.card.CardRepository;
import com.bmarques.cardinsurance.core.card.CardService;
import com.bmarques.cardinsurance.infrastruture.card.postgresql.CardPostgresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CardServiceFactory {

    private final CardPostgresRepository repository;
    private final CardMapper mapper;

    @Autowired
    public CardServiceFactory(CardPostgresRepository repository, CardMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Bean
    @Autowired
    public CardService createProductService(CardRepository repository) {
        return new CardService(repository);
    }

    @Bean
    public CardRepository createCardRepository() {
        return new CardRepositoryBridge(this.repository, this.mapper);
    }

}
