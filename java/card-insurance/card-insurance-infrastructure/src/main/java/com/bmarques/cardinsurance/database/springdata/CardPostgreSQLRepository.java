package com.bmarques.cardinsurance.database.springdata;

import com.bmarques.cardinsurance.adapters.repository.postgres.model.CardPostgreSQLEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CardPostgreSQLRepository extends PagingAndSortingRepository<CardPostgreSQLEntity, UUID> {
}
