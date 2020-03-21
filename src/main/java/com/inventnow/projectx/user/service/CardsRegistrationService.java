package com.inventnow.projectx.user.service;

import com.inventnow.projectx.user.entity.CardEntity;
import com.inventnow.projectx.registration.entity.CustomerEntity;

public interface CardsRegistrationService {

    CardEntity registerNewCardToCustomer(CustomerEntity customerEntity);
}
