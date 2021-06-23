package com.bmarques.cardinsurance.core.card;

import java.util.List;

public class CardService {

    private final CardRepository repository;

    public CardService(CardRepository repository) {
        this.repository = repository;
    }

    public List<Card> getListCard() {
        return repository.findAll();
    }

}
