package com.inventnow.projectx.registration.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inventnow.projectx.user.dto.IdentityType;
import com.inventnow.projectx.user.dto.UserInfo;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CustomerRegistration {

    @Valid
    private UserInfo user;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @NotNull
    private String cityOfBirth;

    @NotNull
    private IdentityType identityType;

    @NotNull
    private String identityNo;

    private String addressStreet;

    private String addressCity;

    private String addressPostalCode;

    private String homePhone;

    private String mobilePhone1;

    private String mobilePhone2;

}
