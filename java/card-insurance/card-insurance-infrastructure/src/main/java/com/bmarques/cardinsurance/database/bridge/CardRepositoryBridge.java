package com.bmarques.cardinsurance.database.bridge;

import com.bmarques.cardinsurance.adapters.repository.postgres.adapter.CardRepositoryAdapter;
import com.bmarques.cardinsurance.adapters.repository.postgres.model.CardModel;
import com.bmarques.cardinsurance.adapters.repository.postgres.model.adapter.CardModelAdapter;
import com.bmarques.cardinsurance.database.springdata.CardPostgreSQLRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class CardRepositoryBridge extends CardRepositoryAdapter {

    private final CardPostgreSQLRepository repository;

    public CardRepositoryBridge(CardPostgreSQLRepository repository,
                                   CardModelAdapter modelAdapter) {
        super(modelAdapter);
        this.repository = repository;
    }

    @Override
    protected List<CardModel> findAllBridge() {
        return repository.findAll();
    }

    @Override
    protected Page<CardModel> findAllPagedBridge(int page, int itemsPerPage) {
        return repository.findAll(PageRequest.of(page - 1, itemsPerPage));
    }

    @Override
    protected CardModel findByCodeBridge(long code) {
        return repository.findById(code).orElse(null);
    }

    @Override
    protected void saveBridge(CardModel cardModel) {
        repository.save(cardModel);
    }

}