package com.bmarques.cardinsurance.core.card;

import java.util.List;

public interface CardRepository {

    List<Card> findAll();
}
