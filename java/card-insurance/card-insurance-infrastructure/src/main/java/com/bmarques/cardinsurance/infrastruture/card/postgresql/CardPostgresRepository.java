package com.bmarques.cardinsurance.infrastruture.card.postgresql;

import com.bmarques.cardinsurance.infrastruture.card.postgresql.CardEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface CardPostgresRepository extends PagingAndSortingRepository<CardEntity, UUID> {

    List<CardEntity> findAll();
}
