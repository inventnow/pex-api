package com.inventnow.projectx.ecoupon.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ECoupon {

    @NotNull
    private Integer merchantId;

    @NotNull
    private Integer pointsTime;
}
