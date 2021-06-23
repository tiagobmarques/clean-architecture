package com.bmarques.cardinsurance.core.repository;

import com.bmarques.cardinsurance.core.entity.Card;
import com.bmarques.cardinsurance.core.entity.Paged;

public interface CardRepository {

    Paged<Card> findAllPaged(int page, int itemsPerPage);

    Card findByCode(long code);

    void save(Card product);
}