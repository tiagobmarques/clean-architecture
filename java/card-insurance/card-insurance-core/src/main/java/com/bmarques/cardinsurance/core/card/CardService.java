package com.bmarques.cardinsurance.core.card;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class CardService {
    /**
     * Get all card in database
     *
     * @return a page of cards
     */
    public Page<CardEntity> getListCard(Pageable pageable) {
        CardEntity cardEntity = CardEntity.builder()
                .id(UUID.randomUUID())
                .nameOnCard("Tiago")
                .number("49844561321465412")
                .type("Visa")
                .securityCode("456")
                .expirationDate(LocalDate.of(2025, 12, 1))
                .build();

        return PageableExecutionUtils
                .getPage(List.of(cardEntity), PageRequest.of(0, 1), () -> 1L);
    }

}
