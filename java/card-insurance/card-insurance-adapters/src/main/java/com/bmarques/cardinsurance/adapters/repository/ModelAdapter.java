package com.bmarques.cardinsurance.adapters.repository;

public interface ModelAdapter<T, E> {

    E toModel(T entity);

    T toEntity(E model);
}
