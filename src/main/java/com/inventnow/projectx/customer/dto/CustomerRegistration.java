package com.inventnow.projectx.customer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inventnow.projectx.user.dto.IdentityType;
import com.inventnow.projectx.user.dto.UserInfo;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
@Builder
@ToString
public class CustomerRegistration {

    private UserInfo user;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @NotNull
    private String cityOfBirth;

    private IdentityType identityType;

    private String identityNo;

    private String addressStreet;

    private String addressCity;

    private String addressPostalCode;

    private String homePhone;

    private String mobilePhone1;

    private String mobilePhone2;

}
