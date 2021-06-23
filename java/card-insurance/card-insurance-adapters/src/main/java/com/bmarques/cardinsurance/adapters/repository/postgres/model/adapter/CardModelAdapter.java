package com.bmarques.cardinsurance.adapters.repository.postgres.model.adapter;

import com.bmarques.cardinsurance.adapters.repository.ModelAdapter;
import com.bmarques.cardinsurance.adapters.repository.postgres.model.CardModel;
import com.bmarques.cardinsurance.core.entity.Card;

public class CardModelAdapter implements ModelAdapter<Card, CardModel> {

    @Override
    public CardModel toModel(Card entity) {
        CardModel model = new CardModel();
        model.setNameOnCard(entity.getNameOnCard());
        model.setExpirationDate(entity.getExpirationDate());
        model.setNumber(entity.getNumber());
        model.setType(entity.getType());
        model.setSecurityCode(entity.getSecurityCode());
        return model;
    }

    @Override
    public Card toEntity(CardModel model) {
        return Card.builder()
                .nameOnCard(model.getNameOnCard())
                .expirationDate(model.getExpirationDate())
                .number(model.getNumber())
                .securityCode(model.getSecurityCode())
                .type(model.getType())
                .build();
    }

}