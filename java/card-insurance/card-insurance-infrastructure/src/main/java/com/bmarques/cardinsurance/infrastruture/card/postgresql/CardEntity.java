package com.bmarques.cardinsurance.infrastruture.card.postgresql;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(value = "card")
public class CardEntity {

    @Id
    @Column("card_id")
    private UUID id;

    private String number;

    private String type;

    @Column("name_on_card")
    private String nameOnCard;

    @Column("expiration_date")
    private LocalDate expirationDate;

    @Column("security_code")
    private String securityCode;
}