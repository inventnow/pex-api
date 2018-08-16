package com.inventnow.projectx.authentication.controller;

import com.inventnow.projectx.authentication.dto.AuthUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@Api(description = "Set of authentication opearation to PEX-API")
public class AuthenticationController {

    @PostMapping
    @ApiOperation("Authentication operation, return Http Status 400 for invalid creds")
    public String authUser(@RequestBody AuthUser authUser) {
        return "OK";
    }
}
