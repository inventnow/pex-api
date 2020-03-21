package com.inventnow.projectx.user.service;

import com.inventnow.projectx.registration.dto.CustomerRegistration;
import com.inventnow.projectx.user.dto.MerchantUserRegistration;
import com.inventnow.projectx.user.dto.User;
import com.inventnow.projectx.user.entity.UserEntity;

public interface UserRegistrationService {

    UserEntity registerUser(User user);

    void registerMerchantUser(MerchantUserRegistration merchantUserRegistration);

    void registerCustomer(CustomerRegistration customerRegistration);
}
