package com.inventnow.projectx.user.controller;

import com.inventnow.projectx.user.dto.CustomerRegistration;
import com.inventnow.projectx.user.service.UserRegistrationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/registration")
@Api(description = "Set of customer registration,forgot password, etc")
public class RegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;


    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody CustomerRegistration customerRegistration) {

        userRegistrationService.registerCustomer(customerRegistration);
    }


}
