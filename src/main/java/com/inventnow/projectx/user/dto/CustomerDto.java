package com.inventnow.projectx.user.dto;

import lombok.Data;

@Data
public class CustomerDto {

    private User user;

    private IdentityType identityType;

    private String identityNo;

    private String addressStreet;

    private String addressCity;

    private String addressPostalCode;

    private String homePhone;

    private String mobilePhone1;

    private String mobilePhone2;

}
