package com.bmarques.cardinsurance.adapters.repository.postgres.adapter;

import com.bmarques.cardinsurance.adapters.repository.postgres.model.CardModel;
import com.bmarques.cardinsurance.adapters.repository.postgres.model.adapter.CardModelAdapter;
import com.bmarques.cardinsurance.core.entity.Card;
import com.bmarques.cardinsurance.core.entity.Paged;
import com.bmarques.cardinsurance.core.repository.CardRepository;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CardRepositoryAdapter implements CardRepository {

    private final CardModelAdapter modelAdapter;

    public CardRepositoryAdapter(CardModelAdapter modelAdapter) {
        this.modelAdapter = modelAdapter;
    }

    @Override
    public Paged<Card> findAllPaged(int page, int itemsPerPage) {
        List<CardModel> modelList;
        long totalItems;

        if (itemsPerPage > 0) {
            Page<CardModel> pagedModel = findAllPagedBridge(page, itemsPerPage);
            modelList = pagedModel.getContent();
            totalItems = pagedModel.getTotalElements();
        } else {
            modelList = findAllBridge();
            totalItems = modelList.size();
        }

        return new Paged<>(convertToProductList(modelList), totalItems);
    }

    protected abstract List<CardModel> findAllBridge();

    protected abstract Page<CardModel> findAllPagedBridge(int page, int itemsPerPage);

    private List<Card> convertToProductList(List<CardModel> items) {
        return items.stream()
                .map(modelAdapter::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Card findByCode(long code) {
        CardModel model = findByCodeBridge(code);
        if (model == null) {
            return null;
        }
        return modelAdapter.toEntity(model);
    }

    protected abstract CardModel findByCodeBridge(long code);

    @Override
    public void save(Card card) {
        saveBridge(modelAdapter.toModel(card));
    }

    protected abstract void saveBridge(CardModel productModel);

}