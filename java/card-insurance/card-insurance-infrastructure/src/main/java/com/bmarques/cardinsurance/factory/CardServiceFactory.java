package com.bmarques.cardinsurance.factory;

import com.bmarques.cardinsurance.adapters.repository.postgres.model.adapter.CardModelAdapter;
import com.bmarques.cardinsurance.core.repository.CardRepository;
import com.bmarques.cardinsurance.core.service.CardService;
import com.bmarques.cardinsurance.core.usecase.FindAllCardsPagedUseCase;
import com.bmarques.cardinsurance.database.springdata.CardPostgreSQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CardServiceFactory {

    private final CardPostgreSQLRepository cardRepositoryImpl;

    @Autowired
    public CardServiceFactory(CardPostgreSQLRepository productRepositoryImpl) {
        this.cardRepositoryImpl = productRepositoryImpl;
    }

    @Bean
    @Autowired
    public CardService createCardService(CardRepository repository) {
        FindAllCardsPagedUseCase findAllProductsPagedUseCase = new FindAllCardsPagedUseCase(repository);

        return new CardService(findAllProductsPagedUseCase);
    }

    @Bean
    public CardRepository createCardRepository() {
        CardModelAdapter modelAdapter = new CardModelAdapter();
        CardRepositoryBridge repository = new CardRepositoryBridge(cardRepositoryImpl,
                modelAdapter);
        return repository;
    }
}
