package com.inventnow.projectx.user.dto;

import com.inventnow.projectx.security.RoleEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UserDto {

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

    @NotNull
    private List<RoleEnum> roles;
}
