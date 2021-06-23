package com.bmarques.cardinsurance.core.service;

import com.bmarques.cardinsurance.core.entity.Card;
import com.bmarques.cardinsurance.core.entity.Paged;
import com.bmarques.cardinsurance.core.usecase.FindAllCardsPagedUseCase;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    private final FindAllCardsPagedUseCase findAllCardsPagedUseCase;

    public CardService(FindAllCardsPagedUseCase findAllCardsPagedUseCase) {
        this.findAllCardsPagedUseCase = findAllCardsPagedUseCase;
    }

    public Paged<Card> findAllProductPaged(Pageable pageable) {
        return findAllCardsPagedUseCase.execute(pageable.getPageNumber(), pageable.getPageSize());
    }

}
