package com.bmarques.cardinsurance.infrastruture.card;

import com.bmarques.cardinsurance.core.card.Card;
import com.bmarques.cardinsurance.core.card.CardRepository;
import com.bmarques.cardinsurance.infrastruture.card.postgresql.CardEntity;
import com.bmarques.cardinsurance.infrastruture.card.postgresql.CardPostgresRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CardRepositoryBridge implements CardRepository {

    private final CardPostgresRepository repository;
    private final CardMapper mapper;

    public CardRepositoryBridge(CardPostgresRepository repository, CardMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Card> findAll() {
        List<CardEntity> cards = repository.findAll();

        return cards.stream()
                .map(mapper::toClass)
                .collect(Collectors.toList());
    }
}
