package com.inventnow.projectx.ecoupon.dto;

import lombok.Data;

import java.util.List;

@Data
public class ECoupons {

    private List<ECoupon> activated;

    private List<ECoupon> deactivated;
}

