package com.inventnow.projectx.customer.service;

import com.inventnow.projectx.customer.dto.CustomerRegistration;

public interface CustomerService {
    void registerCustomer(Long userId, CustomerRegistration customerRegistration);


}
