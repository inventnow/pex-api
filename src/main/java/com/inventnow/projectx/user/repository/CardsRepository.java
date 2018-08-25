package com.inventnow.projectx.user.repository;

import com.inventnow.projectx.user.entity.CardEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsRepository extends PagingAndSortingRepository<CardEntity, Long> {

    CardEntity findTopByOrderByIdDesc();
}
