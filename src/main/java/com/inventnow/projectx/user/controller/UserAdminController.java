package com.inventnow.projectx.user.controller;

import com.inventnow.projectx.user.dto.MerchantUserRegistration;
import com.inventnow.projectx.user.dto.User;
import com.inventnow.projectx.user.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users/admin")
public class UserAdminController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody User user) {
        userRegistrationService.registerUser(user);
    }


    @PostMapping("/registration/merchantuser")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerMerchantUser(@RequestBody MerchantUserRegistration merchantUser) {
        userRegistrationService.registerMerchantUser(merchantUser);
    }

}
