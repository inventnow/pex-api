package com.inventnow.projectx.authentication.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AuthUser {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
