package com.inventnow.projectx.user.service;

import com.inventnow.projectx.user.dto.CustomerRegistration;
import com.inventnow.projectx.user.dto.User;
import com.inventnow.projectx.user.entity.UserEntity;

public interface UserRegistrationService {

    UserEntity registerUser(User user);

    void registerCustomer(CustomerRegistration customerRegistration);
}
