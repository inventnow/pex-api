package com.inventnow.projectx.merchant.repository;

import com.inventnow.projectx.merchant.entity.PointsPromoEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointsPromoRepository extends PagingAndSortingRepository<PointsPromoEntity, Long> {

}
