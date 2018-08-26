package com.inventnow.projectx.merchant.repository;

import com.inventnow.projectx.merchant.entity.MerchantEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends PagingAndSortingRepository<MerchantEntity, Long> {
}
