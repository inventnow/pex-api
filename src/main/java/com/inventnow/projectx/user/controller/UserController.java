package com.inventnow.projectx.user.controller;

import com.inventnow.projectx.user.dto.UserDto;
import com.inventnow.projectx.user.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("v1/user")
public class UserController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody UserDto userDto) {
        userRegistrationService.registerUser(userDto);
    }

   
}
