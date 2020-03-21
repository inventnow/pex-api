package com.inventnow.projectx.registration.repository;

import com.inventnow.projectx.registration.entity.CustomerEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<CustomerEntity, Long> {
}
