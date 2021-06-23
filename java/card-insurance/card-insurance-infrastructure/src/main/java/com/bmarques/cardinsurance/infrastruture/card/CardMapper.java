package com.bmarques.cardinsurance.infrastruture.card;

import com.bmarques.cardinsurance.core.card.Card;
import com.bmarques.cardinsurance.infrastruture.card.postgresql.CardEntity;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CardMapper {
    public Card toClass(CardEntity cardEntity) {
        return Card.builder()
                .id(cardEntity.getId())
                .nameOnCard(cardEntity.getNameOnCard())
                .expirationDate(cardEntity.getExpirationDate())
                .number(cardEntity.getNumber())
                .securityCode(cardEntity.getSecurityCode())
                .type(cardEntity.getType())
                .build();
    }
}
