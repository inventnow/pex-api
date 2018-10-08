package com.inventnow.projectx.user.dto;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Valid
@Value
@Builder
@ToString
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
