package com.inventnow.projectx.user.controller;

import com.inventnow.projectx.user.dto.MerchantUserRegistration;
import com.inventnow.projectx.user.dto.User;
import com.inventnow.projectx.user.service.UserRegistrationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users/admin")
@Api(description = "Set of operation for user activities (registration, deactivate user,etc)")
public class UserAdminController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping("/registration")
    @ApiOperation("User registration, return 201 if successfully created")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody User user) {
        userRegistrationService.registerUser(user);
    }


    @PostMapping("/registration/merchantuser")
    @ApiOperation("Merchant User registration, return 201 if successfully created")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerMerchantUser(@RequestBody MerchantUserRegistration merchantUser) {
        userRegistrationService.registerMerchantUser(merchantUser);
    }

}
