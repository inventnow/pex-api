package com.inventnow.projectx.user.dto;

import com.inventnow.projectx.security.RoleEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MerchantUserRegistration {

    @NotNull
    private UserInfo user;

    @NotNull
    private Long merchantId;

    @NotNull
    private RoleEnum role;
}
