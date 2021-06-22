package com.bmarques.cardinsurance.core.card;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CardEntity {

    private UUID id;
    private String number;
    private String type;
    private String nameOnCard;
    private LocalDate expirationDate;
    private String securityCode;

}

