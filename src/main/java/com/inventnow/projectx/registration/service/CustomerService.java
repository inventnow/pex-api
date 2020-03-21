package com.inventnow.projectx.registration.service;

import com.inventnow.projectx.registration.dto.CustomerRegistration;

public interface CustomerService {
    void registerCustomer(Long userId, CustomerRegistration customerRegistration);


}
