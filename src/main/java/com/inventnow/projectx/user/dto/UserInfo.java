package com.inventnow.projectx.user.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserInfo {

    @NotNull
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;

}
