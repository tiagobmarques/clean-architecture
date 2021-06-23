package com.bmarques.cardinsurance.core.usecase;

import com.bmarques.cardinsurance.core.entity.Card;
import com.bmarques.cardinsurance.core.entity.Paged;
import com.bmarques.cardinsurance.core.repository.CardRepository;

public class FindAllCardsPagedUseCase {

    private final CardRepository repository;

    public FindAllCardsPagedUseCase(CardRepository repository) {
        this.repository = repository;
    }

    public Paged<Card> execute(int page, int itemsPerPage) {
        return repository.findAllPaged(page, itemsPerPage);
    }

}